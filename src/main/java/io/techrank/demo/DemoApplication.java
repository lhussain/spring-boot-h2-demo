package io.techrank.demo;

import io.techrank.demo.config.DEVConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	private DEVConfig myConfig;

	@Autowired
	public DemoApplication(DEVConfig myConfig) {
		this.myConfig = myConfig;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public void run(String... args) {
		System.out.println("using environment: " + myConfig.getEnvironment());
		System.out.println("name: " + myConfig.getName());
		System.out.println("enabled:" + myConfig.isEnabled());
		System.out.println("servers: " + myConfig.getServers());
	}
}
