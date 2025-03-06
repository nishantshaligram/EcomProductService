package com.scaler.ecomproductservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.scaler.ecomproductservice.service.InitService;

@SpringBootApplication
public class EcomproductserviceApplication implements CommandLineRunner{

	@Autowired
	private InitService initService;

	public static void main(String[] args) {
		SpringApplication.run(EcomproductserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initService.initialize();
	}

}
