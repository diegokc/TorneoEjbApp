package py.edu.ucsa.ejb.session;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Remote;

@Remote
public interface GenericEjbRemote<PK extends Serializable, T>  {

	public List<T> listar();

	public T getById(int id);

	public T insertar(T obj);

	public void actualizar(T obj);

	public void eliminar(int id);
	
}
