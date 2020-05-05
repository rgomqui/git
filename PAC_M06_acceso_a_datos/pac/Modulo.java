/***************************************************************
 * Proyecto Hibernate perteneciente a la PAC de desarrollo M06 *
 * Autor: Rafael Gomez Quintero							       *
 * Fecha: 08/04/2020									       *
 ***************************************************************/

package pac;

import java.util.Set;

public class Modulo {
	
	//campos de clase
	private Long idModulo;
	private String nombre;
	private String codigo;
	
	//constructores
	
	public Modulo(){
		
	}
	
	
	public Modulo(String nombre, String codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
	}


	//metodo toString
	@Override
	public String toString() {
		return "Modulo [nombre=" + nombre + ", codigo=" + codigo + "]";
	}



	//metodos getters y setters

	public String getNombre() {
		return nombre;
	}
	public Long getIdModulo() {
		return idModulo;
	}


	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
