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


import pe.edu.upn.model.entity.Mesa;
import pe.edu.upn.service.MesaService;

@Controller
@RequestMapping("/mesa")
public class MesaController {
	@Autowired
	private MesaService mesaService;
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Mesa> mesas = mesaService.findAll();
			model.addAttribute("mesas", mesas);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/mesa/inicio";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
			Mesa mesa = new Mesa();
		model.addAttribute("mesa", mesa);
		
		return "/mesa/nuevo";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("mesa") Mesa mesa, 
			Model model, SessionStatus status) {
		try {
			mesaService.save(mesa);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/mesa";
	}	
	
}
