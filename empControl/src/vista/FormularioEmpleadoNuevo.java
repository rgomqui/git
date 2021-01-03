package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;

import controlador.Conexion;
import controlador.Mensajes;
import modelo.Empleado;




public class FormularioEmpleadoNuevo extends JDialog {

	private final JPanel panelFondo = new JPanel();

		
			public FormularioEmpleadoNuevo(JComboBox comboNombre){
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setAlwaysOnTop(true);
			setVisible(true);
			setSize(600, 400);
			setTitle("EmpControl 1.0 Formulario");
			setResizable(false);
			setLocationRelativeTo(null);
			panelFondo.setBorder(new EmptyBorder(5, 5, 5, 5));
			panelFondo.setBackground(new Color(198,222,235));
			panelFondo.setLayout(null);
			this.comboNombre =  comboNombre;
			getContentPane().add(panelFondo);{
				componentesGraficos();
			}		
			}
	
		
		
		private void componentesGraficos() {	
			
			
			
			
			//TITULO
			
				lblTitulo = new JLabel("FORMULARIO PARA INGRESAR EMPLEADO NUEVO");
				lblTitulo.setBounds(70,15,500,30);
				lblTitulo.setFont(new Font("Arial", 1,18));
				panelFondo.add(lblTitulo);
			
					//NOMBRE DE EMPLEADO
					
					lblNombre = new JLabel("Nombre:");
					lblNombre.setFont(fuente);
					lblNombre.setBounds(10, 68,80,20);
					lblNombre.setHorizontalAlignment(JLabel.RIGHT);
					panelFondo.add(lblNombre);
					
					txtNombre = new JTextField();
					txtNombre.setBounds(100, 68, 200, 20);
					panelFondo.add(txtNombre);
					
					
					//APELLIDO 1 DE EMPLEADO
					
					lblApe1 = new JLabel("Apellido 1:");
					lblApe1.setFont(fuente);
					lblApe1.setBounds(10, 98,80,20);
					lblApe1.setHorizontalAlignment(JLabel.RIGHT);
					panelFondo.add(lblApe1);
					
					txtApe1 = new JTextField();
					txtApe1.setBounds(100, 98, 200, 20);
					panelFondo.add(txtApe1);
					
					
					//APELLIDO 2 DE EMPLEADO
					
					lblApe2 = new JLabel("Apellido 2:");
					lblApe2.setFont(fuente);
					lblApe2.setBounds(10, 128,80,20);
					lblApe2.setHorizontalAlignment(JLabel.RIGHT);
					panelFondo.add(lblApe2);
					
					txtApe2 = new JTextField();
					txtApe2.setBounds(100, 128, 200, 20);
					panelFondo.add(txtApe2);
					
					
					//TELEFONO DE EMPLEADO
					
					lblTlf = new JLabel("Telefono:");
					lblTlf.setFont(fuente);
					lblTlf.setBounds(10, 158,80,20);
					lblTlf.setHorizontalAlignment(JLabel.RIGHT);
					panelFondo.add(lblTlf);
					
					txtTlf = new JTextField();
					txtTlf.setBounds(100, 158, 200, 20);
					panelFondo.add(txtTlf);
					
					
					//DNI DE EMPLEADO
					
					lblDni = new JLabel("D.N.I:");
					lblDni.setFont(fuente);
					lblDni.setBounds(10, 188,80,20);
					lblDni.setHorizontalAlignment(JLabel.RIGHT);
					panelFondo.add(lblDni);
					
					txtDni = new JTextField();
					txtDni.setBounds(100, 188, 200, 20);
					panelFondo.add(txtDni);
					
					
					//******UNIFORMIDAD/************//
					
					//TALLA SUPERIOR
					
					lblTallaSuperior = new JLabel("Talla superior:");
					lblTallaSuperior.setFont(fuente);
					lblTallaSuperior.setBounds(360,68,100,20);
					lblTallaSuperior.setHorizontalAlignment(JLabel.RIGHT);
					panelFondo.add(lblTallaSuperior);
					
					comboTallaSuperior = new JComboBox(tallaSuperior);
					comboTallaSuperior.setBounds(460, 68, 100, 20);
					panelFondo.add(comboTallaSuperior);
					
					
					//TALLA INFERIOR

					lblTallaInferior = new JLabel("Talla inferior:");
					lblTallaInferior.setFont(fuente);
					lblTallaInferior.setBounds(360,98,100,20);
					lblTallaInferior.setHorizontalAlignment(JLabel.RIGHT);
					panelFondo.add(lblTallaInferior);
					
					comboTallaInferior = new JComboBox(tallaInferior);
					comboTallaInferior.setBounds(460, 98, 100, 20);
					panelFondo.add(comboTallaInferior);
					
					
					//TALLA DE CALZADO
					
					lblTallaCalzado = new JLabel("Talla calzado:");
					lblTallaCalzado.setFont(fuente);
					lblTallaCalzado.setBounds(360,128,100,20);
					lblTallaCalzado.setHorizontalAlignment(JLabel.RIGHT);
					panelFondo.add(lblTallaCalzado);
					
					
					comboTallaCalzado= new JComboBox(tallaPie);
					comboTallaCalzado.setBounds(460, 128, 100, 20);
					panelFondo.add(comboTallaCalzado);
						
						
					//TIPO DE CALZADO
					
					lblTipoCalzado = new JLabel("Tipo Calzado:");
					lblTipoCalzado.setFont(fuente);
					lblTipoCalzado.setBounds(360,158,100,20);
					lblTipoCalzado.setHorizontalAlignment(JLabel.RIGHT);
					panelFondo.add(lblTipoCalzado);
					
					comboTipo = new JComboBox(tipoCalzado);
					comboTipo.setBounds(460, 158, 100, 20);
					panelFondo.add(comboTipo);
					
					
					//MENSAJES DE LA APLICACION
					
					lblMensajeError = new JLabel("");
					lblMensajeError.setFont(new Font("arial",1,13));
					lblMensajeError.setBounds(50,220,500,20);
					lblMensajeError.setHorizontalAlignment(JLabel.LEFT);
					panelFondo.add(lblMensajeError);
					
			
					
					//BOTONES DE ACCION
					
					btnInsertar = new JButton();
				 	btnInsertar.setBounds(150,270,60,60);
				 	lblInsertar = new JLabel("AÑADIR NUEVO");
				 	lblInsertar.setFont(new Font("arial", 1, 14));
				 	lblInsertar.setBounds(125, 330, 150, 30);
					try {
					Image icono = new ImageIcon("src/img/verificacionVerde.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
					btnInsertar.setIcon(new ImageIcon(icono));
					btnInsertar.setContentAreaFilled(false);
					btnInsertar.setBorderPainted(false);
					}catch ( Exception e){
						System.out.println("Error al cargar la imagen " + e.getMessage());
					}
					
					
									
					btnInsertar.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								
								
								/*/COMPROBACION DE QUE SE HAN LLENADO LOS CAMPOS OBLIGATORIOS/*/
							if(!txtNombre.getText().equals("") && !txtApe1.getText().equals("") && !txtApe2.getText().equals("") && !txtDni.getText().equals("")) {
								System.out.println("hola");
								Integer i =25;
								i = mensajes.mensajePregunta(panelFondo,"Porfavor, confirme antes de ingresar al nuevo Empleado en el sistema", "Confirmar insercion");
								System.out.println(i);
								
								
								
								/*/ SI SE PULSA LA OPCION "SI" EN LA VENTANA EMERGENTE, SE ENTRA EN ESTE IF Y SE DA DE ALTA EL REGISTRO EN LA BASE DE DATOS/*/
								if(i==0){	
									
									
									local = new LocalDate();
									Date fecha =  new Date(local.toDate().getTime());
									Empleado empleado = new Empleado(comboTallaCalzado.getSelectedItem().toString(),txtNombre.getText(),txtApe1.getText(),txtApe2.getText(),txtDni.getText(),txtTlf.getText(),
											 comboTallaSuperior.getSelectedItem().toString(),comboTallaInferior.getSelectedItem().toString(),comboTipo.getSelectedItem().toString(),fecha);	
									
									System.out.println("control");
							
										con.insertarEmpleado(lblMensajeError, comboNombre, empleado);
											
								}else {	
									mensajes.mensajeVisorEmpNuevo(lblMensajeError,Color.red, "** Se ha cancelado el registro del nuevo empleado.");
								}
								
							}else{
								s="";
								if(txtNombre.getText().equals(""))s += "Nombre de empleado requerido.\n";
								if(txtApe1.getText().equals(""))s += "Apellido 1 del empleado requerido.\n";
								if(txtApe2.getText().equals(""))s += "Apellido 2 del empleado requerido.\n";
								if(txtDni.getText().equals(""))s += "Dni del empleado requerido\n";
								JOptionPane.showMessageDialog(getContentPane(), s);
								s="";
							}
							
							}catch(Exception ex) {
								System.out.println(ex.getMessage() + " fallo aqui???");
							}	
						}
					});
					
					panelFondo.add(lblInsertar);
					panelFondo.add(btnInsertar);
					
					btnSalir = new JButton();
				 	btnSalir.setBounds(390,270,60,60);
				 	lblSalir = new JLabel("SALIR");
				 	lblSalir.setFont(new Font("arial", 1, 14));
				 	lblSalir.setBounds(400, 330, 100, 30);
					try {
					Image icono = new ImageIcon("src/img/cancelar.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
					btnSalir.setIcon(new ImageIcon(icono));
					btnSalir.setContentAreaFilled(false);
					btnSalir.setBorderPainted(false);
					}catch ( Exception e){
						System.out.println("Error al cargar la imagen " + e.getMessage());
					}	
					
					btnSalir.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
					panelFondo.add(lblSalir);
					panelFondo.add(btnSalir);
	
		}
		
		
		Mensajes mensajes = new Mensajes();
		LocalDate local = new LocalDate();
		Conexion con = new Conexion();
		Color verdeOscuro = new Color(67,185,86);
		Color rojo = new Color(227,36,27); 
		
		
		private String [] tallaPie = new String[] {"31","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49", "50"};
		private String[] tallaInferior = new  String[] {"XXS", "XS", "S", "M", "L","XL","XXL","3XL", "4XL", "5XL","32/34", "36/38", "40/42", "44/46", "48/50", "52/54", "56/58","60/62"};
		private String[] tallaSuperior = new  String[] {"XXS", "XS", "S", "M", "L","XL","XXL","3XL", "4XL", "5XL"};
		private String[] tipoCalzado = new  String[] {"CERRADO", "ABIERTO", "BOTAS"}; 
		private JFormattedTextField tftTallaCalzado;
		private String s;
		private Font fuente = new Font("arial", 1, 13);
		private JLabel lblNombre,lblApe1, lblApe2, lblDni, lblTlf, lblTitulo, lblTallaSuperior, lblTallaInferior,lblTallaCalzado, lblTipoCalzado;
		public JLabel lblMensajeError;
		private JLabel lblInsertar;
		private JLabel lblSalir;
		private JTextField txtNombre, txtApe1, txtApe2, txtDni, txtTlf, txtTallaSuperior, txtTallaInferior, txtTallaCalzado;
		private JButton btnInsertar, btnSalir;
		private JComboBox comboTipo, comboNombre, comboTallaInferior, comboTallaSuperior, comboTallaCalzado;
	}


