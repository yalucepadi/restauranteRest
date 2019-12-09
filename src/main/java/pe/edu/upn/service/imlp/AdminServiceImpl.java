package pe.edu.upn.service.imlp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.model.entity.Admin;
import pe.edu.upn.model.repository.AdminRepository;
import pe.edu.upn.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Transactional(readOnly= true)
	@Override
	public List<Admin> findAll() throws Exception {

		return adminRepository.findAll();
	}
	@Transactional(readOnly= true)
	@Override
	public Optional<Admin> findById(Integer id) throws Exception {

		return adminRepository.findById(id);
	}
	@Transactional
	@Override
	public Admin save(Admin entity) throws Exception {

		return adminRepository.save(entity) ;
	}
	@Transactional
	@Override
	public Admin update(Admin entity) throws Exception {

		return  adminRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		adminRepository.deleteById(id);
		
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		adminRepository.deleteAll();
		
	}

	

}
