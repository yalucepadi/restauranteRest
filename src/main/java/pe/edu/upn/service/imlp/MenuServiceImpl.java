package pe.edu.upn.service.imlp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.model.entity.Menu;
import pe.edu.upn.model.repository.MenuRepository;
import pe.edu.upn.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuRepository menuRepository;
	@Transactional( readOnly= true)
	@Override
	public List<Menu> findAll() throws Exception {
		
		return menuRepository.findAll();
	}
	@Transactional( readOnly= true)
	@Override
	public Optional<Menu> findById(Integer id) throws Exception {
		
		return menuRepository.findById(id);
	}
	@Transactional
	@Override
	public Menu save(Menu entity) throws Exception {
	
		return menuRepository.save(entity);
	}
	@Transactional
	@Override
	public Menu update(Menu entity) throws Exception {

		return menuRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
         menuRepository.deleteById(id);
		
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
        menuRepository.deleteAll();
		
	}

}
