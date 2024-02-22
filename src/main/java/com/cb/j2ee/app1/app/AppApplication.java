package com.cb.j2ee.app1.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

   private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    StudentJdbcRepository repository;


	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
    public void run(String... args)  {

        logger.info("Student id 10001 -> {}", repository.findById(10001L));

        logger.info("Inserting -> {}", repository.insert(new Student(10010L, "John", "122233-23-4567")));

        logger.info("Update 10003 -> {}", repository.update(new Student(10001L, "Name-Updated", "New-MyKAD")));

        repository.deleteById(10002L);

        logger.info("All users -> {}", repository.findAll());
    }

}
