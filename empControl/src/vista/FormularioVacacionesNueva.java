package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import controlador.Conexion;
import controlador.Mensajes;
import modelo.Configuracion;
import modelo.Empleado;
import modelo.Vacaciones;



public class FormularioVacacionesNueva extends JDialog {

	private final JPanel panelFondo = new JPanel();

		
			public FormularioVacacionesNueva(Empleado empleadoSeleccionado, ArrayList<Vacaciones> listaDescansosEmpleado){
				
			configuracion = conexion.recuperaConfig();
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
			Image icon = new ImageIcon("src/img/icono.png").getImage();
			this.setIconImage(icon);
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
				cargarTabla();
			}		
			}
			
		
		private void componentesGraficos() {	
			
			
			
			
			//TITULO
			
				lblTitulo = new JLabel("INGRESAR NUEVO DESCANSO PARA: "+ empleadoSeleccionado.getNombre().toUpperCase()+" "+ empleadoSeleccionado.getApellido1().toUpperCase()+ " "+ empleadoSeleccionado.getApellido2().toUpperCase());
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
				comboDiaInicioDescanso.setBounds(150, 140, 40, 20);
				comboDiaInicioDescanso.setFont(fuente);
				JLabel lblBarra=new JLabel("/");
				lblBarra.setBounds(195, 140, 10, 20);
				panelFondo.add(lblBarra);
				comboMesInicioDescanso = new JComboBox();
				for(String s : mes) {
					comboMesInicioDescanso.addItem(s);
				}
				comboMesInicioDescanso.setBounds(205, 140, 40, 20);
				comboMesInicioDescanso.setFont(fuente);
				comboMesInicioDescanso.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						actionComboMes(comboDiaInicioDescanso, comboMesInicioDescanso, comboAnioInicioDescanso);
						
					}
				});
				
				JLabel lblBarra2 = new JLabel("/");
				lblBarra2.setBounds(250, 140, 10, 20);
				panelFondo.add(lblBarra2);
				comboAnioInicioDescanso = new JComboBox();
				comboAnioInicioDescanso.setBounds(260, 140, 60, 20);
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
				comboDiaDevengoDescanso.setBounds(150, 190, 40, 20);
				comboDiaDevengoDescanso.setFont(fuente);
				JLabel lblBarra3=new JLabel("/");
				lblBarra3.setBounds(195, 190, 10, 20);
				panelFondo.add(lblBarra3);
				comboMesDevengoDescanso = new JComboBox();
				for(String s : mes) {
					comboMesDevengoDescanso.addItem(s);
				}
				comboMesDevengoDescanso.setBounds(205, 190, 40, 20);
				comboMesDevengoDescanso.setFont(fuente);
				comboMesDevengoDescanso.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						actionComboMes(comboDiaDevengoDescanso, comboMesDevengoDescanso, comboAnioDevengoDescanso);
						
					}
				});
				
				JLabel lblBarra4 = new JLabel("/");
				lblBarra4.setBounds(250, 190, 10, 20);
				panelFondo.add(lblBarra4);
				comboAnioDevengoDescanso = new JComboBox();
				comboAnioDevengoDescanso.setBounds(260, 190, 60, 20);
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
				lblTipo.setBounds(20, 250, 50, 20);
				lblTipo.setFont(fuente);
				lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
				
				panelFondo.add(lblTipo);
				
				comboTipoDescanso = new JComboBox(listaPermisos);
				comboTipoDescanso.setBounds(80,250,130,20);
				comboTipoDescanso.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						actionCompensatorio();
						
					}
				});
				panelFondo.add(comboTipoDescanso);
				
				checkGuardar = new JCheckBox("Guardar descanso");
				checkGuardar.setBounds(230, 250, 150,20);
				checkGuardar.setContentAreaFilled(false);
				checkGuardar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						actionGuardarDescanso();
					}
				});
				panelFondo.add(checkGuardar);
				
				lblDiasCompensatorio = new JLabel("Dias de compensatorio:");
				lblDiasCompensatorio.setBounds(35, 300, 150, 20);
				lblDiasCompensatorio.setFont(fuente);
				lblDiasCompensatorio.setHorizontalAlignment(SwingConstants.RIGHT);
				panelFondo.add(lblDiasCompensatorio);
				
				comboDiasCompensatorio = new JComboBox(new String[] {"1","2","3","4","5"});
				comboDiasCompensatorio.setBounds(200, 300, 40, 20);
				panelFondo.add(comboDiasCompensatorio);
				
				lblMotivo = new JLabel("Motivo:");
				lblMotivo.setBounds(30, 350, 50, 20);
				lblMotivo.setFont(fuente);
				lblMotivo.setHorizontalAlignment(SwingConstants.RIGHT);
				panelFondo.add(lblMotivo);
				
				comboMotivo = new JComboBox(motivos);
				comboMotivo.setBounds(90, 350, 200, 20);
				panelFondo.add(comboMotivo);
				
				/*/TABLA DE DESCANSOS PENDIENTES DE DISFRUTAR /*/
				modeloDescansos = new DefaultTableModel();
				modeloDescansos.addColumn("Tipo descanso");
				modeloDescansos.addColumn("Año");
				modeloDescansos.addColumn("Dias por disfrutar");
				modeloDescansos.addColumn("Observaciones");
				tablaDescansos = new JTable(modeloDescansos);
				tablaDescansos.setEnabled(false);
				scrollDescansos = new JScrollPane(tablaDescansos, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollDescansos.setBounds(310, 300,390, 110);
				TableColumn columnaInicio = tablaDescansos.getColumn("Tipo descanso");
				columnaInicio.setResizable(false);
				columnaInicio.setPreferredWidth(100);
				TableColumn columnaAnio = tablaDescansos.getColumn("Año");
				columnaAnio.setResizable(false);
				columnaAnio.setPreferredWidth(45);
				TableColumn columnaDias = tablaDescansos.getColumn("Dias por disfrutar");
				columnaDias.setResizable(false);
				columnaDias.setPreferredWidth(100);
				TableColumn columnaObservaciones = tablaDescansos.getColumn("Observaciones");
				columnaObservaciones.setResizable(false);
				columnaObservaciones.setPreferredWidth(145);
				panelFondo.add(scrollDescansos);
				
				
				
				
				
				
				
				
				/*/ FECHA INICIO VACACIONES/*/
				
				lblFechaInicioVacaciones = new JLabel("Fecha de inicio:");
				lblFechaInicioVacaciones.setBounds(390, 140, 130, 20);
				lblFechaInicioVacaciones.setHorizontalAlignment(SwingConstants.RIGHT);
				lblFechaInicioVacaciones.setFont(fuente);
				
				comboDiaInicioVacaciones = new JComboBox();
				comboDiaInicioVacaciones.setBounds(530, 140, 40, 20);
				comboDiaInicioVacaciones.setFont(fuente);
				rellenaDiaMes(31, comboDiaInicioVacaciones);
				JLabel lblBarra5=new JLabel("/");
				lblBarra5.setBounds(575, 140, 10, 20);
				panelFondo.add(lblBarra5);
				comboMesInicioVacaciones = new JComboBox();
				comboMesInicioVacaciones.setBounds(585, 140, 40, 20);
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
				lblBarra6.setBounds(630, 140, 10, 20);
				panelFondo.add(lblBarra6);
				ComboAnioInicioVacaciones = new JComboBox();
				ComboAnioInicioVacaciones.setBounds(640, 140, 60, 20);
				ComboAnioInicioVacaciones.setFont(fuente);
				for(String a : anio) {
					ComboAnioInicioVacaciones.addItem(a);
				}
				ComboAnioInicioVacaciones.setSelectedItem(String.valueOf(local.getYear()));
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
				comboDiaFinVacaciones.setBounds(530, 190, 40, 20);
				comboDiaFinVacaciones.setFont(fuente);
				rellenaDiaMes(31, comboDiaFinVacaciones);
				JLabel lblBarra7=new JLabel("/");
				lblBarra7.setBounds(575, 190, 10, 20);
				panelFondo.add(lblBarra7);
				comboMesFinVacaciones = new JComboBox();
				comboMesFinVacaciones.setBounds(585, 190, 40, 20);
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
				lblBarra8.setBounds(630, 190, 10, 20);
				panelFondo.add(lblBarra8);
				ComboAnioFinVacaciones = new JComboBox();
				ComboAnioFinVacaciones.setBounds(640, 190, 60, 20);
				ComboAnioFinVacaciones.setFont(fuente);
				for(String a : anio) {
					ComboAnioFinVacaciones.addItem(a);
				}
				ComboAnioFinVacaciones.setSelectedItem(String.valueOf(local.getYear()));
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
				comboAnioDevengoVacaciones.setBounds(590, 250, 60, 20);
				comboAnioDevengoVacaciones.setFont(fuente);
				for(String a : anio) {
					comboAnioDevengoVacaciones.addItem(a);
				}
				comboAnioDevengoVacaciones.setSelectedItem(String.valueOf(local.getYear()));
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
							
							guardarVacaciones();
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
		
		//metodo para confeccionar el objeto vacaciones para enviarlo a la clase conexion e insertar los datos//
		private void guardarVacaciones() {

			boolean correcto = true;
			vacaciones =  new Vacaciones();

			//codigo que rescatamos del objeto empleado
			vacaciones.setCodigo(empleadoSeleccionado.getCodigo());  

			if(radioDescanso.isSelected()) {
				//tipo de descanso a enviar
				vacaciones.setTipo(comboTipoDescanso.getSelectedItem().toString());


				//si el descanso es un compensatorio hay que comprobar si se va a guardar los dias, o no.
				if(comboTipoDescanso.getSelectedItem().toString().equalsIgnoreCase("Compensatorio")) {

					//fecha de devengo en compensatorios, es la fecha seleccionada completa
					LocalDate fechaDevengo = new LocalDate(Integer.valueOf(comboAnioDevengoDescanso.getSelectedItem().toString()),
							Integer.valueOf(comboMesDevengoDescanso.getSelectedItem().toString()), 
							Integer.valueOf(comboDiaDevengoDescanso.getSelectedItem().toString()));				
					vacaciones.setFechaDevengo(Date.valueOf(fechaDevengo.toString()));

					//si guardamos los dias
					if(checkGuardar.isSelected()) {

						//en las fechas de inicio y fin pasamos null, ya que se va a guardar el dia y se esta registrando como tal.
						vacaciones.setFechaInicio(null);
						vacaciones.setFechaFin(null);

						//pasamos un false a mes completo, ya que son dias sueltos
						vacaciones.setMesCompleto(false);

						//en el combo motivos rellenamos las observaciones del descanso
						vacaciones.setObservaciones(comboMotivo.getSelectedItem().toString());

						//enviamos un falso ya que se esta guardando el dia en el sistema, pero no se esta disfrutando todavia
						vacaciones.setDisfrutado(false);

						//y por ultimo enviamos los dias por disfrutar y los disfrutados que son 0 en este caso
						vacaciones.setDiasPorDisfrutar(Integer.valueOf(comboDiasCompensatorio.getSelectedItem().toString()));
						vacaciones.setDiasDisfrutados(0);

						//en caso de no guardar los dias, sino que estamos dando de alta un descanso que se va a dar o se ha dado.
					}else{

						//fecha de inicio del descanso
						LocalDate fechaInicio = new LocalDate(Integer.valueOf(comboAnioInicioDescanso.getSelectedItem().toString()),
								Integer.valueOf(comboMesInicioDescanso.getSelectedItem().toString()), 
								Integer.valueOf(comboDiaInicioDescanso.getSelectedItem().toString()));

						vacaciones.setFechaInicio(Date.valueOf(fechaInicio.toString()));

						//fecha de fin del descanso
						LocalDate fechaFin = fechaInicio.plusDays(Integer.valueOf(comboDiasCompensatorio.getSelectedItem().toString())-1);
						//LocalDate fechaFin = new LocalDate(Integer.valueOf(comboAnioInicioDescanso.getSelectedItem().toString()),
							//	Integer.valueOf(comboMesInicioDescanso.getSelectedItem().toString()), 
							//	(Integer.valueOf(comboDiaInicioDescanso.getSelectedItem().toString())+(Integer.valueOf(comboDiasCompensatorio.getSelectedItem().toString())-1)));

						vacaciones.setFechaFin(Date.valueOf(fechaFin.toString()));

						//pasamos un false a mes completo, ya que son dias sueltos
						vacaciones.setMesCompleto(false);

						//en el combo motivos rellenamos las observaciones del descanso
						vacaciones.setObservaciones(comboMotivo.getSelectedItem().toString());
						
						//enviamos un verdadero ya que en este caso si que se ha descansado o se va a descansar
						vacaciones.setDisfrutado(true);

						//y por ultimo enviamos los dias por disfrutar
						vacaciones.setDiasPorDisfrutar(0);
						vacaciones.setDiasDisfrutados(Integer.valueOf(comboDiasCompensatorio.getSelectedItem().toString()));

							
						}
					
					
					//si el descanso no fuera un compensatorio, serian un dia de convenio y se crearia con los siguientes datos
				}else {
					boolean disfrutado = false;
					//recorremos la lista completa objeto por objeto comprobando si ya se ha disfrutado el dia de convenio que se esta pidiendo
					for(Vacaciones v: listaDescansosEmpleado) {
						if(v.getTipo().equalsIgnoreCase(comboTipoDescanso.getSelectedItem().toString()) &&
								v.getFechaDevengo().toString().substring(0, 4).equalsIgnoreCase(comboAnioDevengoDescanso.getSelectedItem().toString())) {
							disfrutado = true;
						}
					}
					//comprobamos que no se ha dado ya en el año en que se pide
					if(!disfrutado) {
					//fecha de devengo en dias de convenio 01/01 y año de devengo del dia
					LocalDate fechaDevengo = new LocalDate(Integer.valueOf(comboAnioDevengoDescanso.getSelectedItem().toString()),01,01);				
					vacaciones.setFechaDevengo(Date.valueOf(fechaDevengo.toString()));
					
					//fecha de inicio del descanso
					LocalDate fechaInicio = new LocalDate(Integer.valueOf(comboAnioInicioDescanso.getSelectedItem().toString()),
							Integer.valueOf(comboMesInicioDescanso.getSelectedItem().toString()), 
							Integer.valueOf(comboDiaInicioDescanso.getSelectedItem().toString()));

					vacaciones.setFechaInicio(Date.valueOf(fechaInicio.toString()));

					//fecha de fin del descanso
					LocalDate fechaFin = new LocalDate(Integer.valueOf(comboAnioInicioDescanso.getSelectedItem().toString()),
							Integer.valueOf(comboMesInicioDescanso.getSelectedItem().toString()), 
							Integer.valueOf(comboDiaInicioDescanso.getSelectedItem().toString()));

					vacaciones.setFechaFin(Date.valueOf(fechaFin.toString()));


					//pasamos un false a mes completo, ya que son dias sueltos
					vacaciones.setMesCompleto(false);

					//en el combo motivos rellenamos las observaciones del descanso
					vacaciones.setObservaciones("");

					//enviamos un verdadero ya que en este caso si que se ha descansado o se va a descansar
					vacaciones.setDisfrutado(true);

					//y por ultimo enviamos los dias por disfrutar
					vacaciones.setDiasPorDisfrutar(0);
					vacaciones.setDiasDisfrutados(1);

				}else {
					//ponemos a false "correcto" para que no haga la insercion e informamos al usuario
					correcto = false;
					mensajes.mensajeInfo(getRootPane(), "Dia " + comboTipoDescanso.getSelectedItem().toString()+" del año "+comboAnioDevengoDescanso.getSelectedItem().toString()+ " ya se ha disfrutado", "Dia de convenio ya disfrutado");
				}
				}
				
			}
			if(radioVacaciones.isSelected()){
				
				
				//tipo "vacaciones" dentro de vacaciones
				vacaciones.setTipo("Vacaciones");
				
				//fecha de devengo en vacaciones es 01/01/año de devengo
				LocalDate fechaDevengoVacaciones = new LocalDate(Integer.valueOf(comboAnioDevengoVacaciones.getSelectedItem().toString()),01,01);				
				vacaciones.setFechaDevengo(Date.valueOf(fechaDevengoVacaciones.toString()));
				
				//fecha de inicio de las vacaciones
				LocalDate fechaInicioVacaciones = new LocalDate(Integer.valueOf(ComboAnioInicioVacaciones.getSelectedItem().toString()),
						Integer.valueOf(comboMesInicioVacaciones.getSelectedItem().toString()), 
						Integer.valueOf(comboDiaInicioVacaciones.getSelectedItem().toString()));

				//System.out.println("entra en vacaciones: " + fechaInicioVacaciones.toString() );
				vacaciones.setFechaInicio(Date.valueOf(fechaInicioVacaciones.toString()));

				//fecha de fin de las vacaciones
				LocalDate fechaFinVacaciones = new LocalDate(Integer.valueOf(ComboAnioFinVacaciones.getSelectedItem().toString()),
						Integer.valueOf(comboMesFinVacaciones.getSelectedItem().toString()), 
						(Integer.valueOf(comboDiaFinVacaciones.getSelectedItem().toString())));

				vacaciones.setFechaFin(Date.valueOf(fechaFinVacaciones.toString()));

				int diasEntre = Days.daysBetween(fechaInicioVacaciones, fechaFinVacaciones).getDays();
				diasEntre++;
				
				//comprobamos si es mes completo o no.
				if(Integer.valueOf(comboMesInicioVacaciones.getSelectedItem().toString())!= 2) {
					if(Integer.valueOf(comboMesInicioVacaciones.getSelectedItem().toString())%2 ==0 && Integer.valueOf(comboMesInicioVacaciones.getSelectedItem().toString())<8) {
						if(diasEntre == 30)vacaciones.setMesCompleto(true);
						System.out.println("Mes de 30 dias");
					}else if(Integer.valueOf(comboMesInicioVacaciones.getSelectedItem().toString())%2 !=0 && Integer.valueOf(comboMesInicioVacaciones.getSelectedItem().toString())<8){
						if(diasEntre == 31)vacaciones.setMesCompleto(true);
						System.out.println("mes de 31 dias");
					}else if(Integer.valueOf(comboMesInicioVacaciones.getSelectedItem().toString())%2 ==0 && Integer.valueOf(comboMesInicioVacaciones.getSelectedItem().toString())>=8){
						if(diasEntre == 31)vacaciones.setMesCompleto(true);
						System.out.println("mes de 31 dias");
					}else {
						if(diasEntre == 30)vacaciones.setMesCompleto(true);
						System.out.println("Mes de 30 dias");
					}
				}else {
					
					if(calendar.isLeapYear(Integer.valueOf(ComboAnioInicioVacaciones.getSelectedItem().toString()))){
						if(diasEntre==29)vacaciones.setMesCompleto(true);
						System.out.println("es febrero bisiesto");
					}else {
						if(diasEntre==28)vacaciones.setMesCompleto(true);
						System.out.println("es febrero NO bisiesto");
					}
				}
					
					
				//en el combo motivos rellenamos las observaciones del descanso
				vacaciones.setObservaciones("");

				//enviamos un verdadero ya que en este caso si que se ha descansado o se va a descansar
				vacaciones.setDisfrutado(true);

				//comprobamos con los datos ya cargados, los dias totales de vacaciones que tiene el trabajador disfrutados y se le suman los que esta pidiendo actualmente.
				int diasDisfrutados = 0;
				for(Vacaciones v : listaDescansosEmpleado) {
					//buscamos los descansos de tipo vacaciones
					if(v.getTipo().equals("Vacaciones")) {
						//y ademas que sean del mismo año que se intenta añadir 
						if(v.getFechaDevengo().toString().substring(0, 4).equalsIgnoreCase(comboAnioDevengoVacaciones.getSelectedItem().toString())) {
							//si tiene consideracion de mes completo a pesar de no ser el total de dias estipulado por la empresa, contara como el maximo de dias.
							if(v.isMesCompleto()) {
								diasDisfrutados+= configuracion.getDiasVacaciones();
								
								//en caso contrario se le sumaran los dias que realmente haya disfrutado.
							}else {
								diasDisfrutados = 0;
								diasDisfrutados += Days.daysBetween(new LocalDate(v.getFechaInicio().toLocalDate().toString()), new LocalDate(v.getFechaFin().toString())).getDays();
							}
						}
					}	
				}
				
				System.out.println("dias vacaciones preguardados: " + diasDisfrutados);
				//se suman los dias capturados con los dias que se estan pidiendo en el formulario
				diasDisfrutados +=diasEntre;
				
				System.out.println("dias vacaciones en conjunto: " + diasDisfrutados);
				//si no se pide mes completo y la suma de todo es inferior o igual a los dias guardados en la configuracion
				if(diasDisfrutados<=configuracion.getDiasVacaciones()) {
					vacaciones.setDiasDisfrutados(diasEntre);
				}else {
					correcto = false;
					mensajes.mensajeInfo(getRootPane(), "Esta intentando introducir "+diasDisfrutados+" dias de vacaciones, cuando lo permitido por la empresa son "+configuracion.getDiasVacaciones()+" dias.\n Porfavor, corrija los datos y vuelta a intentarlo", "error insertando datos");
				}
				
				
				
			}
				
			//llamada a la consulta con la base de datos enviando objeto de vacaciones
			
			if(correcto) {
				conexion.insertarVacaciones(getRootPane(), vacaciones);
				dispose();
			}else {
				System.out.println("Ha ocurrido un error en formulario envio vacaciones nueva");
			}
				
		}
		
		//metodo para desactivar dia y mes en la fecha de devengo del descanso, si el dia es de convenio//
		
		private void actionGuardarDescanso() {
			
			if(checkGuardar.isSelected()) {
				comboDiaInicioDescanso.setEnabled(false);
				comboMesInicioDescanso.setEnabled(false);
				comboAnioInicioDescanso.setEnabled(false);
			}else {
				comboDiaInicioDescanso.setEnabled(true);
				comboMesInicioDescanso.setEnabled(true);
				comboAnioInicioDescanso.setEnabled(true);
			}
		}
		private void actionCompensatorio() {
			if(comboTipoDescanso.getSelectedItem().toString().equals("Compensatorio")) {
				comboDiaDevengoDescanso.setEnabled(true);
				comboMesDevengoDescanso.setEnabled(true);
				checkGuardar.setEnabled(true);
				comboDiasCompensatorio.setEnabled(true);
				comboMotivo.setEnabled(true);
			}else {
				comboDiaDevengoDescanso.setEnabled(false);
				comboDiaDevengoDescanso.setSelectedIndex(0);
				comboMesDevengoDescanso.setEnabled(false);
				comboMesDevengoDescanso.setSelectedIndex(0);
				checkGuardar.setSelected(false);
				checkGuardar.setEnabled(false);
				comboDiasCompensatorio.setEnabled(false);
				comboMotivo.setEnabled(false);
				
			}
			actionGuardarDescanso();
		}
		
		//METODO PARA CARGAR LOS DATOS DE DESCANSOS PENDIENTES DE DISFRUTAR, EN LA TABLA
		private void cargarTabla() {
				try {
			//primero dejamos en blanco la tabla//
			while(modeloDescansos.getRowCount()>0) {
				modeloDescansos.removeRow(0);
			}
			
			// despues de vaciar la tabla, procedemos a llenar los datos automaticos sin el compensatorio (empzando en 1)//
			for(int x = 1 ; x<8; x++) {
				datosTablaDescansos = new String[] {listaPermisos[x], String.valueOf(local.getYear()), "1"};
				modeloDescansos.addRow(datosTablaDescansos);
			}
			
			// cargamos tambien los dias de vacaciones pendientes
			datosTablaDescansos = new String[] {"Vacaciones", String.valueOf(local.getYear()), String.valueOf(configuracion.getDiasVacaciones())};
			modeloDescansos.addRow(datosTablaDescansos);
	
			for(Vacaciones v : listaDescansosEmpleado) {
				datosTablaDescansos = new String[] {v.getTipo(), v.getFechaDevengo().toString().substring(0, 4), String.valueOf(v.getDiasPorDisfrutar()), v.getObservaciones()};	
				
				//comprobamos si coincide el descanso pendiente de disfrutar con algunos de los añadidos automaticamente en la lista
				for(int j = 0; j < modeloDescansos.getRowCount();j++) {	
					
					//si coinciden en tipo y año, se borra el relleno automaticamente. Si no hay coincidencias se añade al listado
					if(String.valueOf(modeloDescansos.getValueAt(j, 0)).equalsIgnoreCase(datosTablaDescansos[0]) && String.valueOf(modeloDescansos.getValueAt(j, 1)).equalsIgnoreCase(datosTablaDescansos[1])&&
							!modeloDescansos.getValueAt(j, 0).toString().equalsIgnoreCase("Compensatorio")) {
					
						modeloDescansos.removeRow(j);
						System.out.println("control en cargar tabla1");
					}
				}
				
				//comprobamos que si son vacaciones//
				if(v.getTipo().equalsIgnoreCase("Vacaciones")) {
					//si son vacaciones rellenamos la tabla con una fila que indica los dias que quedan pendientes de disfrutar de vacaciones
						datosTablaDescansos = new String[] {v.getTipo(), v.getFechaDevengo().toString().substring(0, 4), String.valueOf(configuracion.getDiasVacaciones()-v.getDiasDisfrutados())};
						modeloDescansos.addRow(datosTablaDescansos);	
				}else{
					
					
					if(v.getDiasPorDisfrutar()!=0) {
						int diasPendientes = 0;
						
						if(!v.isMesCompleto())diasPendientes = configuracion.getDiasVacaciones() - Days.daysBetween(new LocalDate(v.getFechaInicio()), new LocalDate(v.getFechaFin())).getDays();
						datosTablaDescansos = new String[] {v.getTipo(), v.getFechaDevengo().toString().substring(0, 4), String.valueOf(v.getDiasPorDisfrutar())};
						modeloDescansos.addRow(datosTablaDescansos);
					}
				}
				}
			
				}catch(Exception e) {
					System.out.println("excepcion en cargar tabla: "+ e.getMessage());
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
				checkGuardar.setEnabled(true);
				comboDiasCompensatorio.setEnabled(true);
				comboMotivo.setEnabled(true);
				
				actionCompensatorio();// comprobamos que tipo de permiso es, para volver a desactivar dia y mes en descanso, si el tipo de permiso es de convenio
				actionGuardarDescanso();
				
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
				checkGuardar.setEnabled(false);
				comboDiasCompensatorio.setEnabled(false);
				comboMotivo.setEnabled(false);
				
			}
		}
		
		private String[] motivos = new String[] {
				"mudanza","boda",  "formacion", "festivo dia descanso","festivo trabajado",
				"dia trabajado","acumulacion horas", "ingreso padre/madre", "intervencion padre/madre",
				"ingreso hermano/a", "intervencion hermano/a", "ingreso cuñado/a", "intervencion cuñado/a",
				"ingreso tio/a", "intervencion tio/a", "ingreso tio/a, conyuge", "intervencion tio/a, conyuge",
				"ingreso conyuge", "intervencion conyuge", "ingreso suegro/a", "intervencion suegro/a",
				"ingreso abuelo/a", "intervencion abuelo/a", "ingreso abuelo/a conyuge", "intervencion abuelo/a conyuge",
				"ingreso trabajador", "intervencion trabajador", "ingreso hijo/a", "intervencion hijo/a"			
		};
		private Configuracion configuracion =  new Configuracion();
		private Mensajes mensajes = new Mensajes();
		private String [] listaPermisos =new String[] {"Compensatorio","Libre Disposición","1ºExtra","2ºExtra","3ºExtra","4ºExtra","Navidad","Semana Santa"};
		private Conexion conexion = new Conexion();
		private DefaultTableModel modeloDescansos;
		private LocalDate local = new LocalDate();
		private GregorianCalendar calendar = new GregorianCalendar();
		private ArrayList <Vacaciones> listaDescansosEmpleado;
		private Vacaciones vacaciones;
		private Empleado empleadoSeleccionado;
		private JScrollPane scrollDescansos;
		private JTable tablaDescansos;
		private Font fuente = new Font("arial", 1, 13);
		private JLabel lblSalir, lblInsertar, lblTitulo, lblTipo, lblFechaInicio, lblFechaInicioVacaciones, lblFechaFinVacaciones, lblAñoDevengo, lblFechaDevengo, lblDiasCompensatorio, lblMotivo;
		private JComboBox comboTipoDescanso, comboDiaInicioDescanso, comboMesInicioDescanso, comboAnioInicioDescanso, comboDiaDevengoDescanso, comboMesDevengoDescanso,
				comboAnioDevengoDescanso, comboDiaInicioVacaciones, comboMesInicioVacaciones, ComboAnioInicioVacaciones,comboDiaFinVacaciones, comboMesFinVacaciones, ComboAnioFinVacaciones,
				comboAnioDevengoVacaciones, comboDiasCompensatorio,comboMotivo;
		private ArrayList <String> dia,mes, anio;
		private String[]  datosTablaDescansos;
		private JCheckBox checkGuardar;
		private JRadioButton radioDescanso, radioVacaciones;
		private ButtonGroup grupo1;
		private JButton btnInsertar, btnSalir;
	}