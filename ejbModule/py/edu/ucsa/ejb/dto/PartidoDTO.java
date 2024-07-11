package py.edu.ucsa.ejb.dto;

import java.io.Serializable;

public class PartidoDTO implements Serializable {

	private static final long serialVersionUID = 1351591322651472641L;

	private Integer id;
	
	private TorneoDTO torneo;
	
	private EquipoDTO equipoLocal;
	
	private EquipoDTO equipoVisitante;
	
	private String fecha;
	
	private String hora;
	
	private Integer numeroDeFecha;
	
	private Integer golesLocal;
	
	private Integer golesVisitante;

	public PartidoDTO() {}
	
	public PartidoDTO(Integer id, TorneoDTO torneo, EquipoDTO equipoLocal, EquipoDTO equipoVisitante, String fecha,
			String hora, Integer numeroDeFecha, Integer golesLocal, Integer golesVisitante) {
		super();
		this.id = id;
		this.torneo = torneo;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.fecha = fecha;
		this.hora = hora;
		this.numeroDeFecha = numeroDeFecha;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TorneoDTO getTorneo() {
		return torneo;
	}

	public void setTorneo(TorneoDTO torneo) {
		this.torneo = torneo;
	}

	public EquipoDTO getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(EquipoDTO equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public EquipoDTO getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(EquipoDTO equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Integer getNumeroDeFecha() {
		return numeroDeFecha;
	}

	public void setNumeroDeFecha(Integer numeroDeFecha) {
		this.numeroDeFecha = numeroDeFecha;
	}

	public Integer getGolesLocal() {
		return golesLocal;
	}

	public void setGolesLocal(Integer golesLocal) {
		this.golesLocal = golesLocal;
	}

	public Integer getGolesVisitante() {
		return golesVisitante;
	}

	public void setGolesVisitante(Integer golesVisitante) {
		this.golesVisitante = golesVisitante;
	}
	
	
}
