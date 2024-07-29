package py.edu.ucsa.ejb.dao;


import jakarta.ws.rs.QueryParam;
import py.edu.ucsa.ejb.entities.Torneo;

public interface ITorneoDao extends IGenericDao<Integer, Torneo> {
	public Iterable<Torneo> findByAno(@QueryParam("ano") Integer ano);
}
