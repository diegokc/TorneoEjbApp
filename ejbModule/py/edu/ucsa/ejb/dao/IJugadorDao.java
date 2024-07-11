package py.edu.ucsa.ejb.dao;

import py.edu.ucsa.ejb.entities.Jugador;

public interface IJugadorDao extends IGenericDao<Long, Jugador> {

	public Iterable<Jugador> findByNombre(String nombre, boolean isNull);
}
