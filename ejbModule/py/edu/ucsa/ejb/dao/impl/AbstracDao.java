package py.edu.ucsa.ejb.dao.impl;

import java.io.Serializable;
import java.util.logging.Logger;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import py.edu.ucsa.ejb.dao.IGenericDao;

public abstract class AbstracDao<PK extends Serializable, T> implements IGenericDao<PK, T> {

	
	private final Class<T> persistentClass;
	protected Logger LOGGER = null;

	public AbstracDao(Class<T> clazz) {
		this.persistentClass = clazz;
		this.LOGGER = Logger.getLogger(persistentClass.getName());
	}

	@PersistenceContext(name = "TorneoJPA")
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public Iterable<T> findAll() {
		return this.entityManager.createNamedQuery(persistentClass.getSimpleName() + ".findAll").getResultList();
	}
	
	public T findById(PK id) {
		return (T) entityManager.find(persistentClass, id);
	}
	
	

}
