package py.edu.ucsa.ejb.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import py.edu.ucsa.ejb.entities.Jugador;

public class EquipoDTO {


	private Integer id;
	private String nombre;
	private String slogan;
	private Jugador capitan;
	private List<JugadorDTO> jugadores;
	
	
	public EquipoDTO() {
		
	}
	public EquipoDTO(Integer id, String nombre, String slogan, Jugador capitan, List<JugadorDTO> jugadores) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.slogan = slogan;
		this.capitan = capitan;
		this.jugadores = jugadores;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public List<JugadorDTO> getJugadores() {
		if(Objects.isNull(jugadores)) {
			jugadores = new ArrayList<JugadorDTO>();
		}
		return jugadores;
	}
	public void setJugadores(List<JugadorDTO> jugadores) {
		this.jugadores = jugadores;
	}

	
	
}
