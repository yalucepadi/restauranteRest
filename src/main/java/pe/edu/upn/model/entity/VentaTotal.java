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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "venta_total")
public class VentaTotal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "venta_total_id")
	private Integer ventaTotalCod;


	/*@OneToMany(mappedBy = "ventaTotal", fetch = FetchType.LAZY)
	private List<DetalleDeVenta> detalleDeVentas;
*/
	@Column(name = "venta_total_total")
	private float ventaTotalTotal;
	
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
 
public VentaTotal() {
	
}
	 


	public Integer getVentaTotalCod() {
		return ventaTotalCod;
	}

	public void setVentaTotalCod(Integer ventaTotalCod) {
		this.ventaTotalCod = ventaTotalCod;
	}



	public float getVentaTotalTotal() {
		return ventaTotalTotal;
	}

	public void setVentaTotalTotal(float ventaTotalTotal) {
		this.ventaTotalTotal = ventaTotalTotal;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


}