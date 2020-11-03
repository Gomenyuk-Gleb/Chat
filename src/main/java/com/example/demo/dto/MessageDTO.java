package com.example.demo.dto;

import com.example.demo.dao.model.UserEntity;

public class MessageDTO {

    private Long id;

    private byte[] text;

    private UserEntity userEntities;

    private StringBuilder stringBuilder;

    public MessageDTO(byte[] text) {
        this.text = text;
    }

    public MessageDTO() {
    }

    public MessageDTO(byte[] text, UserEntity userEntities) {
        this.text = text;
        this.userEntities = userEntities;
    }

    public MessageDTO(StringBuilder stringBuilder, UserEntity userEntities) {
        this.stringBuilder = stringBuilder;
        this.userEntities = userEntities;
    }

    public static MessageDTO of(byte[] text, UserEntity userEntities) {
        return new MessageDTO(text, userEntities);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getText() {
        return text;
    }

    public void setText(byte[] text) {
        this.text = text;
    }

    public String getUserEntities() {
        return userEntities.getName();
    }

    public void setUserEntities(UserEntity userEntities) {
        this.userEntities = userEntities;
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
