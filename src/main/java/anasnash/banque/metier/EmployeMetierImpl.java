package anasnash.banque.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import anasnash.banque.dao.EmployeRepository;
import anasnash.banque.entities.Employe;
@Service
public class EmployeMetierImpl implements EmployeMetier {
	@Autowired
	private EmployeRepository employeRepository;
	
	public Employe save( Employe e) {
		// TODO Auto-generated method stub
		return employeRepository.save(e);
	}

	public List<Employe> listEmployes() {
		// TODO Auto-generated method stub
		return employeRepository.findAll();
	}

}
