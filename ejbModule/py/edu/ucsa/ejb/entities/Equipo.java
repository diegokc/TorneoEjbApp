package py.edu.ucsa.ejb.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import py.edu.ucsa.ejb.dto.EquipoDTO;
import py.edu.ucsa.ejb.dto.JugadorDTO;

@Entity
@Table(name = "equipos")
@NamedQuery(name = "Equipo.findAll", query = " SELECT e FROM Equipo e ORDER BY e.nombre ASC")
public class Equipo implements Serializable {

	private static final long serialVersionUID = 2483414604228354037L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre")
	private String nombre;
	private String slogan;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "capita_id")
	private Jugador capitan;

	@OneToMany(mappedBy = "equipo",fetch = FetchType.LAZY)
	private List<Jugador> jugadores;

	public Equipo() {
super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public Jugador getCapitan() {
		return capitan;
	}

	public void setCapitan(Jugador capitan) {
		this.capitan = capitan;
	}

	public List<Jugador> getJugadores() {
		if (Objects.isNull(jugadores)) {
			jugadores = new ArrayList<Jugador>();
		}
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public void addJugadores(Jugador jugador) {
		jugadores.add(jugador);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public EquipoDTO toDTO() {
		System.out.println("Ejecucio:  EquipoDTO toDTO() ");
		
		EquipoDTO dto = new EquipoDTO();
		dto.setId(this.getId());
		dto.setNombre(this.getNombre());
		dto.setSlogan(this.getSlogan());
		if (!Objects.isNull(this.getCapitan())) {
			dto.setCapitan(this.getCapitan());
		}
		if (!this.getJugadores().isEmpty()) {
			List<JugadorDTO> jugadores = new ArrayList<>();
			for (Jugador j : this.getJugadores()) {
				jugadores.add( j.toDTO());
			}
			dto.setJugadores(jugadores);
		}
		System.out.println("fin Ejecucio:  EquipoDTO toDTO() ");
		
		return dto;
	}

	public EquipoDTO toListaDTO() {
		
		System.out.println("Ejecucio: EquipoDTO toListaDTO() ");
		EquipoDTO dto = new EquipoDTO();
		dto.setId(this.getId());
		dto.setNombre(this.getNombre());
		dto.setSlogan(this.getSlogan());
		if (!Objects.isNull(this.getCapitan())) {
			dto.setCapitan(this.getCapitan());
		}
		
		if (!this.getJugadores().isEmpty()) {
			List<JugadorDTO> jugadores = new ArrayList<>();
			for (Jugador j : this.getJugadores()) {
				jugadores.add(j.toDTO());
			}
			dto.setJugadores(jugadores);
		}


		System.out.println("fin Ejecucio: EquipoDTO toListaDTO() ");
		return dto;
	}
	
	
	public static Equipo ofDTO(EquipoDTO dto) {
		
		System.out.println("Ejecucio: Equipo ofDTO(EquipoDTO dto) ");
		Equipo entity = new Equipo();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		entity.setSlogan(dto.getSlogan());
		
		if (!Objects.isNull(dto.getCapitan())) {
			entity.setCapitan(Jugador.ofDTO(dto.getCapitan().toDTO()));
		}
		if (!dto.getJugadores().isEmpty()) {
			List<Jugador> jugadores = new ArrayList<>();
			for (JugadorDTO j : dto.getJugadores()) {
				jugadores.add(Jugador.ofDTO(j));
			}
			entity.setJugadores(jugadores);
		}
		System.out.println("fin Ejecucio: Equipo ofDTO(EquipoDTO dto) ");
		return entity;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", slogan=" + slogan + ", capitan=" + capitan
				+ ", jugadores=" + jugadores + "]";
	}
	
}
