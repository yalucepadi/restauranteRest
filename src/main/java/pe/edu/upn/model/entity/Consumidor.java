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
@Table(name = "consumidor")
public class Consumidor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "consumidor_id")
	private Integer consumidorCod;

	@Column(name = "consumidor_dni", length = 8)
	private String consumidorDni;

	@Column(name = "consumidor_nombre", length = 20)
	private String consumidorNombre;

	@Column(name = "consumidor_apellidos", length = 40)
	private String consumidorApellidos;

	@OneToMany(mappedBy = "consumidor", fetch = FetchType.LAZY)
	private List<Reserva> reservas;

	@OneToMany(mappedBy = "consumidor", fetch = FetchType.LAZY)
	private  List<Pedido> pedidos;


	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Consumidor() 
{
		
reservas = new ArrayList<>();
}

	public Integer getConsumidorCod() {
		return consumidorCod;
	}

	public void setConsumidorCod(Integer consumidorCod) {
		this.consumidorCod = consumidorCod;
	}

	public String getConsumidorDni() {
		return consumidorDni;
	}

	public void setConsumidorDni(String consumidorDni) {
		this.consumidorDni = consumidorDni;
	}

	public String getConsumidorNombre() {
		return consumidorNombre;
	}

	public void setConsumidorNombre(String consumidorNombre) {
		this.consumidorNombre = consumidorNombre;
	}

	public String getConsumidorApellidos() {
		return consumidorApellidos;
	}

	public void setConsumidorApellidos(String condumidorApellidos) {
		this.consumidorApellidos = condumidorApellidos;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	

	
}
