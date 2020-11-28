package modelo;

import java.sql.Date;

public class Empleado {
	
	
	/*/campos de clase incluyendo los de futura implementacion/*/
	
	private int codigo;
	private String nombre, apellido1, apellido2,dni, telefono, turno, tipoContrato, horasSemana ;
	private Date antiguedad;
	
	
	
	//metodos de acceso
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
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public String getHorasSemana() {
		return horasSemana;
	}
	public void setHorasSemana(String horasSemana) {
		this.horasSemana = horasSemana;
	}
	public Date getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(Date antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	
	

}
