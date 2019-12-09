package pe.edu.upn.service.imlp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.model.entity.Turno;
import pe.edu.upn.model.repository.TurnoRepository;
import pe.edu.upn.service.TurnoService;
@Service
public class TurnoServiceImpl implements TurnoService {
	@Autowired
	private TurnoRepository turnoRepository;
	@Transactional( readOnly= true)
	@Override
	public List<Turno> findAll() throws Exception {
		
		return turnoRepository.findAll();
	}
	@Transactional( readOnly= true)
	@Override
	public Optional<Turno> findById(Integer id) throws Exception {
		
		return turnoRepository.findById(id);
	}
	@Transactional
	@Override
	public Turno save(Turno entity) throws Exception {
		
		return turnoRepository.save(entity);
	}
	@Transactional
	@Override
	public Turno update(Turno entity) throws Exception {
		
		return turnoRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		turnoRepository.deleteById(id);
		
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		turnoRepository.deleteAll();
		
	}

}
