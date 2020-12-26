package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import controlador.Conexion;
import controlador.Mensajes;
import modelo.Empleado;
import modelo.Uniformidad;
import modelo.Vacaciones;

public class PanelVacaciones extends JPanel{
	
	public PanelVacaciones(){
		
		
		setBackground(new Color(198,222,235));
		setLayout(null);
		cuadroTitulo();
		cuadro1();	
		//cuadro2();
		cuadro3();
		
		
		conexion.devolverEmpleados(comboNombre, "");
		cargarTabla(empleadoSeleccionado);
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(new Color (142,196,243));
		
		g.drawRoundRect(10, 5, 590, 25,10,10);	 // CUADRO NOMBRE EMPLEADO
		g.fillRoundRect(10, 5, 590, 25,10,10);
		
		g.drawRoundRect(10, 35, 590, 260,10,10);	 // CUADRO 1 "DESCANSOS" prueba cuadro corrido y una unica tabla
		g.fillRoundRect(10, 35, 590, 260,10,10);

		g.drawRoundRect(10, 300, 335, 140, 10, 10);    // CUADRO 3 "BUSQUEDA EMPLEADO"
		g.fillRoundRect(10, 300, 335, 140, 10, 10); 
		
		g.drawRoundRect(350, 300, 250, 140, 10, 10);   // CUADRO 4 "BOTON AÑADIR"
		g.fillRoundRect(350, 300, 250, 140, 10, 10);
		
		g.setColor(new Color (228,241,245));
		g.drawRoundRect(365, 355, 210, 45, 10, 10);   // CUADRO 5 "TEXTO MENU CONCEPTUAL"
		g.fillRoundRect(365, 355, 210, 45, 10, 10);
		
		
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
		
				modeloDescansos = new DefaultTableModel(new String[] {"id", "fecha inicio", "fecha fin","año", "tipo", "dias por disfrutar", "observaciones"}, 5);
				tablaDescansos = new JTable(modeloDescansos);
				tablaDescansos.setEnabled(true);
				scrollDescansos = new JScrollPane(tablaDescansos, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollDescansos.setBounds(15, 40, 580, 250);
				TableColumn columnaId = tablaDescansos.getColumn("id");
				columnaId.setResizable(false);
				columnaId.setPreferredWidth(40);
				TableColumn columnaInicio = tablaDescansos.getColumn("fecha inicio");
				columnaInicio.setResizable(false);
				columnaInicio.setPreferredWidth(80);
				TableColumn columnaFin = tablaDescansos.getColumn("fecha fin");
				columnaFin.setResizable(false);
				columnaFin.setPreferredWidth(80);
				TableColumn columnaDevengo = tablaDescansos.getColumn("año");
				columnaDevengo.setResizable(false);
				columnaDevengo.setPreferredWidth(40);
				TableColumn columnaTipo = tablaDescansos.getColumn("tipo");
				columnaTipo.setResizable(false);
				columnaTipo.setPreferredWidth(100);
				TableColumn columnaPendientes = tablaDescansos.getColumn("dias por disfrutar");
				columnaPendientes.setResizable(false);
				columnaPendientes.setPreferredWidth(100);
				TableColumn columnaObservaciones = tablaDescansos.getColumn("observaciones");
				columnaObservaciones.setResizable(false);
				columnaObservaciones.setPreferredWidth(145);
				
				add(scrollDescansos);
				popupMenu();
				
	}
	
private void cuadro2() {
		
		//TITULO DEL CUADRO 2 "VACACIONES" 
		
				lblTituloVacaciones = new JLabel("VACACIONES");
				lblTituloVacaciones.setFont(fuente);
				lblTituloVacaciones.setBounds(415,40,150,20);
				add(lblTituloVacaciones);
				
				modeloVacaciones = new DefaultTableModel(new String[] {"id", "fecha inicio", "fecha fin","año"},4 );
				tablaVacaciones = new JTable(modeloVacaciones);
				tablaVacaciones.setEnabled(true);
				scrollVacaciones = new JScrollPane(tablaVacaciones, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollVacaciones.setBounds(355, 60, 240, 200);
				TableColumn columnaId = tablaVacaciones.getColumn("id");
				columnaId.setResizable(false);
				columnaId.setPreferredWidth(40);
				TableColumn columnaInicio = tablaVacaciones.getColumn("fecha inicio");
				columnaInicio.setResizable(false);
				columnaInicio.setPreferredWidth(80);
				TableColumn columnaFin = tablaVacaciones.getColumn("fecha fin");
				columnaFin.setResizable(false);
				columnaFin.setPreferredWidth(80);
				TableColumn columnaAñoDevengo = tablaVacaciones.getColumn("año");
				columnaAñoDevengo.setResizable(false);
				columnaAñoDevengo.setPreferredWidth(40);
				add(scrollVacaciones);
				
				
				
				
	}
	
	
	@SuppressWarnings("rawtypes")
	private void cuadro3() {
		
		//TITULO DEL CUADRO 3 "BUSQUEDA DEL EMPLEADO"
		
		lblTituloBuscar = new JLabel("BUSCAR EMPLEADO");
		lblTituloBuscar.setFont(fuente);
		lblTituloBuscar.setBounds(110,310,150,20);
		add(lblTituloBuscar);

		
		//label y jtextfield para busqueda por nombre//
		
		lblBuscarNombre = new JLabel("Nombre:");
		lblBuscarNombre.setFont(fuente);
		lblBuscarNombre.setBounds(10, 350, 85, 20);
		lblBuscarNombre.setHorizontalAlignment(JLabel.RIGHT);
		add(lblBuscarNombre);
		
		txtBuscarNombre = new JTextField();
		txtBuscarNombre.setBounds(110,350,180,20);
		add(txtBuscarNombre);
		
		btnBuscarNombre = new JButton("Actualizar");
		btnBuscarNombre.setBounds(235,390,95,20);
		btnBuscarNombre.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				conexion.devolverEmpleados(comboNombre, txtBuscarNombre.getText());
				
			}
		});
		add(btnBuscarNombre);
				
