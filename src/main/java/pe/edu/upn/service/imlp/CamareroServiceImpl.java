package pe.edu.upn.service.imlp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.model.entity.Camarero;
import pe.edu.upn.model.repository.CamareroRepository;
import pe.edu.upn.service.CamareroService;
@Service
public class CamareroServiceImpl implements CamareroService {
	@Autowired
	private CamareroRepository camareroRepository;
	@Transactional( readOnly= true)
	@Override
	public List<Camarero> findAll() throws Exception {
	
		return camareroRepository.findAll();
	}

	@Transactional( readOnly= true)
	@Override
	public Optional<Camarero> findById(Integer id) throws Exception {
		
		return camareroRepository.findById(id);
	}
	@Transactional
	@Override
	public Camarero save(Camarero entity) throws Exception {
	
		return  camareroRepository.save(entity);
	}
	@Transactional
	@Override
	public Camarero update(Camarero entity) throws Exception {
		
		return camareroRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {

		camareroRepository.deleteById(id);
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		camareroRepository.deleteAll();
		
	}

}
