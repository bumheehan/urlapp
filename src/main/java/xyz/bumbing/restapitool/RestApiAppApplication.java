package xyz.bumbing.restapitool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackages = "xyz.bumbing.restapitool.config")
@SpringBootApplication
public class RestApiAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiAppApplication.class, args);
	}

}
