package com.example.whatsappbot.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class MessageLog {

    private String id;
    private LocalDateTime timestamp;
    private String sender;
    private String message;
    private String reply;


    public MessageLog() {}


    public MessageLog(String sender, String message, String reply) {
        this.id        = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now();
        this.sender    = sender;
        this.message   = message;
        this.reply     = reply;
    }


    public String getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public String getReply() {
        return reply;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    @Override
    public String toString() {
        return "MessageLog{" +
                "id='"        + id        + '\'' +
                ", timestamp=" + timestamp +
                ", sender='"  + sender    + '\'' +
                ", message='" + message   + '\'' +
                ", reply='"   + reply     + '\'' +
                '}';
    }
}