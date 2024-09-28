package com.learn.ticketsystem.service;

import com.learn.ticketsystem.entity.Conversation;
import com.learn.ticketsystem.entity.Ticket;
import com.learn.ticketsystem.exception.EntityNotFoundException;
import com.learn.ticketsystem.repository.ConversationRepository;
import com.learn.ticketsystem.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationService {

    private final ConversationRepository conversationRepository;
    private final TicketRepository ticketRepository;

    public ConversationService(ConversationRepository conversationRepository, TicketRepository ticketRepository) {
        this.conversationRepository = conversationRepository;
        this.ticketRepository = ticketRepository;
    }

    public Conversation addConversation(Long ticketId, Conversation conversation) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new EntityNotFoundException("Ticket with id " + ticketId + " not found"));

        conversation.setTicket(ticket);

        return conversationRepository.save(conversation);
    }

    public List<Conversation> findAllConversationsByTicketId(Long ticketId) {
        return conversationRepository.findByTicketIdOrderByCreatedAtDesc(ticketId);
    }

}
