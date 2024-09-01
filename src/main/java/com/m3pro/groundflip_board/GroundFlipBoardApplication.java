package com.m3pro.groundflip_board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GroundFlipBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroundFlipBoardApplication.class, args);
	}

}
