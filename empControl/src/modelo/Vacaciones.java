package modelo;

import java.sql.Date;

public class Vacaciones {

	public Vacaciones() {
		super();
	}

	public Vacaciones(int id, int codigo, int diasPorDisfrutar, String tipo, String observaciones, Date fechaInicio,
			Date fechaFin, Date fechaDevengo, boolean mesCompleto, boolean disfrutado) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.diasPorDisfrutar = diasPorDisfrutar;
		this.tipo = tipo;
		this.observaciones = observaciones;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaDevengo = fechaDevengo;
		this.mesCompleto = mesCompleto;
		this.disfrutado = disfrutado;
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
	private int id, codigo, diasPorDisfrutar;
	private String tipo, observaciones;
	private Date fechaInicio, fechaFin, fechaDevengo;
	private boolean mesCompleto, disfrutado;
	public int getDiasPorDisfrutar() {
		return diasPorDisfrutar;
	}

	public void setDiasPorDisfrutar(int diasPorDisfrutar) {
		this.diasPorDisfrutar = diasPorDisfrutar;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public boolean isMesCompleto() {
		return mesCompleto;
	}

	public void setMesCompleto(boolean mesCompleto) {
		this.mesCompleto = mesCompleto;
	}

	public boolean isDisfrutado() {
		return disfrutado;
	}

	public void setDisfrutado(boolean disfrutado) {
		this.disfrutado = disfrutado;
	}
}
