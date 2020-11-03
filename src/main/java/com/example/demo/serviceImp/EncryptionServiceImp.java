package com.example.demo.serviceImp;

import com.example.demo.dao.model.MessageEntity;
import com.example.demo.dao.model.UserEntity;
import com.example.demo.dao.repository.ChatRepository;
import com.example.demo.dao.repository.MessageRepository;
import com.example.demo.dao.repository.UserRepository;
import com.example.demo.dto.MessageDTO;
import com.example.demo.service.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.beans.Transient;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EncryptionServiceImp implements EncryptionService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ChatRepository chatRepository;


    @Transient
    @Override
    public void saveMessage(final String text, final String userName) {

        final UserEntity userEntity = userRepository.findByName(userName);
        final MessageEntity messageEntity = new MessageEntity(text, userEntity);
        messageEntity.setChat(chatRepository.findAll().get(0));
        messageEntity.setUserEntities(userEntity);
        messageRepository.save(messageEntity);
    }

    @Transient
    @Override
    public List<MessageDTO> allMessage() {
        List<MessageDTO> messageDTOS = new ArrayList<>();
        messageRepository.findAll().forEach(x -> {
            messageDTOS.add(x.toMessageDTO());
        });
        return messageDTOS;
    }
}
