package net.croz.spring.ordering.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Stavke {

	@Id
	private Long id;
	@Column(name="narudzba_id")
	private String order_id;
	@Column(name="proizvod_id")
	private String product_id;
	@OneToOne
	@JoinColumn(name = "id")
	private Proizvod product;
	@Column(name="kolicina")
	private String quantitiy;
	@Column(name="cijena")
	private String price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getQuantitiy() {
		return quantitiy;
	}
	public void setQuantitiy(String quantitiy) {
		this.quantitiy = quantitiy;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
