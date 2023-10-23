package org.example.services.client;

import org.example.entity.Client;

public interface ClientCrudService {

    void create(Client client);

    Client read(Long id);

    void update(Client client);

    void delete(Client client);
}
