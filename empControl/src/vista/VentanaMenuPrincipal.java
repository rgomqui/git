package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;





public class VentanaMenuPrincipal extends JFrame{
	
public VentanaMenuPrincipal(){
	
	
	this.setSize(770, 560);
	
	this.setTitle("EmpControl 1.0");
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	Image icon = new ImageIcon("src/img/icono.png").getImage();
	this.setIconImage(icon);
	this.setResizable(false);
	this.setLocationRelativeTo(null);
		panelFondoPrincipal();
		iniciarComponentes();
		panelScroll();
	}
	
	 void panelFondoPrincipal() {
		panelFondoMenu = new JPanel();
		panelFondoMenu.setBackground(new Color(198,222,235));
		panelFondoMenu.setLayout(null);
		this.add(panelFondoMenu);
	}
	 
	 private void panelScroll() {
		 scrollPaneles = new JScrollPane();
		 scrollPaneles.setBounds(130,60,650,520);
		 scrollPaneles.setBorder(BorderFactory.createEmptyBorder());
		 
		
		 panelFondoMenu.add(scrollPaneles);
		 empleado = new PanelEmpleado();
		 vacaciones = new PanelVacaciones();
		scrollPaneles.setViewportView(empleado);
	 }
	 
	 
	 private void iniciarComponentes() {
		 
		 
		 //******************//
		 //     TITULO       //
		 //******************//
		 
		 Font fuente = new Font("arial", 1, 30);
			lblTitulo = new JLabel("EMPLEADOS");
			lblTitulo.setBounds(320,20,400,30);
			lblTitulo.setFont(fuente);
			panelFondoMenu.add(lblTitulo);
		 
		 //*****************//
		 // ICONO EMPLEADO //
		 //****************//
		 
		 iconoEmpleado = new JButton();
			iconoEmpleado.setBounds(45, 70,50,50);
			labelPersonal = new JLabel("EMPLEADOS");
			labelPersonal.setBounds(35, 120, 100, 30);
			try {
			Image icono = new ImageIcon("src/img/empleado.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			iconoEmpleado.setIcon(new ImageIcon(icono));
			iconoEmpleado.setContentAreaFilled(false);
			iconoEmpleado.setBorderPainted(false);
			}catch ( Exception e){
				System.out.println("Error al cargar la imagen " + e.getMessage());
			}	
			
			
			iconoEmpleado.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					scrollPaneles.setViewportView(empleado);
					lblTitulo.setText("EMPLEADOS");
				}
			});
			
			panelFondoMenu.add(iconoEmpleado);
			panelFondoMenu.add(labelPersonal);
			
			
			
			//************************************//
			//        ICONO DESCANSOS			 //
			//**********************************//
			iconoCuadrante = new JButton();
			iconoCuadrante.setBounds(48, 180,50,50);
			labelCuadrante = new JLabel("DESCANSOS");
			labelCuadrante.setBounds(35, 230,100,30);
			try {
			Image icono = new ImageIcon("src/img/descanso.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			iconoCuadrante.setIcon(new ImageIcon(icono));
			iconoCuadrante.setContentAreaFilled(false);
			iconoCuadrante.setBorderPainted(false);
			}catch ( Exception e){
				System.out.println("Error al cargar la imagen " + e.getMessage());
			}	
			
			panelFondoMenu.add(iconoCuadrante);
			panelFondoMenu.add(labelCuadrante);
			
			iconoCuadrante.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					vacaciones = new PanelVacaciones();
					scrollPaneles.setViewportView(vacaciones);
					lblTitulo.setText("VACACIONES");
				}
			});
			
			
			//***********************//
			//   ICONO AJUSTES      //
			//**********************//
			
			iconoConfiguracion = new JButton();
			iconoConfiguracion.setBounds(40, 290,60,60);
			labelConfiguracion = new JLabel("AJUSTES");
			labelConfiguracion.setBounds(42, 350, 100, 30);
			try {
			Image icono = new ImageIcon("src/img/configuracion.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			iconoConfiguracion.setIcon(new ImageIcon(icono));
			iconoConfiguracion.setContentAreaFilled(false);
			iconoConfiguracion.setBorderPainted(false);
			}catch ( Exception e){
				System.out.println("Error al cargar la imagen " + e.getMessage());
			}
			
			iconoConfiguracion.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
						ajustes = new PanelAjustes();
						scrollPaneles.setViewportView(ajustes);
						lblTitulo.setText("AJUSTES");
				}
			});
			
			panelFondoMenu.add(iconoConfiguracion);
			panelFondoMenu.add(labelConfiguracion);
			
			
			//**********************//
			//   ICONO SALIR       //
			//*********************//
			
			iconoCerrar = new JButton();
			iconoCerrar.setBounds(40, 410,60,60);
			labelCerrar = new JLabel("SALIR");
			labelCerrar.setBounds(50, 470, 150, 30);
			try {
			Image icono = new ImageIcon("src/img/cerrar.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			iconoCerrar.setIcon(new ImageIcon(icono));
			iconoCerrar.setContentAreaFilled(false);
			iconoCerrar.setBorderPainted(false);
			}catch ( Exception e){
				System.out.println("Error al cargar la imagen " + e.getMessage());
			}	
			
			panelFondoMenu.add(iconoCerrar);
			panelFondoMenu.add(labelCerrar);
			
			iconoCerrar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					login = new Login();
					login.setVisible(true);
					dispose();
				}
				
				
				
				
			});
	 }
	
	//*****GLOBALES*******//
	 
	private PanelAjustes ajustes;
	private PanelVacaciones vacaciones;
	private PanelEmpleado empleado;
	private Login login;
	private JPanel panelFondoMenu;
	private JLabel labelPersonal, labelCuadrante, labelConfiguracion, labelCerrar;
	private JButton iconoEmpleado, iconoCuadrante, iconoConfiguracion, iconoCerrar;
	public JLabel lblTitulo;
	public JScrollPane scrollPaneles;	
}
	
