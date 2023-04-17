package by.bsuir.proddep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ProductionDepartmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductionDepartmentApplication.class, args);
	}

}
