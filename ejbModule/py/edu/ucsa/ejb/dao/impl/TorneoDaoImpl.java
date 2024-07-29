package py.edu.ucsa.ejb.dao.impl;

import java.util.List;
import java.util.Objects;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.Query;
import py.edu.ucsa.ejb.dao.ITorneoDao;
import py.edu.ucsa.ejb.entities.Jugador;
import py.edu.ucsa.ejb.entities.Torneo;

@Named("torneoDAO")
@RequestScoped
public class TorneoDaoImpl extends AbstracDao<Integer, Torneo> implements ITorneoDao {

	
	public TorneoDaoImpl() {
		super(Torneo.class);
	}
	
	public TorneoDaoImpl(Class<Torneo> clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Iterable<Torneo> findByAno(Integer ano) {
		
		Query query = this.entityManager.createNamedQuery("findByAno");
		query.setParameter("ano",ano);

		return query.getResultList();
	}

}
