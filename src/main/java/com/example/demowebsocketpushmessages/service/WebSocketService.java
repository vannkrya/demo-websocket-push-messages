package com.example.demowebsocketpushmessages.service;


import com.example.demowebsocketpushmessages.dto.ResponseMessage;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public WebSocketService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void notifyFrontend(final String message) {
        ResponseMessage responseMessage = new ResponseMessage(message);
        simpMessagingTemplate.convertAndSend("/topic/messages", responseMessage);
    }

    public void notifyUser(final String id, final String message) {
        ResponseMessage responseMessage = new ResponseMessage(message);
        simpMessagingTemplate.convertAndSendToUser(id, "/topic/private-messages", responseMessage);
    }
}
