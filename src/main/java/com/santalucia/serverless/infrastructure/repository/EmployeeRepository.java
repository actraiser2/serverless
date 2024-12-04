package com.santalucia.serverless.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santalucia.serverless.domain.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
