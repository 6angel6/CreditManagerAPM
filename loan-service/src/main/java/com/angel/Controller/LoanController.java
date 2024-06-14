package com.angel.Controller;

import com.angel.dto.UserResponse;
import com.angel.model.LoanEntity;
import com.angel.service.impl.LoanServiceImpl;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/loan")
@RequiredArgsConstructor
public class LoanController {

	private  final LoanServiceImpl loanService;

	@GetMapping("/{id}")
	public ResponseEntity<String> getUser(@PathVariable Long id){
		String s = loanService.getUsers(id);
		return ResponseEntity.ok(s);
	}

	@PostMapping("/apply")
	public LoanEntity applyForCredit(@RequestParam Long userId) {
		return loanService.applyForCredit(userId);
	}
}
