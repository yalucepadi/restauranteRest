package pe.edu.upn.service.imlp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.model.entity.Reserva;
import pe.edu.upn.model.repository.ReservaRepository;
import pe.edu.upn.service.ReservaService;
@Service
public class ReservaServiceImpl implements ReservaService{
	@Autowired
	private ReservaRepository reservaRepository;
	@Transactional( readOnly= true)
	@Override
	public List<Reserva> findAll() throws Exception {

		return reservaRepository.findAll();
	}
	@Transactional( readOnly= true)
	@Override
	public Optional<Reserva> findById(Integer id) throws Exception {

		return reservaRepository.findById(id);
	}
	@Transactional
	@Override
	public Reserva save(Reserva entity) throws Exception {

		return reservaRepository.save(entity);
	}
	@Transactional
	@Override
	public Reserva update(Reserva entity) throws Exception {

		return reservaRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		reservaRepository.deleteById(id);
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
	 reservaRepository.deleteAll();
		
	}

}
