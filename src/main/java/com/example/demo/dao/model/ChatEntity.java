package com.example.demo.dao.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "chat")
public class ChatEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
    private List<UserEntity> userEntities = new ArrayList<>();

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
    private List<MessageEntity> messageEntities = new ArrayList<>();

    public ChatEntity(String name) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'';
    }
}
