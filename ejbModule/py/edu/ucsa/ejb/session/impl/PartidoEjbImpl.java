package py.edu.ucsa.ejb.session.impl;

import java.util.List;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PartidoDTO getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PartidoDTO insertar(PartidoDTO obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(PartidoDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	
	
}
