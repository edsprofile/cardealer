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
    	log.info("Preloading " + repository.save(new Employee("1", "Bob Smith", "Sales")));
        log.info("Preloading " + repository.save(new Employee("2", "David Smithe", "Manager")));
    };
  }
}