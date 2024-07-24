package py.edu.ucsa.ejb.dao.impl;

import java.util.Objects;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.Query;
import py.edu.ucsa.ejb.dao.IEquipoDao;
import py.edu.ucsa.ejb.entities.Equipo;


@RequestScoped
@Named("equipoDAO")
public class EquipoDaoImpl extends AbstracDao<Integer, Equipo> implements IEquipoDao {

	public EquipoDaoImpl() {
		super(Equipo.class);
	}

	public EquipoDaoImpl(Class<Equipo> clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Equipo> findAllByNombre(String nombre, boolean isNull) {
		boolean isBlank = Objects.isNull(nombre) || nombre.isBlank();
		String hql = "FROM EquipoDTO e" 
				+ ((isBlank && !isNull) ? "" : "where"
				+ (!isBlank ? "e.nombre LIKE : nombre" : "")
				+ (!isBlank && isNull ? "AND" : "")
				+(isNull? "e.equipo IS NULL" : "" ));
		Query   query = this.entityManager.createQuery(hql, Equipo.class);
		if(!isBlank) {
			query.setParameter("nombre","%"+ nombre +"%" );
		}
		return query.getResultList();
	}

}
