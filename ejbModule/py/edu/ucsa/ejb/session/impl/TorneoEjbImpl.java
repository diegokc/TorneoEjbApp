package py.edu.ucsa.ejb.session.impl;

import java.util.List;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TorneoDTO getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TorneoDTO insertar(TorneoDTO obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(TorneoDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
