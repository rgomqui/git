package modelo;

public class Empleado {
	
	
	public Empleado() {
		
	}
	
	
	public Empleado(String nombre, String apellido1, String apellido2, String dni, String telefono) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.telefono = telefono;
	}


	/*/SOBREESCRITURA DEL METODO TOSTRING/*/
	@Override
	public String toString() {
		return " " + apellido1+ " " + apellido2 + ", " + nombre +" ";
	}
	
	
	/*/METODOS DE ACCESO/*/
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	/*/CAMPOS DE CLASE/*/
	private int codigo;
	private String nombre, apellido1, apellido2,dni, telefono;
		
}
