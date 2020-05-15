package com.example.cardealer;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(EmployeeRepository repository) {
		return args -> {
	    	CassandraConnector connector = new CassandraConnector();
	    	connector.connectDefault();
	    	connector.createKeyspace("test_keyspace", "SimpleStrategy", 1);
	    	connector.useKeyspace("test_keyspace");
    };
  }
}