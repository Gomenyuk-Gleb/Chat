package com.example.demo.dao.repository;

import com.example.demo.dao.model.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<ChatEntity, Long> {

}
