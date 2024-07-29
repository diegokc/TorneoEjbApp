package py.edu.ucsa.ejb.session;

import java.util.List;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.PartidoDTO;

@Remote
public interface PartidoEjbRemote extends GenericEjbRemote<Long, PartidoDTO> {
	public List<PartidoDTO> finAll();
	public void insert(PartidoDTO dto);
	public List<PartidoDTO> finByTorneo(int torneo);
}
