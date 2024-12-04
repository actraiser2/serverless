package com.santalucia.serverless;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import software.amazon.awssdk.services.s3.S3Client;

@SpringBootTest
class ServerlessApplicationTests {

	@MockBean S3Client s3Client;
	
	@Test
	void contextLoads() {
	}

}
