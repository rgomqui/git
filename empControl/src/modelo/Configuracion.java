package modelo;

public class Configuracion {
	
	private int diasVacaciones, diasConvenio;
	
	public Configuracion(){
		diasVacaciones = 31;
		diasConvenio = 9;
	}

	public int getDiasVacaciones() {
		return diasVacaciones;
	}

	public void setDiasVacaciones(int diasVacaciones) {
		this.diasVacaciones = diasVacaciones;
	}

	public int getDiasConvenio() {
		return diasConvenio;
	}

	public void setDiasConvenio(int diasConvenio) {
		this.diasConvenio = diasConvenio;
	}

}
