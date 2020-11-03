package com.example.demo.dto;

import com.example.demo.dao.model.UserEntity;

public class MessageDTO {

    private UserEntity userEntities;

    private String text;

    public MessageDTO() {
    }

    public MessageDTO(String text, UserEntity userEntities) {
        this.text = text;
        this.userEntities = userEntities;
    }

    public static MessageDTO of(String text, UserEntity userEntities) {
        return new MessageDTO(text, userEntities);
    }


    public String getUserEntities() {
        return userEntities.getName();
    }

    public void setUserEntities(UserEntity userEntities) {
        this.userEntities = userEntities;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return
                "text='" + text + '\'' +
                        ", massgeList=" + userEntities.getName() +
                        '}';
    }

}
