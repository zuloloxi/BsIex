package anasnash.banque.metier;

import java.util.List;

import anasnash.banque.entities.Client;

public interface ClientMetier {
	public Client saveClient(Client c);
	public List<Client> listClients();
}
