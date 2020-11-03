package com.example.demo.controller;

import com.example.demo.dao.model.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping
public class ChatController {

    @Autowired
    private UserService userService;

    private UserEntity userFirst;

    private UserEntity userSecond;

    @GetMapping("/")
    public void connectUserToChat(final HttpServletResponse httpServletResponse) throws IOException {
        if (userService.length() == 0) {
            userFirst = new UserEntity("first");
            userService.save(userFirst);
            httpServletResponse.sendRedirect("indexfirst.html");

        } else if (userService.length() == 1) {
            userSecond = new UserEntity("second");
            userService.save(userSecond);
            httpServletResponse.sendRedirect("indexsecond.html");
        } else {
            httpServletResponse.sendRedirect("error.html");
        }
    }

    @GetMapping("/indexfirst")
    public UserEntity alindexfirstlUser() {

        return userFirst;
    }

    @GetMapping("/indexsecond")
    public UserEntity indexsecond() {
        return userSecond;
    }


}
