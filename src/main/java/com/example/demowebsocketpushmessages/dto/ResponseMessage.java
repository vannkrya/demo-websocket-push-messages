package com.example.demowebsocketpushmessages.dto;

public class ResponseMessage {
    public ResponseMessage(String content) {
        this.content = content;
    }

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
