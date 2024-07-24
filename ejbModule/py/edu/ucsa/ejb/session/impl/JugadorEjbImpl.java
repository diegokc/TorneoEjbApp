package py.edu.ucsa.ejb.session.impl;

import java.util.List;
import java.util.Objects;
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

	public JugadorEjbImpl() {
	}

	@Override
	public List<JugadorDTO> findAll() {

		Stream<Jugador> jugadores = StreamSupport.stream(jdao.findAll().spliterator(), false);
		return jugadores.map(Jugador::toListaDTO).toList();

	}

	@Override
	public void insert(JugadorDTO dto) {
		jdao.insert(Jugador.ofDTO(dto));
	}

	@Override
	public List<JugadorDTO> findByNombre(String nombre, boolean isNull) {
		Stream<Jugador> jugadores = StreamSupport.stream(jdao.findByNombre(nombre, isNull).spliterator(), false);
		return jugadores.map(Jugador::toListaDTO).toList();
	}

	@Override
	public List<JugadorDTO> listar() {
		Stream<Jugador> jugadores = StreamSupport.stream(jdao.findAll().spliterator(), false);
		return jugadores.map(Jugador::toListaDTO).toList();
	}

	@Override
	public JugadorDTO getById(int id) {
		Jugador j = jdao.findById(id);

		if (!Objects.isNull(j))
			return j.toDTO();
		else
			return null;
	}

	@Override
	public JugadorDTO insertar(JugadorDTO obj) {
		Jugador er = jdao.insert(Jugador.ofDTO(obj));
		return er.toDTO();
	}

	@Override
	public void actualizar(JugadorDTO obj) {
		Jugador er = jdao.update(Jugador.ofDTO(obj));

	}

	@Override
	public void eliminar(int id) {
		Jugador j = jdao.findById(id);

		if (!Objects.isNull(j))
			jdao.delete(j);

	}

}
