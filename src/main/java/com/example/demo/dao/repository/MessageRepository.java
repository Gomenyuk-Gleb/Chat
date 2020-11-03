package com.example.demo.dao.repository;

import com.example.demo.dao.model.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
}
