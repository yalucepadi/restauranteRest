package pe.edu.upn.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reserva_id")
	private Integer reservaCod;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "consumidor_id")
	private Consumidor consumidor;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "mesa_id")
	private Mesa mesa;

	public Integer getReservaCod() {
		return reservaCod;
	}

	public void setReservaCod(Integer reservaCod) {
		this.reservaCod = reservaCod;
	}

	public Consumidor getConsumidor() {
		return consumidor;
	}

	public void setConsumidor(Consumidor consumidor) {
		this.consumidor = consumidor;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	

	



}
