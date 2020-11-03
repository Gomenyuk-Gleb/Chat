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

import javax.crypto.*;
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

    private static SecretKey secretKeyFirst;

    private static SecretKey secretKeySecond;

    @Transient
    @Override
    public void saveMessage(final String text, final String userName) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        final UserEntity userEntity = userRepository.findByName(userName);
        byte[] bytes = new byte[0];
        Cipher cipher = Cipher.getInstance("AES");
        if (userName.equals("first")) {
            if (secretKeyFirst == null)
                secretKeyFirst = userEntity.secretKey();
            cipher.init(Cipher.ENCRYPT_MODE, secretKeyFirst);
            bytes = cipher.doFinal(text.getBytes());
        } else if (userName.equals("second")) {
            if (secretKeySecond == null) {
                secretKeySecond = userEntity.secretKey();
            }
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySecond);
            bytes = cipher.doFinal(text.getBytes());
        }
        final MessageEntity messageEntity = new MessageEntity(bytes, userEntity);
        messageEntity.setChat(chatRepository.findAll().get(0));
        messageEntity.setUserEntities(userEntity);
        messageRepository.save(messageEntity);
    }

    @Transient
    @Override
    public List<MessageDTO> allMessage() {
        List<MessageDTO> messageDTOS = new ArrayList<>();
        messageRepository.findAll().forEach(x -> {
            if (x.getUserEntities().getName().equals("first")) {
                add(secretKeyFirst, x.getText(), "first", messageDTOS);
            } else if (x.getUserEntities().getName().equals("second")) {
                add(secretKeySecond, x.getText(), "second", messageDTOS);
            }
        });
        return messageDTOS;
    }

    @Transient
    @Override
    public MessageDTO decrypt(final SecretKey keys, final byte[] bytes, final String userName) throws
            NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher decript = Cipher.getInstance("AES");
        decript.init(Cipher.DECRYPT_MODE, keys);
        byte[] decrip = decript.doFinal(bytes);
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : decrip) {
            stringBuilder.append((char) b);
        }
        return new MessageDTO(stringBuilder, userRepository.findByName(userName));
    }

    public void add(final SecretKey secretKey, final byte[] bytes, String userName, final List<MessageDTO> messageDTO) {
        try {
            messageDTO.add(decrypt(secretKey, bytes, userName));
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }
}
