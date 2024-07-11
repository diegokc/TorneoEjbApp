package py.edu.ucsa.ejb.session.impl;

import java.util.List;
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
@Transactional
@LocalBean
public class EquipoEjbRemoteImpl  implements EquipoEjbRemote {

	@Inject
	@Named("equipoDAO")
	private IEquipoDao eqdao;
	
	@Inject
	@Named("jugadorDAO")
	private IJugadorDao jDao;
	
	
	@Override
	public List<EquipoDTO> findAll() {
		Stream<Equipo> equipos = StreamSupport.stream(eqdao.findAll().spliterator(),false);
		return equipos.map(Equipo::toListaDTO).toList();

	}
	

	@Override
	public void insert(EquipoDTO dto) {
		Equipo equipo = Equipo.ofDTO(dto);
		equipo = eqdao.insert(equipo);
		
		Jugador eJugador;
		for(Jugador jugador : equipo.getJugadores()) {
			eJugador = jDao.findById(jugador.getId().longValue());
			eJugador.setEquipo(equipo);
			jDao.update(eJugador);
		}
		
	}
	
	@Override
	public List<EquipoDTO> findByNombre(String nombre, boolean isNull) {
		Stream<Equipo> equipos = StreamSupport.stream(eqdao.findAllByNombre(nombre,isNull).spliterator(),false);
		return equipos.map(Equipo::toListaDTO).toList();
	}


	@Override
	public List<EquipoDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public EquipoDTO getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public EquipoDTO insertar(EquipoDTO obj) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void actualizar(EquipoDTO obj) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
