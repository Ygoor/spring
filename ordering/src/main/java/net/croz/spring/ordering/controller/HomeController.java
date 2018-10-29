package net.croz.spring.ordering.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import net.croz.spring.ordering.model.Kupac;
import net.croz.spring.ordering.repository.KupacRepository;

@Controller
public class HomeController {
	
	@Autowired
	private KupacRepository iKupacRepository;

	
	@GetMapping("/welcome")
	public String helloWorld(Map<String, Object> model) {
		
		Kupac tKupac = new Kupac();
		tKupac.setCity("Zagreb");
		tKupac.setEmail("a@a.com");
		tKupac.setId(Long.valueOf(1));
		tKupac.setName("Petar");
		tKupac.setSurname("Spirek");
		
		iKupacRepository.save(tKupac);
		
		model.put("message", "asdasdasd");
		return "welcome";
	}
	
	@GetMapping("/kupac")
	public String getKupac(Map<String, Object> model) {
			
		Kupac tKupac = iKupacRepository.getOne(Long.valueOf(1));
 
		model.put("message", tKupac.getSurname());
		return "welcome";
	}
}
