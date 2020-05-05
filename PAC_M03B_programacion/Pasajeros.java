package PAC_UF5_M03B_RAFAEL_GOMEZ_QUINTERO;

import java.util.*;

public class Pasajeros{

	//DECLARACION DE VARIABLES, LISTAS E ITERADOR NECESARIOS
	int total_pasajeros;
	ArrayList<Pasajero> lista_pasaje = new ArrayList<Pasajero>();
	Iterator<Pasajero> it;
	
	//CONSTRUCTOR DE LA CLASE
	public Pasajeros(int total_pasajeros){
	this.total_pasajeros=total_pasajeros;
	}
	
	//METODOS DE LA CLASE:
	
	//METODO PARA AÑADIR PASAJEROS, PASADOS POR PARAMETRO, A LA LISTA_PASAJE
	public void addPasajero(Pasajero pasajero) {
			lista_pasaje.add(pasajero);
	}
	//FIN METODO AÑADIR PASAJEROS
	
	//METODO PARA COMPROBAR SI HAY MAS PASAJEROS EN COLA, EN ESE CASO DEVUELVE TRUE
	public boolean tieneMasPasajeros(){	
		return it.hasNext();
}
	//FIN METODO COMPRUEBA SI MAS PASAJEROS
	
	//METODO PARA TRAER EL SIGUIENTE PASAJERO DE LA LISTA, CON EL ITERADOR "IT"
	public Pasajero siguientePasajero() {
		return it.next();
	}
	//FIN METODO SIGUIENTE PASAJERO
	
	//METODO PARA DESORDENAR LA LISTA Y ELIMINAR LA TARJETA DE EMBARQUE DEL PRIMER PASAJERO
	public void desordenar() {
	Collections.shuffle(lista_pasaje);
	lista_pasaje.get(0).setTieneTarjeta(false);
	}	
	//FIN METODO DESORDENAR LISTA
	
	////METODO PARA INICIAR EL ITERADOR 
	public void iniciaIterador() {
		it=lista_pasaje.iterator();
	}
	//FIN METODO INICIA ITERADOR
	 
	//METODO 'OPCIONAL' PARA IMPRIMIR LA LISTA DE PASAJEROS ANTES DE SER EMBARCADOS(NO EJECUTADO EN LA CLASE PRINCIPAL)
	public void imprimeListaPasaje() {
		
		System.out.println("/*************************** LISTA DE PASAJEROS  ************************/ ");
		 for(int i = 0; i<lista_pasaje.size();i++) {
			 int x=i;
			 System.out.println(++x+". - " + lista_pasaje.get(i));
		 }
		 System.out.println("/*************************** FIN LISTA DE PASAJEROS ************************/ \r\n");
	}
	//FIN METODO IMPRIMIR LISTA PASAJEROS

}	

