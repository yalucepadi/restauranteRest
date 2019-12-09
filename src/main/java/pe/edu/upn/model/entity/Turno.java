package pe.edu.upn.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "turno")
public class Turno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "turno_id")
	private Integer turnoCod;

	@Column(name = "turno_descripcion", length = 10)
	private String turnoDescripcion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menu_id")
	private Menu menu;

	public Integer getTurnoCod() {
		return turnoCod;
	}

	public void setTurnoCod(Integer turnoCod) {
		this.turnoCod = turnoCod;
	}

	public String getTurnoDescripcion() {
		return turnoDescripcion;
	}

	public void setTurnoDescripcion(String turnoDescripcion) {
		this.turnoDescripcion = turnoDescripcion;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}


}
