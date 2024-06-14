package com.angel.service.impl;

import com.angel.dao.impl.UserDaoImpl;
import com.angel.exception.NoSuchElementFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class UserLoanServiceImpl {

	private final RestTemplate restTemplate;
	private final UserDaoImpl userDao;

	private final String url = "http://localhost:8081/credits/apply?userId=";

	public UserLoanServiceImpl(RestTemplate restTemplate, UserDaoImpl userDao) {
		this.restTemplate = restTemplate;
		this.userDao = userDao;
	}

	public void applyForCredit(Long userId){
		if (userId == null){
			throw new NoSuchElementFoundException("No such id");
		}
		restTemplate.postForObject(url + userId , null, void.class );
	}
}
