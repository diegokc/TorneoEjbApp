package py.edu.ucsa.ejb.dao.impl;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.Query;
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
	public Iterable<Partido> finByFechaNro(int fechaNro) {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<Partido> finByTorneo(int torneo){
		
		Query query = this.entityManager.createNamedQuery("Partido.findByTorneo");
		query.setParameter("torneo",torneo);

		return query.getResultList();
	}

	
}
