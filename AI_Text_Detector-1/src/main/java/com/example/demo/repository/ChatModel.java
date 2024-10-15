package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.ChatResponce;
import com.example.demo.entity.Prompt;

@Repository
public interface ChatModel {
		  
		  ChatResponce call(Prompt prompt);
		}


