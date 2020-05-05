/***************************************************************
 * Proyecto Hibernate perteneciente a la PAC de desarrollo M06 *
 * Autor: Rafael Gomez Quintero							       *
 * Fecha: 08/04/2020									       *
 ***************************************************************/

package pac;

public class Profesor {
	
	//campos de clase
	
	private long id;
	private String sexo;
	private String nombre;
	
	
	
	//constructores
	public Profesor() {
		
	}
	public Profesor(String nombre, String sexo) {
		this.nombre = nombre;
		this.sexo = sexo;
	}
	
	//metodos getters y setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	//metodo toString()
	
	@Override
	public String toString() {
		return "Profesor, [nombre=" + nombre + ", sexo=" + sexo + "]";
	}
	
	
	
	
}
