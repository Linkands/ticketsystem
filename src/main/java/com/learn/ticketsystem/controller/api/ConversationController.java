package com.learn.ticketsystem.controller.api;

import com.learn.ticketsystem.entity.Conversation;
import com.learn.ticketsystem.service.ConversationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/conversations")
public class ConversationController {

    private final ConversationService conversationService;

    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @PostMapping("/{ticketId}")
    public Conversation addConversation(@PathVariable Long ticketId, @RequestBody Conversation conversation) {
        return this.conversationService.addConversation(ticketId, conversation);
    }

    @GetMapping("/{ticketId}")
    public List<Conversation> getAllConversations(@PathVariable Long ticketId) {
        return conversationService.findAllConversationsByTicketId(ticketId);
    }
}
