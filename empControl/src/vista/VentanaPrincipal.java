package vista;


public class VentanaPrincipal{
	
	public void ventanaMenu() {
		menu = new VentanaMenuPrincipal();
		menu.setVisible(true);
		
	}
	public void ventanaLogin() {
		login = new VentanaLogin();
		login.setVisible(true);
	}
	public void ventanaEmpleado() {
		try {
		empleado = new PanelEmpleado();
		
		}catch(Exception e) {
			 System.out.println(e.getMessage());
			}
	}
	
	
	
	VentanaMenuPrincipal menu;
	VentanaLogin login;
	PanelEmpleado empleado;
	
}