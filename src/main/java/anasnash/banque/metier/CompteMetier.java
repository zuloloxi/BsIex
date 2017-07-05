package anasnash.banque.metier;

import anasnash.banque.entities.Compte;

public interface CompteMetier {
	
	public Compte saveCompte(Compte cp);
	public Compte getCompte(String code);
}
