package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.joda.time.LocalDate;

import controlador.Conexion;
import modelo.Empleado;
import modelo.Uniformidad;

public class FormularioEntregaUniformidad extends JDialog {

	public final JPanel panelFondo = new JPanel();

	public FormularioEntregaUniformidad(Empleado empleado) {
		this.empleado = empleado;
		listaUniformes = new ArrayList();
		
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setVisible(true);
		setSize(650, 430);
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
		
		//TABLA DE ENTREGAS//
		
		modeloDescansos = new DefaultTableModel();
		modeloDescansos.addColumn("camisa");	
		modeloDescansos.addColumn("forro");
		modeloDescansos.addColumn("pantalon");
		modeloDescansos.addColumn("zapatos");
		modeloDescansos.addColumn("Tipo");
		modeloDescansos.addColumn("fecha entrega");
		tablaUniformidad = new JTable(modeloDescansos);
		tablaUniformidad.setEnabled(false);
		scrollUniformidad = new JScrollPane(tablaUniformidad, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollUniformidad.setBounds(20, 100, 350, 180);
		columnaCamisa = tablaUniformidad.getColumn("camisa");
		columnaCamisa.setResizable(false);
		columnaCamisa.setPreferredWidth(40);
		columnaForro = tablaUniformidad.getColumn("forro");
		columnaForro.setResizable(false);
		columnaForro.setPreferredWidth(30);
		columnaPantalon = tablaUniformidad.getColumn("pantalon");
		columnaPantalon.setResizable(false);
		columnaPantalon.setPreferredWidth(50);
		columnaZapatos = tablaUniformidad.getColumn("zapatos");
		columnaZapatos.setResizable(false);
		columnaZapatos.setPreferredWidth(50);
		columnaTipo = tablaUniformidad.getColumn("Tipo");
		columnaTipo.setResizable(false);
		columnaTipo.setPreferredWidth(50);
		columnaFecha = tablaUniformidad.getColumn("fecha entrega");
		columnaFecha.setResizable(false);
		columnaFecha.setPreferredWidth(80);
		panelFondo.add(scrollUniformidad);

		//TITULO

		lblTitulo = new JLabel("FORMULARIO PARA ENTREGAR UNIFORMIDAD");
		lblTitulo.setBounds(100,10,500,30);
		lblTitulo.setFont(new Font("Arial", 1,18));
		panelFondo.add(lblTitulo);

		//CODIGO DE EMPLEADO

		lblCod = new JLabel("Codigo:");
		lblCod.setFont(fuente);
		lblCod.setBounds(30,60,80,20);
		lblCod.setHorizontalAlignment(JLabel.RIGHT);
		panelFondo.add(lblCod);

		txtCod = new JTextField();
		txtCod.setBounds(120,60,50,20);
		txtCod.setEditable(false);
		txtCod.setText(String.valueOf(empleado.getCodigo()));
		panelFondo.add(txtCod);


		//NOMBRE DE EMPLEADO

		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(fuente);
		lblNombre.setBounds(230, 60,80,20);
		lblNombre.setHorizontalAlignment(JLabel.RIGHT);
		panelFondo.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(320, 60, 200, 20);
		txtNombre.setEditable(false);
		txtNombre.setText(empleado.toString());
		panelFondo.add(txtNombre);


		//CAMISA

		lblCamisa = new JLabel("Camisa:");
		lblCamisa.setFont(fuente);
		lblCamisa.setBounds(360,100,100,20);
		lblCamisa.setHorizontalAlignment(JLabel.RIGHT);
		panelFondo.add(lblCamisa);

		comboCamisa = new JComboBox(tallaSuperior);
		comboCamisa.setBounds(470,100, 100, 20);
		panelFondo.add(comboCamisa);
		
		checkCamisa = new JCheckBox();
		checkCamisa.setBounds(580, 90, 40, 40);
		checkCamisa.setBackground(null);
		panelFondo.add(checkCamisa);
		
		//FORRO POLAR

				lblForroPolar = new JLabel("Forro polar:");
				lblForroPolar.setFont(fuente);
				lblForroPolar.setBounds(360,130,100,20);
				lblForroPolar.setHorizontalAlignment(JLabel.RIGHT);
				panelFondo.add(lblForroPolar);

				comboForroPolar = new JComboBox(tallaSuperior);
				comboForroPolar.setBounds(470,130, 100, 20);
				panelFondo.add(comboForroPolar);

				checkForro = new JCheckBox();
				checkForro.setBounds(580, 120, 40, 40);
				checkForro.setBackground(null);
				panelFondo.add(checkForro);

		//PANTALON

		lblPantalon = new JLabel("Pantalón:");
		lblPantalon.setFont(fuente);
		lblPantalon.setBounds(360,160,100,20);
		lblPantalon.setHorizontalAlignment(JLabel.RIGHT);
		panelFondo.add(lblPantalon);

		comboPantalon = new JComboBox(tallaInferior);
		comboPantalon.setBounds(470, 160, 100, 20);
		panelFondo.add(comboPantalon);
		
		checkPantalon = new JCheckBox();
		checkPantalon.setBounds(580, 150, 40, 40);
		checkPantalon.setBackground(null);
		panelFondo.add(checkPantalon);


		//TALLA DE CALZADO

		lblZapatos = new JLabel("Zapatos:");
		lblZapatos.setFont(fuente);
		lblZapatos.setBounds(360,190,100,20);
		lblZapatos.setHorizontalAlignment(JLabel.RIGHT);
		panelFondo.add(lblZapatos);


		comboZapatos = new JComboBox(tallaPie);
		comboZapatos.setBounds(470, 190, 100, 20);
		panelFondo.add(comboZapatos);
		
		checkZapatos = new JCheckBox();
		checkZapatos.setBounds(580, 180, 40, 40);
		checkZapatos.setBackground(null);
		panelFondo.add(checkZapatos);



		//TIPO DE CALZADO

		lblTipoCalzado = new JLabel("Tipo Zapatos:");
		lblTipoCalzado.setFont(fuente);
		lblTipoCalzado.setBounds(360,220,100,20);
		lblTipoCalzado.setHorizontalAlignment(JLabel.RIGHT);
		panelFondo.add(lblTipoCalzado);

		comboTipo = new JComboBox(tipoCalzado);
		comboTipo.setBounds(470, 220, 100, 20);
		panelFondo.add(comboTipo);

		
		//RELLENAMOS LOS COMBOBOX//
		comboCamisa.setSelectedItem(empleado.getTallaSuperior());
		comboCamisa.updateUI();
		comboForroPolar.setSelectedItem(empleado.getTallaSuperior());
		comboForroPolar.updateUI();
		comboPantalon.setSelectedItem(empleado.getTallaInferior());
		comboPantalon.updateUI();
		comboZapatos.setSelectedItem(empleado.getTallaPie());
		comboZapatos.updateUI();
		comboTipo.setSelectedItem(empleado.getTipoCalzado());
		comboTipo.updateUI();
		

		//BOTONES DE ACCION

		btnInsertar = new JButton();
		btnInsertar.setBounds(150,290,70,70);
		lblInsertar = new JLabel("ENTREGAR UNIFORMIDAD");
		lblInsertar.setFont(new Font("arial", 1, 14));
		lblInsertar.setBounds(100, 350, 200, 30);
		try {
			Image icono = new ImageIcon("src/img/verificacionVerde.png").getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
			btnInsertar.setIcon(new ImageIcon(icono));
			btnInsertar.setContentAreaFilled(false);
			btnInsertar.setBorderPainted(false);
		}catch ( Exception e){
			System.out.println("Error al cargar la imagen " + e.getMessage());
		}	
		
		btnInsertar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				uniformidad = new Uniformidad();
				uniformidad.setCamisa(comboCamisa.getSelectedItem().toString());
				uniformidad.setForro(comboForroPolar.getSelectedItem().toString());
				uniformidad.setPantalon(comboPantalon.getSelectedItem().toString());
				uniformidad.setZapatos(Integer.valueOf(comboZapatos.getSelectedItem().toString()));
				uniformidad.setTipo(comboTipo.getSelectedItem().toString());
				fechaHoy = new Date(local.toDate().getTime());
				System.out.println(fechaHoy);
				uniformidad.setUltimaEntrega(new Date(local.toDate().getTime()));
				conexion.insertarUniformidad(getRootPane(), empleado, uniformidad);
				System.out.println(uniformidad.toString());
				cargarTabla();
			}
		});

		panelFondo.add(lblInsertar);
		panelFondo.add(btnInsertar);



		//BOTON SALIR//

		btnSalir = new JButton();
		btnSalir.setBounds(390,290,60,60);
		lblSalir = new JLabel("SALIR");
		lblSalir.setFont(new Font("arial", 1, 14));
		lblSalir.setBounds(400, 350, 100, 30);
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
	
	
	//METODO PARA CARGAR LOS DATOS DE UNIFORMIDAD EN LA TABLA, CON BORRADO PREVIO PARA QUE NO SE SOLAPEN DATOS//
	private void cargarTabla() {
		try {
			for(int i = 0; i <modeloDescansos.getRowCount();i++) {
				modeloDescansos.removeRow(i);
			}
			listaUniformes = conexion.devolverUniformidad(empleado.getCodigo());
			for(Uniformidad u : listaUniformes) {
				lista = new Object[] {u.getCamisa(), u.getForro(), u.getPantalon(), u.getZapatos(), u.getTipo(), u.getUltimaEntrega()};
				 System.out.println(u.getUltimaEntrega());
				modeloDescansos.addRow(lista);
					
				}
				
				
			
		}catch(Exception e){
			System.out.println("Error en formulario entrega uniformidad");
		}
	}

	private Date fechaHoy;
	private LocalDate local = new LocalDate();
	private TableColumn columnaCamisa, columnaForro, columnaPantalon, columnaZapatos, columnaTipo, columnaFecha;
	private JCheckBox checkCamisa, checkForro, checkPantalon, checkZapatos;
	private DefaultTableModel modeloDescansos;
	private Object [] lista;
	private ArrayList<Uniformidad> listaUniformes;
	private Uniformidad uniformidad;
	private JTable  tablaUniformidad;
	private JScrollPane  scrollUniformidad;
	private Empleado empleado;
	private Conexion conexion = new Conexion();
	private String [] tallaPie = new String[] {"31","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49", "50"};
	private String [] tallaInferior = new  String[] {"XXS", "XS", "S", "M", "L","XL","XXL","3XL", "4XL", "5XL","32/34", "36/38", "40/42", "44/46", "48/50", "52/54", "56/58","60/62"};
	private String [] tallaSuperior = new  String[] {"XXS", "XS", "S", "M", "L","XL","XXL","3XL", "4XL", "5XL"};
	private String [] tipoCalzado = new  String[] {"CERRADO", "ABIERTO", "BOTAS"}; 
	private Font fuente = new Font("arial", 1, 13);
	private JLabel lblNombre,lblTitulo, lblCamisa, lblPantalon,lblZapatos, lblTipoCalzado,lblCod,lblInsertar, lblSalir, lblForroPolar;
	private JTextField txtNombre,txtCod;
	public JButton btnInsertar, btnSalir;
	private JComboBox comboTipo, comboPantalon, comboCamisa, comboZapatos, comboForroPolar;
}
