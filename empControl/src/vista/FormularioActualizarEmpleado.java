package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import modelo.Empleado;



public class FormularioActualizarEmpleado extends JDialog {

	private final JPanel panelFondo = new JPanel();

		
			public FormularioActualizarEmpleado(Empleado empleado){
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
			System.out.println(empleado.getTallaInferior());
			txtCod.setText(String.valueOf(empleado.getCodigo()));
			txtNombre.setText(empleado.getNombre());
			txtApe1.setText(empleado.getApellido1());
			txtApe2.setText(empleado.getApellido2());
			txtDni.setText(empleado.getDni());
			txtTlf.setText(empleado.getTelefono());
			comboTallaSuperior.setSelectedItem(empleado.getTallaSuperior());
			
			}
	
		
		
		private void componentesGraficos() {	
			
			//TITULO
			
				lblTitulo = new JLabel("FORMULARIO PARA ACTUALIZAR EMPLEADO");
				lblTitulo.setBounds(90,15,500,30);
				lblTitulo.setFont(new Font("Arial", 1,18));
				panelFondo.add(lblTitulo);
			
			//CODIGO DE EMPLEADO
			
					lblCod = new JLabel("Codigo:");
					lblCod.setFont(fuente);
					lblCod.setBounds(10,68,80,20);
					lblCod.setHorizontalAlignment(JLabel.RIGHT);
					panelFondo.add(lblCod);
					
					txtCod = new JTextField();
					txtCod.setBounds(100,68,200,20);
					txtCod.setEditable(false);
					panelFondo.add(txtCod);
					
					
					//NOMBRE DE EMPLEADO
					
					lblNombre = new JLabel("Nombre:");
					lblNombre.setFont(fuente);
					lblNombre.setBounds(10, 98,80,20);
					lblNombre.setHorizontalAlignment(JLabel.RIGHT);
					panelFondo.add(lblNombre);
					
					txtNombre = new JTextField();
					txtNombre.setBounds(100, 98, 200, 20);
					panelFondo.add(txtNombre);
					
					
					//APELLIDO 1 DE EMPLEADO
					
					lblApe1 = new JLabel("Apellido 1:");
					lblApe1.setFont(fuente);
					lblApe1.setBounds(10, 128,80,20);
					lblApe1.setHorizontalAlignment(JLabel.RIGHT);
					panelFondo.add(lblApe1);
					
					txtApe1 = new JTextField();
					txtApe1.setBounds(100, 128, 200, 20);
					panelFondo.add(txtApe1);
					
					
					//APELLIDO 2 DE EMPLEADO
					
					lblApe2 = new JLabel("Apellido 2:");
					lblApe2.setFont(fuente);
					lblApe2.setBounds(10, 158,80,20);
					lblApe2.setHorizontalAlignment(JLabel.RIGHT);
					panelFondo.add(lblApe2);
					
					txtApe2 = new JTextField();
					txtApe2.setBounds(100, 158, 200, 20);
					panelFondo.add(txtApe2);
					
					
					//TELEFONO DE EMPLEADO
					
					lblTlf = new JLabel("Telefono:");
					lblTlf.setFont(fuente);
					lblTlf.setBounds(10, 188,80,20);
					lblTlf.setHorizontalAlignment(JLabel.RIGHT);
					panelFondo.add(lblTlf);
					
					txtTlf = new JTextField();
					txtTlf.setBounds(100, 188, 200, 20);
					panelFondo.add(txtTlf);
					
					
					//DNI DE EMPLEADO
					
					lblDni = new JLabel("D.N.I:");
					lblDni.setFont(fuente);
					lblDni.setBounds(10, 218,80,20);
					lblDni.setHorizontalAlignment(JLabel.RIGHT);
					panelFondo.add(lblDni);
					
					txtDni = new JTextField();
					txtDni.setBounds(100, 218, 200, 20);
					panelFondo.add(txtDni);
					
					
					//******UNIFORMIDAD/************//
					
					//TALLA SUPERIOR
					
					lblTallaSuperior = new JLabel("Talla superior:");
					lblTallaSuperior.setFont(fuente);
					lblTallaSuperior.setBounds(360,68,100,20);
					lblTallaSuperior.setHorizontalAlignment(JLabel.RIGHT);
					panelFondo.add(lblTallaSuperior);
					
					comboTallaSuperior = new JComboBox(tallas);
					comboTallaSuperior.setBounds(460, 68, 100, 20);
					panelFondo.add(comboTallaSuperior);
					
					
					//TALLA INFERIOR

					lblTallaInferior = new JLabel("Talla inferior:");
					lblTallaInferior.setFont(fuente);
					lblTallaInferior.setBounds(360,98,100,20);
					lblTallaInferior.setHorizontalAlignment(JLabel.RIGHT);
					panelFondo.add(lblTallaInferior);
					
					comboTallaInferior = new JComboBox(tallas);
					comboTallaInferior.setBounds(460, 98, 100, 20);
					panelFondo.add(comboTallaInferior);
					
					
					//TALLA DE CALZADO
					
					lblTallaCalzado = new JLabel("Talla calzado:");
					lblTallaCalzado.setFont(fuente);
					lblTallaCalzado.setBounds(360,128,100,20);
					lblTallaCalzado.setHorizontalAlignment(JLabel.RIGHT);
					panelFondo.add(lblTallaCalzado);
					
					
						comboTallaCalzado = new JComboBox(tallaPie);
						comboTallaCalzado.setBounds(460, 128, 100, 20);
						panelFondo.add(comboTallaCalzado);

									
					
					//TIPO DE CALZADO
					
					lblTipoCalzado = new JLabel("Tipo Calzado:");
					lblTipoCalzado.setFont(fuente);
					lblTipoCalzado.setBounds(360,158,100,20);
					lblTipoCalzado.setHorizontalAlignment(JLabel.RIGHT);
					panelFondo.add(lblTipoCalzado);
					
					comboTipo = new JComboBox(new String[] {"Cerrado", "Abierto", "Botas"});
					comboTipo.setBounds(460, 158, 100, 20);
					panelFondo.add(comboTipo);
						
					
					//BOTONES DE ACCION
					
					btnInsertar = new JButton();
				 	btnInsertar.setBounds(150,270,70,70);
				 	lblInsertar = new JLabel("ACTUALIZAR EMPLEADO");
				 	lblInsertar.setFont(new Font("arial", 1, 14));
				 	lblInsertar.setBounds(100, 330, 200, 30);
					try {
					Image icono = new ImageIcon("src/img/verificacionVerde.png").getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
					btnInsertar.setIcon(new ImageIcon(icono));
					btnInsertar.setContentAreaFilled(false);
					btnInsertar.setBorderPainted(false);
					}catch ( Exception e){
						System.out.println("Error al cargar la imagen " + e.getMessage());
					}	
					
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
		
		private String [] tallaPie = new String[] {"31","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49", "50"};
		private String[] tallas = new  String[] {"XXS", "XS", "S", "M", "L","XL","XXL","3XL", "4XL", "5XL"};
		private Font fuente = new Font("arial", 1, 13);
		private JLabel lblNombre,lblApe1, lblApe2, lblDni, lblTlf, lblTitulo, lblTallaSuperior, lblTallaInferior,
						lblTallaCalzado, lblTipoCalzado, lblTallaUltimaEntrega,lblCod,lblInsertar, lblSalir;
		private JTextField txtNombre, txtApe1, txtApe2, txtDni, txtTlf, txtTallaSuperior, txtTallaInferior, txtTallaCalzado, txtTipoCalzado, txtUltimaEntrega,
							txtCod;
		public JButton btnInsertar, btnSalir;
		private JComboBox comboTipo, comboNombre, comboTallaInferior, comboTallaSuperior, comboTallaCalzado;
	}


