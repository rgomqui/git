package modelo;

import java.sql.Date;

public class Uniformidad {
	
	
	
	
	
	public Uniformidad(int id, int codigo, String camisa, String pantalon, String tipo, String forro,
			Date ultimaEntrega, int zapatos) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.camisa = camisa;
		this.pantalon = pantalon;
		this.tipo = tipo;
		this.forro = forro;
		this.ultimaEntrega = ultimaEntrega;
		this.zapatos = zapatos;
	}
	public Uniformidad() {
		
	}

	
	@Override
	public String toString() {
		return "Uniformidad [id=" + id + ", codigo=" + codigo + ", camisa=" + camisa + ", pantalon=" + pantalon
				+ ", tipo=" + tipo + ", forro=" + forro + ", ultimaEntrega=" + ultimaEntrega + ", zapatos=" + zapatos
				+ "]";
	}


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
	public String getCamisa() {
		return camisa;
	}
	public void setCamisa(String camisa) {
		this.camisa = camisa;
	}
	public String getPantalon() {
		return pantalon;
	}
	public void setPantalon(String pantalon) {
		this.pantalon = pantalon;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getForro() {
		return forro;
	}
	public void setForro(String forro) {
		this.forro = forro;
	}
	public Date getUltimaEntrega() {
		return ultimaEntrega;
	}
	public void setUltimaEntrega(Date ultimaEntrega) {
		this.ultimaEntrega = ultimaEntrega;
	}
	public int getZapatos() {
		return zapatos;
	}
	public void setZapatos(int zapatos) {
		this.zapatos = zapatos;
	}


	int id, codigo;
	String camisa, pantalon, tipo, forro;
	Date ultimaEntrega;
	int zapatos;
	
	
	
	

}
