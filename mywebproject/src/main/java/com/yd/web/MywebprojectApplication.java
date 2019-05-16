package com.yd.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yd.web.mappers")
public class MywebprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MywebprojectApplication.class, args);
	}

}
