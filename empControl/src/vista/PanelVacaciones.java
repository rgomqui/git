package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class PanelVacaciones extends JPanel{
	
	public PanelVacaciones(){
		setBackground(new Color(198,222,235));
		setLayout(null);
		cuadroTitulo();
		cuadro1();	
		cuadro2();
		cuadro3();
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(new Color (142,196,243));
		
		g.drawRoundRect(10, 5, 590, 25,10,10);	 // CUADRO NOMBRE EMPLEADO
		g.fillRoundRect(10, 5, 590, 25,10,10);
		
		g.drawRoundRect(10, 35, 335, 230,10,10);	 // CUADRO 1 "COMPENSATORIOS"
		g.fillRoundRect(10, 35, 335, 230,10,10);
		
		g.drawRoundRect(350, 35, 250, 230,10,10);	// CUADRO 2 "DESCANSOS"
		g.fillRoundRect(350, 35, 250, 230,10,10);
		
		g.drawRoundRect(10, 270, 335, 175, 10, 10);    // CUADRO 3 "BUSQUEDA EMPLEADO"
		g.fillRoundRect(10, 270, 335, 175, 10, 10); 
		
		g.drawRoundRect(350, 270, 250, 175, 10, 10);   // CUADRO 4 "VACACIONES"
		g.fillRoundRect(350, 270, 250, 175, 10, 10);
		
		
	}
	private void cuadroTitulo() {
		
		lblNombre = new JLabel("Nombre empleado:");
		lblNombre.setFont(fuente);
		lblNombre.setBounds(15,10,125,20);
		lblNombre.setHorizontalAlignment(JLabel.RIGHT);
		add(lblNombre);
		
		txtNombreEmpleado = new JTextField();
		txtNombreEmpleado.setBounds(140,10,200,20);
		txtNombreEmpleado.setEditable(false);
		add(txtNombreEmpleado);
		
		lblCodigo = new JLabel("Codigo empleado:");
		lblCodigo.setFont(fuente);
		lblCodigo.setBounds(360,10,120,20);
		lblCodigo.setHorizontalAlignment(JLabel.RIGHT);
		add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(480,10,100,20);
		txtCodigo.setEditable(false);
		add(txtCodigo);
		
	}
	
	private void cuadro1() {
		
		//TITULO DEL CUADRO 1 "DESCANSOS"
		
				lblTituloDescansos = new JLabel("DESCANSOS");
				lblTituloDescansos.setFont(fuente);
				lblTituloDescansos.setBounds(140,40,150,20);
				add(lblTituloDescansos);
				
				DefaultTableModel modeloDescansos = new DefaultTableModel();
				modeloDescansos.addColumn("fecha descanso");					
				modeloDescansos.addColumn("tipo");
				modeloDescansos.addColumn("fecha devengo");
				tablaDescansos = new JTable(modeloDescansos);
				tablaDescansos.setEnabled(false);
				scrollDescansos = new JScrollPane(tablaDescansos, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollDescansos.setBounds(15, 60, 325, 200);
				TableColumn columnaInicio = tablaDescansos.getColumn("fecha descanso");
				columnaInicio.setResizable(false);
				columnaInicio.setPreferredWidth(110);
				TableColumn columnaTipo = tablaDescansos.getColumn("tipo");
				columnaTipo.setResizable(false);
				columnaTipo.setPreferredWidth(115);
				TableColumn columnaDevengo = tablaDescansos.getColumn("fecha devengo");
				columnaDevengo.setResizable(false);
				columnaDevengo.setPreferredWidth(110);
				add(scrollDescansos);
	}
	
private void cuadro2() {
		
		//TITULO DEL CUADRO 2 "VACACIONES" 
		
				lblTituloVacaciones = new JLabel("VACACIONES");
				lblTituloVacaciones.setFont(fuente);
				lblTituloVacaciones.setBounds(415,40,150,20);
				add(lblTituloVacaciones);
				
				DefaultTableModel modeloVacaciones = new DefaultTableModel();
				modeloVacaciones.addColumn("fecha inicio");
				modeloVacaciones.addColumn("fecha fin");
				modeloVacaciones.addColumn("a�o devengo");
				tablaVacaciones = new JTable(modeloVacaciones);
				tablaVacaciones.setEnabled(false);
				scrollVacaciones = new JScrollPane(tablaVacaciones, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollVacaciones.setBounds(355, 60, 240, 200);
				TableColumn columnaInicio = tablaVacaciones.getColumn("fecha inicio");
				columnaInicio.setResizable(false);
				columnaInicio.setPreferredWidth(80);
				TableColumn columnaFin = tablaVacaciones.getColumn("fecha fin");
				columnaFin.setResizable(false);
				columnaFin.setPreferredWidth(80);
				TableColumn columnaA�oDevengo = tablaVacaciones.getColumn("a�o devengo");
				columnaA�oDevengo.setResizable(false);
				columnaA�oDevengo.setPreferredWidth(80);
				add(scrollVacaciones);
	}
	
	
	@SuppressWarnings("rawtypes")
	private void cuadro3() {
		
		//TITULO DEL CUADRO 3 "BUSQUEDA DEL EMPLEADO"
		
		lblTituloBuscar = new JLabel("BUSCAR EMPLEADO");
		lblTituloBuscar.setFont(fuente);
		lblTituloBuscar.setBounds(110,270,150,20);
		add(lblTituloBuscar);
		
		
		//BUSQUEDA POR CODIGO DE EMPLEADO
		
		lblBuscarCod = new JLabel("C�digo:");
		lblBuscarCod.setFont(fuente);
		lblBuscarCod.setBounds(10, 300, 100, 20);
		lblBuscarCod.setHorizontalAlignment(JLabel.RIGHT);
		add(lblBuscarCod);
		
		
		comboCodigo = new JComboBox();
		comboCodigo.setBounds(110, 300, 80, 20);
		comboCodigo.setEditable(true);
		add(comboCodigo);
		
		
		//BUSQUEDA POR NOMBRE DE EMPLEADO
		
		lblBuscarNombre = new JLabel("Nombre:");
		lblBuscarNombre.setFont(fuente);
		lblBuscarNombre.setBounds(10, 340, 100, 20);
		lblBuscarNombre.setHorizontalAlignment(JLabel.RIGHT);
		add(lblBuscarNombre);
		
		comboNombre = new JComboBox();
		comboNombre.setBounds(110, 340, 200, 20);		
		comboNombre.setEditable(true);
		add(comboNombre);
			
		//BOTONES DE ACCION
		
			btnInsertar = new JButton();
		 	btnInsertar.setBounds(50,380,40,40);
		 	lblInsertar = new JLabel("A�ADIR NUEVO");
		 	lblInsertar.setFont(new Font("arial", 1, 11));
		 	lblInsertar.setBounds(30, 415, 100, 30);
			try {
			Image icono = new ImageIcon("src/img/anadirDescanso.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			btnInsertar.setIcon(new ImageIcon(icono));
			btnInsertar.setContentAreaFilled(false);
			btnInsertar.setBorderPainted(false);
			}catch ( Exception e){
				System.out.println("Error al cargar la imagen " + e.getMessage());
			}
			
			btnInsertar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					formularioVacacionesNueva = new FormularioVacacionesNueva();								
				}
			});
			
			add(lblInsertar);
			add(btnInsertar);
			 
		// BOTON ACTUALIZAR
			
			btnActualizar = new JButton();
			btnActualizar.setBounds(150,378,50,50);
			lblActualizar = new JLabel("MODIFICAR");
			lblActualizar.setFont(new Font("arial", 1, 11));
			lblActualizar.setBounds(140, 415, 120, 30);
			try {
			Image icono = new ImageIcon("src/img/actualizar.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			btnActualizar.setIcon(new ImageIcon(icono));
			btnActualizar.setContentAreaFilled(false);
			btnActualizar.setBorderPainted(false);
			}catch ( Exception e){
				System.out.println("Error al cargar la imagen " + e.getMessage());
			}	
			
			btnActualizar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					formularioActualizarVacaciones = new FormularioActualizarVacaciones();								
				}
			});
			
			add(lblActualizar);
			add(btnActualizar);
			
			//BOTON ELIMINAR
			
			btnEliminar = new JButton();
			btnEliminar.setBounds(260,378,40,40);
			lblEliminar = new JLabel("ELIMINAR DESCANSO");
			lblEliminar.setFont(new Font("arial", 1, 11));
			lblEliminar.setBounds(225, 415, 120, 30);
			try {
			Image icono = new ImageIcon("src/img/cancelar.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			btnEliminar.setIcon(new ImageIcon(icono));
			btnEliminar.setContentAreaFilled(false);
			btnEliminar.setBorderPainted(false);
			}catch ( Exception e){
				System.out.println("Error al cargar la imagen " + e.getMessage());
			}	
			
			add(lblEliminar);
			add(btnEliminar);
		
	}
	
	
	
	private Font fuente = new Font("arial", 1, 13);
	private JLabel  lblTituloVacaciones, lblTituloDescansos,lblBuscarNombre, lblBuscarCod, lblNombre, lblCodigo, lblTituloBuscar, lblEliminar, lblActualizar, lblInsertar;
	private JTextField txtBuscarCod, txtBuscarNombre, txtNombreEmpleado, txtCodigo;
	private JButton btnInsertar, btnActualizar, btnEliminar;
	private PanelEmpleado empleado;
	private FormularioVacacionesNueva formularioVacacionesNueva;
	private FormularioActualizarVacaciones formularioActualizarVacaciones;
	JComboBox comboNombre, comboCodigo;
	JTable  tablaVacaciones, tablaDescansos;
	
	JScrollPane  scrollDescansos, scrollVacaciones;
	

}