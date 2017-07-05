package anasnash.banque.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import anasnash.banque.entities.Compte;

public interface BanqueRmiRemote extends Remote{
	
	public Compte saveCompte(Compte cp ) throws RemoteException;
	public Compte getCompte(String code) throws RemoteException;
	public Boolean verser(String code, double montant, Long codeEmp) throws RemoteException;
	public Boolean retirer(String code, double montant, Long codeEmp) throws RemoteException;
	public Boolean virement(String cpte1, String cpte2, double montant, Long codeEmp) throws RemoteException;
	
}
