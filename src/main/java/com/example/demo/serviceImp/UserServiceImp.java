package com.example.demo.serviceImp;

import com.example.demo.dao.model.UserEntity;
import com.example.demo.dao.repository.ChatRepository;
import com.example.demo.dao.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChatRepository chatRepository;

    @Transient
    @Override
    public void save(final UserEntity userEntity) {
        System.out.println(userEntity.getChat());
        userRepository.save(userEntity);
    }

    @Transient
    @Override
    public int length() {
        return userRepository.findAll().size();
    }
}

