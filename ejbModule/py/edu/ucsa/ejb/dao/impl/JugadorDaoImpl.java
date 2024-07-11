package py.edu.ucsa.ejb.dao.impl;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import py.edu.ucsa.ejb.dao.IJugadorDao;
import py.edu.ucsa.ejb.entities.Jugador;

@Named("jugadorDAO")
@RequestScoped
public class JugadorDaoImpl extends AbstracDao<Long, Jugador> implements IJugadorDao {

	public JugadorDaoImpl() {
		super(Jugador.class);
	}
	
	public JugadorDaoImpl(Class<Jugador> clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Jugador insert(Jugador entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jugador update(Jugador entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Jugador entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Jugador> findByNombre(String nombre, boolean isNull) {
		// TODO Auto-generated method stub
		return null;
	}


}
