package com.angel.service;

import com.angel.model.LoanEntity;

public interface LoanService {

	String getUsers(Long id);
	LoanEntity applyForCredit(Long userId);
}

