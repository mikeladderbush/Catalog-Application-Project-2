package com.ladderbush.catalogapplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ladderbush.catalogapplication.Authentication.AuthenticationService;
import com.ladderbush.catalogapplication.Authentication.RegisterRequest;
import com.ladderbush.catalogapplication.User.UserRepository;

import static com.ladderbush.catalogapplication.User.Role.ADMIN;
import static com.ladderbush.catalogapplication.User.Role.MANAGER;

@SpringBootApplication
public class CatalogapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogapplicationApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserRepository userRepository, AuthenticationService service) {
		return args -> {
			String adminEmail = "mikeladderbush@gmail.com";
			if (userRepository.findByEmail(adminEmail).isEmpty()) {
				var admin = RegisterRequest.builder()
						.firstname("Mike")
						.lastname("Ladderbush")
						.email(adminEmail)
						.password("Applesauce1!")
						.role(ADMIN)
						.build();
				System.out.println("Admin token: " + service.register(admin).getAccessToken());
			} else {
				System.out.println("Admin already exists");
			}

			String managerEmail = "manager@mail.com";
			if (userRepository.findByEmail(managerEmail).isEmpty()) {
				var manager = RegisterRequest.builder()
						.firstname("Admin")
						.lastname("Admin")
						.email(managerEmail)
						.password("password")
						.role(MANAGER)
						.build();
				System.out.println("Manager token: " + service.register(manager).getAccessToken());
			} else {
				System.out.println("Manager already exists");
			}
		};
	}

}

/*
 * Next steps:
 * Build apis for creating miniatures with images that can be posted to
 * create a login form in react for spring security
 * add connection to react front end to apis and components
 */