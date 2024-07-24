package py.edu.ucsa.ejb.dao.impl;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import py.edu.ucsa.ejb.dao.IPartidoDao;
import py.edu.ucsa.ejb.entities.Partido;

@Named("partidoDAO")
@RequestScoped
public class PartidoDaoImpl extends AbstracDao<Integer, Partido> implements IPartidoDao {

	public PartidoDaoImpl() {
		super(Partido.class);
	}
	
	
	public PartidoDaoImpl(Class<Partido> clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Partido insert(Partido entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Partido update(Partido entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Partido entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Partido> finByFechaNro(int fechaNro) {
		// TODO Auto-generated method stub
		return null;
	}

}
