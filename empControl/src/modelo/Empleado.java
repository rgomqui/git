package modelo;

import java.sql.Date;

public class Empleado {
	
	
	public Empleado() {
		
	}
	

	public Empleado(String tallaPie, String nombre, String apellido1, String apellido2, String dni,
			String telefono, String tallaSuperior, String tallaInferior, String tipoCalzado, Date fechaRegistro) {
		super();
		this.tipoCalzado = tipoCalzado;
		this.tallaPie = tallaPie;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.telefono = telefono;
		this.tallaSuperior = tallaSuperior;
		this.tallaInferior = tallaInferior;
		this.fechaRegistro = fechaRegistro;
	}



	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getTallaPie() {
		return tallaPie;
	}


	public void setTallaPie(String tallaPie) {
		this.tallaPie = tallaPie;
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


	public String getTallaSuperior() {
		return tallaSuperior;
	}


	public void setTallaSuperior(String tallaSuperior) {
		this.tallaSuperior = tallaSuperior;
	}


	public String getTallaInferior() {
		return tallaInferior;
	}


	public void setTallaInferior(String tallaInferior) {
		this.tallaInferior = tallaInferior;
	}


	public Date getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public String getTipoCalzado() {
		return tipoCalzado;
	}


	public void setTipoCalzado(String tipoCalzado) {
		this.tipoCalzado = tipoCalzado;
	}


	/*/SOBREESCRITURA DEL METODO TOSTRING/*/
	@Override
	public String toString() {
		return " " + apellido1+ " " + apellido2 + ", " + nombre +" ";
	}
	
	
	/*/CAMPOS DE CLASE/*/
	private int codigo;
	private String nombre, apellido1, apellido2, dni, telefono, tallaSuperior, tallaInferior, tipoCalzado, tallaPie;
	private Date fechaRegistro;
		
}
