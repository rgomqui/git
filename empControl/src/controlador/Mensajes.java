package controlador;


import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import vista.FormularioActualizarEmpleado;
import vista.FormularioActualizarVacaciones;
import vista.FormularioEmpleadoNuevo;
import vista.FormularioVacacionesNueva;

public class Mensajes {
	
	public Mensajes(){
	}
	
	/*/ METODO MENSAJE PARA INFORMAR/*/
	
	public void mensajeInfo(Component parent, String mensaje, String titulo) {
		JOptionPane.showMessageDialog(parent, mensaje,titulo, JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	
	/*/METODO MENSAJE PARA PREGUNTAR OPCION/*/
	public Integer mensajePregunta(Component parent,String mensaje, String titulo) {
		Integer i;
		i = JOptionPane.showConfirmDialog(parent, mensaje,titulo,JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION);
		return(i==null)?25:i;
	}
	
	/*/METODO PARA ENVIAR MENSAJE AL LBL DE LA APLICACION/*/
	
	public void mensajeVisorEmpNuevo(JLabel componente,Color color, String mensaje) {
		
		componente.setText(mensaje);
		componente.setForeground(color);
		System.out.println(mensaje);
	}
	
	Color verdeOscuro = new Color(67,185,86);
	Color rojo = new Color(227,36,27); 
	FormularioEmpleadoNuevo empNuevo;
	FormularioActualizarEmpleado empActualiza;
	FormularioActualizarVacaciones vacacionesActualiza;
	FormularioVacacionesNueva vacacionesNuevo;

}
