package com.santalucia.serverless.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name= "employee")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	 @Id
     @GeneratedValue(generator = "UUID") 
	 private Long id;
     private String name;
     private int employeeid;
     private String email;
     private Double salary;
}
