package net.croz.spring.ordering.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import net.croz.spring.ordering.form.ProizvodForma;
import net.croz.spring.ordering.model.Dobavljac;
import net.croz.spring.ordering.model.Kupac;
import net.croz.spring.ordering.model.Proizvod;
import net.croz.spring.ordering.repository.DobavljacRepository;
import net.croz.spring.ordering.repository.KupacRepository;
import net.croz.spring.ordering.repository.ProizvodRepository;

@Controller
public class HomeController {

	@Autowired
	private KupacRepository iKupacRepository;
	@Autowired
	private DobavljacRepository iDobavljacRepository;
	@Autowired
	private ProizvodRepository iProizvodRepository;

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

	@GetMapping("/dobavljac")
	public String setDobavljac(Map<String, Object> model) {

		Dobavljac tDobavljac = new Dobavljac();
		tDobavljac.setId(Long.valueOf(1));
		tDobavljac.setName("Dobavljac 1");

		iDobavljacRepository.save(tDobavljac);

		return "welcome";
	}

	@GetMapping("/proizvod")
	public String newProizvod(Model model) {
		model.addAttribute("proizvodForma", new ProizvodForma());
		model.addAttribute("listaDobavljaca", iDobavljacRepository.findAll());
		return "proizvodi";
	}

	@GetMapping(value = { "/proizvod/{id}/", "/proizvod/{id}" })
	public String getProizvodById(Model model, @PathVariable final String id) {

		ProizvodForma tForma = new ProizvodForma();
		Proizvod tProizvod = iProizvodRepository.getOne(Long.valueOf(id));
		tForma.setId(tProizvod.getId());
		tForma.setName(tProizvod.getName());
		tForma.setPrice(tProizvod.getPrice());
		tForma.setSupplier_id(tProizvod.getSupplier_id());

		model.addAttribute("proizvodForma", tForma);
		model.addAttribute("listaDobavljaca", iDobavljacRepository.findAll());
		return "proizvodi";
	}

	@GetMapping("/dohvatiProizvode")
	public String getProizvod(Model model) {
		model.addAttribute("listaProizvoda", iProizvodRepository.findAll());
		return "listaProizvoda";
	}

	@PostMapping("/spremiProizvod")
	public String saveProizvod(@Valid @ModelAttribute ProizvodForma forma, BindingResult bindingResult, Model model) {

		if (!bindingResult.hasErrors()) {
			Proizvod tProizvod = new Proizvod();

			tProizvod.setId(forma.getId());
			tProizvod.setName(forma.getName());
			tProizvod.setPrice(forma.getPrice());
			tProizvod.setSupplier_id(forma.getSupplier_id());

			iProizvodRepository.save(tProizvod);
			return "redirect:/dohvatiProizvode";

		} else {
			model.addAttribute("listaDobavljaca", iDobavljacRepository.findAll());
			return "proizvodi";

		}

	}

	@DeleteMapping("/delete")
	public ResponseEntity deteleProizvod(@RequestBody String id) {
		if (id != null) {
			iProizvodRepository.deleteById(Long.valueOf(id));
		}
		return new ResponseEntity(HttpStatus.OK);
	}
}
