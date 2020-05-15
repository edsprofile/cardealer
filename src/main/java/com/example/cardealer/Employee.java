package com.example.cardealer;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Employee {
	
	private @PrimaryKey UUID id;
	
	private String name;
	private String role;
	
	Employee(){
	}
	
	Employee(UUID id, String name, String role){
		this.id = id;
		this.name = name;
		this.role = role;
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getRole() {
		return role;
	}
	
	//possiable error here since id is UUID and not a string
	@Override
	public String toString() {
		return String.format("{ @type = %1$s, id = %2$s, name = %3$s, role = %4$d }", getClass().getName(), getId(),
				getName(), getRole());
	}
}
