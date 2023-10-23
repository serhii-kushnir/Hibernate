package org.example.services.client;

import org.example.entity.Client;

public class ClientService implements ClientCrudService{
    private final ClientCrudServiceImpl clientCrudService = new ClientCrudServiceImpl();
    @Override
    public void create(Client client) {
        clientCrudService.create(client);
    }

    @Override
    public Client read(Long id) {
        return clientCrudService.read(id);
    }

    @Override
    public void update(Client client) {
        clientCrudService.update(client);
    }

    @Override
    public void delete(Client client) {
        clientCrudService.delete(client);
    }
}
