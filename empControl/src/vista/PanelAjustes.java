package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.Conexion;
import modelo.Configuracion;

public class PanelAjustes extends JPanel {
	
	public PanelAjustes(){
		
		setBackground(new Color(198,222,235));
		setLayout(null);
		iniciarComponentes();

	}
	
	private void iniciarComponentes() {
		
		
		configuracion = conexion.recuperaConfig();
		
		
		/*/MODELO PARA RELLENAR JCOMBOBOX DE DIAS/*/
		
		
		for(int i = 0 ;i<=39;i++) {
			dias[i]=String.valueOf(i);			
		
		}
		
		/*/TIULO DEL PANEL AJUSTES/*/
		
		lblTitulo = new JLabel("AJUSTES DE CONFIGURACIÓN");
		lblTitulo.setBounds(190,20,300,30);
		lblTitulo.setFont(fuenteTitulo);
		add(lblTitulo);
		
		
		
		/*/AJUSTE DE DIAS DE VACACIONES/*/
		
		lblDiasVacaciones = new JLabel("Dias de vacaciones anuales:");
		lblDiasVacaciones.setBounds(50,90,200,20);
		lblDiasVacaciones.setFont(fuenteNormal);
		lblDiasVacaciones.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblDiasVacaciones);
		
		comboDiasVacaciones = new JComboBox(dias);
		comboDiasVacaciones.setBounds(260, 90, 50, 20);
		add(comboDiasVacaciones);
		
		/*/AJUSTE DE DIAS DE CONVENIO/*/
		
		lblDiasConvenio = new JLabel("Dias de convenio anuales:");
		lblDiasConvenio.setBounds(50,140,200,20);
		lblDiasConvenio.setFont(fuenteNormal);
		lblDiasConvenio.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblDiasConvenio);
		
		comboDiasConvenio = new JComboBox(dias);
		comboDiasConvenio.setBounds(260, 140, 50, 20);
		add(comboDiasConvenio);
		
		
		
		/*/DIAS ACTUALES DE VACACIONES Y CONVENIO/*/
		
		lblActual = new JLabel("CONFIGURACIÓN ACTUAL DE DIAS");
		lblActual.setBounds(170,220,300,30);
		lblActual.setFont(fuenteTitulo);
		add(lblActual);
		
		lblActualDiasVacaciones = new JLabel("Dias de Vacaciones: ");
		lblActualDiasVacaciones.setBounds(50,290,150,20);
		lblActualDiasVacaciones.setFont(fuenteNormal);
		lblActualDiasVacaciones.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtVacaciones = new JTextField();
		txtVacaciones.setBounds(200, 290, 30, 20);
		txtVacaciones.setText(String.valueOf(configuracion.getDiasVacaciones()));
		add(txtVacaciones);
		add(lblActualDiasVacaciones);
		
		lblActualDiasConvenio = new JLabel("Dias de Convenio: ");
		lblActualDiasConvenio.setBounds(50,340,150,20);
		lblActualDiasConvenio.setFont(fuenteNormal);
		lblActualDiasConvenio.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtConvenio = new JTextField();
		txtConvenio.setBounds(200, 340, 30, 20);
		txtConvenio.setText(String.valueOf(configuracion.getDiasConvenio()));
		add(txtConvenio);
		add(lblActualDiasConvenio);
		
		//BOTON ACEPTAR CAMBIOS
		
		btnAceptar = new JButton();
		btnAceptar.setBounds(520,370,40,40);
		lblAceptar = new JLabel("CONFIRMAR CAMBIOS");
		lblAceptar.setFont(new Font("arial",1, 12));
		lblAceptar.setBounds(470, 405, 200, 30);
		try {
		Image icono = new ImageIcon("src/img/verificacionVerde.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		btnAceptar.setIcon(new ImageIcon(icono));
		btnAceptar.setContentAreaFilled(false);
		btnAceptar.setBorderPainted(false);
		}catch ( Exception e){
			System.out.println("Error al cargar la imagen " + e.getMessage());
		}	
		
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				configuracion.setDiasConvenio(Integer.valueOf(comboDiasConvenio.getSelectedItem().toString()));
				configuracion.setDiasVacaciones(Integer.valueOf(comboDiasVacaciones.getSelectedItem().toString()));
				conexion.updateConfig(configuracion, getRootPane());
				configuracion = conexion.recuperaConfig();
				actualizaCampos();
			}
		});
		add(lblAceptar);
		add(btnAceptar);
		
		actualizaCampos();
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(new Color (142,196,243));
		
		
		g.drawRoundRect(10, 10, 600, 440,10,10);	   // CUADRO 1 "DATOS PERSONALES"
		g.fillRoundRect(10, 10, 600, 440,10,10);
		
	}
	private void actualizaCampos() {
		comboDiasConvenio.setSelectedItem(String.valueOf(configuracion.getDiasConvenio()));
		comboDiasConvenio.updateUI();
		comboDiasVacaciones.setSelectedItem(String.valueOf(configuracion.getDiasVacaciones()));
		comboDiasVacaciones.updateUI();
		txtVacaciones.setText(String.valueOf(configuracion.getDiasVacaciones()));
		txtConvenio.setText(String.valueOf(configuracion.getDiasConvenio()));
		
	}
	
	private String[] dias = new String[40];
	private Configuracion configuracion = new Configuracion();
	private Conexion conexion = new Conexion();
	private JTextField txtVacaciones, txtConvenio;
	private Font fuenteNormal= new Font("Arial",1,14), fuenteTitulo = new Font("Arial", 1, 16);
	private JLabel lblDiasVacaciones, lblDiasConvenio, lblTitulo, lblEnviar, lblActual,lblAceptar;
	private JComboBox comboDiasVacaciones, comboDiasConvenio;
	private JButton btnAceptar;
	public JLabel lblActualDiasVacaciones, lblActualDiasConvenio;

}
