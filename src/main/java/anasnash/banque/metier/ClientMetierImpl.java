package anasnash.banque.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import anasnash.banque.dao.ClientRepository;
import anasnash.banque.entities.Client;
//pour considéret la classe comme un bean spring
@Service
public class ClientMetierImpl implements ClientMetier {

	@Autowired
	private ClientRepository clientRepository;
	
	public Client saveClient(Client c) {
		return clientRepository.save(c);
	}

	public List<Client> listClients() {
		return clientRepository.findAll();
	}
	
	
}
