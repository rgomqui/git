package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

import controlador.Conexion;
import controlador.Mensajes;
import modelo.Empleado;
import modelo.Uniformidad;
public class PanelEmpleado extends JPanel{
	
	public PanelEmpleado(){
		
		setBackground(new Color(198,222,235));
		setLayout(null);
		cuadro1();
		cuadro2();
		cuadro3();
		cuadro4();
		
		conexion.devolverEmpleados(comboNombre);
		
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(new Color (142,196,243));
		
		
		g.drawRoundRect(10, 10, 335, 235,10,10);	   // CUADRO 1 "DATOS PERSONALES"
		g.fillRoundRect(10, 10, 335, 235,10,10);
		
		g.drawRoundRect(350, 10, 250, 235,10,10);	   // CUADRO 2 "UNIFORMIDAD"
		g.fillRoundRect(350, 10, 250, 235,10,10);
		
		g.drawRoundRect(10, 250, 335, 180, 10, 10);    // CUADRO 3 "BUSQUEDA DEL EMPLEADO"
		g.fillRoundRect(10, 250, 335, 180, 10, 10); 
		
		g.drawRoundRect(350, 250, 250, 180, 10, 10);   // CUADRO 4 "VACACIONES"
		g.fillRoundRect(350, 250, 250, 180, 10, 10);
		
	}
	
	private void cuadro1() {
		
		
		//TITULO DEL CUADRO 1 "DATOS PERSONALES"
		
		lblTituloDatos = new JLabel("DATOS PERSONALES");
		lblTituloDatos.setFont(fuente);
		lblTituloDatos.setBounds(120,10,150,20);
		add(lblTituloDatos);
		
		//CODIGO DE EMPLEADO
		
		lblCod = new JLabel("Codigo:");
		lblCod.setFont(fuente);
		lblCod.setBounds(10,50,80,20);
		lblCod.setHorizontalAlignment(JLabel.RIGHT);
		add(lblCod);
		
		txtCod = new JTextField();
		txtCod.setBounds(100,50,200,20);
		txtCod.setEditable(false);
		add(txtCod);
		
		
		//NOMBRE DE EMPLEADO
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(fuente);
		lblNombre.setBounds(10, 80,80,20);
		lblNombre.setHorizontalAlignment(JLabel.RIGHT);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(100, 80, 200, 20);
		txtNombre.setEditable(false);
		add(txtNombre);
		
		
		//APELLIDO 1 DE EMPLEADO
		
		lblApe1 = new JLabel("Apellido 1:");
		lblApe1.setFont(fuente);
		lblApe1.setBounds(10, 110,80,20);
		lblApe1.setHorizontalAlignment(JLabel.RIGHT);
		add(lblApe1);
		
		txtApe1 = new JTextField();
		txtApe1.setBounds(100, 110, 200, 20);
		txtApe1.setEditable(false);
		add(txtApe1);
		
		
		//APELLIDO 2 DE EMPLEADO
		
		lblApe2 = new JLabel("Apellido 2:");
		lblApe2.setFont(fuente);
		lblApe2.setBounds(10, 140,80,20);
		lblApe2.setHorizontalAlignment(JLabel.RIGHT);
		add(lblApe2);
		
		txtApe2 = new JTextField();
		txtApe2.setBounds(100, 140, 200, 20);
		txtApe2.setEditable(false);
		add(txtApe2);
		
		
		//TELEFONO DE EMPLEADO
		
		lblTlf = new JLabel("Telefono:");
		lblTlf.setFont(fuente);
		lblTlf.setBounds(10, 170,80,20);
		lblTlf.setHorizontalAlignment(JLabel.RIGHT);
		add(lblTlf);
		
		txtTlf = new JTextField();
		txtTlf.setBounds(100, 170, 200, 20);
		txtTlf.setEditable(false);
		add(txtTlf);
		
		
		//DNI DE EMPLEADO
		
		lblDni = new JLabel("D.N.I:");
		lblDni.setFont(fuente);
		lblDni.setBounds(10, 200,80,20);
		lblDni.setHorizontalAlignment(JLabel.RIGHT);
		add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(100, 200, 200, 20);
		txtDni.setEditable(false);
		add(txtDni);
	}
	
	
	
