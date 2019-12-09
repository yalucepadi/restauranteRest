package pe.edu.upn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.model.entity.DetalleDeVenta;
import pe.edu.upn.model.entity.Plato;
import pe.edu.upn.service.DetalleDeVentaService;
import pe.edu.upn.service.PlatoService;

@Controller
@RequestMapping("/plato")
public class PlatoController {
	@Autowired
	private PlatoService platoService;
	@Autowired
	private DetalleDeVentaService detalleDeVentaService;
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Plato> platos =platoService.findAll();
			model.addAttribute("platos", platos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/plato/inicio";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
			Plato plato = new Plato();
		model.addAttribute("plato", plato);
		
		return "/plato/nuevo";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("plato") Plato plato, 
			Model model, SessionStatus status) {
		try {
			platoService.save(plato);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/plato";
	}	

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Plato> optional = platoService.findById(id);
			if (optional.isPresent()) {
				
	
				model.addAttribute("plato", optional.get());
	
			} else {
				return "redirect:/plato";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/plato/edit";
	}
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Plato> plato = platoService.findById(id);
			if(plato.isPresent()) {
				platoService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Plato> platos = platoService.findAll();
				model.addAttribute("platos", platos);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/plato/inicio";
		}
		return "redirect:/plato";
	}
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		try {
			Optional<Plato> plato = platoService.findById(id);
			if(plato.isPresent()) {
				model.addAttribute("plato", plato.get());
			} else {
				return "redirect:/plato";
			}
		} catch (Exception e) {

		}	
		
		return "/plato/info";
	}
	
	@GetMapping("/{id}/nuevodetalledeventa")
	public String nuevodetalledeventa(@PathVariable("id") int id, Model model) {
		DetalleDeVenta detalledeventa = new DetalleDeVenta();
		try {
			Optional<Plato> plato= platoService.findById(id);
			if(plato.isPresent()) {
			detalledeventa.setPlato(plato.get());
				model.addAttribute("detalledeventa", detalledeventa);
			} else {
				return "redirect:/plato";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/plato/nuevodetalledeventa";
	}
	
	@PostMapping("/savedetalledeventa")
	public String savePaciente(@ModelAttribute("detalledeventa") DetalleDeVenta detalledeventa, 
			Model model, SessionStatus status) {
		try {
			detalleDeVentaService.save(detalledeventa);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/plato/info/" + detalledeventa.getPlato().getPlatoId();
	}
	
	
}
