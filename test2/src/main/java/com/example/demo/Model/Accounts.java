package com.example.demo.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ToString


@Document(collection = "accounts" )
public class Accounts {
	@Id
	public String id;
	public String name;
	public int blance;
	
	
}
