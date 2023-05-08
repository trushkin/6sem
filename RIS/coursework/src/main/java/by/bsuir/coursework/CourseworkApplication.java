package by.bsuir.coursework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication(scanBasePackages = "by.bsuir.coursework")
public class CourseworkApplication {

	public static void main(String[] args) {
		System.out.println(UUID.randomUUID());
		SpringApplication.run(CourseworkApplication.class, args);
	}
}
