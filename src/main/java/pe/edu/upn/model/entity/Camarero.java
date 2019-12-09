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
@Table(name = "camarero")
public class Camarero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "camarero_id")
	private Integer camareroCod;

	@Column(name = "camarero_nombre", length = 20)
	private String camareroNombre;

	@Column(name = "camarero_serie", length = 10)
	private String camareroSerie;

	@OneToOne(mappedBy = "camarero", fetch = FetchType.LAZY)
	private Pedido pedido;

	public Integer getCamareroCod() {
		return camareroCod;
	}

	public void setCamareroCod(Integer camareroCod) {
		this.camareroCod = camareroCod;
	}

	public String getCamareroNombre() {
		return camareroNombre;
	}

	public void setCamareroNombre(String camareroNombre) {
		this.camareroNombre = camareroNombre;
	}

	public String getCamareroSerie() {
		return camareroSerie;
	}

	public void setCamareroSerie(String camareroSerie) {
		this.camareroSerie = camareroSerie;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
