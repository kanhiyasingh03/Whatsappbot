package com.example.whatsappbot.service;

import com.example.whatsappbot.model.MessageLog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class MessageLogRepository {

    // In-memory store — lives as long as the app is running
    private final List<MessageLog> store = new ArrayList<>();

    // Save a new log entry
    public void save(MessageLog log) {
        store.add(log);
    }

    // Return all logs — unmodifiable so the list can't be changed from outside
    public List<MessageLog> findAll() {
        return Collections.unmodifiableList(store);
    }

    // Return total count of messages logged
    public int count() {
        return store.size();
    }
}