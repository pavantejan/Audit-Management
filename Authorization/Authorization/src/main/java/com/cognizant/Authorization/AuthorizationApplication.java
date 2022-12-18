package com.cognizant.Authorization;

import com.cognizant.Authorization.model.user;
import com.cognizant.Authorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableSwagger2
public class AuthorizationApplication {

//	@Autowired
//	private UserRepository userRepository;
//
//	@PostConstruct
//	public void initUsers(){
//		List<user> users = Stream.of(
//				new user(101,"java","pass","java@gmail.com"),
//				new user(102,"java1","pass","java1@gmail.com")
//		).collect(Collectors.toList());
//		userRepository.saveAll(users);
// 	}
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationApplication.class, args);
	}

}
