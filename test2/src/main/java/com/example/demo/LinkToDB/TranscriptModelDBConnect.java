package com.example.demo.LinkToDB;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.Model.TranscriptModel;

public interface TranscriptModelDBConnect extends MongoRepository<TranscriptModel, String> {
}
