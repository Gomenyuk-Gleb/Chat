package com.example.demo.service;

import com.example.demo.dao.model.UserEntity;

public interface UserService {

    public void save(final UserEntity userEntity);

    public int length();
}
