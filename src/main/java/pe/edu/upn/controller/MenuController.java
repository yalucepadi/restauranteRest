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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import pe.edu.upn.model.entity.DetalleDeVenta;
import pe.edu.upn.model.entity.Menu;
import pe.edu.upn.model.entity.Plato;
import pe.edu.upn.model.entity.Turno;
import pe.edu.upn.service.DetalleDeVentaService;
import pe.edu.upn.service.MenuService;
import pe.edu.upn.service.PlatoService;
import pe.edu.upn.service.TurnoService;

@Controller
@RequestMapping("/menu")
@SessionAttributes( {"menu", "plato" ,"turno","detalleDeVenta"} )
public class MenuController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private PlatoService platoService;
	@Autowired
	private TurnoService turnoService;
	@Autowired
	private DetalleDeVentaService detalleDeVentaService;
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Menu> menus = menuService.findAll();
			model.addAttribute("menus", menus);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/menu/inicio";
	}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
			Menu menu = new Menu();
		model.addAttribute("menu", menu);
		
		return "/menu/nuevo";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("menu") Menu menu, 
			Model model, SessionStatus status) {
		try {
			menuService.save(menu);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/menu";
	}	
	
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		try {
			Optional<Menu> menu = menuService.findById(id);
			if(menu.isPresent()) {
				model.addAttribute("menu", menu.get());
			} else {
				return "redirect:/menu";
			}
		} catch (Exception e) {

		}	
		
		return "/menu/info";
	}
	
	@GetMapping("/infoturno/{id}")
	public String info_turno(@PathVariable("id") int id, Model model) {
		try {
			Optional<Menu> menu = menuService.findById(id);
			if(menu.isPresent()) {
				model.addAttribute("menu", menu.get());
			} else {
				return "redirect:/menu";
			}
		} catch (Exception e) {

		}	
		
		return "/menu/infoturno";
	}
	
	@GetMapping("/infoplato/{id}")
	public String info_plato(@PathVariable("id") int id, Model model) {
		try {
			Optional<Plato> plato = platoService.findById(id);
			if(plato.isPresent()) {
				model.addAttribute("plato", plato.get());
			} else {
				return "redirect:/menu";
			}
		} catch (Exception e) {

		}	
		
		return "/menu/infoplato";
	}
	
	
	@GetMapping("/{id}/nuevoplato")
	public String nuevoPlato(@PathVariable("id") int id, Model model) {
		Plato plato = new Plato();
		try {
			Optional<Menu> menu = menuService.findById(id);
			if(menu.isPresent()) {
				plato.setMenu(menu.get());
				model.addAttribute("plato", plato);
			} else {
				return "redirect:/menu";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/menu/nuevoplato";
	}
	
	@PostMapping("/saveplato")
	public String savePlato(@ModelAttribute("plato") Plato plato,
			Model model, SessionStatus status) {
		try {
			platoService.save(plato);
			status.setComplete();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/menu/info/" + plato.getMenu().getMenuId();
	}
	
	@GetMapping("/{id}/nuevoturno")
	public String nuevoTurno(@PathVariable("id") int id, Model model) {
		Turno turno = new Turno();
		try {
			Optional<Menu> menu = menuService.findById(id);
			if(menu.isPresent()) {
				turno.setMenu(menu.get());
				model.addAttribute("turno", turno);
			} else {
				return "redirect:/menu";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/menu/nuevoturno";
	}
	
	@PostMapping("/saveturno")
	public String saveTurno(@ModelAttribute("turno") Turno turno,
			Model model, SessionStatus status) {
		try {
			turnoService.save(turno);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/menu/infoturno/" + turno.getMenu().getMenuId();
	}
	@GetMapping("/{id}/nuevodetalledeventa")
	public String nuevoDetalleDeventa(@PathVariable("id") int id, Model model) {
		DetalleDeVenta detalleDeVenta = new DetalleDeVenta();
		try {
			Optional<Plato> plato = platoService.findById(id);
			if(plato.isPresent()) {
				detalleDeVenta.setPlato(plato.get());
				model.addAttribute("detalledeDeVenta", detalleDeVenta);
			} else {
				return "redirect:/menu";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/menu/nuevodetalledeventa";
	}
	
	@PostMapping("/savedetalledeventa")
	public String savedetalleDeVenta(@ModelAttribute("detalleDeVenta") DetalleDeVenta detalleDeVenta,
			Model model, SessionStatus status) {
		try {
			detalleDeVentaService.save(detalleDeVenta);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/menu/infoplato/" + detalleDeVenta.getPlato().getPlatoId();
	}
	@GetMapping("/editplato/{id}")
	public String editarPlato(@PathVariable("id") int id, Model model) {
		try {
			Optional<Plato> optional = platoService.findById(id);
			if (optional.isPresent()) {
				
				
				
				model.addAttribute("plato", optional.get());
		
			} else {
				return "redirect:/menu";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/menu/editplato";
	}
	}
	
	
	

