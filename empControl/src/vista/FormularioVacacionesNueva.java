package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;



public class FormularioVacacionesNueva extends JDialog {

	private final JPanel panelFondo = new JPanel();

		
			public FormularioVacacionesNueva(){
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setAlwaysOnTop(true);
			setVisible(true);
			setSize(770, 560);
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
			
				lblTitulo = new JLabel("INGRESAR NUEVO DESCANSO DE RAFAEL GOMEZ QUINTERO");
				lblTitulo.setBounds(10,15,750,30);
				lblTitulo.setFont(new Font("Arial", 1,16));
				lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				panelFondo.add(lblTitulo);
				
				lblTipo = new JLabel("Seleccione el tipo de descanso:");
				lblTipo.setBounds(50,60,300,20);
				lblTipo.setFont(fuente);
				panelFondo.add(lblTipo);
				
				radioDescanso = new JRadioButton("DESCANSO");
				radioDescanso.setBounds(50, 100, 100, 20);
				radioDescanso.setFont(fuente);
				radioDescanso.setContentAreaFilled(false);
				radioDescanso.setSelected(true);
				panelFondo.add(radioDescanso);
				
				
				
				
				
				
				radioVacaciones = new JRadioButton("VACACIONES");
				radioVacaciones.setBounds(400, 100, 200, 20);
				radioVacaciones.setFont(fuente);
				radioVacaciones.setContentAreaFilled(false);
				panelFondo.add(radioVacaciones);
				
				

			
				grupo1 =new ButtonGroup();
				grupo1.add(radioDescanso);
				grupo1.add(radioVacaciones);				
								
				
				/*/ FECHA INICIO DESCANSOS/*/
				
				lblFechaInicio = new JLabel("Fecha de inicio:");
				lblFechaInicio.setBounds(60, 140, 130, 20);
				lblFechaInicio.setHorizontalAlignment(SwingConstants.RIGHT);
				lblFechaInicio.setFont(fuente);
				
				txtDiaFechaInicio = new JTextField("18");
				txtDiaFechaInicio.setBounds(190, 140, 20, 20);
				txtDiaFechaInicio.setFont(fuente);
				JLabel lblBarra=new JLabel("/");
				lblBarra.setBounds(215, 140, 10, 20);
				panelFondo.add(lblBarra);
				txtMesFechaInicio = new JTextField("05");
				txtMesFechaInicio.setBounds(220, 140, 20, 20);
				txtMesFechaInicio.setFont(fuente);
				JLabel lblBarra2 = new JLabel("/");
				lblBarra2.setBounds(245, 140, 10, 20);
				panelFondo.add(lblBarra2);
				txtAnioFechaInicio = new JTextField("1988");
				txtAnioFechaInicio.setBounds(250, 140, 40, 20);
				txtAnioFechaInicio.setFont(fuente);
				
				
				panelFondo.add(lblFechaInicio);
				panelFondo.add(txtDiaFechaInicio);
				panelFondo.add(txtMesFechaInicio);
				panelFondo.add(txtAnioFechaInicio);
				
				
				/*/ FECHA DEVENGO DESCANSOS/*/
				
				lblFechaDevengo = new JLabel("Fecha de Devengo:");
				lblFechaDevengo.setBounds(60, 190, 130, 20);
				lblFechaDevengo.setHorizontalAlignment(SwingConstants.RIGHT);
				lblFechaDevengo.setFont(fuente);
				
				txtDiaFechaDevengo = new JTextField("18");
				txtDiaFechaDevengo.setBounds(190, 190, 20, 20);
				txtDiaFechaDevengo.setFont(fuente);
				JLabel lblBarra3=new JLabel("/");
				lblBarra3.setBounds(215, 190, 10, 20);
				panelFondo.add(lblBarra3);
				txtMesFechaDevengo = new JTextField("05");
				txtMesFechaDevengo.setBounds(220, 190, 20, 20);
				txtMesFechaDevengo.setFont(fuente);
				JLabel lblBarra4 = new JLabel("/");
				lblBarra4.setBounds(245, 190, 10, 20);
				panelFondo.add(lblBarra4);
				txtAnioFechaDevengo = new JTextField("1988");
				txtAnioFechaDevengo.setBounds(250, 190, 40, 20);
				txtAnioFechaDevengo.setFont(fuente);
				
				
				panelFondo.add(lblFechaDevengo);
				panelFondo.add(txtDiaFechaDevengo);
				panelFondo.add(txtMesFechaDevengo);
				panelFondo.add(txtAnioFechaDevengo);
				
				
				/*/COMBOBOX PARA SELECCIONAR EL TIPO DE DESCANSO/*/
				
				lblTipo = new JLabel("Tipo:");
				lblTipo.setBounds(60, 250, 80, 20);
				lblTipo.setFont(fuente);
				lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
				
				panelFondo.add(lblTipo);
				
				comboTipo = new JComboBox(new String[] {"Compensatorio","Libre Disposición","1ºExtra","2ºExtra","3ºExtra","4ºExtra","Navidad","Semana Santa"});
				comboTipo.setBounds(140,250,150,20);
				panelFondo.add(comboTipo);
				
				
				
				/*/TABLA DE DESCANSOS PENDIENTES DE DISFRUTAR /*/
				DefaultTableModel modeloDescansos = new DefaultTableModel();
				modeloDescansos.addColumn("Pendientes");
				modeloDescansos.addColumn("Año");
				tablaDescansos = new JTable(modeloDescansos);
				tablaDescansos.setEnabled(false);
				scrollDescansos = new JScrollPane(tablaDescansos, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollDescansos.setBounds(60, 300,230, 100);
				TableColumn columnaInicio = tablaDescansos.getColumn("Pendientes");
				columnaInicio.setResizable(false);
				columnaInicio.setPreferredWidth(80);
				TableColumn columnaFin = tablaDescansos.getColumn("Año");
				columnaFin.setResizable(false);
				columnaFin.setPreferredWidth(80);
				panelFondo.add(scrollDescansos);
				
				
				/*/ FECHA INICIO VACACIONES/*/
				
				lblFechaInicioVacaciones = new JLabel("Fecha de inicio:");
				lblFechaInicioVacaciones.setBounds(390, 140, 130, 20);
				lblFechaInicioVacaciones.setHorizontalAlignment(SwingConstants.RIGHT);
				lblFechaInicioVacaciones.setFont(fuente);
				
				txtDiaFechaInicioVacaciones = new JTextField("18");
				txtDiaFechaInicioVacaciones.setBounds(520, 140, 20, 20);
				txtDiaFechaInicioVacaciones.setFont(fuente);
				JLabel lblBarra5=new JLabel("/");
				lblBarra5.setBounds(545, 140, 10, 20);
				panelFondo.add(lblBarra5);
				txtMesFechaInicioVacaciones = new JTextField("05");
				txtMesFechaInicioVacaciones.setBounds(550, 140, 20, 20);
				txtMesFechaInicioVacaciones.setFont(fuente);
				JLabel lblBarra6 = new JLabel("/");
				lblBarra6.setBounds(575, 140, 10, 20);
				panelFondo.add(lblBarra6);
				txtAnioFechaInicioVacaciones = new JTextField("1988");
				txtAnioFechaInicioVacaciones.setBounds(580, 140, 40, 20);
				txtAnioFechaInicioVacaciones.setFont(fuente);
				
				
				panelFondo.add(lblFechaInicioVacaciones);
				panelFondo.add(txtDiaFechaInicioVacaciones);
				panelFondo.add(txtMesFechaInicioVacaciones);
				panelFondo.add(txtAnioFechaInicioVacaciones);	
				
				/*/ FECHA FIN VACACIONES/*/
				
				lblFechaFinVacaciones = new JLabel("Fecha de Fin:");
				lblFechaFinVacaciones.setBounds(390, 190, 130, 20);
				lblFechaFinVacaciones.setHorizontalAlignment(SwingConstants.RIGHT);
				lblFechaFinVacaciones.setFont(fuente);
				
				txtDiaFechaFinVacaciones = new JTextField("18");
				txtDiaFechaFinVacaciones.setBounds(520, 190, 20, 20);
				txtDiaFechaFinVacaciones.setFont(fuente);
				JLabel lblBarra7=new JLabel("/");
				lblBarra7.setBounds(545, 140, 10, 20);
				panelFondo.add(lblBarra7);
				txtMesFechaFinVacaciones = new JTextField("05");
				txtMesFechaFinVacaciones.setBounds(550, 190, 20, 20);
				txtMesFechaFinVacaciones.setFont(fuente);
				JLabel lblBarra8 = new JLabel("/");
				lblBarra8.setBounds(575, 140, 10, 20);
				panelFondo.add(lblBarra8);
				txtAnioFechaFinVacaciones = new JTextField("1988");
				txtAnioFechaFinVacaciones.setBounds(580, 190, 40, 20);
				txtAnioFechaFinVacaciones.setFont(fuente);
				
				
				panelFondo.add(lblFechaFinVacaciones);
				panelFondo.add(txtDiaFechaFinVacaciones);
				panelFondo.add(txtMesFechaFinVacaciones);
				panelFondo.add(txtAnioFechaFinVacaciones);	
				
				/*/ AÑO DEVENGO VACACIONES /*/
				lblAñoDevengo = new JLabel("Año de devengo:");
				lblAñoDevengo.setBounds(450, 250, 130, 20);
				lblAñoDevengo.setFont(fuente);
				lblAñoDevengo.setHorizontalAlignment(SwingConstants.RIGHT);
				
				txtAñoDevengoVacaciones = new JTextField();
				txtAñoDevengoVacaciones.setBounds(580, 250, 40, 20);
				txtAñoDevengoVacaciones.setFont(fuente);
				
				panelFondo.add(lblAñoDevengo);
				panelFondo.add(txtAñoDevengoVacaciones);
				
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
					
					btnInsertar.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							/*/ evento para, segun la opcion seleccionada dar de alta un descanso o dias de vacaciones/*/
							
						}
					});
					
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
		
		
		private boolean bDescansos, bVacaciones;
		private JScrollPane scrollDescansos;
		private JTable tablaDescansos;
		private Font fuente = new Font("arial", 1, 13);
		private JLabel lblSalir, lblInsertar, lblTitulo, lblTipo, lblFechaInicio, lblFechaInicioVacaciones, lblFechaFinVacaciones, lblAñoDevengo, lblFechaDevengo;
		private JTextField txtDiaFechaInicio, txtMesFechaInicio, txtAnioFechaInicio, txtAñoDevengo,txtDiaFechaFinVacaciones,
		        txtMesFechaFinVacaciones, txtAnioFechaFinVacaciones, txtDiaFechaDevengo, txtMesFechaDevengo, txtAnioFechaDevengo, txtDiaFechaInicioVacaciones,
		        txtMesFechaInicioVacaciones, txtAnioFechaInicioVacaciones, txtAñoDevengoVacaciones;
		private JComboBox comboTipo;
		private JRadioButton radioDescanso, radioVacaciones;
		private ButtonGroup grupo1;
		private JButton btnInsertar, btnSalir;
	}