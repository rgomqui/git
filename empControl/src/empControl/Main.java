package empControl;

import javax.swing.SwingUtilities;

import vista.*;

public class  Main{

	public static void main(String[] args) {
		Login login = new Login();
		VentanaMenuPrincipal v1 = new VentanaMenuPrincipal();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() { 
				//login.setVisible(true);	
				v1.setVisible(true);
				} 
			});
		
	}

}
