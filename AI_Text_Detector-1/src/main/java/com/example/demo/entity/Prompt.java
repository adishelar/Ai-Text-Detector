package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class Prompt {
    private List<UserMessage> messages;

    public Prompt(UserMessage userMessage) {
        this.messages = new ArrayList<>();
        this.messages.add(userMessage);
    }

    public void addMessage(UserMessage message) {
        this.messages.add(message);
    }

    public List<UserMessage> getMessages() {
        return this.messages;
    }
}
