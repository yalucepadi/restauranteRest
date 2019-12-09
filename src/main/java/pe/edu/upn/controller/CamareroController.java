package pe.edu.upn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.model.entity.Camarero;

import pe.edu.upn.service.CamareroService;

@Controller
@RequestMapping("/camarero")
public class CamareroController {
	@Autowired
	private CamareroService camareroService;
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Camarero> camareros =camareroService.findAll();
			model.addAttribute("camareros", camareros);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/camarero/inicio";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
			Camarero camarero = new Camarero();
		model.addAttribute("camarero", camarero);
		
		return "/camarero/nuevo";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("camarero") Camarero camarero, 
			Model model, SessionStatus status) {
		try {
			camareroService.save(camarero);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/camarero";
	}	
	
	
}
