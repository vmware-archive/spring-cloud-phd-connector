package io.pivotal.spring.cloud.config.java;

import org.springframework.cloud.Cloud;
import org.springframework.cloud.config.java.CloudServiceConnectionFactory;

public class PivotalCloudServiceConnectionFactory extends CloudServiceConnectionFactory
		implements PivotalServiceConnectionFactory {
	private CloudConnectorsConfig cloudConnectorsConfig;

	public PivotalCloudServiceConnectionFactory(
			CloudConnectorsConfig cloudConnectorsConfig, Cloud cloud) {
		super(cloud);
		this.cloudConnectorsConfig = cloudConnectorsConfig;
	}

}
