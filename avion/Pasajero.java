package PAC_UF5_M03B_RAFAEL_GOMEZ_QUINTERO;

public class Pasajero {
	
	//DECLARACION DE VARIABLES 
	
	private String nombre_pasajero;
	private int numero_asiento;
	private Boolean tiene_tarjeta;
	 
	//CONSTRUCTOR DE LA CLASE PASAJERO
	Pasajero(String nombre_pasajero, int numero_asiento)
	{
		this.nombre_pasajero = nombre_pasajero;
		this.numero_asiento = numero_asiento;
		tiene_tarjeta  = true;
	} 
	
	
	//GETTERS Y SETTERS CORRESPONDIENTES
	
	String getNombrePasajero(){return nombre_pasajero;}
	int getNumeroAsiento(){return numero_asiento;}
	boolean getTieneTarjeta(){return tiene_tarjeta;}
	
	void setNombrePasajero(String nombre_pasajero){this.nombre_pasajero = nombre_pasajero;}
	void setNumeroAsiento(int numero_asiento){this.numero_asiento = numero_asiento;}
	void setTieneTarjeta(boolean tiene_tarjeta) {this.tiene_tarjeta = tiene_tarjeta;}
	
	//SOBRESCRITURA DEL METODO TOSTRING()	
	public String toString() {
		if(tiene_tarjeta)
			return "El pasajero " + nombre_pasajero +
				" con el numero de asiento " + numero_asiento+
				", si tiene tarjeta de embarque.";
		else 
			return "El pasajero " + nombre_pasajero +
				" con el numero de asiento " + numero_asiento+
				", no tiene tarjeta de embarque.";
	//FIN METODO TOSTRING()
	}
}