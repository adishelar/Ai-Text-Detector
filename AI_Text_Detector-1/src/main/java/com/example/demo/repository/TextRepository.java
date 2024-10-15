package com.example.demo.repository;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TextEntity;
	
@Repository
	public interface TextRepository extends MongoRepository<TextEntity, ObjectId> {
	  
	  // You can add custom query methods here, for example:
	  List<TextEntity> findByAiGenerated(boolean aiGenerated);
	  
	  List<TextEntity> findByWebsite(String website);
	}


