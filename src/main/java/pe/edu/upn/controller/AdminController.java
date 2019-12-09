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

import pe.edu.upn.model.entity.Admin;

import pe.edu.upn.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private  AdminService adminService;
	@GetMapping
public String inicio(Model model) {
	try {
		List<Admin> admines = adminService.findAll();
		model.addAttribute("admines",admines);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return "/admin/inicio";
}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
			Admin admin = new Admin();
		model.addAttribute("admin",admin);
		
		return "/admin/nuevo";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("admin") 	Admin admin, 
			Model model, SessionStatus status) {
		try {
			adminService.save(admin);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/admin";
	}	
}
	
	


