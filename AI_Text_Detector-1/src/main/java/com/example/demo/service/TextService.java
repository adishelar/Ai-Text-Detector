package com.example.demo.service;

import com.example.demo.entity.TextEntity;
import com.example.demo.repository.TextRepository;

import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	

	@Service
		public class TextService {
		  
		  @Autowired
		  private TextRepository textRepository;
		  
		  public void saveText(TextEntity textEntity) {
		    textRepository.save(textEntity);
		  }
		  
		  public List<TextEntity> getTexts() {
		    return textRepository.findAll();
		  }
		  
		  public List<TextEntity> getAiGeneratedTexts() {
		    return textRepository.findByAiGenerated(true);
		  }
		  
		  public List<TextEntity> getTextsByWebsite(String website) {
		    return textRepository.findByWebsite(website);
		  }
		}



