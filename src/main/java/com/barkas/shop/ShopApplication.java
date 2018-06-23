package com.barkas.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	@Bean
	ApplicationRunner run(CustomerRepository cr) {
		return args -> Stream.of("Andrii", "Anton", "Sanya", "Dimon").forEach(x -> cr.save(new Customer(null, x)));

	}
}


interface CustomerRepository extends JpaRepository<Customer, Long> {

}

@RestController
class CustomerRestController {
	private final CustomerRepository customerRepository;

	CustomerRestController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@GetMapping("/customers")
	Collection<Customer> customerCollections() {
		return this.customerRepository.findAll();
	}
}

@Component
class CustomHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		return Health.status("Health check: ").build();
	}
}

@Configuration
@EnableWebSecurity
class SecurityConfigurator extends WebSecurityConfigurerAdapter {
	@Bean
	UserDetailsService users() {
		return new InMemoryUserDetailsManager(Collections.singleton(User.withUsername("Andrii").roles("ADMIN").password("pw").build()));
	}
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
class Customer {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
}