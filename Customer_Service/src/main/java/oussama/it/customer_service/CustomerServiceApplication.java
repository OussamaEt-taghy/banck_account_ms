package oussama.it.customer_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import oussama.it.customer_service.Config.GlobalConfig;
import oussama.it.customer_service.Entities.Customer;
import oussama.it.customer_service.Services.CustomerService;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
 CommandLineRunner commandLineRunner(CustomerService customerService) {

		return args -> {
			List<Customer> customerList = List.of(
					Customer.builder()
							.firstname("Oussama")
							.lastname("Et-taghy")
							.email("oussama@gmail.com")
							.build(),
					Customer.builder()
							.firstname("youssef")
							.lastname("smahi")
							.email("youssef@gmail.com")
							.build()
			);
			customerService.saveAll(customerList);

		};
	}

}
