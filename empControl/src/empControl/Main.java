package empControl;

import javax.swing.SwingUtilities;

import vista.*;

public class  Main{

	public static void main(String[] args) {
		VentanaMenuPrincipal v2 = new VentanaMenuPrincipal();
		Login login = new Login();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() { 
				//login.setVisible(true);
				v2.setVisible(true);
				} 
			});
		
	}

}
