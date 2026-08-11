package io.github.macebot.cobble_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CobbleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CobbleApiApplication.class, args);
	}





	}
