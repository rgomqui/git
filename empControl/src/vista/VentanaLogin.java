package vista;

import java.awt.*;

import javax.swing.*;

public class VentanaLogin extends JFrame{
	
	public  VentanaLogin() {
			
			this.setSize(500, 450);
			this.setTitle("FerroJob  0.1");
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			panelFondoGeneral();
			componentes();
	}
	
	private void panelFondoGeneral() {
		
		panelFondoGeneral = new JPanel();
		panelFondoGeneral.setBackground(new Color(244,208,63));
		panelFondoGeneral.setLayout(null);
		this.add(panelFondoGeneral);
		
	}
	
	private void componentes() {
		labelUsuario = new JLabel("USUARIO: ");
		labelPass = new JLabel("CONTRASEÑA: ");
		txtUsuario = new JTextField();
		txtPass = new JTextField();
		
		labelUsuario.setBounds(50, 50, 100, 30);
		txtUsuario.setBounds(150, 50, 50, 30);
		
		
		this.add(labelUsuario);
		this.add(txtUsuario);
	}
	
	JPanel panelFondoGeneral;
	JLabel labelUsuario, labelPass;
	JTextField txtUsuario, txtPass;

}
