package py.edu.ucsa.ejb.session;

import java.util.List;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.JugadorDTO;

@Remote
public interface JugadorEjbRemote extends GenericEjbRemote<Long, JugadorDTO> {

	public List<JugadorDTO> findAll();
	
	public void insert(JugadorDTO dto);
	
	public List<JugadorDTO> findByNombre(String nombre, boolean isNull);
	
}
