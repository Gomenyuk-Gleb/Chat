package com.example.demo.dao.model;

import com.example.demo.dto.MessageDTO;

import javax.persistence.*;

@Entity(name = "massageentity_list")
public class MessageEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String text;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private UserEntity userEntities;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "chat_id")
    private ChatEntity chat;

    public MessageEntity(String text) {
        this.text = text;
    }

    public MessageEntity() {
    }

    public MessageEntity(String text, UserEntity userEntities) {
        this.text = text;
        this.userEntities = userEntities;
    }

    public static MessageEntity of(String text, UserEntity userEntities) {
        return new MessageEntity(text, userEntities);
    }

    public MessageDTO toMessageDTO() {
        return MessageDTO.of(text, userEntities);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserEntity getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(UserEntity userEntities) {
        this.userEntities = userEntities;
    }

    public ChatEntity getChat() {
        return chat;
    }

    public void setChat(ChatEntity chat) {
        this.chat = chat;
    }

    @Override
    public String toString() {
        return "Massage{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", massgeList=" + userEntities.getName() +
                '}';
    }
}
