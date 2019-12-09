package pe.edu.upn.service.imlp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.model.entity.VentaTotal;
import pe.edu.upn.model.repository.VentaTotalRepository;
import pe.edu.upn.service.VentaTotalService;
@Service
public class VentaTotalServiceImpl implements VentaTotalService {
	@Autowired
	private VentaTotalRepository ventaTotalRepository;
	@Transactional( readOnly= true)
	@Override
	public List<VentaTotal> findAll() throws Exception {
	
		return ventaTotalRepository.findAll();
	}
	@Transactional( readOnly= true)
	@Override
	public Optional<VentaTotal> findById(Integer id) throws Exception {
		
		return ventaTotalRepository.findById(id);
	}
	@Transactional
	@Override
	public VentaTotal save(VentaTotal entity) throws Exception {
		
		return ventaTotalRepository.save(entity);
	}
	@Transactional
	@Override
	public VentaTotal update(VentaTotal entity) throws Exception {

		return ventaTotalRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
	ventaTotalRepository.deleteById(id);
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
	
		ventaTotalRepository.deleteAll();
		
	}

}
