package com.example.demo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "texts")
public class TextEntity {
  
  @Id
  private ObjectId id;
  
  public ObjectId getId() {
	return id;
}

public void setId(ObjectId id) {
	this.id = id;
}

public String getText() {
	return text;
}

public void setText(String text) {
	this.text = text;
}

public boolean isAiGenerated() {
	return aiGenerated;
}

public void setAiGenerated(boolean aiGenerated) {
	this.aiGenerated = aiGenerated;
}

public String getWebsite() {
	return website;
}

public void setWebsite(String website) {
	this.website = website;
}

public String getMetadata() {
	return metadata;
}

public void setMetadata(String metadata) {
	this.metadata = metadata;
}

private String text;
  
  private boolean aiGenerated;
  
  private String website;
  
  private String metadata; // additional metadata extracted from the text
  
  // getters and setters
}