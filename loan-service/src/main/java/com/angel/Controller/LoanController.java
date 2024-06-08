package com.angel.Controller;

import com.angel.model.LoanEntity;
import com.angel.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LoanController {

	private final LoanService loanService;

	@PostMapping
	public ResponseEntity<LoanEntity> createCredit(@RequestBody LoanEntity loan) {
		// Логика создания кредита
		LoanEntity loanEntity = loanService.createLoan(loan);
		return ResponseEntity.status(HttpStatus.CREATED).body(loanEntity);
	}
}
