package modelo;

public class Configuracion {
	
	private int diasVacaciones, diasDescanso;
	
	Configuracion(){
		diasVacaciones = 31;
		diasDescanso = 9;
	}

	public int getDiasVacaciones() {
		return diasVacaciones;
	}

	public void setDiasVacaciones(int diasVacaciones) {
		this.diasVacaciones = diasVacaciones;
	}

	public int getDiasDescanso() {
		return diasDescanso;
	}

	public void setDiasDescanso(int diasDescanso) {
		this.diasDescanso = diasDescanso;
	}

}
