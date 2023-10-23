package org.example.services.client;

import org.example.entity.Client;

public final class ClientService implements ClientCrudService {
    private final ClientCrudServiceImpl clientCrudService = new ClientCrudServiceImpl();
    @Override
    public void create(final Client client) {
        clientCrudService.create(client);
    }

    @Override
    public Client read(final Long id) {
        return clientCrudService.read(id);
    }

    @Override
    public void update(final Client client) {
        clientCrudService.update(client);
    }

    @Override
    public void delete(final Client client) {
        clientCrudService.delete(client);
    }
}
