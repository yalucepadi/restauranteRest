package pe.edu.upn.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mesa")
public class Mesa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mesa_id")
	private Integer mesaCod;

	@Column(name = "mesa_numero")
	private Integer mesaNumero;
	@OneToOne(mappedBy = "mesa", fetch = FetchType.LAZY)
	private Reserva reserva;
	public Integer getMesaCod() {
		return mesaCod;
	}
	public void setMesaCod(Integer mesaCod) {
		this.mesaCod = mesaCod;
	}
	public Integer getMesaNumero() {
		return mesaNumero;
	}
	public void setMesaNumero(Integer mesaNumero) {
		this.mesaNumero = mesaNumero;
	}
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}
