package py.edu.ucsa.ejb.dto;

public class TorneoDTO {


	private Integer id;
	
	private Integer ano;
	
	private String nombre;
	
	private Integer numeroDeEquipos;
	
	private String fechaDeInicio;

	private String fechaDeFin;
	
	public TorneoDTO() {}

	public TorneoDTO(Integer id, Integer ano, String nombre, Integer numeroDeEquipos, String fechaDeInicio,
			String fechaDeFin) {
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

	public String getFechaDeInicio() {
		return fechaDeInicio;
	}

	public void setFechaDeInicio(String fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
	}

	public String getFechaDeFin() {
		return fechaDeFin;
	}

	public void setFechaDeFin(String fechaDeFin) {
		this.fechaDeFin = fechaDeFin;
	}
	
	
}
