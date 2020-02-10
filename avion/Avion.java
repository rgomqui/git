package PAC_UF5_M03B_RAFAEL_GOMEZ_QUINTERO;

import java.util.*;

public class Avion{

	//DECLARAMOS LAS VARIABLES,LISTAS Y OBJETOS NECESARIOS
	private int plazas_avion=0;
	private int ultimoAsiento=0;
	ArrayList<Pasajero> lista_avion= new ArrayList<Pasajero>();
	ArrayList<Integer> aleatorio = new ArrayList<Integer>();
	Iterator it_lista, it_aleatorio;
	Pasajero pasajero;
	private int asientoAleatorio=0;
	
	//CONSTRUCTOR DE CLASE CON UN ARGUMENTO DE TIPO ENTERO CON LAS PLAZAS DEL AVION
	public Avion(int plazas_avion){
		this.plazas_avion = plazas_avion;
		for(int i = 0 ; i<=plazas_avion;i++) {
			lista_avion.add(null);
		}
	}

	//METODO PRINCIPAL DE LA CLASE CON UN OBJETO DE TIPO PASAJEROS COMO ARGUMENTO PARA PODER ACCEDER A LA CLASE
	 void embarque(Pasajeros pActual){
		 numeroAleatorio();
		 try {
		 while(pActual.tieneMasPasajeros()){
			 	pasajero= pActual.siguientePasajero();
				if(pasajero.getTieneTarjeta()) {
					if(lista_avion.get(pasajero.getNumeroAsiento()) == null) {
						lista_avion.set(pasajero.getNumeroAsiento(), pasajero);
						ultimoAsiento=pasajero.getNumeroAsiento();
					}
					else {
						asientoAleatorio = asignaAsiento(pasajero);
						lista_avion.set(asientoAleatorio, pasajero);
						ultimoAsiento= asientoAleatorio;
					}
				}
				else {
					asientoAleatorio = asignaAsiento(pasajero);
					lista_avion.set(asientoAleatorio, pasajero);
					ultimoAsiento= asientoAleatorio;
				}
		}
		 }catch	(Exception e) {
			 System.out.println("Ha ocurrido un error inesperado en el metodo embarque: " + e);
		}		 
}	
	 
	 // METODOS PROPIOS
	  
	 //METODO PARA ASIGNAR ASIENTO, COMPROBANDO PREVIAMENTE QUE SE ENCUENTRA LIBRE (PRIVADO)
	 private int asignaAsiento(Pasajero pasajero){
		 boolean correcto = false;
			int numeroAzar = 0;
	try {
		do {
			numeroAzar = (int)it_aleatorio.next();
			if(lista_avion.get(numeroAzar) == null) {
				correcto = true;
			}		
		}while(!correcto);
		  }catch	(Exception e) {
			 System.out.println("Ha ocurrido un error en el metodo asignaAsiento: " + e);
		  }
		 return numeroAzar;
	}
	 //FIN METODO ASIGNA ASIENTO
	 
	 //METODO RANDOM PROPIO, PARA CONSEGUIR NUMEROS ALEATORIOS ENTRE 1 Y EL MAXIMO DE PLAZAS DEL AVION (PRIVADO)
	private void numeroAleatorio() {
		 try {
		 for(int i=1;i <= plazas_avion ;i++) {
			 aleatorio.add(i);
		 }
		 Collections.shuffle(aleatorio);
		 it_aleatorio = aleatorio.iterator();
		 }catch	(Exception e) {
			 System.out.println("Ha ocurrido un error en el metodo numeroAleatorio: " + e);
		}
	 }
	 //FIN METODO RANDOM PROPIO
	 
	 //METODO QUE IMPRIME LA LISTA COMPLETA DE PASAJEROS EMBARCADOS EN EL AVION
	 void imprimeListaCompleta() {
		 try {
		 it_lista = lista_avion.iterator();
		 System.out.println("/**************  LISTA DE PASAJEROS EMBARCADOS EN EL AVION  *****************/");
		 for(int i = 1; i<lista_avion.size();i++) {
			 System.out.println(i+". - " + lista_avion.get(i));
		 }
		 System.out.println("/************** FIN LISTA DE PASAJEROS EMBARCADOS EN EL AVION *****************/");
		 if(ultimoAsiento == pasajero.getNumeroAsiento()) {
				System.out.println("");
				System.out.println(" El ultimo pasajero en entrar al avion ha sido capaz de "
						+ "sentarse en el asiento correspondiente a su tarjeta de embarque");
				System.out.println("Asiento asignado --> "+ ultimoAsiento + ". ");
				System.out.println("Asiento de tarjeta de embarque --> " + pasajero.getNumeroAsiento()+".");
		}else {
			System.out.println("");
			System.out.println(" El ultimo pasajero en entrar al avion no ha logrado "
					+ "sentarse en el asiento correspondiente a su tarjeta de embarque");
			System.out.println("Asiento asignado --> "+ ultimoAsiento + ". ");
			System.out.println("Asiento de tarjeta de embarque --> " + pasajero.getNumeroAsiento()+".");		
		}
		 }catch	(Exception e) {
			 System.out.println("Ha ocurrido un error en el metodo de impresion de la lista embarcada: " + e);
		}
	 }	 
	 //FIN METODO IMPRESION POR PANTALLA
}
