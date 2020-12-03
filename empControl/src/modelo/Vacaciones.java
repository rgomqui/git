package modelo;

import java.sql.Date;

public class Vacaciones {

	public Vacaciones() {
		super();
	}
	
	public Vacaciones(int id, int codigo, String tipo, Date fechaInicio, Date fechaFin, Date fechaDevengo) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.tipo = tipo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaDevengo = fechaDevengo;
	}
	
	
	/*/METODOS DE ACCESO/*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaDevengo() {
		return fechaDevengo;
	}

	public void setFechaDevengo(Date fechaDevengo) {
		this.fechaDevengo = fechaDevengo;
	}


	/*/CAMPOS DE CLASE/*/
	private int id, codigo;
	private String tipo, observaciones;
	private Date fechaInicio, fechaFin, fechaDevengo;
}
