package com.example.cardealer;

import lombok.Data;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Table
public class Employee {
	
	private @PrimaryKey String id;
	
	private String name;
	private String role;
	
	Employee(){
	}
	
	Employee(String id, String name, String role){
		this.id = id;
		this.name = name;
		this.role = role;
	}
}
