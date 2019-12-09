package pe.edu.upn.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import pe.edu.upn.model.entity.Consumidor;
import pe.edu.upn.service.ConsumidorService;

@RestController
@RequestMapping("/api/consumidores")
public class ConsumidorRestController {
	@Autowired
	private  ConsumidorService consumidorService;
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Consumidor> > fetchConsumidor() {
		try {
			List<Consumidor> consumidores = consumidorService.findAll();
			return new ResponseEntity<List<Consumidor>>(consumidores, HttpStatus.OK);   
		} catch (Exception e) {
			return new ResponseEntity<List<Consumidor>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Consumidor > saveMedico(@RequestBody Consumidor consumidor) {
		try {
			Consumidor newConsumidor = consumidorService.save(consumidor);
			return new ResponseEntity< Consumidor >(newConsumidor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity< Consumidor >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
