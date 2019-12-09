package pe.edu.upn.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private Integer adminCod;

	@Column(name = "admin_dni", length = 8)
	private String adminDni;

	@Column(name = "admin_nombre", length = 20)
	private String adminNombre;

	@Column(name = "admin_apellidos", length = 40)
	private String adminApellidos;

	@OneToMany(mappedBy = "admin", fetch = FetchType.LAZY)
	private List<Menu> menus;
	

	public Admin() {
		
		menus= new ArrayList<>();
		
	}

	public Integer getAdminCod() {
		return adminCod;
	}

	public void setAdminCod(Integer adminCod) {
		this.adminCod = adminCod;
	}

	public String getAdminDni() {
		return adminDni;
	}

	public void setAdminDni(String adminDni) {
		this.adminDni = adminDni;
	}

	public String getAdminNombre() {
		return adminNombre;
	}

	public void setAdminNombre(String adminNombre) {
		this.adminNombre = adminNombre;
	}

	public String getAdminApellidos() {
		return adminApellidos;
	}

	public void setAdminApellidos(String adminApellidos) {
		this.adminApellidos = adminApellidos;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}


	

}
