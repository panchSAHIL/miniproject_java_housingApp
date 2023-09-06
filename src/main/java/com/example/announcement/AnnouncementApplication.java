package com.example.announcement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class AnnouncementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnouncementApplication.class, args);
	}

}
