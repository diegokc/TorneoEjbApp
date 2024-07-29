package py.edu.ucsa.ejb.session.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import py.edu.ucsa.ejb.dao.IPartidoDao;
import py.edu.ucsa.ejb.dto.PartidoDTO;
import py.edu.ucsa.ejb.entities.Partido;
import py.edu.ucsa.ejb.session.PartidoEjbRemote;

@Stateless
@LocalBean
public class PartidoEjbImpl implements PartidoEjbRemote {

	@Inject
	@Named("partidoDAO")
	private IPartidoDao dao;
	
	public PartidoEjbImpl() {}
	
	@Override
	public List<PartidoDTO> finAll() {
		Stream<Partido> partidos= StreamSupport.stream(dao.findAll().spliterator(),false);
		return partidos.map(Partido::toDTO).toList();
	}

	@Override
	public void insert(PartidoDTO dto) {
		dao.insert(Partido.ofDTO(dto));
		
	}

	@Override
	public List<PartidoDTO> listar() {
		Stream<Partido> partidos = StreamSupport.stream(dao.findAll().spliterator(), false);
		return partidos.map(Partido::toListaDTO).toList();
	}

	@Override
	public PartidoDTO getById(int id) {
		Partido j = dao.findById(id);

		if (!Objects.isNull(j))
			return j.toDTO();
		else
			return null;
	}

	@Override
	public PartidoDTO insertar(PartidoDTO obj) {
		Partido er = dao.insert(Partido.ofDTO(obj));
		return er.toDTO();
	}

	@Override
	public void actualizar(PartidoDTO obj) {
		Partido j = Partido.ofDTO(obj);
		System.out.println(j.toString());
		
		Partido er = dao.update(j);
		
	}

	@Override
	public void eliminar(int id) {
		Partido j = dao.findById(id);

		if (!Objects.isNull(j))
			dao.delete(j);
	}

	@Override
	public List<PartidoDTO> finByTorneo(int torneo) {
		Stream<Partido> partidos = StreamSupport.stream(dao.finByTorneo(torneo).spliterator(), false);
		return partidos.map(Partido::toListaDTO).toList();
	}

	
	
}
