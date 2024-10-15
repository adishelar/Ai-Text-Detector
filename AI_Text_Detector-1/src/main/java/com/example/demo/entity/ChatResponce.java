package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.message.Message;

public class ChatResponce {
	 private List<Message> messages;
	  
	  public ChatResponce() {
	    this.messages = new ArrayList<>();
	  }
	  
	  public void addMessage(Message message) {
	    this.messages.add(message);
	  }
	  
	  public List<Message> getMessages() {
	    return this.messages;
	  }

}
