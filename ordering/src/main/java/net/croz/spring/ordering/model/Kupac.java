package net.croz.spring.ordering.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;


@Entity
@Data
public class Kupac {

	@Id
	private Long id;
	@OneToMany
	@JoinColumn(name = "id")
	private List<Narudzba> order;
	
	@Column(name = "ime")
	private String name;
	@Column(name = "prezime")
	private String surname;
	@Column(name = "grad")
	private String city;
	private String email;


	
	
}
