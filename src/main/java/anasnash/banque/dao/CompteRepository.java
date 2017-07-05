package anasnash.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import anasnash.banque.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {

}
