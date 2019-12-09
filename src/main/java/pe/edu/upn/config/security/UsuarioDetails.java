package pe.edu.upn.config.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import pe.edu.upn.model.entity.Usuario;



// Implementación de una clase detail que manipula al usuario
public class UsuarioDetails implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	// @Autowired
	private Usuario usuario;	
	public UsuarioDetails(Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		
		// Extraer la lista de las Authorities
		this.usuario.getAuthorities().forEach(authority -> {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
			grantedAuthorities.add(grantedAuthority);
		});

		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return this.usuario.getUsuarioContrasena();
	}

	@Override
	public String getUsername() {
		return this.usuario.getUsuarioNombre();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.usuario.isEnable();
	}
	
	// Datos de la Clase Usuario
	
	public String getCargo() {
		return this.usuario.getCargo();
	}
	public Long getId() {
		return this.usuario.getUsuarioCod();
	}

}
