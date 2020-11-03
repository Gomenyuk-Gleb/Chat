package com.example.demo.dao.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "chat")
public class ChatEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String chatName;

    @OneToMany(mappedBy = "chat")
    private List<UserEntity> userEntities = new ArrayList<>();

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MessageEntity> messageEntities = new ArrayList<>();

    public ChatEntity(String chatName) {
        this.chatName = chatName;
    }

    public ChatEntity() {
    }

    public List<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(List<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MessageEntity> getMessageEntities() {
        return messageEntities;
    }

    public void setMessageEntities(List<MessageEntity> messageEntities) {
        this.messageEntities = messageEntities;
    }

    public void setMassgeList(List<MessageEntity> massgemessageEntitiesList) {
        this.messageEntities = messageEntities;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String name) {
        this.chatName = name;
    }

    @Override
    public String toString() {
        return "ChatEntity{" +
                "chatName='" + chatName + '\'' +
                '}';
    }
}
