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

import pe.edu.upn.model.entity.VentaTotal;
import pe.edu.upn.service.VentaTotalService;

@Controller
@RequestMapping("/ventaTotal")
public class VentaTotalController {
	@Autowired
	private VentaTotalService ventaTotalService;
	@GetMapping
	public String inicio(Model model) {
		try {
			List<VentaTotal> ventaTotales =ventaTotalService.findAll();
			model.addAttribute("ventaTotales", ventaTotales);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/ventaTotal/inicio";
	}  
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
			VentaTotal ventTotal = new VentaTotal();
		model.addAttribute("ventaTotal", ventTotal);
		
		return "/ventaTotal/nuevo";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("ventaTotal") VentaTotal ventaTotal, 
			Model model, SessionStatus status) {
		try {
		ventaTotalService.save(ventaTotal);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/ventaTotal";
	}	
}
