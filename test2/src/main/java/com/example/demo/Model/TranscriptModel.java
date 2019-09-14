package com.example.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "Transcript" )
public class TranscriptModel {
	@Id
	public String id;
	public String Name;
	public double English;
	public double Math;
	public double Science;
	public double Average;
	public String Result;
}
