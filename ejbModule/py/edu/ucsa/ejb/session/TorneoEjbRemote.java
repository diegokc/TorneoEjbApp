package py.edu.ucsa.ejb.session;

import java.util.List;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.TorneoDTO;

@Remote
public interface TorneoEjbRemote extends GenericEjbRemote<Long, TorneoDTO> {

	public List<TorneoDTO> findAll();

	public void insert(TorneoDTO dto);

	public List<TorneoDTO> findByAno(int ano);

}
