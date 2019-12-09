package pe.edu.upn.model.entity;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;







@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private Long usuarioCod;

	@Column(name = "usuario_nombre", length = 30)
	private String usuarioNombre;

	@Column(name = "usuario_contrasena", length = 60)
	private String usuarioContrasena;
	
    private boolean enable;
    @Column(length = 30, nullable = false)
    private String cargo;
	   
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)    
    private List<Authority> authorities;
    

	

	
	public  Usuario() {
		this.enable = true;
		this.authorities = new ArrayList<>();
		
	}
	
	public Usuario (String username, String password) {
		
		this.usuarioNombre = username;
		this.usuarioContrasena = password;
		this.enable = true;
		this.authorities = new ArrayList<>();
		
		
	}

	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public List<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	public Long getUsuarioCod() {
		return usuarioCod;
	}
	public void setUsuarioCod(Long usuarioCod) {
		this.usuarioCod = usuarioCod;
	}
	public String getUsuarioNombre() {
		return usuarioNombre;
	}
	public void addAuthority( String _authority ) {
		Authority authority = new Authority();
		authority.setAuthority( _authority );
		authority.setUsuario(this);
		this.authorities.add(authority);
	}
	public void setUsuarioNombre(String usuarioNombre) {
		this.usuarioNombre = usuarioNombre;
	}

	public String getUsuarioContrasena() {
		return usuarioContrasena;
	}

	public void setUsuarioContrasena(String usuarioContraseña) {
		this.usuarioContrasena = usuarioContraseña;
	}


	
}
