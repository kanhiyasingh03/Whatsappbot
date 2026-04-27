package com.example.whatsappbot.model;

public class MessageRequest {

    private String sender;
    private String message;


    public MessageRequest() {}

    public MessageRequest(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }


    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }


    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageRequest{sender='" + sender + "', message='" + message + "'}";
    }
}