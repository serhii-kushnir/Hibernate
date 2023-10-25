package org.example.services.ticket;

import org.example.entity.Ticket;

public final class TicketService implements TicketCrudService {
    private final TicketCrudServiceImpl ticketCrudService = new TicketCrudServiceImpl();

    @Override
    public void create(final Ticket ticket) {
        ticketCrudService.create(ticket);
    }

    @Override
    public Ticket read(final Long id) {
        return ticketCrudService.read(id);
    }

    @Override
    public void update(final Ticket ticket) {
        ticketCrudService.update(ticket);
    }

    @Override
    public void delete(final Ticket ticket) {
        ticketCrudService.delete(ticket);
    }
}
