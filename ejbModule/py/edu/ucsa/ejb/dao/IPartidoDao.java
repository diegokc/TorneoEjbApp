package py.edu.ucsa.ejb.dao;

import py.edu.ucsa.ejb.entities.Partido;

public interface IPartidoDao extends IGenericDao<Long, Partido> {
	public Iterable<Partido> finByFechaNro(int fechaNro);
}
