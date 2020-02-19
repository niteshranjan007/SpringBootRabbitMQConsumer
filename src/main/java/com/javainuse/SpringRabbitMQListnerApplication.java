package com.javainuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.javainuse")
public class SpringRabbitMQListnerApplication {

	public static void main(String[] args)  {
		SpringApplication.run(SpringRabbitMQListnerApplication.class, args);
	}
}
