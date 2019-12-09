package pe.edu.upn.model.entity;


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
@Table(name = "plato")

public class Plato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plato_id")
	private Integer platoId;

	@Column(name = "plato_nombre", length = 20)
	private String platoNombre;

	@Column(name = "plato_descripcion", length = 500)
	private String platoDescripcion;
	
	@Column(name = "plato_stock")
	private Integer stock;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menu_id")
	private Menu menu;

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@OneToOne(mappedBy = "plato", fetch = FetchType.LAZY)
	private DetalleDeVenta detalleDeVenta;

	public Integer getPlatoId() {
		return platoId;
	}

	public void setPlatoId(Integer platoId) {
		this.platoId = platoId;
	}

	public String getPlatoNombre() {
		return platoNombre;
	}

	public void setPlatoNombre(String platoNombre) {
		this.platoNombre = platoNombre;
	}

	public String getPlatoDescripcion() {
		return platoDescripcion;
	}

	public void setPlatoDescripcion(String platoDescripcion) {
		this.platoDescripcion = platoDescripcion;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public DetalleDeVenta getDetalleDeVenta() {
		return detalleDeVenta;
	}

	public void setDetalleDeVenta(DetalleDeVenta detalleDeVenta) {
		this.detalleDeVenta = detalleDeVenta;
	}

}
