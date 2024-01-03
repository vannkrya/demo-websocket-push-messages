package com.example.demowebsocketpushmessages.controller;

import com.example.demowebsocketpushmessages.dto.Message;
import com.example.demowebsocketpushmessages.service.WebSocketService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {

    private final WebSocketService webSocketService;

    public WebSocketController(WebSocketService webSocketService) {
        this.webSocketService = webSocketService;
    }

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody final Message message) {
        webSocketService.notifyFrontend(message.getMessageContent());
    }

    @PostMapping("/send-private-message/{id}")
    public void sendPrivateMessage(@PathVariable String id, @RequestBody final Message message) {
        webSocketService.notifyUser(id, message.getMessageContent());
    }
}
