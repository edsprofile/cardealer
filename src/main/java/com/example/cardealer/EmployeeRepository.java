package com.example.cardealer;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CassandraRepository<Employee, UUID>{

}
