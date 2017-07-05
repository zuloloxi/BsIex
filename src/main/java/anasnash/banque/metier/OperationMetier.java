package anasnash.banque.metier;

import anasnash.banque.entities.Compte;

public interface OperationMetier  {
	
	public Boolean verser(String code, double montant, Long codeEmp);
	public Boolean retirer(String code, double montant, Long codeEmp);
	public Boolean virement(String cpte1, String cpte2, double montant, Long codeEmp);
	public PageOperation getOperation(String code, int page, int size);
}
