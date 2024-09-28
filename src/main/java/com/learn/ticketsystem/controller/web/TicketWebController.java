package com.learn.ticketsystem.controller.web;

import com.learn.ticketsystem.entity.Customer;
import com.learn.ticketsystem.entity.Ticket;
import com.learn.ticketsystem.service.CustomerService;
import com.learn.ticketsystem.service.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class TicketWebController {

    private final TicketService ticketService;

    private final CustomerService customerService;

    public TicketWebController(TicketService ticketService, CustomerService customerService) {
        this.ticketService = ticketService;
        this.customerService = customerService;
    }

    @GetMapping("/customers/{customerId}/tickets")
    public String getCustomerTickets(@PathVariable Long customerId, Model model) {
        Customer customer = customerService.findCustomerById(customerId);

        List<Ticket> tickets = ticketService.findAllTicketsByCustomerId(customerId);

        model.addAttribute("tickets", tickets);
        model.addAttribute("customer", customer);

        return "tickets";
    }
}
