package org.example.services.client;

import org.example.entity.Client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Test CRUD operations on Client")
class ClientServiceTest {

    @Test
    public void testClientCRUD() {
        // Create Client
        final ClientService clientService = new ClientService();
        final Client client = new Client();
        client.setName("Serhii");
        clientService.create(client);

        // Read Client
        final Long clientId = client.getId();
        final Client readClient = clientService.read(clientId);
        assertEquals(client.getName(), readClient.getName());

        // Update Client
        final String updateClientName = "Serhii Kushnir1";
        readClient.setName(updateClientName);
        clientService.update(readClient);
        final Client updatedClient = clientService.read(clientId);
        assertEquals(updateClientName, updatedClient.getName());

        // Delete Client
        clientService.delete(updatedClient);
        assertNull(clientService.read(clientId));
    }
}