package anasnash.banque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import anasnash.banque.entities.Compte;
import anasnash.banque.metier.CompteMetier;

@RestController
public class CompteRestService {
	@Autowired
	private CompteMetier compteMetier;
	@RequestMapping(value="/comptes", method= RequestMethod.POST)
	public Compte saveCompte(@RequestBody Compte cp) {
		return compteMetier.saveCompte(cp);
	}
	@RequestMapping(value="/comptes/{code}", method= RequestMethod.GET)
	public Compte getCompte(@PathVariable String code) {
		return compteMetier.getCompte(code);
	}
	
}
