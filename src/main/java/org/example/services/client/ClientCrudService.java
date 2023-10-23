package org.example.services.client;

import org.example.entity.Client;

public interface ClientCrudService {

    void create(final Client client);

    Client read(final Long id);

    void update(final Client client);

    void delete(final Client client);
}
