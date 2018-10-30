package net.croz.spring.ordering.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Data;
import net.croz.spring.ordering.model.Dobavljac;

@Data
public class ProizvodForma {
	
	private Long id;
	private Long supplier_id;
	private Dobavljac supplier;
    @Size(min=2, max=30)
	private String name;
	private String measure;
	@Max(100000)
	@Min(value = 1, message = "The value must be positive")
	private Long price;

}
