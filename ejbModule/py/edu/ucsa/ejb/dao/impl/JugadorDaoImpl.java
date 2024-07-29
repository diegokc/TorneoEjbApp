package py.edu.ucsa.ejb.dao.impl;

import java.util.Objects;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.Query;
import py.edu.ucsa.ejb.dao.IJugadorDao;
import py.edu.ucsa.ejb.entities.Jugador;

@Named("jugadorDAO")
@RequestScoped
public class JugadorDaoImpl extends AbstracDao<Integer, Jugador> implements IJugadorDao {

	public JugadorDaoImpl() {
		super(Jugador.class);
	}
	
	public JugadorDaoImpl(Class<Jugador> clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
	}


	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Jugador> findByNombre(String nombre, boolean isNull) {
		boolean isBlank = Objects.isNull(nombre) || nombre.isBlank();
		/*
		String hql = "SELECT NEW JugadorDTO(j.id,j.nroFicha , j.nombre , j.apellido ,j.nacionalidad) FROM JugadorDTO j" 
				+ ((isBlank && !isNull) ? "" : "WHERE"
				+ (!isBlank ? "e.nombre LIKE : nombre" : "")
				+ (!isBlank && isNull ? "AND" : "")
				+(isNull? "e.equipo IS NULL" : "" ));
		*/
		String hql = "SELECT j FROM Jugador j " 
								+ ((!isBlank ? " WHERE lower( concat(j.nombres,' ',j.apellidos) ) LIKE lower(:nombre) " : ""));
		Query query = this.entityManager.createQuery(hql, Jugador.class);
		if(!isBlank) {
			query.setParameter("nombre","%"+ nombre +"%" );
		}
		return query.getResultList();
	}


}
