package org.example.services.ticket;

import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.example.services.planet.PlanetService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Test CRUD operations on Ticket")
class TicketServiceTest {

    @Test
    void testTicketCRUD() {
        // Create Ticket
        final TicketService ticketService = new TicketService();
        final Ticket ticket = new Ticket();

        final Client client = new Client();
        client.setName("Test Ticket");

        final PlanetService planetService = new PlanetService();
        final Planet fromPlanet = new Planet();
        fromPlanet.setId("FTST");
        fromPlanet.setName("from testPlanet");

        final Planet toPlanet = new Planet();
        toPlanet.setId("TTST");
        toPlanet.setName("to testPlanet");

        ticket.setClient(client);
        ticket.setFromPlanet(fromPlanet);
        ticket.setToPlanet(toPlanet);

        ticketService.create(ticket);

        // Read Ticket
        final Long ticketId = ticket.getId();
        final Ticket readTicket = ticketService.read(ticketId);
        assertEquals(ticket.getId(), readTicket.getId());

        // Update Ticket
        final Planet upadateToPlanet = new Planet();
        upadateToPlanet.setId("NTST");
        upadateToPlanet.setName("update testPlanet");

        readTicket.setToPlanet(upadateToPlanet);
        ticketService.update(readTicket);

        // Delete Ticket
        final Ticket updatedTicket = ticketService.read(ticketId);
        ticketService.delete(updatedTicket);
        assertNull(ticketService.read(ticketId));

        // Clear
        planetService.delete(toPlanet);
    }
}