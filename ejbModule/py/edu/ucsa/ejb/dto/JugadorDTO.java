package py.edu.ucsa.ejb.dto;

import java.io.Serializable;

public class JugadorDTO implements Serializable{

	private static final long serialVersionUID = -7944014219145045983L;
	
	private Integer id;
	private String nombres;
	private String apellidos;
	private String fechaDeNacimiento;
	private Long nroFicha;
	private String nacionalidad;
	private String telefono;
	private String email;
	private EquipoDTO equipo;
	
	
	public JugadorDTO() {}
	
	public JugadorDTO(Integer id, String nombres, String apellidos, String fechaDeNacimiento, Long nroFicha,
			String nacionalidad, String telefono, String email, EquipoDTO equipo) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.nroFicha = nroFicha;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.email = email;
		this.equipo = equipo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public Long getNroFicha() {
		return nroFicha;
	}
	public void setNroFicha(Long nroFicha) {
		this.nroFicha = nroFicha;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public EquipoDTO getEquipo() {
		return equipo;
	}
	public void setEquipo(EquipoDTO equipo) {
		this.equipo = equipo;
	}
	
	
}
