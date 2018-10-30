package net.croz.spring.ordering.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Proizvod {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="dobavljac_id")
	private Long supplier_id;
	@OneToOne
	@JoinColumn(name = "id")
	private Dobavljac supplier;
	@Column(name="naziv")
	private String name;
	@Column(name="mjera")
	private String measure;
	@Column(name="cijena")
	private Long price;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(Long supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMeasure() {
		return measure;
	}
	public void setMeasure(String measure) {
		this.measure = measure;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	
	
}
