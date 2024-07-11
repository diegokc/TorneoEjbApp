package py.edu.ucsa.ejb.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
import py.edu.ucsa.ejb.dto.PartidoDTO;

@Entity
@Table(name = "partidos")
@NamedQuery(name = "Partido.findAll", query = " SELECT e FROM Partido e ORDER BY e.torneo.id ASC")
public class Partido implements Serializable {

	private static final long serialVersionUID = 266429255559612300L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_torneo")
	private Torneo torneo;

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_equipo_local")
	private Equipo equipoLocal;

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_equipo_visitante")
	private Equipo equipoVisitante;

	@Column(name = "fecha", columnDefinition = "DATE")
	private LocalDate fecha;

	@Column(name = "hora", columnDefinition = "TIMESTAMP")
	private LocalDateTime hora;

	@Column(name = "numero_de_fecha")
	private Integer numeroDeFecha;

	@Column(name = "goles_local")
	private Integer golesLocal;

	@Column(name = "goles_visitante")
	private Integer golesVisitante;

	public Partido() {

	}

	public Partido(Integer id, Torneo torneo, Equipo equipoLocal, Equipo equipoVisitante, LocalDate fecha,
			LocalDateTime hora, Integer numeroDeFecha, Integer golesLocal, Integer golesVisitante) {
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

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

	public Equipo getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalDateTime getHora() {
		return hora;
	}

	public void setHora(LocalDateTime hora) {
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

	public PartidoDTO toDTO() {
		PartidoDTO dto = new PartidoDTO();

		dto.setId(this.getId());
		if (!Objects.isNull(this.getTorneo())) {
			dto.setTorneo(this.getTorneo().toDTO());
		}
		if (!Objects.isNull(this.getEquipoLocal())) {
			dto.setEquipoLocal(this.getEquipoLocal().toDTO());
		}
		if (!Objects.isNull(this.getEquipoVisitante())) {
			dto.setEquipoVisitante(this.getEquipoVisitante().toDTO());
		}
		if (!Objects.isNull(this.getFecha())) {
			DateTimeFormatter fd = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			dto.setFecha(this.getFecha().format(fd));
		}
		if (!Objects.isNull(this.getHora())) {
			DateTimeFormatter ft = DateTimeFormatter.ofPattern("HH:mm");
			dto.setHora(this.getHora().format(ft));
		}

		dto.setNumeroDeFecha(this.getNumeroDeFecha());
		dto.setGolesLocal(this.getGolesLocal());
		dto.setGolesVisitante(this.getGolesVisitante());

		return dto;
	}

	public static Partido ofDTO(PartidoDTO dto) {
		Partido entity = new Partido();

		entity.setId(dto.getId());
		if (!Objects.isNull(dto.getTorneo())) {
			entity.setTorneo(Torneo.ofDTO(dto.getTorneo()));
		}
		if (!Objects.isNull(dto.getEquipoLocal())) {
			entity.setEquipoLocal(Equipo.ofDTO(dto.getEquipoLocal()));
		}
		if (!Objects.isNull(dto.getEquipoVisitante())) {
			entity.setEquipoVisitante(Equipo.ofDTO(dto.getEquipoVisitante()));
		}
		
		if (!Objects.isNull(dto.getFecha())) {
		entity.setFecha(LocalDate.parse(dto.getFecha(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		}
		if (!Objects.isNull(dto.getHora())) {
		entity.setHora(LocalDateTime.parse(dto.getFecha()+" "+dto.getHora(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		}
		entity.setNumeroDeFecha(dto.getNumeroDeFecha());
		entity.setGolesLocal(dto.getGolesLocal());
		entity.setGolesVisitante(dto.getGolesVisitante());

		return entity;

	}
}
