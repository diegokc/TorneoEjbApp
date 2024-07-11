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
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import py.edu.ucsa.ejb.dto.TorneoDTO;

@Entity
@Table(name = "torneos")
@NamedQuery(name = "Torneo.findAll", query = " SELECT e FROM Torneo e ORDER BY e.id ASC")
public class Torneo implements Serializable {

	private static final long serialVersionUID = 2149231568156322891L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "ano")
	private Integer ano;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "numero_de_equipos")
	private Integer numeroDeEquipos;

	@Column(name = "fecha_de_inicio", columnDefinition = "DATE")
	private LocalDate fechaDeInicio;

	@Column(name = "fecha_de_fin", columnDefinition = "DATE")
	private LocalDate fechaDeFin;

	public Torneo() {
	}

	public Torneo(Integer id, Integer ano, String nombre, Integer numeroDeEquipos, LocalDate fechaDeInicio,
			LocalDate fechaDeFin) {
		super();
		this.id = id;
		this.ano = ano;
		this.nombre = nombre;
		this.numeroDeEquipos = numeroDeEquipos;
		this.fechaDeInicio = fechaDeInicio;
		this.fechaDeFin = fechaDeFin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumeroDeEquipos() {
		return numeroDeEquipos;
	}

	public void setNumeroDeEquipos(Integer numeroDeEquipos) {
		this.numeroDeEquipos = numeroDeEquipos;
	}

	public LocalDate getFechaDeInicio() {
		return fechaDeInicio;
	}

	public void setFechaDeInicio(LocalDate fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
	}

	public LocalDate getFechaDeFin() {
		return fechaDeFin;
	}

	public void setFechaDeFin(LocalDate fechaDeFin) {
		this.fechaDeFin = fechaDeFin;
	}

	public TorneoDTO toDTO() {
		TorneoDTO dto = new TorneoDTO();

		dto.setId(this.getId());
		dto.setAno(this.getAno());
		dto.setNombre(this.getNombre());
		dto.setNumeroDeEquipos(this.getNumeroDeEquipos());
		if (!Objects.isNull(this.getFechaDeInicio())) {
			DateTimeFormatter fd = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			dto.setFechaDeInicio(this.getFechaDeInicio().format(fd));
		}
		if (!Objects.isNull(this.getFechaDeFin())) {
			DateTimeFormatter fd = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			dto.setFechaDeFin(this.getFechaDeFin().format(fd));
		}

		return dto;

	}
	
	public static Torneo ofDTO(TorneoDTO dto) {
		Torneo entity = new Torneo();
		
		entity.setId(dto.getId());
		entity.setAno(dto.getAno());
		entity.setNombre(dto.getNombre());
		entity.setNumeroDeEquipos(dto.getNumeroDeEquipos());
		if (!Objects.isNull(dto.getFechaDeInicio())) {
			entity.setFechaDeInicio(LocalDate.parse(dto.getFechaDeInicio(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		}
		if (!Objects.isNull(dto.getFechaDeFin())) {
			entity.setFechaDeFin(LocalDate.parse(dto.getFechaDeFin(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		}
		
		return entity;
	}

}
