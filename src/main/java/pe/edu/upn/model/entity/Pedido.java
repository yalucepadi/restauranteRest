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
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pedido_id")
	private Integer pedidoCod;
   
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "camarero_id")
	private Camarero camarero;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "consumidor_id")
	private Consumidor consumidor;
	
	
	
	@OneToOne(mappedBy = "pedido", fetch = FetchType.LAZY)
	private Cocina cosina;
@OneToOne(mappedBy = "pedido",fetch = FetchType.LAZY)
private VentaTotal ventaTotal;
public Integer getPedidoCod() {
	return pedidoCod;
}
public void setPedidoCod(Integer pedidoCod) {
	this.pedidoCod = pedidoCod;
}
public Camarero getCamarero() {
	return camarero;
}
public void setCamarero(Camarero camarero) {
	this.camarero = camarero;
}
public Consumidor getConsumidor() {
	return consumidor;
}
public void setConsumidor(Consumidor consumidor) {
	this.consumidor = consumidor;
}
public Cocina getCosina() {
	return cosina;
}
public void setCosina(Cocina cosina) {
	this.cosina = cosina;
}
public VentaTotal getVentaTotal() {
	return ventaTotal;
}
public void setVentaTotal(VentaTotal ventaTotal) {
	this.ventaTotal = ventaTotal;
}

}
	