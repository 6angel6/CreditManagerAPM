package com.angel.service.impl;

import com.angel.model.LoanEntity;
import com.angel.repository.LoanRepository;
import com.angel.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

	private final RestTemplate restTemplate;
	private final LoanRepository loanRepository;

	private String url = "http://localhost:8082/api/v1/clients/";

	@Override
	public String getUsers(Long id) {
		return restTemplate.getForObject(url + id, String.class);
	}

	@Override
	public LoanEntity applyForCredit(Long userId) {
		LoanEntity loan = new LoanEntity();
		loan.setUserId(userId);
		loan.setSigningStatus("Pending");
		return loanRepository.save(loan);
	}
}
