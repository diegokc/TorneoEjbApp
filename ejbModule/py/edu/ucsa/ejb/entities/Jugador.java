package py.edu.ucsa.ejb.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import py.edu.ucsa.ejb.dto.JugadorDTO;

@Entity
@Table(name = "jugadores")
@NamedQuery(name = "Jugador.findAll", query = " SELECT e FROM Jugador e ORDER BY e.nroFicha ASC")
@NamedQuery(name = "Jugador.findNombre", query = " SELECT e FROM Jugador e ORDER BY e.nroFicha ASC")
public class Jugador implements Serializable {

	private static final long serialVersionUID = 584837202246365146L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nombres;
	private String apellidos;

	@Column(name = "fecha_de_nacimiento", columnDefinition = "DATE")
	private LocalDate fechaDeNacimiento;

	@Column(name = "nro_ficha")
	private Long nroFicha;

	private String nacionalidad;
	private String telefono;
	private String email;

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_equipo")
	private Equipo equipo;

	public Jugador() {
		super();
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

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
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

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public JugadorDTO toDTO() {
		
		System.out.println("Ejecucio: JugadorDTO toDTO() ");
		
		JugadorDTO dto = new JugadorDTO();
		dto.setId(this.getId());

		dto.setNombres(this.getNombres());
		dto.setApellidos(this.getApellidos());
		if (!Objects.isNull(this.getFechaDeNacimiento())) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			dto.setFechaDeNacimiento(this.getFechaDeNacimiento().format(formatter));
		}
		dto.setNroFicha(this.getNroFicha());
		dto.setNacionalidad(this.getNacionalidad());
		dto.setTelefono(this.getTelefono());
		dto.setEmail(this.getEmail());
		/*
		if (!Objects.isNull(this.getEquipo())) {
			dto.setEquipo(this.getEquipo().toDTO());
		}
		*/
		System.out.println("fin Ejecucio: JugadorDTO toDTO() ");
		return dto;
	}

	public JugadorDTO toListaDTO() {
		System.out.println("Ejecucio: JugadorDTO toListaDTO() ");
		
		JugadorDTO dto = new JugadorDTO();
		dto.setId(this.getId());

		dto.setNombres(this.getNombres());
		dto.setApellidos(this.getApellidos());
		if (!Objects.isNull(this.getFechaDeNacimiento())) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			dto.setFechaDeNacimiento(this.getFechaDeNacimiento().format(formatter));
		}
		dto.setNroFicha(this.getNroFicha());
		dto.setNacionalidad(this.getNacionalidad());
		dto.setTelefono(this.getTelefono());
		dto.setEmail(this.getEmail());

		System.out.println("fin Ejecucio: JugadorDTO toListaDTO() ");
		
		return dto;
	}
/*
	public JugadorDTO toListaBusquedaDTO() {
		
		System.out.println("Ejecucio: JugadorDTO toListaBusquedaDTO() ");
		
		JugadorDTO dto = new JugadorDTO();
		dto.setId(this.getId());

		dto.setNombres(this.getNombres());
		dto.setApellidos(this.getApellidos());
		if (!Objects.isNull(this.getFechaDeNacimiento())) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			dto.setFechaDeNacimiento(this.getFechaDeNacimiento().format(formatter));
		}
		dto.setNroFicha(this.getNroFicha());
		dto.setNacionalidad(this.getNacionalidad());
		dto.setTelefono(this.getTelefono());
		dto.setEmail(this.getEmail());

		System.out.println("Ejecucio: JugadorDTO toListaBusquedaDTO() ");
		
		return dto;
	}
*/
	public static Jugador ofDTO(JugadorDTO dto) {
		
		System.out.println("Ejecucio:  static Jugador ofDTO(JugadorDTO dto)  ");
		
		Jugador entity = new Jugador();

		entity.setId(dto.getId());
		entity.setNombres(dto.getNombres());
		entity.setApellidos(dto.getApellidos());
		if (!Objects.isNull(dto.getFechaDeNacimiento())) {
			entity.setFechaDeNacimiento(
					LocalDate.parse(dto.getFechaDeNacimiento(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		}
		entity.setNroFicha(dto.getNroFicha());
		entity.setNacionalidad(dto.getNacionalidad());
		entity.setTelefono(dto.getTelefono());
		entity.setEmail(dto.getEmail());
		/*
		if (!Objects.isNull(dto.getEquipo())) {
			entity.setEquipo(Equipo.ofDTO(dto.getEquipo()));
		}
		*/
		System.out.println("fin Ejecucio:  static Jugador ofDTO(JugadorDTO dto)  ");
		
		return entity;
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", fechaDeNacimiento="
				+ fechaDeNacimiento + ", nroFicha=" + nroFicha + ", nacionalidad=" + nacionalidad + ", telefono="
				+ telefono + ", email=" + email + ", equipo=" + equipo + "]";
	}
	
	
}