				comboNombre = new JComboBox();
				comboNombre.setBounds(40, 390, 190, 20);		
				comboNombre.setEditable(false);
				comboNombre.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent arg0) {
						
						empleadoSeleccionado =(Empleado) comboNombre.getSelectedItem();
						if(arg0.getSource()==comboNombre && empleadoSeleccionado!=null) {
							txtCodigo.setFont(fuente);
							txtCodigo.setText(String.valueOf(empleadoSeleccionado.getCodigo()));
							txtNombreEmpleado.setFont(fuente);
							txtNombreEmpleado.setText(empleadoSeleccionado.toString());
							cargarTabla(empleadoSeleccionado);
						}
					}
				});
				
				add(comboNombre);
		
			lblMensaje = new JLabel("Porfavor, utilice el menu contextual");
			lblMensaje.setFont(new Font("arial",1,12));
			lblMensaje.setBounds(370, 350, 200, 30);
			add(lblMensaje);
			lblMensaje2 = new JLabel("para interactuar con la tabla.");
			lblMensaje2.setFont(new Font("arial",1,12));
			lblMensaje2.setBounds(370, 370, 200, 30);
			add(lblMensaje2);

			
	}
	private void cargarTabla(Empleado empleadoSeleccionado) {
		try {
			
			//borramos las tablas
			while(modeloDescansos.getRowCount()>0) {
				modeloDescansos.removeRow(0);
			}
			
			//añadimos dos filas vacias para poder interactuar con el menu contextual en las tablas//
			modeloDescansos.addRow(new String[] {""});
			
			
			//bucle para añadir los descansos a la tabla//
			listaVacacionesEmpleado = conexion.devolverVacacionesEmpleado(empleadoSeleccionado.getCodigo());
			for(Vacaciones v : listaVacacionesEmpleado) {
	
					String añoDevengo = String.valueOf(v.getFechaDevengo()).substring(0, 4);				
					listaDescansos = new Object[] {v.getId(), v.getFechaInicio(), v.getFechaFin(), añoDevengo, v.getTipo(), v.getDiasPorDisfrutar(), v.getObservaciones()};
					
					modeloDescansos.addRow(listaDescansos);
				
				}
			
			//si se han añadido registros borra la fila vacia//
			if(modeloDescansos.getRowCount()>1)modeloDescansos.removeRow(0);
			
			
		}catch(Exception e){
			System.out.println("Error en formulario llenado de lista descansos");
		}
	}
	
	
	private void popupMenu() {
		
		//popup menu tabla descansos//
		try {
		popup = new JPopupMenu();
		
		Image iconoPopupEliminar =  new ImageIcon("src/img/cancelar.png").getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
		JMenuItem menuItemEliminar = new JMenuItem("Eliminar registro", new ImageIcon(iconoPopupEliminar));
		Image iconoPopupActualizar =  new ImageIcon("src/img/actualizar.png").getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
		JMenuItem menuItemActualizar = new JMenuItem("Actualizar registro", new ImageIcon(iconoPopupActualizar));
		Image iconoPopupAnadir = new ImageIcon("src/img/anadirDescanso.png").getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
		JMenuItem menuItemAnadir = new JMenuItem("Añadir nuevo registro", new ImageIcon(iconoPopupAnadir));
		menuItemEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println("eliminar en descansos");
			if(mensajes.mensajePregunta(getRootPane(), "¿Esta seguro de eliminar el registro?","Confirmar eliminar registro") == 0){

				Integer id = Integer.valueOf(modeloDescansos.getValueAt(tablaDescansos.getSelectedRow(), 0).toString());
				
				int x = conexion.borrado("vacaciones", "id",id);
				
				if(x==1) {
					
					JOptionPane.showMessageDialog(getRootPane(), "Registro eliminado");
					cargarTabla(empleadoSeleccionado);
					
				}else {
					
					JOptionPane.showMessageDialog(getRootPane(), "Registro  no eliminado");
					
				}
			}else {
				
				JOptionPane.showMessageDialog(getRootPane(), "Cancelado eliminar");
				
			}
			}
			
		});
		
		menuItemActualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
				
				int i = Integer.valueOf(modeloDescansos.getValueAt(tablaDescansos.getSelectedRow(), 0).toString());
				System.out.println(i);
				
				for(Vacaciones v : listaVacacionesEmpleado) {
					System.out.println("punto de control actualizar");
					if(v.getId() == i) {
						System.out.println("coincidencia");
						formularioActualizarVacaciones = new FormularioActualizarVacaciones(v.getId(), listaVacacionesEmpleado, empleadoSeleccionado);
						
					}
				}			
			}catch(Exception e) {
				System.out.println("Excepcion en popup actualizar " + e.getMessage());
			}
			}
		});
		
		
		menuItemAnadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				formularioVacacionesNueva = new FormularioVacacionesNueva(empleadoSeleccionado, listaVacacionesEmpleado);
			}
		});
		
		
		popup.add(menuItemAnadir);
		popup.add(menuItemActualizar);
		popup.add(menuItemEliminar);
		
		tablaDescansos.setComponentPopupMenu(popup);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private JPopupMenu popup;
	private Object listaDescansos [];
	private Mensajes mensajes = new Mensajes();
	private ArrayList<Vacaciones> listaVacacionesEmpleado;
	private DefaultTableModel modeloDescansos, modeloVacaciones;
	private Conexion conexion =  new Conexion();
	private Empleado empleadoSeleccionado;
	private Font fuente = new Font("arial", 1, 13);
	private JLabel  lblTituloVacaciones, lblTituloDescansos,lblBuscarNombre,lblNombre, lblCodigo, lblTituloBuscar, lblEliminar, lblActualizar, lblInsertar, lblMensaje, lblMensaje2;
	private JTextField txtBuscarNombre, txtNombreEmpleado, txtCodigo;
	private JButton btnInsertar, btnActualizar, btnEliminar, btnBuscarNombre;
	private PanelEmpleado empleado;
	private FormularioVacacionesNueva formularioVacacionesNueva;
	private FormularioActualizarVacaciones formularioActualizarVacaciones;
	JComboBox comboNombre;
	JTable  tablaVacaciones, tablaDescansos;
	
	JScrollPane  scrollDescansos, scrollVacaciones;
	

}
