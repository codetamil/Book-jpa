package com.janani;
   
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("applicationContext.xml")
public class BookappJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookappJpaApplication.class, args);
	}
}
