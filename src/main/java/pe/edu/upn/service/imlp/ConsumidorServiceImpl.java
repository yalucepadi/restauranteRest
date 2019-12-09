package pe.edu.upn.service.imlp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.model.entity.Consumidor;
import pe.edu.upn.model.repository.ConsumidorRepository;
import pe.edu.upn.service.ConsumidorService;
@Service
public class ConsumidorServiceImpl  implements ConsumidorService{
	@Autowired
	private ConsumidorRepository consumidorRepository;
	@Transactional( readOnly= true)
	@Override
	public List<Consumidor> findAll() throws Exception {
		
		return consumidorRepository.findAll();
	}
	@Transactional( readOnly= true)
	@Override
	public Optional<Consumidor> findById(Integer id) throws Exception {
		
		return consumidorRepository.findById(id);
	}
	@Transactional
	@Override
	public Consumidor save(Consumidor entity) throws Exception {
		
		return consumidorRepository.save(entity);
	}
	@Transactional
	@Override
	public Consumidor update(Consumidor entity) throws Exception {
	
		return consumidorRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		consumidorRepository.deleteById(id);
		
		
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
	consumidorRepository.deleteAll();
		
	}
	

}
