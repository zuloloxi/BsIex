package anasnash.banque.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import anasnash.banque.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
