package com.angel.service.impl;

import com.angel.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserLoanService {
	private final RestTemplate restTemplate;


	public UserLoanService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public void createCreditForUser(User user) {

	}
}