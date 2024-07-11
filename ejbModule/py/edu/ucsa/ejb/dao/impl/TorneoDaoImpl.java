package py.edu.ucsa.ejb.dao.impl;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import py.edu.ucsa.ejb.dao.ITorneoDao;
import py.edu.ucsa.ejb.entities.Torneo;

@Named("torneoDAO")
@RequestScoped
public class TorneoDaoImpl extends AbstracDao<Long, Torneo> implements ITorneoDao {

	public TorneoDaoImpl(Class<Torneo> clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Torneo insert(Torneo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Torneo update(Torneo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Torneo entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Torneo> findByAno(int ano) {
		// TODO Auto-generated method stub
		return null;
	}

}
