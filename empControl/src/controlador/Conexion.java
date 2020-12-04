package controlador;


import java.awt.Color;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JComboBox;
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
	
	
	/*/METODO PARA DEVOLVER AL COMBOBOX TODOS LOS EMPLEADOS AL CARGAR LA PESTAÑA EMPLEADO/*/
	public void devolverEmpleados(JComboBox comboNombre) {
		try {
		con = getConnection();
		ps = con.prepareStatement("select * from empleado");
		rs = ps.executeQuery();
		listaEmpleados = new ArrayList(); 
		
		while(rs.next()) {
			empleado = new Empleado();
			empleado.setCodigo(rs.getInt("codigo"));
			empleado.setNombre(rs.getString("nombre"));
			empleado.setApellido1(rs.getString("apellido1"));
			empleado.setApellido2(rs.getString("apellido2"));
			empleado.setTelefono(rs.getString("telefono"));
			empleado.setDni(rs.getString("dni"));
			
			listaEmpleados.add(empleado);	
		}
				
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
			
			recuperaConfig();
			diasPendienteVacaciones = configuracion.getDiasVacaciones()-diasPendienteVacaciones;
			diasPendienteConvenio = configuracion.getDiasConvenio()-diasPendienteConvenio;
			
			txtConvenio.setText(String.valueOf(diasPendienteConvenio));
			txtCompensatorio.setText(String.valueOf(diasPendientecompensatorio));
			txtVacaciones.setText(String.valueOf(diasPendienteVacaciones));
			txtPermiso.setText(String.valueOf(diasPendientePermiso));
				
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
	}
	
	/*/METODO PARA RESCATAR LA CONFIGURACION DE LA BASE DE DATOS/*/
	
	public void recuperaConfig() {
		try {
			configuracion = new Configuracion();
			/* rescatamos los dias predefinidos que estan guardados en la base de datos*/
			ps = con.prepareStatement("select * from configuracion"); 
			rs=ps.executeQuery();
			if(rs.next()){
				configuracion.setDiasVacaciones(rs.getInt("diasVacaciones"));
				configuracion.setDiasConvenio(rs.getInt("diasConvenio"));
			}
			
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
	}

	
	/*/METODO PARA RELLENAR LOS CAMPOS DE EMPLEADO AL SELECCIONARLO EN EL JCOMBOBOX/*/
	public void devolverEmpleadosConBusqueda(JComboBox comboNombre, String texto) {
		try {
		con = getConnection();
		
		ps = con.prepareStatement("select * from empleado where nombre LIKE ?  or apellido1 LIKE ? or apellido2 LIKE ?");
		ps.setString(1, "%"+texto+"%");
		ps.setString(2, "%"+texto+"%");
		ps.setString(3, "%"+texto+"%");
		rs = ps.executeQuery();
		listaEmpleados = new ArrayList(); 
		
		while(rs.next()) {
			empleado = new Empleado();
			empleado.setCodigo(rs.getInt("codigo"));
			empleado.setNombre(rs.getString("nombre"));
			empleado.setApellido1(rs.getString("apellido1"));
			empleado.setApellido2(rs.getString("apellido2"));
			empleado.setTelefono(rs.getString("telefono"));
			empleado.setDni(rs.getString("dni"));
			
			System.out.println(empleado);
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
			
			e.printStackTrace();
		}
		}
		
		
	}
	
	
	/*/METODO PARA INSERTAR EMPLEADO/*/
	public boolean insertarEmpleado(Empleado empleado, Uniformidad uniformidad) {
		System.out.println("entra en empleado");
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
			ps = con.prepareStatement("INSERT INTO empleado (nombre, apellido1, apellido2, telefono, dni) VALUES (?,?,?,?,?)");
			
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellido1());
			ps.setString(3, empleado.getApellido2());
			ps.setString(4, empleado.getTelefono());
			ps.setString(5, empleado.getDni());
			
			i = ps.executeUpdate();
			
			insertarUniformidad(empleado, uniformidad);
			
			}
			
			
			
			/*/SI DEVUELVE ALGUN RESULTADO, RETORNA TRUE INDICANDO QUE HA HABIDO UNA INSERCION/*/
			
			if(i>0) {
				return true;
			
				
			}else {
				return false;
				
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
		return false;
	}
	
	
	/*/METODO PARA CONFIRMAR INCLUIR REGISTRO CON FECHA DUPLICADA/*/
	public boolean fechaDuplicada(Integer codigo) {
		
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
	
	
	/*/ METODO PARA INSERTAR UNIFORMIDAD/*/
	public void insertarUniformidad(Empleado empleado, Uniformidad uniformidad){
		try {
			 con = getConnection();
			 ps = con.prepareStatement("select codigo from empleado where dni =?");
			 ps.setString(1,empleado.getDni());
			 rs = ps.executeQuery();
				
			if(rs.next()) {
					Integer codigo = rs.getInt(1);
					System.out.println("codigo del empleado a ingresar la uniformidad: " + codigo);	
					boolean b = fechaDuplicada(codigo);					
					System.out.println("booleano de entrada al if para ingresar uniformidad " + b);
					if(b) {
						System.out.println(uniformidad.toString());
						ps = con.prepareStatement("insert into uniformidad (codigo, superior, inferior, tallaPie, tipo, ultimaEntrega) values (?, ?, ?, ?, ?, ?)");
						System.out.println("codigo de empleado: " + codigo);
						ps.setInt(1, codigo);
						ps.setString(2, uniformidad.getSuperior());
						ps.setString(3, uniformidad.getInferior());
						ps.setDouble(4, uniformidad.getTallaPie());
						ps.setString(5, uniformidad.getTipo());
						ps.setDate(6, uniformidad.getUltimaEntrega());
						
						rs = ps.executeQuery();
				
						if(rs.next()) {
							mensajes.mensajeVisorEmpNuevo(form.lblMensajeError,verdeOscuro, "** Uniformidad insertada correctamente para el empleado " + codigo);
						}else {
							mensajes.mensajeVisorEmpNuevo(form.lblMensajeError,Color.red, "** No se ha podido insertar la uniformidad para el empleado " + codigo);
						}
				}else {
					mensajes.mensajeVisorEmpNuevo(form.lblMensajeError,Color.red,"Se ha denegado duplicar fechas de entrega" );
				}
			}	
			}catch(Exception e) {
				e.getMessage();
			}finally {
				try{
					if(con!=null)con.close();
					if(ps!=null)ps.close();
					if(rs!=null)rs.close();	
				}catch(Exception e) {
					
					e.printStackTrace();
				}
				System.out.println("finally de uniformidad");
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
	private Configuracion configuracion;
	private Uniformidad uniformidad;
	private Empleado empleado;
	private ArrayList<Empleado> listaEmpleados;
	private ArrayList<Vacaciones> listaVacaciones;
	private LocalDate local = new LocalDate();
	private Color verdeOscuro = new Color(67,185,86);
	private Color rojo = new Color(227,36,27); 
	private Mensajes mensajes = new Mensajes();
	private FormularioEmpleadoNuevo form;
	private LocalDate localdate;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
}
