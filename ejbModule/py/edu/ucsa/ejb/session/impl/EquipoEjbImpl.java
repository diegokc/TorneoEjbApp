package py.edu.ucsa.ejb.session.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import py.edu.ucsa.ejb.dao.IEquipoDao;
import py.edu.ucsa.ejb.dao.IJugadorDao;
import py.edu.ucsa.ejb.dto.EquipoDTO;
import py.edu.ucsa.ejb.entities.Equipo;
import py.edu.ucsa.ejb.entities.Jugador;
import py.edu.ucsa.ejb.session.EquipoEjbRemote;

@Stateless
@LocalBean
@Transactional
public class EquipoEjbImpl implements EquipoEjbRemote {

	@Inject
	@Named("equipoDAO")
	private IEquipoDao eqdao;

	@Inject
	@Named("jugadorDAO")
	private IJugadorDao jDao;

	public EquipoEjbImpl() {

	}

	@Override
	public List<EquipoDTO> findAll() {
		Stream<Equipo> equipos = StreamSupport.stream(eqdao.findAll().spliterator(), false);
		return equipos.map(Equipo::toListaDTO).toList();

	}

	@Override
	public void insert(EquipoDTO dto) {
		Equipo equipo = Equipo.ofDTO(dto);
		equipo = eqdao.insert(equipo);

		Jugador eJugador;
		for (Jugador jugador : equipo.getJugadores()) {
			eJugador = jDao.findById(jugador.getId());
			eJugador.setEquipo(equipo);
			jDao.update(eJugador);
		}

	}

	@Override
	public List<EquipoDTO> findByNombre(String nombre, boolean isNull) {
		Stream<Equipo> equipos = StreamSupport.stream(eqdao.findAllByNombre(nombre, isNull).spliterator(), false);
		return equipos.map(Equipo::toListaDTO).toList();
	}

	@Override
	public List<EquipoDTO> listar() {
		Stream<Equipo> equipos = StreamSupport.stream(eqdao.findAll().spliterator(), false);
		return equipos.map(Equipo::toListaDTO).toList();
	}

	@Override
	public EquipoDTO getById(int id) {
		Equipo e = eqdao.findById(id);
		
		if (!Objects.isNull(e))
			return e.toDTO();
		else
			return null;

	}

	@Override
	public EquipoDTO insertar(EquipoDTO obj) {

		Equipo er = eqdao.insert( Equipo.ofDTO(obj));
		return er.toDTO();
	}

	@Override
	public void actualizar(EquipoDTO obj) {
		Equipo er = eqdao.update( Equipo.ofDTO(obj));
		
	}

	@Override
	public void eliminar(int id) {
		eqdao.deleteById(id);
	}

}
