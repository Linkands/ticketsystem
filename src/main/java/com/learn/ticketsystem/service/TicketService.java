package com.learn.ticketsystem.service;

import com.learn.ticketsystem.entity.Ticket;
import com.learn.ticketsystem.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> findAllTicketsByCustomerId(Long customerId) {
        return ticketRepository.findByCustomerId(customerId);
    }

    public Ticket findTicketById(Long id) {
        return ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    public Ticket updateTicketStatus(Long id, Ticket.Status status) {
        Ticket ticket = findTicketById(id);
        ticket.setStatus(status);
        ticketRepository.save(ticket);

        return ticket;
    }
}
