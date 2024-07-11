package py.edu.ucsa.ejb.session.impl;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import py.edu.ucsa.ejb.dao.IJugadorDao;
import py.edu.ucsa.ejb.dto.JugadorDTO;
import py.edu.ucsa.ejb.entities.Jugador;
import py.edu.ucsa.ejb.session.JugadorEjbRemote;

@Stateless
@LocalBean
public class JugadorEjbImpl implements JugadorEjbRemote {

	@Inject
	@Named("jugadorDAO")
	private IJugadorDao jdao;
	
	public JugadorEjbImpl() {}
	
	@Override
	public List<JugadorDTO> findAll() {

		Stream<Jugador> jugadores  = StreamSupport.stream(jdao.findAll().spliterator(),false);
		return jugadores.map(Jugador::toListaDTO).toList();
		
	}

	@Override
	public void insert(JugadorDTO dto) {
		jdao.insert(Jugador.ofDTO(dto));
	}

	@Override
	public List<JugadorDTO> findByNombre(String nombre, boolean isNull) {
		Stream<Jugador> jugadores  = StreamSupport.stream(jdao.findByNombre(nombre,isNull).spliterator(), false);
		return jugadores.map(Jugador::toListaBusquedaDTO).toList();
	}

	@Override
	public List<JugadorDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JugadorDTO getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JugadorDTO insertar(JugadorDTO obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(JugadorDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	
	
}
