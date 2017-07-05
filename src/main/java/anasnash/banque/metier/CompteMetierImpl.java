package anasnash.banque.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anasnash.banque.dao.CompteRepository;
import anasnash.banque.entities.Compte;
@Service
public class CompteMetierImpl implements CompteMetier {
	@Autowired
	private CompteRepository compteRepository;
	public Compte saveCompte(Compte cp) {
		cp.setDateCreation(new Date());
		return compteRepository.save(cp);
	}

	public Compte getCompte(String code) {
		
		Compte cp = compteRepository.findOne(code);
		if(cp==null) throw new RuntimeException("Compte Innexistant!");
		return cp;
	}

}
