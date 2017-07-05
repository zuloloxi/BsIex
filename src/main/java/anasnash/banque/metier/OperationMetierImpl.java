package anasnash.banque.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import anasnash.banque.dao.CompteRepository;
import anasnash.banque.dao.EmployeRepository;
import anasnash.banque.dao.OperationRepository;
import anasnash.banque.entities.Compte;
import anasnash.banque.entities.Employe;
import anasnash.banque.entities.Operation;
import anasnash.banque.entities.Retrait;
import anasnash.banque.entities.Versement;

@Service
public class OperationMetierImpl implements OperationMetier{
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private EmployeRepository employeRepository;
	
	@Transactional
	public Boolean verser(String code, double montant, Long codeEmp) {
		Compte cp=compteRepository.findOne(code);
		Employe e=employeRepository.findOne(codeEmp);
		Operation o = new Versement();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(e);
		operationRepository.save(o);
		cp.setSolde(cp.getSolde()+montant);
		return true;
		
	}
	@Transactional
	public Boolean retirer(String code, double montant, Long codeEmp) {
		Compte cp=compteRepository.findOne(code);
		if(cp.getSolde()<montant) throw new RuntimeException("solde insuffisant");
		Employe e=employeRepository.findOne(codeEmp);
		Operation o = new Retrait();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(e);
		operationRepository.save(o);
		cp.setSolde(cp.getSolde()- montant);
		return true;
	}
	@Transactional
	public Boolean virement(String cpte1, String cpte2, double montant,
			Long codeEmp) {
		retirer(cpte1, montant, codeEmp);
		verser(cpte2, montant, codeEmp);
		return true;
	}
	@Transactional
	public PageOperation getOperation(String codeCompte, int page, int size) {
		Page<Operation> ops =operationRepository.getOperations
				(codeCompte, new PageRequest(page, size));
		PageOperation pOp = new PageOperation();
		pOp.setOperations(ops.getContent());
		pOp.setNombreOperations(ops.getNumberOfElements());
		pOp.setPage(ops.getNumber());
		pOp.setTotalPages(ops.getTotalPages());
		pOp.setTotalOperations((int) ops.getTotalElements());
		return pOp;
	}

}
