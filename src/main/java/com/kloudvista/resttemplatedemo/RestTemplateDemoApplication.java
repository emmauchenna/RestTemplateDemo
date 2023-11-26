package com.kloudvista.resttemplatedemo;

import com.kloudvista.resttemplatedemo.infrastructure.ConsumeNurse;
import com.kloudvista.resttemplatedemo.infrastructure.NurseDto;
import com.kloudvista.resttemplatedemo.infrastructure.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class RestTemplateDemoApplication  {

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateDemoApplication.class, args);
	}


}
