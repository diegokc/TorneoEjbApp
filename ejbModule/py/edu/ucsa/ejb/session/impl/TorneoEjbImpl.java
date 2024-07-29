package py.edu.ucsa.ejb.session.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import py.edu.ucsa.ejb.dao.ITorneoDao;
import py.edu.ucsa.ejb.dto.TorneoDTO;
import py.edu.ucsa.ejb.entities.Torneo;
import py.edu.ucsa.ejb.session.TorneoEjbRemote;

@Stateless
@LocalBean
public class TorneoEjbImpl implements TorneoEjbRemote {

	@Inject
	@Named("torneoDAO")
	private ITorneoDao dao;
	
	public TorneoEjbImpl() {}
	
	@Override
	public List<TorneoDTO> findAll() {
		Stream<Torneo> torneos = StreamSupport.stream(dao.findAll().spliterator(),false);
		return torneos.map(Torneo::toDTO).toList();
	}

	@Override
	public void insert(TorneoDTO dto) {
			dao.insert(Torneo.ofDTO(dto));
		
	}

	@Override
	public List<TorneoDTO> findByAno(int ano) {
		Stream<Torneo> torneos = StreamSupport.stream(dao.findByAno(ano).spliterator(),false);
		return torneos.map(Torneo::toDTO).toList();
	}

	@Override
	public List<TorneoDTO> listar() {
		Stream<Torneo> torneos = StreamSupport.stream(dao.findAll().spliterator(), false);
		return torneos.map(Torneo::toListaDTO).toList();
	}

	@Override
	public TorneoDTO getById(int id) {
		Torneo j = dao.findById(id);

		if (!Objects.isNull(j))
			return j.toDTO();
		else
			return null;
	}

	@Override
	public TorneoDTO insertar(TorneoDTO obj) {
		Torneo er = dao.insert(Torneo.ofDTO(obj));
		return er.toDTO();
	}

	@Override
	public void actualizar(TorneoDTO obj) {
		Torneo j = Torneo.ofDTO(obj);
		System.out.println(j.toString());
		
		Torneo er = dao.update(j);
	}

	@Override
	public void eliminar(int id) {
		Torneo j = dao.findById(id);

		if (!Objects.isNull(j))
			dao.delete(j);
	}
	
}
