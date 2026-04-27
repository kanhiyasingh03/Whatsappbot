package com.example.whatsappbot.service;

import org.springframework.stereotype.Service;

@Service
public class BotService {

    public String getReply(String message) {

        if (message == null || message.trim().isEmpty()) {
            return "Please send a valid message.";
        }

        String cleaned = message.trim().toLowerCase();

        switch (cleaned) {
            case "hi":
            case "hello":
                return "Hello!";

            case "bye":
            case "goodbye":
                return "Goodbye!";

            case "help":
                return "Available commands: Hi, Bye. Type any of these to get a response!";

            default:
                return "Sorry, I don't understand.";
        }
    }
}