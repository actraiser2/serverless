package com.santalucia.serverless.configProps;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Value;

@ConfigurationProperties("aws.s3")
@Value
public class S3BucketProperties {
	private String accessKey;
	private String secretKey;
	private String region;
	private String bucketName;
}
