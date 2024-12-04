package com.santalucia.serverless.config;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.santalucia.serverless.domain.model.Employee;
import com.santalucia.serverless.infrastructure.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class FunctionsConfig {

	private final EmployeeRepository employeeRepository;	
	
	@Bean
	Consumer<Employee> employeeConsumer() {
		return e -> {
			log.info("Consuming employee {}", e);
		
			var employee = Employee.builder().email(e.getEmail()).
				name(e.getName()).
				salary(e.getSalary()).
				build();
			
			employeeRepository.save(employee);
			

		};
	}
	
	@Bean
	Supplier<List<Employee>> employersList(){
		return () -> {
			return employeeRepository.findAll();
		};
	}
}
