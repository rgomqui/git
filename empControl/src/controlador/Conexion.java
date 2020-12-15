package controlador;


import java.awt.Color;
import java.awt.Component;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import modelo.Configuracion;
import modelo.Empleado;
import modelo.Uniformidad;
import modelo.Vacaciones;
import vista.FormularioEmpleadoNuevo;
import java.text.*;



public class Conexion{
	
	//public static final String URL= "jdbc:mysql://localhost:3306/empcontrol?useSSL=false&serverTimezone=UTC";
	//public static final String USER="root";
	//public static final String PASS="8142";
	
	//public final String URL= "jdbc:mysql://db4free.net:3306/pruebas479?useSSL=false&serverTimezone=UTC";
    //public final String USER="rgomqui";
    //public final String PASS = "44760093";
    
    public final String URL = "jdbc:mysql://sql262.main-hosting.eu:3306/u877485772_empcontrol?useSSL=false&serverTimezone=UTC";
    public final String USER = "u877485772_rgomqui";
    public final String PASS = "Rafa44760093.";
	
	///id12310196_rgomqui
	
	
    
  
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
			listaEmpleados = new ArrayList();
			if(texto != "") {
				con = getConnection();
				ps = con.prepareStatement("select * from empleado where nombre LIKE ?  or apellido1 LIKE ? or apellido2 LIKE ?");
				ps.setString(1, "%"+texto+"%");
				ps.setString(2, "%"+texto+"%");
				ps.setString(3, "%"+texto+"%");
				rs = ps.executeQuery(); 
			}else {
				con = getConnection();
				ps = con.prepareStatement("select * from empleado");
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
			System.out.println(e.getMessage());
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
		
	
	/*/METODO PARA RELLENAR LOS CAMPOS DE UNIFORMIDAD AL SELECCIONAR EMPLEADO EN EL JCOMBOBOX/*/
	public Uniformidad devolverUniformidad(int codigoEmpleado) {
		try {
			con = getConnection();
			
			ps=con.prepareStatement("select * from uniformidad where codigo=?");
			ps.setInt(1, codigoEmpleado);
			rs = ps.executeQuery();
			while(rs.next()) {
				uniformidad = new Uniformidad();
				uniformidad.setCodigo(codigoEmpleado);
				uniformidad.setInferior(rs.getString("inferior"));
				uniformidad.setSuperior(rs.getString("superior"));
				uniformidad.setTallaPie(rs.getDouble("tallaPie"));
				uniformidad.setTipo(rs.getString("tipo"));
				uniformidad.setUltimaEntrega(rs.getDate("ultimaEntrega"));
				return uniformidad;
			}
			return null;
		}catch(Exception e) {
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

	/*/ METODO PARA DEVOLVER DIAS DE DESCANSO PENDIENTES DE DISFRUTAR/*/
	public void devolverVacaciones(int codigoEmpleado, JTextField txtCompensatorio, JTextField txtConvenio, JTextField txtVacaciones, JTextField txtPermiso) {
		
	diasPendienteVacaciones =0;
	diasPendienteConvenio = 0;
	diasPendientecompensatorio = 0;
	diasPendientePermiso = 0;
	
		try {
			con = getConnection();
			
			/* hacemos una consulta de todos los descansos del trabajador*/
			ps = con.prepareStatement("select * from vacaciones where codigo=?");
			ps.setInt(1, codigoEmpleado);
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Date fechaDevengo = rs.getDate("fechaDevengo"); // guardamos la fecha de devengo para ver a que año corresponde el descanso
				listaVacaciones = new ArrayList();
				vacaciones = new Vacaciones();
			
			//if(fechaDevengo !=null && fechaDevengo.after(fechaEneroActual.parse(unoEneroAñoActual)) &&  fechaDevengo.before(fechaEneroAñoSiguiente.parse(unoEneroAñoSiguiente)))System.out.println("Es de este año");
				vacaciones.setCodigo(rs.getInt("codigo"));
				vacaciones.setId(rs.getInt("id"));
				vacaciones.setDiasPorDisfrutar(rs.getInt("diasPorDisfrutar"));
				vacaciones.setDisfrutado(rs.getBoolean("disfrutado"));
				vacaciones.setFechaDevengo((rs.getDate("fechaDevengo")==null)?null:(rs.getDate("fechaDevengo")));
			
				if(rs.getBoolean("disfrutado")) {
					vacaciones.setFechaInicio(rs.getDate("fechaInicio"));
					vacaciones.setFechaFin(rs.getDate("fechaFin"));
				}
			vacaciones.setMesCompleto(rs.getBoolean("mesCompleto"));
			vacaciones.setObservaciones(rs.getString("observaciones"));
			vacaciones.setTipo(rs.getString("tipo"));
			
			listaVacaciones.add(vacaciones);  // guardamos en el arraylist todos los resultados de vacaciones del empleado buscado.
			
			}
			
			for(Vacaciones v:listaVacaciones) {
				if(v.getTipo().equals("vacaciones")) {
					diasPendienteVacaciones = Days.daysBetween(new LocalDate(v.getFechaInicio()), new LocalDate(v.getFechaFin())).getDays();
					++diasPendienteVacaciones;
				}
				if(v.getTipo().equals("convenio")) {
					diasPendienteConvenio+=diasPendienteConvenio;
				}
				if(v.getTipo().equals("compensatorio")) {
					diasPendientecompensatorio += v.getDiasPorDisfrutar();
				}
				if(v.getTipo().equals("permiso")) {
					diasPendientePermiso += v.getDiasPorDisfrutar();
				}
	
			}
			
			configuracion = recuperaConfig();
			diasPendienteVacaciones = configuracion.getDiasVacaciones()-diasPendienteVacaciones;
			diasPendienteConvenio = configuracion.getDiasConvenio()-diasPendienteConvenio;
			
			txtConvenio.setText(String.valueOf(diasPendienteConvenio));
			txtCompensatorio.setText(String.valueOf(diasPendientecompensatorio));
			txtVacaciones.setText(String.valueOf(diasPendienteVacaciones));
			txtPermiso.setText(String.valueOf(diasPendientePermiso));
				
		}catch(Exception e) {
			System.out.println("No hay vacaciones para mostrar");
			//e.printStackTrace();
			
		}finally{
			try{
		
			if(con!=null)con.close();
			if(ps!=null)ps.close();
			if(rs!=null)rs.close();	
		}catch(Exception e) {
			
			
			//e.printStackTrace();
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
		
	}


	/*/METODO PARA INSERTAR EMPLEADO/*/
	public void insertarEmpleado(JLabel visor, JComboBox comboNombre, Empleado empleado) {
		try {
			
			Integer i = -1;
			con = getConnection();
			ps= con.prepareStatement("SELECT * FROM empleado where dni =?");
			ps.setString(1, empleado.getDni());
			rs=ps.executeQuery();
			
			boolean b = rs.next();
			System.out.println(b + " existe o no el dni");
			if(!b) {
				System.out.println("punto de control");
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
			
			
			}
			
			
			
			/*/SI DEVUELVE ALGUN RESULTADO, RETORNA TRUE INDICANDO QUE HA HABIDO UNA INSERCION/*/
			
			if(i>0) {
				mensajes.mensajeVisorEmpNuevo(visor, mensajes.verdeOscuro,"** El empleado ha sido insertado correctamente.");
				devolverEmpleados(comboNombre, "");

			}else {
				mensajes.mensajeVisorEmpNuevo(visor, mensajes.rojo, "** El empleado ya existe en la base de datos.");
				
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
	public boolean fechaDuplicada(int codigo) {
		
		try {
			con = getConnection();
			ps = con.prepareStatement("select ultimaEntrega from uniformidad where codigo = ?");
			ps.setInt(1,codigo);
			rs = ps.executeQuery();
		while(rs.next()) {
			Integer i = 25;		
			if(rs.getDate(1).compareTo(new Date(local.toDate().getTime()))==0) {
				System.out.println("fechas iguales");
				i =  mensajes.mensajePregunta(form.getParent(),"Ya existe un registro con la misma fecha para esa entrega de uniformidad.\n"+
						"¿Desea continuar con la insercion?", "Confirmar insercion");
				System.out.println(i);		
			}
			
			if(i!=null)return(i==0)?true:false;
				
		}
		}catch(Exception e) {
			System.out.println(e.toString()+" 1");
			e.getMessage();
		}finally {
			try{
				if(con!=null)con.close();
				if(ps!=null)ps.close();
				if(rs!=null)rs.close();
				
			}catch(Exception e) {
				
				System.out.println(e.toString() + "2");
			}
		}
		return true;
	}
	
	
	/*/METODO PARA BORRAR UNA FILA/*/
	public int borrado(String tabla, Integer clausula) {
		
		try {
			Integer i;
			con = getConnection();
			ps=con.prepareStatement("select * from "+tabla+" where codigo = ? ");
			ps.setInt(1, clausula);
			rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("hay registros");
				ps=con.prepareStatement("delete from "+tabla+" where codigo = ?");
				ps.setInt(1, clausula);
				System.out.println(ps.toString());
				i = ps.executeUpdate();
				return(i>0)?0:1;
			}else {
				return -1;
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
		return -1;		
	}
	
	/*/METODO PARA ACTUALIZAR EMPLEADO/*/
	
	public void actualizarEmpleado() {
		System.out.println(" Error actualizando empleado");
		try {
			
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
			i = ps.executeUpdate();
			

			
			if(i>0) {
			}else {
				
			}
			
		}catch(SQLException ex) {
			System.out.println(ex.getSQLState());
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
	
	/*/ METODO PARA INSERTAR UNIFORMIDAD/*/
	public void insertarUniformidad(JLabel visor, Empleado empleado, Uniformidad uniformidad){
		try {
			if(fechaDuplicada(empleado.getCodigo())) {
				con = getConnection();
				ps = con.prepareStatement("select codigo from empleado where dni =?");
				ps.setString(1,empleado.getDni());
				rs = ps.executeQuery();

				if(rs.next()) {
					uniformidad.setCodigo(rs.getInt("codigo"));
					System.out.println(uniformidad.toString());	
					boolean b = fechaDuplicada(uniformidad.getCodigo());					
					System.out.println("booleano de entrada al if para ingresar uniformidad " + b);
					if(b) {
						con = getConnection();
						ps = con.prepareStatement("insert into uniformidad (codigo, superior, inferior, tallaPie, tipo, ultimaEntrega) values (?, ?, ?, ?, ?, ?)");
						ps.setInt(1, uniformidad.getCodigo());
						ps.setString(2, uniformidad.getSuperior());
						ps.setString(3, uniformidad.getInferior());
						ps.setDouble(4, uniformidad.getTallaPie());
						ps.setString(5, uniformidad.getTipo());
						ps.setDate(6, uniformidad.getUltimaEntrega());

						int i = ps.executeUpdate();
						System.out.println("punto de control uniformidad3");

						if(i == 1) {
							System.out.println("** Uniformidad insertada correctamente para el empleado ");
							mensajes.mensajeVisorEmpNuevo(visor, mensajes.verdeOscuro, "**Uniformidad insertada correctamente");
						}else {
							System.out.println("** No se ha podido insertar la uniformidad para el empleado ");
							mensajes.mensajeVisorEmpNuevo(visor, mensajes.rojo, "**Uniformidad no insertada");
						}
					}else {
						System.out.println("Se ha denegado duplicar fechas de entrega");
						mensajes.mensajeVisorEmpNuevo(visor, mensajes.rojo, "**Se ha denegado duplicar las fechas de entrega");
					}
					System.out.println("finally de uniformidad");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
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
	
	private int diasPendienteVacaciones;
	private int diasPendienteConvenio;
	private int diasPendientecompensatorio;
	private int diasPendientePermiso;
	private String unoEneroAñoActual = (new LocalDate().now().getYear()-1)+"-12-31";
	private String unoEneroAñoSiguiente =  (new LocalDate().now().getYear()+1)+"-01-01";
	private SimpleDateFormat fechaEneroActual = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat fechaEneroAñoSiguiente= new SimpleDateFormat("yyyy-MM-dd");
	private Vacaciones vacaciones;
	private Configuracion configuracion= new Configuracion();
	private Uniformidad uniformidad;
	private Empleado empleado;
	private ArrayList<Empleado> listaEmpleados;
	private ArrayList<Vacaciones> listaVacaciones;
	private LocalDate local = new LocalDate();
	private Mensajes mensajes = new Mensajes();
	private FormularioEmpleadoNuevo form;
	private LocalDate localdate;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
}
