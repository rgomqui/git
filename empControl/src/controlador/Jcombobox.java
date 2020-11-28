package controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Empleado;
import vista.PanelEmpleado;

public class Jcombobox{
	
	public Jcombobox(){
		
		
	}	
	
	public void comboBox (String cadena) {
		
		ArrayList <Object> nombres = new ArrayList<Object>();
		Conexion con = new Conexion();
		
		
		try {
			Connection conexion = con.getConnection();
			PreparedStatement ps;
			ResultSet rs;
			
			ps = conexion.prepareStatement("select * from empleado where nombre like %" + cadena +"%;");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String cadena1 = rs.getString(1)+ " "+rs.getString(2)+" "+rs.getString(3);
				nombres.add(cadena1);
			}
			
			for( Object s: nombres) empleado.comboCodigo.add((Component) s);
			

		} catch (SQLException e) {
			e.printStackTrace();;
		}

			}
					
	public void tecladoNombre() {
		JOptionPane.showConfirmDialog(null, "prueba1");
	}

	KeyListener eventoTeclado;
	
	
	PanelEmpleado empleado = new PanelEmpleado();
}

