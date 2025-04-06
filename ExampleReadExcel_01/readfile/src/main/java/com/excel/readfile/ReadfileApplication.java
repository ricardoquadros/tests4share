package com.excel.readfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//http://localhost:8080/read-excel?filePath=/Users/ricardoquadros/Public/tmp/Santander-PF-2025-01.xls

@SpringBootApplication
public class ReadfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadfileApplication.class, args);
	}

}
