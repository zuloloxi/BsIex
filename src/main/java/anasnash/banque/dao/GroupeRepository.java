package anasnash.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import anasnash.banque.entities.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {

}
