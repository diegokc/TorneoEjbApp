package py.edu.ucsa.ejb.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import py.edu.ucsa.ejb.entities.Jugador;

public class EquipoDTO implements Serializable {

	private static final long serialVersionUID = -5646141133846236444L;
	
	private Integer id;
	private String nombre;
	private String slogan;
	private Jugador capitan;
	private List<JugadorDTO> jugadores;
	
	
	public EquipoDTO() {
		super();
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
