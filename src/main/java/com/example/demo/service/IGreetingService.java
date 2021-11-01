package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Greeting;
import com.example.demo.model.User;

public interface IGreetingService {
	Greeting addGreeting(User user);
	Optional<Greeting> getGreetingById(long id);
	List<Greeting> getGreetings();
	void deleteGreeting(long id);
}
