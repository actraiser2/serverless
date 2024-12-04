package com.santalucia.serverless.config;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.santalucia.serverless.configProps.S3BucketProperties;
import com.santalucia.serverless.domain.model.Employee;
import com.santalucia.serverless.infrastructure.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class FunctionsConfig {

	private final EmployeeRepository employeeRepository;
	private final S3Client s3Client;
	private final S3BucketProperties s3BucketProperties;
	
	@Bean
	Consumer<Employee> employeeConsumer() {
		return e -> {
			log.info("Consuming employee {}", e);
			
		
			var employee = Employee.builder().email(e.getEmail()).
				name(e.getName()).
				salary(e.getSalary()).
				build();
			
			employeeRepository.save(employee);
			
			PutObjectRequest putObjectRequest = PutObjectRequest.builder()
		        .bucket(s3BucketProperties.getBucketName())
		        .key(employee.getId() + "")
		        .build();
			s3Client.putObject(putObjectRequest, 
					RequestBody.fromString(employee.toString()));

		};
	}
	
	@Bean
	Supplier<List<Employee>> employersList(){
		return () -> {
			return employeeRepository.findAll();
			
			
		};
	}
}
