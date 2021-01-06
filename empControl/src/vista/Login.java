package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controlador.Conexion;


public class Login extends JFrame{
	
	public Login(){
		
		this.setSize(300, 400);
		this.setTitle("EmpControl 1.0");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Image icon = new ImageIcon("src/img/icono.png").getImage();
		this.setIconImage(icon);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		componentesGraficos();
		}
	
	
	public void componentesGraficos() {
		
		panelFondo = new JPanel();
		panelFondo.setBackground(new Color(198,222,235));
		panelFondo.setLayout(null);
		panelFondo.setFocusable(true);
		panelFondo.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				metodoAcceso();
				
			}
		});
		this.add(panelFondo);
		
		btnIcono = new JButton();
		btnIcono.setBounds(110,30,70,70);
		
		try {
			Image icono = new ImageIcon("src/img/empleado.png").getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
			btnIcono.setIcon(new ImageIcon(icono));
			btnIcono.setContentAreaFilled(false);
			btnIcono.setBorderPainted(false);
			}catch ( Exception e){
				System.out.println("Error al cargar la imagen " + e.getMessage());
			}	
		
		panelFondo.add(btnIcono);
		
		lblTitulo = new JLabel("Introduzca las credenciales");
		lblTitulo.setBounds(55,120,200,30);
		lblTitulo.setFont(fuente);
		panelFondo.add(lblTitulo);
		
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(75, 160, 150, 20);
		txtUsuario.setText("Nombre de usuario");
		txtUsuario.setToolTipText("Introduzca el nombre de usuario");
		txtUsuario.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getKeyChar()== KeyEvent.VK_ENTER) {
				metodoAcceso();
				}
			}
		});
		txtUsuario.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUsuario.getText().equals("Nombre de usuario")) txtUsuario.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsuario.getText().equals("")) txtUsuario.setText("Nombre de usuario");	
			}
			
			
		});
		panelFondo.add(txtUsuario);
		
		
		//textfield pass
		
		 
		txtPass = new JPasswordField();
		txtPass.setBounds(75, 200, 150, 20);
		txtPass.setText("Contraseña");
		txtPass.setToolTipText("Introduzca contraseña");
		txtPass.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getKeyChar()== KeyEvent.VK_ENTER) {
					metodoAcceso();
					}
			}
		});
		
		txtPass.addFocusListener(new FocusListener() {
		
			
		
			@Override
			public void focusGained(FocusEvent e) {
				if(new String(txtPass.getPassword()).equals("Contraseña")) txtPass.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {				
				if(new String(txtPass.getPassword()).equals("")) txtPass.setText("Contraseña");	
			}
			
			
		});
		panelFondo.add(txtPass);

		btnEntrar = new JButton();
		btnEntrar.setBounds(50, 260, 50, 50);
		btnEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				metodoAcceso();
				
				
			}
		});
		
		try {
			Image icono = new ImageIcon("src/img/entrar.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			btnEntrar.setIcon(new ImageIcon(icono));
			btnEntrar.setContentAreaFilled(false);
			btnEntrar.setBorderPainted(false);
			}catch ( Exception e){
				System.out.println("Error al cargar la imagen " + e.getMessage());
			}	
		
		lblEntrar = new JLabel("ENTRAR");
		lblEntrar.setBounds(50, 310, 100, 20);
		lblEntrar.setFont(new Font("arial",1, 13));
		
		panelFondo.add(btnEntrar);
		panelFondo.add(lblEntrar);
		
		
		btnSalir = new JButton();
		btnSalir.setBounds(180,260,50,50);
		try {
			Image icono = new ImageIcon("src/img/cerrar.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			btnSalir.setIcon(new ImageIcon(icono));
			btnSalir.setContentAreaFilled(false);
			btnSalir.setBorderPainted(false);
			}catch ( Exception e){
				System.out.println("Error al cargar la imagen " + e.getMessage());
			}	
		
			btnSalir.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			
			lblSalir = new JLabel("SALIR");
			lblSalir.setBounds(185, 310, 50, 20);
			lblSalir.setFont(new Font("arial",1, 13));
			
		
		panelFondo.add(btnSalir);
		panelFondo.add(lblSalir);

		
		
	}
	
	//METODO PARA ACCEDER
	
	private void metodoAcceso() {
		if(conexion.login(txtUsuario.getText().toString(), new String(txtPass.getPassword()))) {
			
			vMenu = new VentanaMenuPrincipal();
			vMenu.setVisible(true);
			dispose();
		}else {
			JOptionPane.showMessageDialog(null, "Usuario Erroneo", "Usuario Erroneo", JOptionPane.ERROR_MESSAGE);
		}
	}

	
	private Conexion conexion = new Conexion();
	private String cadenaPass = new String();
	private VentanaMenuPrincipal vMenu;
	private Font fuente = new Font("arial", 3, 15);
	private JLabel lblUsuario, lblPass, lblTitulo, lblEntrar, lblSalir;
	private JTextField txtUsuario;
	private JPasswordField txtPass;
	private JPanel panelFondo;
	private JButton btnIcono, btnEntrar, btnSalir;

	
}
