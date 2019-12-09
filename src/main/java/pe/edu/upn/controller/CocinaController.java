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

import pe.edu.upn.model.entity.Camarero;
import pe.edu.upn.model.entity.Cocina;
import pe.edu.upn.model.entity.Usuario;
import pe.edu.upn.service.CocinaService;

@Controller
@RequestMapping("/cocina")
public class CocinaController {
	@Autowired
	private CocinaService cocinaService;
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Cocina> cocina =cocinaService.findAll();
			model.addAttribute("cocina", cocina);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/cocina/inicio";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
			Cocina cocina = new Cocina();
		model.addAttribute("cocina", cocina);
		
		return "/cocina/nuevo";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("cocina") Cocina cocina, 
			Model model, SessionStatus status) {
		try {
			cocinaService.save(cocina);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/cocina";
	}	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Cocina> optional = cocinaService.findById(id);
			if (optional.isPresent()) {
				
				
				
				model.addAttribute("cocina", optional.get());
		
			} else {
				return "redirect:/cocina";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/cocina/edit";
	}
}
