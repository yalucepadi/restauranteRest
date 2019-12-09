package pe.edu.upn.init;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upn.model.entity.Usuario;
import pe.edu.upn.model.repository.AuthorityRepository;
import pe.edu.upn.model.repository.UsuarioRepository;



@Service
public class InitDB implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		/*
		this.usuarioRepository.deleteAll();
		this.authorityRepository.deleteAll();
		
		Usuario juan = new Usuario();
		juan.setUsuarioNombre("juan");
		juan.setUsuarioContrasena(passwordEncoder.encode("juan"));
		
		juan.setCargo("cargo");
		juan.setEnable(true);
		
		Usuario admin = new Usuario();
		admin.setUsuarioNombre("admin");
		admin.setUsuarioContrasena(passwordEncoder.encode("admin"));
		
		admin.setCargo("cargo");
		admin.setEnable(true);
		
        Usuario manager = new Usuario();
        manager.setUsuarioNombre("manager");
		manager.setUsuarioContrasena(passwordEncoder.encode("manager"));
		
		manager.setCargo("cargo");
        manager.setEnable(true);
        
        juan.addAuthority("ROLE_USER");
        juan.addAuthority("ACCESS_CONSUMIDOR_READ");
        admin.addAuthority("ROLE_ADMIN");
        admin.addAuthority("ACCESS_REST1");
        admin.addAuthority("ACCESS_REST2");
        manager.addAuthority("ROLE_MANAGER");
        manager.addAuthority("ACCESS_REST1");
        
        List<Usuario> usuarios = Arrays.asList(juan, admin, manager);        
        this.usuarioRepository.saveAll(usuarios);	
		*/
	}
	
	 }
	 