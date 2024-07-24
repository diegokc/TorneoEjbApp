package py.edu.ucsa.ejb.dao;

import py.edu.ucsa.ejb.entities.Equipo;

public interface IEquipoDao extends IGenericDao<Integer, Equipo> {

	public Iterable<Equipo> findAllByNombre(String nombre, boolean isNull);
}
