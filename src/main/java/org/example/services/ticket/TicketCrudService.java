package org.example.services.ticket;

import org.example.entity.Ticket;

public interface TicketCrudService {

    void create(final Ticket ticket);

    Ticket read(final Long id);

    void update(final Ticket ticket);

    void delete(final Ticket ticket);
}
