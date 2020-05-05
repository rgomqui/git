/***************************************************************
 * Proyecto Hibernate perteneciente a la PAC de desarrollo M06 *
 * Autor: Rafael Gomez Quintero							       *
 * Fecha: 08/04/2020									       *
 ***************************************************************/


package pac;

import java.util.Set;

public class Alumno {
	
	//campos de clase
	
	private long idAlumno;
	private String nombre;
	private String nacionalidad;
	private int edad;
	private String sexo;
	private Set <Modulo> alumno_modulo;
	
	
	//constructores
	
	public Alumno() {
		
	}



	public Alumno(String nombre, String nacionalidad, int edad, String sexo, Set<Modulo> modulos) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.edad = edad;
		this.sexo = sexo;
		this.alumno_modulo = modulos;
	}





	//metodos getters y setters
	
	



	public long getIdAlumno() {
		return idAlumno;
	}



	public void setIdAlumno(long idAlumno) {
		this.idAlumno = idAlumno;
	}









	public Set<Modulo> getAlumno_modulo() {
		return alumno_modulo;
	}



	public void setAlumno_modulo(Set<Modulo> alumno_modulo) {
		this.alumno_modulo = alumno_modulo;
	}



	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



	//metodo toString

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", edad=" + edad
				+ ", sexo=" + sexo + ", modulos=" + alumno_modulo.size() + "]";
	}
	
}
