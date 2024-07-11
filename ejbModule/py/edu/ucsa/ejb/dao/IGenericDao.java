package py.edu.ucsa.ejb.dao;

import java.io.Serializable;

public interface IGenericDao<PK extends Serializable, T> {
	
	public Iterable<T> findAll();
	public T findById(PK id);
	public T insert(T entity);
	public T update(T entity);
	public void delete(T entity);
	public void deleteById(PK id);

}
