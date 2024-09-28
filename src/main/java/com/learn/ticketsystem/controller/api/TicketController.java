package com.learn.ticketsystem.controller.api;

import com.learn.ticketsystem.entity.Ticket;
import com.learn.ticketsystem.service.TicketService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {

    public final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        ticket.setStatus(Ticket.Status.OPEN);
        return ticketService.createTicket(ticket);
    }

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return ticketService.findTicketById(id);
    }

    @PutMapping("/{id}/status")
    public Ticket updateTicketStatus(@PathVariable Long id, @RequestParam Ticket.Status status) {
        return ticketService.updateTicketStatus(id, status);
    }
}
