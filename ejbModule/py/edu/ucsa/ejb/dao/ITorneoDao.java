package py.edu.ucsa.ejb.dao;

import py.edu.ucsa.ejb.entities.Torneo;

public interface ITorneoDao extends IGenericDao<Integer, Torneo> {
	public Iterable<Torneo> findByAno(Integer ano);
}
