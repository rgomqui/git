package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class FormularioActualizarVacaciones extends JDialog {

	private final JPanel panelFondo = new JPanel();

		
			public FormularioActualizarVacaciones(){
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setAlwaysOnTop(true);
			setVisible(true);
			setSize(770, 560);
			setTitle("EmpControl 1.0 Formulario nuevas vacaciones");
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
			
				lblTitulo = new JLabel("MODIFICAR DESCANSO PARA RAFAEL GOMEZ QUINTERO");
				lblTitulo.setBounds(10,15,750,30);
				lblTitulo.setFont(new Font("Arial", 1,16));
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				panelFondo.add(lblTitulo);

			
					

				//BOTONES DE ACCION
				
				btnInsertar = new JButton();
			 	btnInsertar.setBounds(40,420,60,60);
			 	lblInsertar = new JLabel("AÑADIR NUEVO");
			 	lblInsertar.setFont(new Font("arial", 1, 14));
			 	lblInsertar.setBounds(20, 475, 150, 30);
				try {
				Image icono = new ImageIcon("src/img/verificacionVerde.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
				btnInsertar.setIcon(new ImageIcon(icono));
				btnInsertar.setContentAreaFilled(false);
				btnInsertar.setBorderPainted(false);
				}catch ( Exception e){
					System.out.println("Error al cargar la imagen " + e.getMessage());
				}	
				
				panelFondo.add(lblInsertar);
				panelFondo.add(btnInsertar);
				
				btnSalir = new JButton();
			 	btnSalir.setBounds(660,420,60,60);
			 	lblSalir = new JLabel("SALIR");
			 	lblSalir.setFont(new Font("arial", 1, 14));
			 	lblSalir.setBounds(670, 475, 100, 30);
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
		
		
		private VentanaMenuPrincipal ventanaMenuPrincipal = new VentanaMenuPrincipal();
		private Font fuente = new Font("arial", 1, 13);
		private JLabel lblNombre,lblApe1, lblApe2, lblDni, lblTlf, lblTitulo, lblTallaSuperior, lblTallaInferior,
		lblTallaCalzado, lblTipoCalzado, lblTallaUltimaEntrega,lblCod,lblInsertar, lblSalir;
		private JTextField txtNombre, txtApe1, txtApe2, txtDni, txtTlf, txtTallaSuperior, txtTallaInferior, txtTallaCalzado, txtTipoCalzado, txtUltimaEntrega,
		txtCod;
		private JButton btnInsertar, btnSalir;
	}