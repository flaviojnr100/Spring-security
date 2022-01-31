package com.flavio.seguranca;

import com.flavio.seguranca.model.Role;
import com.flavio.seguranca.model.Usuario;
import com.flavio.seguranca.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SegurancaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SegurancaApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_USUARIO"));
			userService.save(new Usuario(null,"Flavio","Junior","flavio@gmail.com","123",null));
			userService.addRole("flavio@gmail.com","ROLE_ADMIN");
		};
	}

}
