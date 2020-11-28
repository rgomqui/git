package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controlador.Conexion;
import modelo.Empleado;
import modelo.Uniformidad;



public class FormularioEmpleadoNuevo extends JDialog {

	private final JPanel panelFondo = new JPanel();

		
			public FormularioEmpleadoNuevo(){
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
					
					txtTallaSuperior = new JTextField();
					txtTallaSuperior.setBounds(460, 68, 30, 20);
					panelFondo.add(txtTallaSuperior);
					
					
					//TALLA INFERIOR

					lblTallaInferior = new JLabel("Talla inferior:");
					lblTallaInferior.setFont(fuente);
					lblTallaInferior.setBounds(360,98,100,20);
					lblTallaInferior.setHorizontalAlignment(JLabel.RIGHT);
					panelFondo.add(lblTallaInferior);
					
					txtTallaInferior = new JTextField();
					txtTallaInferior.setBounds(460, 98, 30, 20);
					panelFondo.add(txtTallaInferior);
					
					
					//TALLA DE CALZADO
					
					lblTallaCalzado = new JLabel("Talla calzado:");
					lblTallaCalzado.setFont(fuente);
					lblTallaCalzado.setBounds(360,128,100,20);
					lblTallaCalzado.setHorizontalAlignment(JLabel.RIGHT);
					panelFondo.add(lblTallaCalzado);
					
					txtTallaCalzado = new JTextField();
					txtTallaCalzado.setBounds(460, 128, 30, 20);
					panelFondo.add(txtTallaCalzado);
					
					
					//TIPO DE CALZADO
					
					lblTipoCalzado = new JLabel("Tipo Calzado:");
					lblTipoCalzado.setFont(fuente);
					lblTipoCalzado.setBounds(360,158,100,20);
					lblTipoCalzado.setHorizontalAlignment(JLabel.RIGHT);
					panelFondo.add(lblTipoCalzado);
					
					txtTipoCalzado = new JTextField();
					txtTipoCalzado.setBounds(460, 158, 30, 20);
					panelFondo.add(txtTipoCalzado);
					
					
					//FECHA DE ULTIMA ENTREGA
					
					lblTallaUltimaEntrega = new JLabel("Ultima entrega:");
					lblTallaUltimaEntrega.setFont(fuente);
					lblTallaUltimaEntrega.setBounds(360,188,100,20);
					lblTallaUltimaEntrega.setHorizontalAlignment(JLabel.RIGHT);
					panelFondo.add(lblTallaUltimaEntrega);
					
					txtUltimaEntrega = new JTextField();
					txtUltimaEntrega.setBounds(460, 188, 100, 20);
					panelFondo.add(txtUltimaEntrega);
			
					
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
							
							System.out.println("entra");
							
							try {
							if(!txtNombre.getText().equals("") && !txtApe1.getText().equals("") && !txtApe2.getText().equals("") && !txtDni.getText().equals("")) {
								Integer i = JOptionPane.showConfirmDialog(getContentPane(), "Porfavor, confirme antes de ingresar al nuevo Empleado en el sistema","Confirmar insercion",JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION);
								
								if(i==0){
									
									//Uniformidad uniformidad = new Uniformidad();
									Empleado empleado = new Empleado();
									empleado.setNombre(txtNombre.getText());
									empleado.setApellido1(txtApe1.getText());
									empleado.setApellido2(txtApe2.getText());
									empleado.setDni(txtDni.getText());
									empleado.setTelefono(txtTlf.getText());
									//uniformidad.setInferior(txtTallaInferior.getText());
									//uniformidad.setSuperior(txtTallaSuperior.getText());
									//uniformidad.setTallaPie(Double.valueOf(txtTallaCalzado.getText()));
									//uniformidad.setTipo(txtTipoCalzado.getText());
									//uniformidad.setUltimaEntrega(Date.valueOf(txtUltimaEntrega.getText()));
									conexion.insertarEmpleado(empleado);
									System.out.println("confirmado el aceptar");
								}else {
									System.out.println("dscrtado el aceptar");
								}
								
							}else {
								s="";
								if(txtNombre.getText().equals(""))s += "Nombre de empleado requerido.\n";
								if(txtApe1.getText().equals(""))s += "Apellido 1 del empleado requerido.\n";
								if(txtApe2.getText().equals(""))s += "Apellido 2 del empleado requerido.\n";
								if(txtDni.getText().equals(""))s += "Dni del empleado requerido\n";
								JOptionPane.showMessageDialog(getContentPane(), s);
								s="";
							}
							
							}catch(Exception ex) {
								ex.printStackTrace();
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
		
		Conexion conexion; 
		private String s;
		private Font fuente = new Font("arial", 1, 13);
		private JLabel lblNombre,lblApe1, lblApe2, lblDni, lblTlf, lblTitulo, lblTallaSuperior, lblTallaInferior,
		lblTallaCalzado, lblTipoCalzado, lblTallaUltimaEntrega,lblCod,lblInsertar, lblSalir;
		private JTextField txtNombre, txtApe1, txtApe2, txtDni, txtTlf, txtTallaSuperior, txtTallaInferior, txtTallaCalzado, txtTipoCalzado, txtUltimaEntrega,
		txtCod;
		private JButton btnInsertar, btnSalir;
	}