	private void cuadro2() {
		
		//TITULO DEL CUADRO 2 "UNIFORMIDAD"
		
		lblTituloUniformidad = new JLabel("UNIFORMIDAD");
		lblTituloUniformidad.setFont(fuente);
		lblTituloUniformidad.setBounds(430,10,100,20);
		add(lblTituloUniformidad);
		
		
		//TALLA SUPERIOR
		
		lblTallaSuperior = new JLabel("Talla superior:");
		lblTallaSuperior.setFont(fuente);
		lblTallaSuperior.setBounds(360,50,100,20);
		lblTallaSuperior.setHorizontalAlignment(JLabel.RIGHT);
		add(lblTallaSuperior);
		
		txtTallaSuperior = new JTextField();
		txtTallaSuperior.setBounds(460, 50, 30, 20);
		txtTallaSuperior.setEditable(false);
		add(txtTallaSuperior);
		
		
		//TALLA INFERIOR

		lblTallaInferior = new JLabel("Talla inferior:");
		lblTallaInferior.setFont(fuente);
		lblTallaInferior.setBounds(360,80,100,20);
		lblTallaInferior.setHorizontalAlignment(JLabel.RIGHT);
		add(lblTallaInferior);
		
		txtTallaInferior = new JTextField();
		txtTallaInferior.setBounds(460, 80, 30, 20);
		txtTallaInferior.setEditable(false);
		add(txtTallaInferior);
		
		
		//TALLA DE CALZADO
		
		lblTallaCalzado = new JLabel("Talla calzado:");
		lblTallaCalzado.setFont(fuente);
		lblTallaCalzado.setBounds(360,110,100,20);
		lblTallaCalzado.setHorizontalAlignment(JLabel.RIGHT);
		add(lblTallaCalzado);
		
		txtTallaCalzado = new JTextField();
		txtTallaCalzado.setBounds(460, 110, 30, 20);
		txtTallaCalzado.setEditable(false);
		add(txtTallaCalzado);
		
		
		//TIPO DE CALZADO
		
		lblTipoCalzado = new JLabel("Tipo Calzado:");
		lblTipoCalzado.setFont(fuente);
		lblTipoCalzado.setBounds(360,140,100,20);
		lblTipoCalzado.setHorizontalAlignment(JLabel.RIGHT);
		add(lblTipoCalzado);
		
		txtTipoCalzado = new JTextField();
		txtTipoCalzado.setBounds(460, 140, 30, 20);
		txtTipoCalzado.setEditable(false);
		add(txtTipoCalzado);
		
		
		//FECHA DE ULTIMA ENTREGA
		
		lblTallaUltimaEntrega = new JLabel("Ultima entrega:");
		lblTallaUltimaEntrega.setFont(fuente);
		lblTallaUltimaEntrega.setBounds(360,190,100,20);
		lblTallaUltimaEntrega.setHorizontalAlignment(JLabel.RIGHT);
		add(lblTallaUltimaEntrega);
		
		txtUltimaEntrega = new JTextField();
		txtUltimaEntrega.setBounds(460, 190, 100, 20);
		txtUltimaEntrega.setEditable(false);
		add(txtUltimaEntrega);
		
	}
	
