package com.example.whatsappbot.controller;

import com.example.whatsappbot.model.MessageLog;
import com.example.whatsappbot.model.MessageRequest;
import com.example.whatsappbot.model.MessageResponse;
import com.example.whatsappbot.service.BotService;
import com.example.whatsappbot.service.LoggingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    private final BotService botService;
    private final LoggingService loggingService;


    public WebhookController(BotService botService, LoggingService loggingService) {
        this.botService     = botService;
        this.loggingService = loggingService;
    }


    @PostMapping
    public ResponseEntity<MessageResponse> receiveMessage(@RequestBody MessageRequest request) {

        String reply = botService.getReply(request.getMessage());

        // Save to in-memory log
        loggingService.log(request.getSender(), request.getMessage(), reply);

        return ResponseEntity.ok(new MessageResponse(reply));
    }


    @GetMapping("/logs")
    public ResponseEntity<List<MessageLog>> getAllLogs() {
        List<MessageLog> logs = loggingService.getAllLogs();
        return ResponseEntity.ok(logs);
    }
}