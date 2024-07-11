package py.edu.ucsa.ejb.session;

import java.util.List;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.EquipoDTO;

@Remote
public interface EquipoEjbRemote extends GenericEjbRemote<Long, EquipoDTO> {

	public List<EquipoDTO> findAll();
	
	public void insert(EquipoDTO dto);
	
	public List<EquipoDTO> findByNombre(String nombre, boolean isNull);

}
