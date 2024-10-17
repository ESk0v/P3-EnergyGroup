package dk.energygroup.Backtester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // This annotation includes component scanning
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
