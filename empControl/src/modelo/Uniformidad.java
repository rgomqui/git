package modelo;

import java.sql.Date;

public class Uniformidad {
	
	
	
	
	
	public Uniformidad() {
		
	}
	public Uniformidad( String superior, String inferior, String tipo, Date ultimaEntrega, Double tallaPie) {
		this.superior = superior;
		this.inferior = inferior;
		this.tipo = tipo;
		this.ultimaEntrega = ultimaEntrega;
		this.tallaPie = tallaPie;
	}
	
	
	@Override
	public String toString() {
		return "Uniformidad [id=" + id + ", codigo=" + codigo + ", superior=" + superior + ", inferior=" + inferior
				+ ", tipo=" + tipo + ", ultimaEntrega=" + ultimaEntrega + ", tallaPie=" + tallaPie + "]";
	}
	int id, codigo;
	String superior, inferior, tipo;
	Date ultimaEntrega;
	Double tallaPie;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getSuperior() {
		return superior;
	}
	public void setSuperior(String superior) {
		this.superior = superior;
	}
	public String getInferior() {
		return inferior;
	}
	public void setInferior(String inferior) {
		this.inferior = inferior;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getUltimaEntrega() {
		return ultimaEntrega;
	}
	public void setUltimaEntrega(Date date) {
		this.ultimaEntrega = date;
	}
	public Double getTallaPie() {
		return tallaPie;
	}
	public void setTallaPie(Double tallaPie) {
		this.tallaPie = tallaPie;
	}
	
	

}
