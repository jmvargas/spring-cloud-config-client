package com.privalia.springcloudconfigclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringCloudConfigClientApplication implements CommandLineRunner{

	@Value("${config.key}")
	String key;

	@SuppressWarnings("unused")
	@Autowired
	private DiscoveryClient discoveryClient;

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringCloudConfigClientApplication.class);
		application.setApplicationContextClass(AnnotationConfigApplicationContext.class);
		SpringApplication.run(SpringCloudConfigClientApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.printf("Valor de propiedad de configuracion (%s): %s\\n", "config.key", key);
	}
}
