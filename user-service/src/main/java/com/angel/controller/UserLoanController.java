package com.angel.controller;

import com.angel.dto.response.ApiResponse;
import com.angel.dto.response.CommandResponse;
import com.angel.service.impl.UserLoanServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;
import java.time.Instant;

import static com.angel.common.Constants.SUCCESS;

@RestController
@RequestMapping("/users")
public class UserLoanController {

	private final Clock clock;
	private final UserLoanServiceImpl userLoanService;

	public UserLoanController(Clock clock, UserLoanServiceImpl userLoanService) {
		this.clock = clock;
		this.userLoanService = userLoanService;
	}

	@PostMapping("/{userId}/applyForCredit")
	public ResponseEntity<ApiResponse<CommandResponse>> applyForCredit(@PathVariable Long userId){
		userLoanService.applyForCredit(userId);
		return ResponseEntity.ok(new ApiResponse<>(Instant.now(clock).toEpochMilli(), SUCCESS));
	}

}
