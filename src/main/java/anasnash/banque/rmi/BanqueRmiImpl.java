package anasnash.banque.rmi;
import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import anasnash.banque.entities.Compte;
import anasnash.banque.metier.CompteMetier;
import anasnash.banque.metier.OperationMetier;


@Component("myRmiService")

public class BanqueRmiImpl implements BanqueRmiRemote {
	@Autowired
	 private CompteMetier compteMetier;
	@Autowired
	 public OperationMetier operationMetier;
	 
	public Compte saveCompte(Compte cp) throws RemoteException {
		return compteMetier.saveCompte(cp);
	}

	public Compte getCompte(String code) throws RemoteException {
		return compteMetier.getCompte(code);
	}

	public Boolean verser(String code, double montant, Long codeEmp)
			throws RemoteException {
		return operationMetier.verser(code, montant, codeEmp);
	}

	public Boolean retirer(String code, double montant, Long codeEmp)
			throws RemoteException {
		return operationMetier.retirer(code, montant, codeEmp);
	}

	public Boolean virement(String cpte1, String cpte2, double montant,
			Long codeEmp) throws RemoteException {
		return operationMetier.virement(cpte1, cpte2, montant, codeEmp);
	}

}
