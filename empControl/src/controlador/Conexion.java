package controlador;


import java.sql.*;

import modelo.Empleado;
import modelo.Uniformidad;

public class Conexion {
	
	public static final String URL= "jdbc:mysql://localhost:3306/empcontrol?useSSL=false&serverTimezone=UTC";
	public static final String USER="root";
	public static final String PASS="8142";
	
	//public final String URL= "jdbc:mysql://db4free.net:3306/pruebas479";
    //public final String USER="rgomqui";
    //public final String PASS = "44760093";
	
	/*/ METODO PARA CONECTAR CON LA BBDD/*/
	
	public Conexion(){
		
	}
	
	public Connection getConnection() {
	  
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =(Connection) DriverManager.getConnection(URL,USER,PASS);
			System.out.println("conexion exitosa");
		} catch (Exception e) {	
			
			
		}	
		
		return con;	
	}
	
	/*/METODO PARA INSERTAR EMPLEADO/*/
	
	public void insertarEmpleado(Empleado empleado/*, Uniformidad uniformidad*/) {
		
		try {
			con =getConnection();
			ps = con.prepareStatement("INSERT INTO empleado (nombre, apellido1, apellido2, telefono, dni)"+
										" VALUES (?,?,?,?,?)");
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellido1());
			ps.setString(3, empleado.getApellido2());
			ps.setString(4, empleado.getTelefono());
			ps.setString(5, empleado.getDni());
			
			Integer i = ps.executeUpdate();
			
			System.out.println(i + " registros insertados.");
			
			/*if(rs.rowInserted()) {
				
				ps=con.prepareStatement("select codigo from empleado where dni = ?");
				ps.setString(1, empleado.getDni());
				
				rs = ps.executeQuery();
				
				ps= con.prepareStatement("INSERT INTO uniformidad (codigo, superior, inferior, tallaPie, tipo, ultimaEntrega)"+
											"VALUES (?, ?, ?, 39, 'cerrado', '2020-06-12');");
				
				ps.setInt(1, rs.getInt(1));
				ps.setString(2, uniformidad.getSuperior());
				ps.setString(3, uniformidad.getInferior());
				ps.setDouble(4, uniformidad.getTallaPie());
				ps.setString(5, uniformidad.getTipo());
				ps.setDate(6, uniformidad.getUltimaEntrega());
				
				rs = ps.executeQuery();
				
				if(rs.rowInserted()) {
					System.out.println("registro uniforme insertado");
				}else {
					System.out.println("registro uniforme erroneo");
				}
				
			}*/
			
		}catch(Exception ex) {
			System.out.println("error en conexion insertando empleado");
		}
		
	}
	
	
	/*/ METODO PARA HACER LOGIN  rafa 0000/*/
	
	public boolean login(String user, String pass){
		
		try {
			con = getConnection();
			ps = con.prepareStatement("select * from login where usuario = ? AND pass = ?");
			
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				rs.close();
				ps.close();
				con.close();
				return true;
			}else{
				rs.close();
				ps.close();
				con.close();
			return false;
			
		}
			
		}catch(Exception e) {
				System.out.println("error SQL");
				return false;
		}		
	}
	
	
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
}
