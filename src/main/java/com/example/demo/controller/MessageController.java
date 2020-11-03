package com.example.demo.controller;

import com.example.demo.dto.MessageDTO;
import com.example.demo.service.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping
public class MessageController {

    @Autowired
    private EncryptionService encryptionService;

    @PostMapping("message")
    public String userSend(@RequestParam final String text, @RequestParam final String name) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        encryptionService.saveMessage(text, name);

        return "success";
    }

    @GetMapping("/message")
    public List<MessageDTO> allMessage() {

        return encryptionService.allMessage();
    }
}
