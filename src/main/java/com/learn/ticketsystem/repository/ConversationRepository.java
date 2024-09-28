package com.learn.ticketsystem.repository;

import com.learn.ticketsystem.entity.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {

    List<Conversation> findByTicketIdOrderByCreatedAtDesc(Long ticketId);
}
