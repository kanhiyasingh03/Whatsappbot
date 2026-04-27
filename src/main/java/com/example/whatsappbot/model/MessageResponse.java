package com.example.whatsappbot.model;

public class MessageResponse {

    private String reply;


    public MessageResponse() {}

    public MessageResponse(String reply) {
        this.reply = reply;
    }


    public String getReply() {
        return reply;
    }


    public void setReply(String reply) {
        this.reply = reply;
    }

    @Override
    public String toString() {
        return "MessageResponse{reply='" + reply + "'}";
    }
}