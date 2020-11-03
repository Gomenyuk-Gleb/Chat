package com.example.demo.service;

import com.example.demo.dto.MessageDTO;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface EncryptionService {

    public void saveMessage(final String text, final String userName) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException;

    public List<MessageDTO> allMessage();

    public MessageDTO decrypt(final SecretKey keys, final byte[] bytes, String userName) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException;
}
