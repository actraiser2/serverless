package com.santalucia.serverless;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import io.awspring.cloud.autoconfigure.s3.S3AutoConfiguration;

@SpringBootApplication(exclude = S3AutoConfiguration.class)
@ConfigurationPropertiesScan(value = "com.santalucia.serverless.configProps")
public class ServerlessApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerlessApplication.class, args);
	}

}
