package com.shipflow;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class MessageService {
    private final List<String> messages = new CopyOnWriteArrayList<>();

    public void addMessage(String text) {
        messages.add(text);
    }

    public List<String> getAllMessages() {
        return List.copyOf(messages);
    }

    public void clearMessages() {
        messages.clear();
    }
}
