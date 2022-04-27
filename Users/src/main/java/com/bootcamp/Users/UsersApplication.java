package com.bootcamp.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bootcamp.Users.Model.Users;
import com.bootcamp.Users.Repository.UsersRepository;

@SpringBootApplication
public class UsersApplication {
	
	@Autowired
	private PasswordEncoder pe;
	
	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}
	
	@Bean
	protected CommandLineRunner init(final UsersRepository ur){
		return args->{
			String passwordHashed = pe.encode("1234");
			Users user = new Users("CarlosR", "carlos@algo.com", passwordHashed);
			ur.save(user);
		};
	}

}
