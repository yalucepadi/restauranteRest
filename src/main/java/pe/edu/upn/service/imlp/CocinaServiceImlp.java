package pe.edu.upn.service.imlp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.model.entity.Cocina;
import pe.edu.upn.model.repository.CocinaRepository;
import pe.edu.upn.service.CocinaService;
@Service
public class CocinaServiceImlp implements CocinaService {
	@Autowired
	private CocinaRepository cocinaRepository;
	
	@Transactional( readOnly= true)
	@Override
	public List<Cocina> findAll() throws Exception {
		
		return cocinaRepository.findAll();
	}
	@Transactional( readOnly= true)
	@Override
	public Optional<Cocina> findById(Integer id) throws Exception {
		
		return cocinaRepository.findById(id);
	}
	@Transactional
	@Override
	public Cocina save(Cocina entity) throws Exception {

		return cocinaRepository.save(entity);
	}
	@Transactional
	@Override
	public Cocina update(Cocina entity) throws Exception {
	
		return cocinaRepository.save(entity) ;
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		cocinaRepository.deleteById(id);
		
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		cocinaRepository.deleteAll();
		
	}

}
