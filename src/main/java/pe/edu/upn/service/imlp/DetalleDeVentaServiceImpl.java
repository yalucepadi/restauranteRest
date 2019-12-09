package pe.edu.upn.service.imlp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.model.entity.DetalleDeVenta;
import pe.edu.upn.model.repository.DetalleDeVentaRepository;
import pe.edu.upn.service.DetalleDeVentaService;
@Service
public class DetalleDeVentaServiceImpl implements DetalleDeVentaService{
	@Autowired
	private DetalleDeVentaRepository detalleDeVentaRepository;
	@Transactional( readOnly= true)
	@Override
	public List<DetalleDeVenta> findAll() throws Exception {
		
		return  detalleDeVentaRepository.findAll();
	}
	@Transactional( readOnly= true)
	@Override
	public Optional<DetalleDeVenta> findById(Integer id) throws Exception {
		return detalleDeVentaRepository.findById(id);
	}
	@Transactional
	@Override
	public DetalleDeVenta save(DetalleDeVenta entity) throws Exception {

		return detalleDeVentaRepository.save(entity);
	}
	@Transactional
	@Override
	public DetalleDeVenta update(DetalleDeVenta entity) throws Exception {
	
		return detalleDeVentaRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
	  detalleDeVentaRepository.deleteById(id);
		
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		detalleDeVentaRepository.deleteAll();
		
	}

}
