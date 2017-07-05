package anasnash.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import anasnash.banque.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
