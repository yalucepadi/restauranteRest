package pe.edu.upn.model.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cocina")

public class Cocina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cocina_id")
	private Integer cocinaCod;

	@Column(name = "cocina_estado", length = 50)
	private String cocinaEstado;
	
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;

	public Integer getCocinaCod() {
		return cocinaCod;
	}

	public void setCocinaCod(Integer cocinaCod) {
		this.cocinaCod = cocinaCod;
	}

	public String getCocinaEstado() {
		return cocinaEstado;
	}

	public void setCocinaEstado(String cocinaEstado) {
		this.cocinaEstado = cocinaEstado;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
