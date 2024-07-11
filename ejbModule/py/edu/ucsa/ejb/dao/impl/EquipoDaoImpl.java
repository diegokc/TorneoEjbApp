package py.edu.ucsa.ejb.dao.impl;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import py.edu.ucsa.ejb.dao.IEquipoDao;
import py.edu.ucsa.ejb.entities.Equipo;

@Named("equipoDAO")
@RequestScoped
public class EquipoDaoImpl extends AbstracDao<Long, Equipo> implements IEquipoDao {

	public EquipoDaoImpl(Class<Equipo> clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Equipo insert(Equipo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Equipo update(Equipo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Equipo entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Equipo> findAllByNombre(String nombre, boolean isNull) {
		// TODO Auto-generated method stub
		return null;
	}


}
