package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.NewGreeting;
import com.example.demo.model.Greeting;
import com.example.demo.model.User;
import com.example.demo.repository.GreetingRepository;

@Service
public class GreetingService implements IGreetingService {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	
	@Autowired
	private GreetingRepository greetingRepository;
	 
	@Override
	public Greeting addGreeting(User user) 
	{
		String message = String.format(template, (user.toString().isEmpty())? "Hello World": user.toString());
		Greeting greeting = new Greeting(counter.incrementAndGet(),message);
		return greetingRepository.save(new Greeting(counter.incrementAndGet(),message));
	}

	@Override
	public Optional<Greeting> getGreetingById(long id) {
		return greetingRepository.findById(id);
	}

}
