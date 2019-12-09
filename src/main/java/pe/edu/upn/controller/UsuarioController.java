package pe.edu.upn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;


import pe.edu.upn.model.entity.Usuario;
import pe.edu.upn.service.UsuarioService;

@Controller
@RequestMapping("/usuario")

public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@GetMapping
public String inicio(Model model) {
	try {
		List<Usuario> usuarios = usuarioService.findAll();
		model.addAttribute("usuarios", usuarios);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return "/usuario/inicio";
}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
			Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		
		return "/usuario/nuevo";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("usuario") Usuario usuario, 
			Model model, SessionStatus status) {
		
		try {
			// Verificar que el username ya exista.
			Optional<Usuario> optional 
				= usuarioService.findByUsuarioNombre(usuario.getUsuarioNombre());
			if(optional.isPresent()) {
				model.addAttribute("dangerRegister"
						, "ERROR - El username " 
							+ usuario.getUsuarioNombre()
							+ " ya existe ");
				return "/usuario/nuevo";
			} else {
				usuario.setUsuarioContrasena(passwordEncoder
						.encode( usuario.getUsuarioContrasena() ));
				usuario.addAuthority("ROLE_CLIENTE");
				usuarioService.save(usuario);
				status.setComplete();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/login";
	}
	@GetMapping("/edit/{usuarioCod}")
	public String editar(@PathVariable("usuarioCod") Long usuarioCod, Model model) {
		try {
			Optional<Usuario> optional = usuarioService.findById(usuarioCod);
			if (optional.isPresent()) {
				
				
				
				model.addAttribute("usuario", optional.get());
		
			} else {
				return "redirect:/usuario";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/usuario/edit";
	}

	@GetMapping("/del/{usuarioCod}")
	public String eliminar(@PathVariable("usuarioCod") Long usuarioCod, Model model) {
		try {
			Optional<Usuario> usuario = usuarioService.findById(usuarioCod);
			if(usuario.isPresent()) {
				usuarioService.deleteById(usuarioCod);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Usuario> usuarios = usuarioService.findAll();
				model.addAttribute("usuarios",usuarios);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/usuario/inicio";
		}
		return "redirect:/usuario";
	}
}