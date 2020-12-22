package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.joda.time.LocalDate;

import modelo.Empleado;
import modelo.Vacaciones;



public class FormularioVacacionesNueva extends JDialog {

	private final JPanel panelFondo = new JPanel();

		
			public FormularioVacacionesNueva(Empleado empleadoSeleccionado, ArrayList<Vacaciones> listaDescansosEmpleado){
				
			
			this.empleadoSeleccionado = empleadoSeleccionado;
			this.listaDescansosEmpleado = listaDescansosEmpleado;
			anio = new ArrayList();
			mes = new ArrayList();
			dia = new ArrayList();
			
			for(int i = 2018;i<2069;i++) {
				anio.add(String.valueOf(i));
			}
			for(int i = 1;i<13;i++) {
				mes.add(String.valueOf(i));
			}
			
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
			
				lblTitulo = new JLabel("INGRESAR NUEVO DESCANSO PARA "+ empleadoSeleccionado.getNombre()+" "+ empleadoSeleccionado.getApellido1()+ " "+ empleadoSeleccionado.getApellido2());
				lblTitulo.setBounds(10,15,750,30);
				lblTitulo.setFont(new Font("Arial", 1,15));
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
				
				radioDescanso.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						actionRadioButon();
					}
				});
				panelFondo.add(radioDescanso);
				
				
				radioVacaciones = new JRadioButton("VACACIONES");
				radioVacaciones.setBounds(400, 100, 200, 20);
				radioVacaciones.setFont(fuente);
				radioVacaciones.setContentAreaFilled(false);
				radioVacaciones.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						actionRadioButon();
						
					}
				});
				panelFondo.add(radioVacaciones);
				
				

			
				grupo1 =new ButtonGroup();
				grupo1.add(radioDescanso);
				grupo1.add(radioVacaciones);				
								
				
				
				
				/*/ FECHA INICIO DESCANSOS/*/
				
				lblFechaInicio = new JLabel("Fecha de inicio:");
				lblFechaInicio.setBounds(20, 140, 120, 20);
				lblFechaInicio.setHorizontalAlignment(SwingConstants.RIGHT);
				lblFechaInicio.setFont(fuente);
				
				comboDiaInicioDescanso = new JComboBox();
				rellenaDiaMes(31, comboDiaInicioDescanso);
				comboDiaInicioDescanso.setBounds(140, 140, 40, 20);
				comboDiaInicioDescanso.setFont(fuente);
				JLabel lblBarra=new JLabel("/");
				lblBarra.setBounds(185, 140, 10, 20);
				panelFondo.add(lblBarra);
				comboMesInicioDescanso = new JComboBox();
				for(String s : mes) {
					comboMesInicioDescanso.addItem(s);
				}
				comboMesInicioDescanso.setBounds(195, 140, 40, 20);
				comboMesInicioDescanso.setFont(fuente);
				comboMesInicioDescanso.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						actionComboMes(comboDiaInicioDescanso, comboMesInicioDescanso, comboAnioInicioDescanso);
						
					}
				});
				
				JLabel lblBarra2 = new JLabel("/");
				lblBarra2.setBounds(240, 140, 10, 20);
				panelFondo.add(lblBarra2);
				comboAnioInicioDescanso = new JComboBox();
				comboAnioInicioDescanso.setBounds(250, 140, 60, 20);
				comboAnioInicioDescanso.setFont(fuente);
				for(String a : anio) {
					comboAnioInicioDescanso.addItem(a);
				}
				comboAnioInicioDescanso.setSelectedItem(String.valueOf(local.getYear()));
				comboAnioInicioDescanso.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						actionComboMes(comboDiaInicioDescanso, comboMesInicioDescanso, comboAnioInicioDescanso);
						
					}
				});
				
				panelFondo.add(lblFechaInicio);
				panelFondo.add(comboDiaInicioDescanso);
				panelFondo.add(comboMesInicioDescanso);
				panelFondo.add(comboAnioInicioDescanso);
				
				
