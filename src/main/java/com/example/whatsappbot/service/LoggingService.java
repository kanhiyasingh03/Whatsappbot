package com.example.whatsappbot.service;

import com.example.whatsappbot.model.MessageLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoggingService {

    private static final Logger logger = LoggerFactory.getLogger(LoggingService.class);

    private final MessageLogRepository repository;

    public LoggingService(MessageLogRepository repository) {
        this.repository = repository;
    }


    public void log(String sender, String message, String reply) {
        MessageLog entry = new MessageLog(sender, message, reply);
        repository.save(entry);


        logger.info("--------------------------------------------------");
        logger.info("ID        : {}", entry.getId());
        logger.info("Timestamp : {}", entry.getTimestamp());
        logger.info("Sender    : {}", entry.getSender());
        logger.info("Message   : {}", entry.getMessage());
        logger.info("Reply     : {}", entry.getReply());
        logger.info("Total logs: {}", repository.count());
        logger.info("--------------------------------------------------");
    }


    public List<MessageLog> getAllLogs() {
        return repository.findAll();
    }
}