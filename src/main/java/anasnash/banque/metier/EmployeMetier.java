package anasnash.banque.metier;

import java.util.List;

import anasnash.banque.entities.Employe;

public interface EmployeMetier {
	
	public Employe save(Employe e);
	public List<Employe> listEmployes();
	

}
