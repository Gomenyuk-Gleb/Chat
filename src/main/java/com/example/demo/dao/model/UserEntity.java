package com.example.demo.dao.model;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.persistence.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_table")
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "userEntities", cascade = CascadeType.ALL)
    private List<MessageEntity> messageEntities = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "chats_id")
    private ChatEntity chat;

    public UserEntity() {
    }

    public List<MessageEntity> getMessageEntities() {
        return messageEntities;
    }

    public void setMessageEntities(List<MessageEntity> messageEntities) {
        this.messageEntities = messageEntities;
    }

    public SecretKey secretKey() throws NoSuchAlgorithmException {
        KeyGenerator key = KeyGenerator.getInstance("AES");
        key.init(128);
        SecretKey secretKey = key.generateKey();
        return secretKey;
    }

    public UserEntity(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChatEntity getChat() {
        return chat;
    }

    public void setChat(ChatEntity chat) {
        this.chat = chat;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", messageEntities=" + messageEntities +
                ", chat=" + chat +
                '}';
    }
}
