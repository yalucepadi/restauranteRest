package pe.edu.upn.service.imlp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.model.entity.Mesa;
import pe.edu.upn.model.repository.MesaRepository;
import pe.edu.upn.service.MesaService;

@Service
public class MesaServiceImpl implements MesaService{
	@Autowired
	private MesaRepository mesaRepository;
	@Transactional( readOnly= true)
	@Override
	public List<Mesa> findAll() throws Exception {

		return mesaRepository.findAll();
	}
	@Transactional( readOnly= true)
	@Override
	public Optional<Mesa> findById(Integer id) throws Exception {
		
		return mesaRepository.findById(id);
	}
	@Transactional
	@Override
	public Mesa save(Mesa entity) throws Exception {
	
		return mesaRepository.save(entity);
	}
	@Transactional
	@Override
	public Mesa update(Mesa entity) throws Exception {

		return mesaRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		mesaRepository.deleteById(id);
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
	mesaRepository.deleteAll();
		
	}

}
