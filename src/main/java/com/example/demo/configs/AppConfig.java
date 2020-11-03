package com.example.demo.configs;

import com.example.demo.dao.model.ChatEntity;
import com.example.demo.dao.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.Transient;


@Configuration
public class AppConfig {

    @Autowired
    private ChatRepository chatRepository;

    @Transient
    @Bean
    public CommandLineRunner demo() {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {

                chatRepository.save(new ChatEntity("first"));
            }
        };
    }
}
