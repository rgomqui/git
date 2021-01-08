package controlador;


import java.awt.Color;
import java.awt.Component;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import modelo.Configuracion;
import modelo.Empleado;
import modelo.Uniformidad;
import modelo.Vacaciones;
import vista.FormularioEmpleadoNuevo;
import java.text.*;



public class Conexion{
	
    
    public final String URL = "jdbc:mysql://sql262.main-hosting.eu:3306/u877485772_empcontrol?useSSL=false&serverTimezone=UTC";
    public final String USER = "u877485772_rgomqui";
    public final String PASS = "Rafa44760093.";
	
	///id12310196_rgomqui
	
	public  Conexion() {

		
		
	}
    
  
	/*/ METODO PARA CONECTAR CON LA BBDD/*/
	
	public Connection getConnection() {
	  
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =(Connection) DriverManager.getConnection(URL,USER,PASS);
		} catch (Exception e) {	
			
			
		}	
		if(con != null) {
			//System.out.println("conexion establecida");
		}else {
			System.out.println("error al conectar");
		}
		
		return con;	
		
	}
	

	

/*/ METODO PARA HACER LOGIN  rafa 0000/*/
	public boolean login(String user, String pass){
		
		try {
			con = getConnection();
			ps = con.prepareStatement("select * from login where usuario = ? AND pass = ?");
			
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			
			return (rs.next())?true:false;

		}catch(Exception e) {
				System.out.println("error SQL");
				return false;
		}finally {
			try{
				if(con!=null)con.close();
				if(ps!=null)ps.close();
				if(rs!=null)rs.close();	
			}catch(Exception e) {
				
				e.printStackTrace();
			}
		}
	}	
	
	
	/*/METODO PARA RELLENAR JCOMBOBOX DE BUSQUEDA DE EMPLEADOS/*/
	public void devolverEmpleados(JComboBox comboNombre, String texto) {
		try {
			listarVacaciones();
			listaEmpleados = new ArrayList();
			if(texto != "") {
				con = getConnection();
				ps = con.prepareStatement("select * from empleado where nombre LIKE ?  or apellido1 LIKE ? or apellido2 LIKE ? order by apellido1 asc");
				ps.setString(1, "%"+texto+"%");
				ps.setString(2, "%"+texto+"%");
				ps.setString(3, "%"+texto+"%");
				rs = ps.executeQuery(); 
			}else {
				con = getConnection();
				ps = con.prepareStatement("select * from empleado order by apellido1 asc");
				rs = ps.executeQuery();
			}
		while(rs.next()) {
			empleado = new Empleado();
			empleado.setCodigo(rs.getInt("codigo"));
			empleado.setNombre(rs.getString("nombre"));
			empleado.setApellido1(rs.getString("apellido1"));
			empleado.setApellido2(rs.getString("apellido2"));
			empleado.setTelefono(rs.getString("telefono"));
			empleado.setDni(rs.getString("dni"));
			empleado.setTallaSuperior(rs.getString("tallaSuperior"));
			empleado.setTallaInferior(rs.getString("tallaInferior"));
			empleado.setTallaPie(rs.getString("tallaPie"));
			empleado.setTipoCalzado(rs.getString("tipoCalzado"));
			
			
			listaEmpleados.add(empleado);
			
		}
			comboNombre.removeAllItems();
			for(Empleado e:listaEmpleados)	{
				comboNombre.addItem(e);
			}
			
		}catch(Exception e) {
			System.out.println("Error devolviendo empleados: "+e.getMessage());
		}finally{
			try{
		
			if(con!=null)con.close();
			if(ps!=null)ps.close();
			if(rs!=null)rs.close();	
		}catch(Exception e) {
			System.out.println("da error");
			e.printStackTrace();
		}
		}
		
	}
		
	
	/*/METODO PARA RELLENAR LA TABLA DE UNIFORMIDAD/*/
	public ArrayList<Uniformidad> devolverUniformidad(int codigoEmpleado) {
		try {
			listaUniformes = new ArrayList();
			con = getConnection();
			
			
			ps=con.prepareStatement("select * from uniformidad where codigo=?");
			ps.setInt(1, codigoEmpleado);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				uniformidad = new Uniformidad();
				uniformidad.setId(rs.getInt("id"));
				uniformidad.setCodigo(codigoEmpleado);
				uniformidad.setCamisa(rs.getString("camisa"));
				uniformidad.setForro(rs.getString("forro"));
				uniformidad.setPantalon(rs.getString("pantalon"));
				uniformidad.setZapatos(rs.getInt("zapatos"));
				uniformidad.setTipo(rs.getString("tipo"));
				uniformidad.setUltimaEntrega(rs.getDate("ultimaEntrega"));
				
				listaUniformes.add(uniformidad);
			}
			return listaUniformes;
		}catch(Exception e) {
			System.out.println("Error devolviendo uniformidad");
			e.printStackTrace();
		}finally{
			try{
		
			if(con!=null)con.close();
			if(ps!=null)ps.close();
			if(rs!=null)rs.close();	
		}catch(Exception e) {
			
			
			e.printStackTrace();
		}
		}
		return null;
	}
	
	//METODO PARA DEVOLVER UNA LISTA DE LOS DESCANSOS DE UN DETERMINADO EMPLEADO//
	
	public ArrayList<Vacaciones> devolverVacacionesEmpleado(int codigoEmpleado) {
		
		try {
			listaVacacionesEmpleado = new ArrayList();
				for(Vacaciones v: listaVacaciones) {
					if(v.getCodigo() == codigoEmpleado) {
						listaVacacionesEmpleado.add(v);
					}
				}
				
			
			return listaVacacionesEmpleado;
		}catch(Exception e) {
			System.out.println("Error listando vacaciones de empleado "+ codigoEmpleado +".  " + e.getMessage());
				e.printStackTrace();	
		}
		
		return null;
		
	}
		
	

	//METODO PARA LISTAR LAS VACACIONES DE LOS EMPLEADOS ACTUALES//
	public ArrayList<Vacaciones> listarVacaciones() {
		
		try {
			con = getConnection();
			listaVacaciones = new ArrayList();
			
			ps = con.prepareStatement("select * from vacaciones;");
			rs = ps.executeQuery();
			
			 
			 
			while(rs.next()) {
				
				
				vacaciones = new Vacaciones();
				
				//RELLENAMOS EL OBJETO VACACIONES//
				
				Date fechaDevengo = rs.getDate("fechaDevengo"); // guardamos la fecha de devengo para ver a que año corresponde el descanso
				//if(fechaDevengo !=null && fechaDevengo.after(fechaEneroActual.parse(unoEneroAñoActual)) &&  fechaDevengo.before(fechaEneroAñoSiguiente.parse(unoEneroAñoSiguiente)))System.out.println("Es de este año");
				vacaciones.setCodigo(rs.getInt("codigo"));
				vacaciones.setId(rs.getInt("id"));
				vacaciones.setDiasPorDisfrutar(rs.getInt("diasPorDisfrutar"));
				vacaciones.setDisfrutado(rs.getBoolean("disfrutado"));
				vacaciones.setDiasDisfrutados(rs.getInt("diasDisfrutados"));
				vacaciones.setFechaDevengo((rs.getDate("fechaDevengo")==null)?null:(rs.getDate("fechaDevengo")));
			
					if(rs.getBoolean("disfrutado")) {
						vacaciones.setFechaInicio(rs.getDate("fechaInicio"));
						vacaciones.setFechaFin(rs.getDate("fechaFin"));
					}
					
				vacaciones.setMesCompleto(rs.getBoolean("mesCompleto"));
				vacaciones.setObservaciones(rs.getString("observaciones"));
				vacaciones.setTipo(rs.getString("tipo"));
				
				listaVacaciones.add(vacaciones);
				
			}
			return listaVacaciones;
		}catch(Exception e) {
			System.out.println("Error listando vacaciones" + e.getMessage());
				//e.printStackTrace();	
		}finally{
			try{
		
			if(con!=null)con.close();
			if(ps!=null)ps.close();
			if(rs!=null)rs.close();	
		}catch(Exception e) {
			
			
			e.printStackTrace();
		}
		}
		return null;
	}
	
	/*/ METODO PARA DEVOLVER DIAS DE DESCANSO PENDIENTES DE DISFRUTAR/*/
	public void devolverVacaciones(int codigoEmpleado, JTextField txtConvenio, JTextField txtCompensatorio, JTextField txtVacaciones) {
		
	configuracion = recuperaConfig();
 
	diasPendienteVacaciones = configuracion.getDiasVacaciones();
	diasPendienteConvenio = configuracion.getDiasConvenio();
	diasPendienteCompensatorio = 0;
	
	//PONEMOS EN BLANCO LAS CAJAS DE TEXTO//
	txtConvenio.setText("");
	txtCompensatorio.setText("");
	txtVacaciones.setText("");
	
	try {
		
			listarVacaciones();
		for(Vacaciones v:listaVacaciones) {
			int fechaDevengo = Integer.valueOf(v.getFechaDevengo().toString().substring(0,4));
			int anioActual = local.getYear();
			
			if(v.getCodigo()==codigoEmpleado) {
				if(v.getTipo().equals("Vacaciones") && fechaDevengo == anioActual) {
					diasPendienteVacaciones -= v.getDiasDisfrutados();
				}else if(v.getTipo().equals("Compensatorio")) {
					if(!v.isDisfrutado() && fechaDevengo == anioActual)
					diasPendienteCompensatorio += v.getDiasPorDisfrutar();
				}else{	
					if(fechaDevengo == anioActual)diasPendienteConvenio--;
					
					
				}
			}
		}
				
			txtConvenio.setText(String.valueOf(diasPendienteConvenio));
			txtCompensatorio.setText(String.valueOf(diasPendienteCompensatorio));
			txtVacaciones.setText(String.valueOf(diasPendienteVacaciones));			
	
		}catch(Exception e) {
			System.out.println("Error mostrando vacaciones " + e.getMessage());

			
		}finally{
			try{
		
			if(con!=null)con.close();
			if(ps!=null)ps.close();
			if(rs!=null)rs.close();	
		}catch(Exception e) {
			
			
			e.printStackTrace();
		}
		}
	}
	
	/*/METODO PARA INSERTAR NUEVAS VACACIONES/*/
	public void insertarVacaciones(Component parent, Vacaciones v) {
		try {
			int i = mensajes.mensajePregunta(parent, "¿Esta seguro de ingresar el registro?", "Confirmar insercion");
			if(i==0) {
			
			con = getConnection();
			ps = con.prepareStatement("INSERT INTO vacaciones (codigo, tipo, fechaDevengo, FechaInicio, fechaFin, mesCompleto, observaciones, disfrutado, diasPorDisfrutar, diasDisfrutados)"+
									" VALUES(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, v.getCodigo());
			ps.setString(2, v.getTipo());
			ps.setDate(3, v.getFechaDevengo());
			ps.setDate(4, v.getFechaInicio());
			ps.setDate(5, v.getFechaFin());
			ps.setBoolean(6, v.isMesCompleto());
			ps.setString(7, v.getObservaciones());
			ps.setBoolean(8, v.isDisfrutado());
			ps.setInt(9, v.getDiasPorDisfrutar());
			ps.setInt(10, v.getDiasDisfrutados());
			
			int resultado = ps.executeUpdate();
			if(resultado>0) {
				mensajes.mensajeInfo(parent, "Registro incluido con exito en la base de datos", "Insercion satisfactoria");
			}else {
				mensajes.mensajeInfo(parent, "No se ha podido registrar con exito en la base de datos", "Error en la insercion");
			}
			}else {
				mensajes.mensajeInfo(parent, "Se ha cancelado la insercion en la base de datos", "insercion cancelada");
			}
			
			
		}catch(Exception e) {
			System.out.println("Error insertando vacaciones en clase conexion "+e.getMessage());
		}finally{
			try{
	
				if(con!=null)con.close();
				if(ps!=null)ps.close();
				if(rs!=null)rs.close();	
			}catch(Exception e) {
		
				e.printStackTrace();
			}
		}
		
	}
	
	
	/*/METODO PARA ACTUALIZAR VACACIONES/*/
	public void actualizarVacaciones(Component parent, Vacaciones v) {
		try {
			int i = mensajes.mensajePregunta(parent, "¿Esta seguro de actualizar el registro?", "Confirmar actualizacion");
			if(i==0) {
			System.out.println("id: "+ v.getId());
			con = getConnection();
			ps = con.prepareStatement("UPDATE vacaciones SET codigo = ?, tipo = ?, fechaDevengo = ?, FechaInicio = ?, fechaFin = ?, mesCompleto = ?, observaciones = ?,"
										+ " disfrutado = ?, diasPorDisfrutar = ?, diasDisfrutados =? WHERE id = ?");
			ps.setInt(1, v.getCodigo());
			ps.setString(2, v.getTipo());
			ps.setDate(3, v.getFechaDevengo());
			ps.setDate(4, v.getFechaInicio());
			ps.setDate(5, v.getFechaFin());
			ps.setBoolean(6, v.isMesCompleto());
			ps.setString(7, v.getObservaciones());
			ps.setBoolean(8, v.isDisfrutado());
			ps.setInt(9, v.getDiasPorDisfrutar());
			ps.setInt(10, v.getDiasDisfrutados());
			ps.setInt(11, v.getId());
			
			int resultado = ps.executeUpdate();
			if(resultado>0) {
				mensajes.mensajeInfo(parent, "Registro actualizado con exito en la base de datos", "Actualizacion satisfactoria");
			}else {
				mensajes.mensajeInfo(parent, "No se ha podido actualizar con exito en la base de datos", "Error en la actualizacion");
			}
			}else {
				mensajes.mensajeInfo(parent, "Se ha cancelado la actualizacion en la base de datos", "actualizacion cancelada");
			}
			
			
		}catch(Exception e) {
			System.out.println("Error actualizacion vacaciones en clase conexion "+e.getMessage());
		}finally{
			try{
	
				if(con!=null)con.close();
				if(ps!=null)ps.close();
				if(rs!=null)rs.close();	
			}catch(Exception e) {
		
				e.printStackTrace();
			}
		}
		
		
	}
	/*/METODO PARA RESCATAR LA CONFIGURACION DE LA BASE DE DATOS/*/
	
	public Configuracion recuperaConfig() {
		
		Configuracion configuracion2 = new Configuracion();
		try {
			con = getConnection();
			/* rescatamos los dias predefinidos que estan guardados en la base de datos*/
			ps = con.prepareStatement("select * from configuracion"); 
			rs=ps.executeQuery();
			if(rs.next()){
				configuracion2.setDiasVacaciones(rs.getInt("diasVacaciones"));
				configuracion2.setDiasConvenio(rs.getInt("diasConvenio"));
			}
			 return configuracion2;
		}catch(Exception e) {
		
			System.out.println("error recuperando configuracion");
		
		}finally{
			try{
	
				if(con!=null)con.close();
				if(ps!=null)ps.close();
				if(rs!=null)rs.close();	
			}catch(Exception e) {
		
				e.printStackTrace();
			}
		}
		return configuracion2;
	}
	
	
	/*/ METODO PARA ACTUALIZAR LA CONFIGURACION EN LA BASE DE DATOS/*/
	public void updateConfig(Configuracion configuracion, Component parent) {
		
		try {
			con = getConnection();
			int i = -2;
			
			/* actualizamos en la base de datos los dias de vacaciones y convenio*/
			ps = con.prepareStatement("update configuracion set diasVacaciones = ?, diasConvenio = ?");
			System.out.println(configuracion.getDiasConvenio() + " estos son dias de convenio dentro de conexion");
			ps.setInt(1, configuracion.getDiasVacaciones());
			ps.setInt(2, configuracion.getDiasConvenio());
			
			int pregunta = -1;
			
			pregunta = mensajes.mensajePregunta(parent, "¿Esta seguro de querer cambiar la configuración actual?", "Confirmacion de cambios");
			System.out.println(pregunta);
			if(pregunta ==0) {
			i = ps.executeUpdate();
			
				if(i > 0) {
					mensajes.mensajeInfo(parent, "Configuración actualizada correctamente", "Actualización correcta");
				}else {
					mensajes.mensajeInfo(parent, "No se han podido guardar los cambios de la configuracion", "Actualización incorrecta");
				}
			
			}else {
				
				mensajes.mensajeInfo(parent, "Cambios en la configuracion cancelados", "Actualización incorrecta");
			}
			
		}catch(Exception e) {
		
			System.out.println("error actualizando configuracion");
		
		}finally{
			try{
	
				if(con!=null)con.close();
				if(ps!=null)ps.close();
				if(rs!=null)rs.close();	
			}catch(Exception e) {
		
				e.printStackTrace();
			}
		}
		configuracion = recuperaConfig();
	}


	/*/METODO PARA INSERTAR EMPLEADO/*/
	public void insertarEmpleado(Component parent, JComboBox comboNombre, Empleado empleado) {
		try {
			
			//COMPROBAMOS SI EL DNI YA EXISTE EN EL SISTEMA
			Integer i = -1;
			con = getConnection();
			ps= con.prepareStatement("SELECT * FROM empleado where dni =?");
			ps.setString(1, empleado.getDni());
			rs=ps.executeQuery();
			
			boolean b = rs.next();
			
			//SI EL DNI NO EXISTE GENERA LA CONSULTA PARA INSERTAR AL EMPLEADO
			if(!b) {
			ps = con.prepareStatement("INSERT INTO empleado (nombre, apellido1, apellido2, telefono, dni, tallaSuperior, tallaInferior, tallaPie, tipoCalzado, fechaRegistro) VALUES (?,?,?,?,?,?,?,?,?,?)");
			
			
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellido1());
			ps.setString(3, empleado.getApellido2());
			ps.setString(4, empleado.getTelefono());
			ps.setString(5, empleado.getDni());
			ps.setString(6, empleado.getTallaSuperior());
			ps.setString(7, empleado.getTallaInferior());
			ps.setString(8, empleado.getTallaPie());
			ps.setString(9, empleado.getTipoCalzado());
			ps.setDate(10, empleado.getFechaRegistro());
			
			i = ps.executeUpdate();
			
			
			/*/SI DEVUELVE ALGUN RESULTADO, RETORNA TRUE INDICANDO QUE HA HABIDO UNA INSERCION/*/
			
			if(i>0) {
				mensajes.mensajeInfo(parent, "El empleado ha sido insertado correctamente.", "Insercion correcta");
				devolverEmpleados(comboNombre, "");

			}else {
				mensajes.mensajeInfo(parent, "Ha habido un error en la inserción.", "Insercion incorrecta");
				
			}
			
			//SI EL DNI EXISTE, MUESTRA UN MENSAJE DE ERROR Y NO HACE LA INSERCION
			}else {
				mensajes.mensajeInfo(parent, "El empleado con el DNI que intenta introducir, ya existe en la base de datos.", "El Dni ya existe en la base de datos");
			}

			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage() + " Error ingresando empleado");
		}finally {
			try{
				if(con!=null)con.close();
				if(ps!=null)ps.close();
				if(rs!=null)rs.close();	
			}catch(Exception e) {
				
				System.out.println(e.getMessage());
			}
		}
	}
	
	
	/*/METODO PARA CONFIRMAR INCLUIR REGISTRO CON FECHA DUPLICADA/*/
	public boolean fechaDuplicada(int codigo, Component parent) {
		
		//comprobamos si hay entregas anteriores para ese trabajador, con una fecha igual a la misma que se intenta insertar
		try {
			con = getConnection();
			ps = con.prepareStatement("select ultimaEntrega from uniformidad where codigo = ?");
			ps.setInt(1,codigo);
			rs = ps.executeQuery();
			
			//si encuentra algun o varios resultados preguntará antes de hacer la insercion
			while(rs.next()) {
				Integer i = null;		
				if(rs.getDate(1).compareTo(new Date(local.toDate().getTime()))==0) {
					System.out.println("fechas iguales");
					i =  mensajes.mensajePregunta(parent,"Ya existe un registro con la misma fecha para esa entrega de uniformidad.\n"+
							"¿Desea continuar con la insercion?", "Confirmar insercion");
					System.out.println(i);		
				}

				//si respondemos que si en el cuadro, devolvera true.
				if(i==JOptionPane.YES_NO_OPTION) {
					return true;
					
				//si respondemos que no, devolveá false.	
				}else {
					return false;
				}

			}
		}catch(Exception e) {
			System.out.println(e.toString()+" en fecha duplicada");
			e.getMessage();
		}finally {
			try{
				if(con!=null)con.close();
				if(ps!=null)ps.close();
				if(rs!=null)rs.close();

			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//si no encuentra ninguna devolvera true;
		return true;
	}
	
	
	/*/METODO PARA BORRAR UNA FILA (si borra una o mas filas devuelve 1, sino devuelve 0 o -1 en caso de error/*/
	public void borrado(Component parent, String tabla, String columna, Integer clausula) {
		
		//PRIMERO HACEMOS UNA CONSULTAR PARA VER QUE EXISTE EL DATO QUE QUEREMOS BORRAR
		try {
			if(mensajes.mensajePregunta(parent, "¿Esta seguro de eliminar el registro?","Confirmar eliminar registro") == JOptionPane.YES_NO_OPTION) {
				Integer i;
				con = getConnection();
				ps=con.prepareStatement("select * from "+tabla+" where "+columna+" = ? ");
				ps.setInt(1, clausula);
				rs = ps.executeQuery();

				//SI EXISTE PROCEDEMOS A SU BORRADO
				if(rs.next()) {
					ps=con.prepareStatement("delete from "+tabla+" where "+columna+" = ?");
					ps.setInt(1, clausula);
					i = ps.executeUpdate();

					//SI SE BORRA UN OBJETO O MAS MOSTRAMOS UN MENSAJE CONFIRMANDO EL BORRADO Y SINO CONFIRMAMOS QUE NO SE HA PODIDO BORRAR
					if(i>0) {
						if(i==1) {
							mensajes.mensajeInfo(parent, i + " registro se ha borrado correctamente", "Registro borrado correctamente");	
						}else {
							mensajes.mensajeInfo(parent, i + " registros se han borrado", "Registros borrados correctamente");
						}
					}else {
						mensajes.mensajeInfo(parent, "No existe el registro que pretende borrar", "No existe el registro");
					}
					
					//SI NO EXISTE EL REGISTRO QUE QUEREMOS BORRAR MOSTRAMOS UN MENSAJE
				}else {		

					mensajes.mensajeInfo(parent, "No existe el registro que pretende borrar", "No existe el registro");

				}
				
			}else {
				mensajes.mensajeInfo(parent, "Ha cancelado borrar el registro", "Cancelado borrado");
			}

		}catch(Exception e) {

			System.out.println(e.getMessage() + " error en el delete");

		}finally {
			try{
				if(con!=null)con.close();
				if(ps!=null)ps.close();
				if(rs!=null)rs.close();

			}catch(Exception e) {

			}
		}	
	}
	
	/*/METODO PARA ACTUALIZAR EMPLEADO/*/
	
	public void actualizarEmpleado(Empleado empleado, Component parent) {
		
		int respuesta = mensajes.mensajePregunta(parent, "¿Está seguro de querer actualizar la información?", "Confirmar Actualizar");
		if(respuesta ==0) //si es igual a 0 han aceptado el update contra la base de datos 
		{
			try {
				con = getConnection();

				int i = -1;
				ps = con.prepareStatement("UPDATE empleado SET nombre = ?, apellido1 = ?, apellido2 = ?, telefono = ?, dni = ?, tallaSuperior = ?, tallaInferior = ?, tallaPie = ?, tipoCalzado = ? WHERE codigo = ?");			
				ps.setString(1, empleado.getNombre());
				ps.setString(2, empleado.getApellido1());
				ps.setString(3, empleado.getApellido2());
				ps.setString(4, empleado.getTelefono());
				ps.setString(5, empleado.getDni());
				ps.setString(6, empleado.getTallaSuperior());
				ps.setString(7, empleado.getTallaInferior());
				ps.setString(8, empleado.getTallaPie());
				ps.setString(9, empleado.getTipoCalzado());
				ps.setInt(10, empleado.getCodigo());


				i = ps.executeUpdate(); // devuelve la cantidad de filas afectadas con el update.

				if(i>0) mensajes.mensajeInfo(parent, "Informacion del empleado "+empleado.getCodigo()+" actualizada correctamente", "Actualización satisfactoria");

			}catch(Exception ex) {
				System.out.println("Error en actualizar empleado en clase conexion " + ex.getMessage());
			}finally {
				try{
					if(con!=null)con.close();
					if(ps!=null)ps.close();
					if(rs!=null)rs.close();	
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}else {
			mensajes.mensajeInfo(parent, "Cancelada la actualizacion de la información", "Actualización cancelada");
		}

	}
	
	/*/ METODO PARA INSERTAR UNIFORMIDAD/*/
	public void insertarUniformidad(Component parent, Empleado empleado, Uniformidad uniformidad){
		try {	
					boolean b = false;
					
					//primero comprobamos si hay una entrega previa que corresponda con la misma fecha, para evitar duplicidades
					 b = fechaDuplicada(empleado.getCodigo(), parent);	//				

					 //si no la hubiera o damos permiso para añadirla con fecha duplicada, devolveria true; 
					if(b) {
						con = getConnection();
						ps = con.prepareStatement("insert into uniformidad (codigo, camisa, forro, pantalon, zapatos, tipo, ultimaEntrega) values (?, ?, ?, ?, ?, ?, ?)");
						ps.setInt(1, empleado.getCodigo());
						ps.setString(2, uniformidad.getCamisa());
						ps.setString(3, uniformidad.getForro());
						ps.setString(4, uniformidad.getPantalon());
						ps.setDouble(5, uniformidad.getZapatos());
						ps.setString(6, uniformidad.getTipo());
						ps.setDate(7, uniformidad.getUltimaEntrega());

						int i = ps.executeUpdate();
						System.out.println("punto de control uniformidad3");

						if(i == 1) {
							System.out.println("** Uniformidad insertada correctamente para el empleado ");
							mensajes.mensajeInfo(parent, "Uniformidad insertada correctamente", "Insercion correcta");
						}else {
							System.out.println("** No se ha podido insertar la uniformidad para el empleado ");
							mensajes.mensajeInfo(parent, "Uniformidad no se ha podido insertar", "Error insertando uniformidad");
						}
						
						//si devuelve false, porque hayamos cancelado incluirla por duplicado mostrará un mensaje en pantalla
					}else {
						System.out.println("Se ha denegado duplicar fechas de entrega");
						mensajes.mensajeInfo(parent, "Se ha denegado duplicar las fechas de entrega", "Denegado duplicar entrega");
					}
				
		}catch(Exception e) {
			System.out.println("Error en añadir uniforme(conexion): " + e.getMessage());
		}finally {
			try{
				if(con!=null)con.close();
				if(ps!=null)ps.close();
				if(rs!=null)rs.close();	
			}catch(Exception e) {

				e.printStackTrace();
			}

		}


	}
	
	
	private ArrayList<Uniformidad> listaUniformes;
	private int diasPendienteVacaciones, diasPendienteConvenio, diasPendienteCompensatorio;
	private String unoEneroAñoActual = (new LocalDate().now().getYear()-1)+"-12-31";
	private String unoEneroAñoSiguiente =  (new LocalDate().now().getYear()+1)+"-01-01";
	private SimpleDateFormat fechaEneroActual = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat fechaEneroAñoSiguiente= new SimpleDateFormat("yyyy-MM-dd");
	private Vacaciones vacaciones;
	private Configuracion configuracion;
	private Uniformidad uniformidad;
	private Empleado empleado;
	private ArrayList<Empleado> listaEmpleados;
	private ArrayList<Vacaciones> listaVacaciones,listaVacacionesEmpleado;
	private LocalDate local = new LocalDate();
	private Mensajes mensajes = new Mensajes();
	private FormularioEmpleadoNuevo form;
	private LocalDate localdate;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
}