/*/ FECHA DEVENGO DESCANSOS/*/
				
				lblFechaDevengo = new JLabel("Fecha devengo:");
				lblFechaDevengo.setBounds(20, 190, 120, 20);
				lblFechaDevengo.setHorizontalAlignment(SwingConstants.RIGHT);
				lblFechaDevengo.setFont(fuente);
				
				comboDiaDevengoDescanso = new JComboBox();
				rellenaDiaMes(31,comboDiaDevengoDescanso);
				comboDiaDevengoDescanso.setBounds(140, 190, 40, 20);
				comboDiaDevengoDescanso.setFont(fuente);
				JLabel lblBarra3=new JLabel("/");
				lblBarra3.setBounds(185, 140, 10, 20);
				panelFondo.add(lblBarra3);
				comboMesDevengoDescanso = new JComboBox();
				for(String s : mes) {
					comboMesDevengoDescanso.addItem(s);
				}
				comboMesDevengoDescanso.setBounds(195, 190, 40, 20);
				comboMesDevengoDescanso.setFont(fuente);
				comboMesDevengoDescanso.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						actionComboMes(comboDiaDevengoDescanso, comboMesDevengoDescanso, comboAnioDevengoDescanso);
						
					}
				});
				
				JLabel lblBarra4 = new JLabel("/");
				lblBarra4.setBounds(240, 190, 10, 20);
				panelFondo.add(lblBarra4);
				comboAnioDevengoDescanso = new JComboBox();
				comboAnioDevengoDescanso.setBounds(250, 190, 60, 20);
				comboAnioDevengoDescanso.setFont(fuente);
				for(String a : anio) {
					comboAnioDevengoDescanso.addItem(a);
				}
				comboAnioDevengoDescanso.setSelectedItem(String.valueOf(local.getYear()));
				comboAnioDevengoDescanso.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						actionComboMes(comboDiaDevengoDescanso, comboMesDevengoDescanso, comboAnioDevengoDescanso);
						
					}
				});
				
				panelFondo.add(lblFechaDevengo);
				panelFondo.add(comboDiaDevengoDescanso);
				panelFondo.add(comboMesDevengoDescanso);
				panelFondo.add(comboAnioDevengoDescanso);
				
				
				/*/COMBOBOX PARA SELECCIONAR EL TIPO DE DESCANSO/*/
				
				lblTipo = new JLabel("Tipo:");
				lblTipo.setBounds(60, 250, 80, 20);
				lblTipo.setFont(fuente);
				lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
				
				panelFondo.add(lblTipo);
				
				comboTipoDescanso = new JComboBox(new String[] {"Compensatorio","Libre Disposición","1ºExtra","2ºExtra","3ºExtra","4ºExtra","Navidad","Semana Santa"});
				comboTipoDescanso.setBounds(140,250,150,20);
				comboTipoDescanso.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						actionCompensatorio();
						
					}
				});
				panelFondo.add(comboTipoDescanso);
				
				
				
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
				
				comboDiaInicioVacaciones = new JComboBox();
				comboDiaInicioVacaciones.setBounds(520, 140, 40, 20);
				comboDiaInicioVacaciones.setFont(fuente);
				rellenaDiaMes(31, comboDiaInicioVacaciones);
				JLabel lblBarra5=new JLabel("/");
				lblBarra5.setBounds(565, 140, 10, 20);
				panelFondo.add(lblBarra5);
				comboMesInicioVacaciones = new JComboBox();
				comboMesInicioVacaciones.setBounds(575, 140, 40, 20);
				comboMesInicioVacaciones.setFont(fuente);
				for(String s : mes) {
					comboMesInicioVacaciones.addItem(s);
				}
				comboMesInicioVacaciones.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						actionComboMes(comboDiaInicioVacaciones, comboMesInicioVacaciones, ComboAnioInicioVacaciones);
						
					}
				});
				JLabel lblBarra6 = new JLabel("/");
				lblBarra6.setBounds(620, 140, 10, 20);
				panelFondo.add(lblBarra6);
				ComboAnioInicioVacaciones = new JComboBox();
				ComboAnioInicioVacaciones.setBounds(630, 140, 60, 20);
				ComboAnioInicioVacaciones.setFont(fuente);
				for(String a : anio) {
					ComboAnioInicioVacaciones.addItem(a);
				}
				ComboAnioInicioVacaciones.addActionListener( new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						actionComboMes(comboDiaInicioVacaciones, comboMesInicioVacaciones, ComboAnioInicioVacaciones);
						
					}
				});
				
				panelFondo.add(lblFechaInicioVacaciones);
				panelFondo.add(comboDiaInicioVacaciones);
				panelFondo.add(comboMesInicioVacaciones);
				panelFondo.add(ComboAnioInicioVacaciones);	
				
				/*/ FECHA FIN VACACIONES/*/
				
				lblFechaFinVacaciones = new JLabel("Fecha finalizacion:");
				lblFechaFinVacaciones.setBounds(390, 190, 130, 20);
				lblFechaFinVacaciones.setHorizontalAlignment(SwingConstants.RIGHT);
				lblFechaFinVacaciones.setFont(fuente);
				
				comboDiaFinVacaciones = new JComboBox();
				comboDiaFinVacaciones.setBounds(520, 190, 40, 20);
				comboDiaFinVacaciones.setFont(fuente);
				rellenaDiaMes(31, comboDiaFinVacaciones);
				JLabel lblBarra7=new JLabel("/");
				lblBarra7.setBounds(565, 190, 10, 20);
				panelFondo.add(lblBarra7);
				comboMesFinVacaciones = new JComboBox();
				comboMesFinVacaciones.setBounds(575, 190, 40, 20);
				comboMesFinVacaciones.setFont(fuente);
				for(String s : mes) {
					comboMesFinVacaciones.addItem(s);
				}
				comboMesFinVacaciones.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						actionComboMes(comboDiaFinVacaciones, comboMesFinVacaciones, ComboAnioFinVacaciones);
						
					}
				});
				JLabel lblBarra8 = new JLabel("/");
				lblBarra7.setBounds(620, 190, 10, 20);
				panelFondo.add(lblBarra7);
				ComboAnioFinVacaciones = new JComboBox();
				ComboAnioFinVacaciones.setBounds(630, 190, 60, 20);
				ComboAnioFinVacaciones.setFont(fuente);
				for(String a : anio) {
					ComboAnioFinVacaciones.addItem(a);
				}
				
				ComboAnioFinVacaciones.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						actionComboMes(comboDiaFinVacaciones, comboMesFinVacaciones, ComboAnioFinVacaciones);
						
					}
				});
				
				panelFondo.add(lblFechaFinVacaciones);
				panelFondo.add(comboDiaFinVacaciones);
				panelFondo.add(comboMesFinVacaciones);
				panelFondo.add(ComboAnioFinVacaciones);	
				
				/*/ AÑO DEVENGO VACACIONES /*/
				lblAñoDevengo = new JLabel("Año de devengo:");
				lblAñoDevengo.setBounds(450, 250, 130, 20);
				lblAñoDevengo.setFont(fuente);
				lblAñoDevengo.setHorizontalAlignment(SwingConstants.RIGHT);
				
				comboAnioDevengoVacaciones = new JComboBox();
				comboAnioDevengoVacaciones.setBounds(580, 250, 60, 20);
				comboAnioDevengoVacaciones.setFont(fuente);
				for(String a : anio) {
					comboAnioDevengoVacaciones.addItem(a);
				}
				
				panelFondo.add(lblAñoDevengo);
				panelFondo.add(comboAnioDevengoVacaciones);
				
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
					
					if(radioDescanso.isSelected() && comboAnioDevengoVacaciones.isEnabled())actionRadioButon();
	
		}		
		
		private void rellenaDiaMes(int x, JComboBox componente) {
			try {
			dia.clear();
			for(int i = 1; i<=x; i++) {
				dia.add(String.valueOf(i));
			}
			for(String d : dia) {
				componente.addItem(d);
			}
			}catch(Exception e) {
				System.out.println("Error en rellena dia" + e.getMessage());
			}
		}
		
		private void actionComboMes(JComboBox comboDia, JComboBox comboEvento, JComboBox comboAnio){
			try {
			dia.clear();
			comboDia.removeAllItems();
			
			if(Integer.valueOf(comboEvento.getSelectedItem().toString())!= 2) {
				if(Integer.valueOf(comboEvento.getSelectedItem().toString())%2 ==0 && Integer.valueOf(comboEvento.getSelectedItem().toString())<8) {
					rellenaDiaMes(30, comboDia);
					System.out.println("Mes de 30 dias");
				}else if(Integer.valueOf(comboEvento.getSelectedItem().toString())%2 !=0 && Integer.valueOf(comboEvento.getSelectedItem().toString())<8){
					rellenaDiaMes(31, comboDia);
					System.out.println("mes de 31 dias");
				}else if(Integer.valueOf(comboEvento.getSelectedItem().toString())%2 ==0 && Integer.valueOf(comboEvento.getSelectedItem().toString())>=8){
					rellenaDiaMes(31, comboDia);
					System.out.println("mes de 31 dias");
				}else {
					rellenaDiaMes(30, comboDia);
					System.out.println("Mes de 30 dias");
				}
				
			}else {
				
				if(calendar.isLeapYear(Integer.valueOf(comboAnio.getSelectedItem().toString()))){
					rellenaDiaMes(29, comboDia);
					System.out.println("es febrero bisiesto");
				}else {
					rellenaDiaMes(28, comboDia);
					System.out.println("es febrero NO bisiesto");
				}
				
			}
			}catch(Exception e) {
				System.out.println("Error en combo mes");
			}
			
		}
		
		//metodo para desactivar dia y mes en la fecha de devengo del descanso, si el dia es de convenio//
		
		private void actionCompensatorio() {
			if(comboTipoDescanso.getSelectedItem().toString().equals("Compensatorio")) {
				comboDiaDevengoDescanso.setEnabled(true);
				comboMesDevengoDescanso.setEnabled(true);
			}else {
				comboDiaDevengoDescanso.setEnabled(false);
				comboMesDevengoDescanso.setEnabled(false);
			}
		}
		
		private void actionRadioButon() {
			
			
			
			//si la opcion descanso esta seleccionada activamos su lado y desactivaos el lado de las vacaciones
			if(radioDescanso.isSelected()) {
				comboAnioDevengoVacaciones.setEnabled(false);
				comboDiaInicioVacaciones.setEnabled(false);
				comboMesInicioVacaciones.setEnabled(false);
				ComboAnioInicioVacaciones.setEnabled(false);
				comboDiaFinVacaciones.setEnabled(false);
				comboMesFinVacaciones.setEnabled(false);
				ComboAnioFinVacaciones.setEnabled(false);
				
				
				comboDiaDevengoDescanso.setEnabled(true);
				comboMesDevengoDescanso.setEnabled(true);
				comboAnioDevengoDescanso.setEnabled(true);							
				comboDiaInicioDescanso.setEnabled(true);
				comboMesInicioDescanso.setEnabled(true);
				comboAnioInicioDescanso.setEnabled(true);
				comboTipoDescanso.setEnabled(true);
				
				actionCompensatorio();// comprobamos que tipo de permiso es, para volver a desactivar dia y mes en descanso, si el tipo de permiso es de convenio
				
			}else {
				
				//si esta seleccionado vacaciones, viceversa
				comboAnioDevengoVacaciones.setEnabled(true);
				comboDiaInicioVacaciones.setEnabled(true);
				comboMesInicioVacaciones.setEnabled(true);
				ComboAnioInicioVacaciones.setEnabled(true);
				comboDiaFinVacaciones.setEnabled(true);
				comboMesFinVacaciones.setEnabled(true);
				ComboAnioFinVacaciones.setEnabled(true);
				
				comboDiaDevengoDescanso.setEnabled(false);
				comboMesDevengoDescanso.setEnabled(false);
				comboAnioDevengoDescanso.setEnabled(false);							
				comboDiaInicioDescanso.setEnabled(false);
				comboMesInicioDescanso.setEnabled(false);
				comboAnioInicioDescanso.setEnabled(false);
				comboTipoDescanso.setEnabled(false);
			}
		}
		
		private LocalDate local = new LocalDate();
		private GregorianCalendar calendar = new GregorianCalendar();
		private ArrayList <Vacaciones> listaDescansosEmpleado;
		private Vacaciones vacaciones;
		private Empleado empleadoSeleccionado;
		private JScrollPane scrollDescansos;
		private JTable tablaDescansos;
		private Font fuente = new Font("arial", 1, 13);
		private JLabel lblSalir, lblInsertar, lblTitulo, lblTipo, lblFechaInicio, lblFechaInicioVacaciones, lblFechaFinVacaciones, lblAñoDevengo, lblFechaDevengo;
		private JTextField txtAñoDevengoVacaciones;
		private JComboBox comboTipoDescanso, comboDiaInicioDescanso, comboMesInicioDescanso, comboAnioInicioDescanso, comboDiaDevengoDescanso, comboMesDevengoDescanso,
				comboAnioDevengoDescanso, comboDiaInicioVacaciones, comboMesInicioVacaciones, ComboAnioInicioVacaciones,comboDiaFinVacaciones, comboMesFinVacaciones, ComboAnioFinVacaciones,
				comboAnioDevengoVacaciones;
		private ArrayList <String> dia,mes, anio;
		private JRadioButton radioDescanso, radioVacaciones;
		private ButtonGroup grupo1;
		private JButton btnInsertar, btnSalir;
	}