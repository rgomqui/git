/*
 * Esta aplicacion muestra una lista de 'x' pasajeros sentados en sus correspondientes asientos dentro del avion,
 * si se encontraba libre al momento de embarcar. De no estarlo se le asigna uno aleatoriamente, lo mismo que ocurre
 * si el pasajero no tiene su tarjeta de embarque.
 * 
 *@author Rafael gomez quintero
 *@version: 1.0.10/11/2019
 *
 */

package PAC_UF5_M03B_RAFAEL_GOMEZ_QUINTERO;

import java.util.*;


public class Principal {
	public static void main(String[] args) {
		int total_pasajeros = 0;
		Scanner entrada = new Scanner(System.in);
		

		 
		//PEDIMOS AL USUARIO EL TOTAL DE PASAJEROS QUE VAN A EMBARCAR
		try {
		System.out.println("Porfavor, introduce la cantidad de pasajeros del vuelo");
		 total_pasajeros = entrada.nextInt();
		entrada.close();
		
		//INSTANCIAMOS OBJETO DE LA CLASE PASAJEROS PARA PODER TRABAJAR
		Pasajeros trabajador = new Pasajeros(total_pasajeros);
		
		//INSTANCIAMOS OBJETO DE LA CLASE AVION PARA PODER TRABAJAR
		Avion avion= new Avion(total_pasajeros);
				
		//CREAMOS UN  ARRAY Y LO RELLENAMOS AUTOMATICAMENTE CON LA CANTIDAD DE OBJETOS "PASAJERO" INDICADOS ANTERIORMENTE
		Pasajero[] arr = new Pasajero[total_pasajeros];
		int x=0;
		for(int i = 0;i<total_pasajeros;i++) {
			x++;
		arr[i] =  new Pasajero("p"+x, x);
		trabajador.addPasajero(arr[i]);
		}
		
		//EJECUTAMOS LOS DIFERENTES METODOS DE LA CLASE AVION Y PASAJEROS
		trabajador.desordenar();
		trabajador.iniciaIterador();
		avion.embarque(trabajador);

		//IMPRIMIMOS POR PANTALLA TANTO LA LISTA DE PASAJEROS ANTES DE EMBARCAR, COMO LA LISTA DE PASAJEROS EMBARCADOS
		//ADEMAS DE SI EL ASIENTO DEL ULTIMO PASAJERO COINCIDE CON SU TARJETA DE EMBARQUE
		
		//trabajador.imprimeListaPasaje(); //<--- LISTA DE IMPRESION OPCIONAL.
		avion.imprimeListaCompleta();
		}
	
		catch(InputMismatchException e) {
			System.out.println("No se ha introducido un valor correcto.");
		}
		catch (IndexOutOfBoundsException e){
				System.out.println("Indice fuera de rango.");
		}
		catch ( Exception e) {
			System.out.println("Ha ocurrido un error");
		}
	}
}
