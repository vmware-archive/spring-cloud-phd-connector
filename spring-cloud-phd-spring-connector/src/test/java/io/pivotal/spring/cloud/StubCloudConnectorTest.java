package io.pivotal.spring.cloud;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.cloud.CloudConnector;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.CloudTestUtil;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

abstract public class StubCloudConnectorTest {

	private static final String MOCK_CLOUD_BEAN_NAME = "mockCloud";

	protected ApplicationContext getTestApplicationContext(Class<?> configClass,
			ServiceInfo... serviceInfos) {
		final CloudConnector stubCloudConnector = CloudTestUtil
				.getTestCloudConnector(serviceInfos);

		return new AnnotationConfigApplicationContext(configClass) {
			@Override
			protected void prepareBeanFactory(ConfigurableListableBeanFactory beanFactory) {
				CloudFactory cloudFactory = new CloudFactory();
				cloudFactory.registerCloudConnector(stubCloudConnector);
				getBeanFactory().registerSingleton(MOCK_CLOUD_BEAN_NAME, cloudFactory);
				super.prepareBeanFactory(beanFactory);
			}
		};
	}

}