	@SuppressWarnings("rawtypes")
	private void cuadro3() {
		
		//TITULO DEL CUADRO 3 "BUSQUEDA DEL EMPLEADO"
		
		lblTituloBuscar = new JLabel("BUSCAR EMPLEADO");
		lblTituloBuscar.setFont(fuente);
		lblTituloBuscar.setBounds(120,250,150,20);
		add(lblTituloBuscar);
		
		
		//BUSQUEDA POR CODIGO DE EMPLEADO
		
		txtBuscarNombre = new JTextField();
		txtBuscarNombre.setBounds(110,290,180,20);
		add(txtBuscarNombre);
		
		btnBuscarNombre = new JButton("Buscar");
		btnBuscarNombre.setBounds(240,325,80,20);
		btnBuscarNombre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				conexion.devolverEmpleadosConBusqueda(comboNombre, txtBuscarNombre.getText());
			}
		});
		add(btnBuscarNombre);

		//BUSQUEDA POR NOMBRE DE EMPLEADO
		
		lblBuscarNombre = new JLabel("Nombre:");
		lblBuscarNombre.setFont(fuente);
		lblBuscarNombre.setBounds(10, 290, 85, 20);
		lblBuscarNombre.setHorizontalAlignment(JLabel.RIGHT);
		add(lblBuscarNombre);
		
		comboNombre = new JComboBox();
		comboNombre.setBounds(40, 325, 190, 20);		
		comboNombre.setEditable(true);
		comboNombre.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				
				Empleado empleadoSeleccionado =(Empleado) comboNombre.getSelectedItem();
				if(arg0!=null && empleadoSeleccionado!=null) {
				//Uniformidad uniformidadSeleccionada = conexion.rellenaUniformidad(106);
				System.out.println(empleadoSeleccionado);
				txtCod.setText(String.valueOf(empleadoSeleccionado.getCodigo()));
				txtNombre.setText(empleadoSeleccionado.getNombre());
				txtApe1.setText(empleadoSeleccionado.getApellido1());
				txtApe2.setText(empleadoSeleccionado.getApellido2());
				txtTlf.setText(empleadoSeleccionado.getTelefono());
				txtDni.setText(empleadoSeleccionado.getDni());
				//txtTallaSuperior.setText(uniformidadSeleccionada.getSuperior());
				//txtTallaInferior.setText(uniformidadSeleccionada.getInferior());
				//txtTallaCalzado.setText(String.valueOf(uniformidadSeleccionada.getTallaPie()));
				
				}
			}
		});
		//comboNombre.getSelectedItem();
		add(comboNombre);
			
		//BOTONES DE ACCION
		
			btnInsertar = new JButton();
		 	btnInsertar.setBounds(50,360,40,40);
		 	lblInsertar = new JLabel("AÑADIR NUEVO");
		 	lblInsertar.setFont(new Font("arial", 1, 11));
		 	lblInsertar.setBounds(30, 395, 100, 30);
			try {
			Image icono = new ImageIcon("src/img/anadir.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			btnInsertar.setIcon(new ImageIcon(icono));
			btnInsertar.setContentAreaFilled(false);
			btnInsertar.setBorderPainted(false);
			}catch ( Exception e){
				System.out.println("Error al cargar la imagen " + e.getMessage());
			}	
			
			btnInsertar.addActionListener(new ActionListener() {
								
				@Override
				public void actionPerformed(ActionEvent e) {				
					vMenu = new VentanaMenuPrincipal();				
					formularioEmpleadoNuevo = new FormularioEmpleadoNuevo();
				}
			});
			
			add(lblInsertar);
			add(btnInsertar);
			
			
		// BOTON ACTUALIZAR
			
			btnActualizar = new JButton();
			btnActualizar.setBounds(150,358,50,50);
			lblActualizar = new JLabel("MODIFICAR");
			lblActualizar.setFont(new Font("arial", 1, 11));
			lblActualizar.setBounds(140, 395, 120, 30);
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
					Conexion con = new Conexion();
					System.out.println(con.fechaDuplicada(1111111));
					
					/*vMenu = new VentanaMenuPrincipal();				
					formularioActualizarEmpleado = new FormularioActualizarEmpleado();*/
				}
			});
			
			add(lblActualizar);
			add(btnActualizar);
			
			//BOTON ELIMINAR
			
			btnEliminar = new JButton();
			btnEliminar.setBounds(260,358,40,40);
			lblEliminar = new JLabel("ELIMINAR USUARIO");
			lblEliminar.setFont(new Font("arial", 1, 11));
			lblEliminar.setBounds(230, 395, 120, 30);
			try {
			Image icono = new ImageIcon("src/img/borrar.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			btnEliminar.setIcon(new ImageIcon(icono));
			btnEliminar.setContentAreaFilled(false);
			btnEliminar.setBorderPainted(false);
			}catch ( Exception e){
				System.out.println("Error al cargar la imagen " + e.getMessage());
			}	
			
			btnEliminar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					/*
					Integer codigo = 111;
					Integer i = conexion.borrado("empleado", codigo);
					if(i == 0) {
						mensajes.mensajeInfo(getParent(),"Registro con el codigo "+codigo+" eliminado correctamente.","registro eliminado correctamente" );
					}else if(i == 1){
						mensajes.mensajeInfo(getParent(),"Registro con el codigo "+codigo+" no se ha podido eliminar correctamente.","error eliminando registro" );
					}else {
						mensajes.mensajeInfo(getParent(),"No existe ningun registro con el codigo " + codigo + ".","Registro inexistente " );
					}
					*/
					conexion.getConnection();
				}
				
			});
			
			add(lblEliminar);
			add(btnEliminar);
		
	}
	
	private void cuadro4() {
		
		//TITULO DEL CUADRO 4 "VACACIONES"
		
		lblTituloVacaciones = new JLabel("DIAS PENDIENTES");
		lblTituloVacaciones.setFont(fuente);
		lblTituloVacaciones.setBounds(420,250,200,20);
		add(lblTituloVacaciones);
		
		//VACACIONES DEL EMPLEADO
		
		lblVacaciones = new JLabel("Vacaciones:");
		lblVacaciones.setFont(fuente);
		lblVacaciones.setBounds(350,290,110,20);
		lblVacaciones.setHorizontalAlignment(JLabel.RIGHT);
		add(lblVacaciones);
		
		txtVacaciones = new JTextField();
		txtVacaciones.setBounds(460, 290, 30, 20);
		txtVacaciones.setEditable(false);
		add(txtVacaciones);
		
		
		//DIAS DE PERMISO DEL EMPLEADO
		
		lblPermisos = new JLabel("Permisos:");
		lblPermisos.setFont(fuente);
		lblPermisos.setBounds(350,350,110,20);
		lblPermisos.setHorizontalAlignment(JLabel.RIGHT);
		add(lblPermisos);
				
		txtPermisos = new JTextField();
		txtPermisos.setBounds(460, 320, 30, 20);
		txtPermisos.setEditable(false);
		add(txtPermisos);
		
		
		//DIAS DE CONVENIO DEL EMPLEADO
		
		lblConvenio = new JLabel("Convenio:");
		lblConvenio.setFont(fuente);
		lblConvenio.setBounds(350,320,110,20);
		lblConvenio.setHorizontalAlignment(JLabel.RIGHT);
		add(lblConvenio);
		
		txtConvenio = new JTextField();
		txtConvenio.setBounds(460, 350, 30, 20);
		txtConvenio.setEditable(false);
		add(txtConvenio);
		
		
		//DIAS COMPENSATORIOS DEL EMPLEADO
		
		lblCompensatorio = new JLabel("Compensatorios:");
		lblCompensatorio.setFont(fuente);
		lblCompensatorio.setBounds(350,380,110,20);
		lblCompensatorio.setHorizontalAlignment(JLabel.RIGHT);
		add(lblCompensatorio);
		
		txtCompensatorio = new JTextField();
		txtCompensatorio.setBounds(460, 380,30, 20);
		txtCompensatorio.setEditable(false);
		add(txtCompensatorio);
		
		
	}
	

	Conexion conexion = new Conexion();
	Mensajes mensajes =  new Mensajes();
	Font fuente = new Font("arial", 1, 13);
	private JLabel lblNombre, titulo, lblApe1, lblApe2, lblDni, lblTlf, lblTituloUniformidad, lblTituloDatos, lblTallaSuperior, lblTallaInferior,
	lblTallaCalzado, lblTipoCalzado, lblTallaUltimaEntrega, lblTituloVacaciones, lblVacaciones, lblPermisos, lblConvenio, lblCompensatorio,
	lblCod, lblTituloBuscar, lblBuscarCod, lblBuscarNombre, lblInsertar, lblEliminar, lblActualizar;
	private JTextField txtNombre, txtApe1, txtApe2, txtDni, txtTlf, txtTallaSuperior, txtTallaInferior, txtTallaCalzado, txtTipoCalzado;
	public JTextField txtUltimaEntrega, txtCod, txtVacaciones, txtPermisos, txtConvenio, txtCompensatorio, txtBuscarCod, txtBuscarNombre;
	public JButton btnInsertar, btnEliminar, btnActualizar, btnBuscarNombre;
	private FormularioEmpleadoNuevo formularioEmpleadoNuevo;
	public JComboBox<Empleado> comboNombre;
	private VentanaMenuPrincipal vMenu;
	private FormularioActualizarEmpleado formularioActualizarEmpleado;
	
	Graphics g;
		
}
