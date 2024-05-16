package com.angel.controller;


import com.angel.dto.request.UserRequest;
import com.angel.dto.response.ApiResponse;
import com.angel.dto.response.CommandResponse;
import com.angel.dto.response.UserResponse;
import com.angel.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Clock;
import java.time.Instant;
import java.util.List;

import static com.angel.common.Constants.DELETED_USER;
import static com.angel.common.Constants.SUCCESS;


@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class UserController {

	private final Clock clock;
	private final UserServiceImpl userService;

	@GetMapping
	public ResponseEntity<ApiResponse<List<UserResponse>>> findAll(){
		final List<UserResponse> userResponse = userService.findAll();
		return ResponseEntity.ok(new ApiResponse<>(Instant.now(clock).toEpochMilli(), SUCCESS, userResponse));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<UserResponse>> findById(@PathVariable long id){
		final UserResponse userResponse = userService.findById(id);
		return ResponseEntity.ok(new ApiResponse<>(Instant.now(clock).toEpochMilli(), SUCCESS, userResponse));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<CommandResponse>> update(@Valid @RequestBody UserRequest userRequest){
		CommandResponse response = userService.update(userRequest);
		return ResponseEntity.ok(new ApiResponse<>(Instant.now(clock).toEpochMilli(), SUCCESS, response));
	}

	@PutMapping
	public ResponseEntity<ApiResponse<CommandResponse>> create(@Valid @RequestBody UserRequest userRequest){
		CommandResponse response = userService.create(userRequest);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ApiResponse<>(Instant.now(clock).toEpochMilli(), SUCCESS, response));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<Void>> delete(@PathVariable long id){
		userService.deleteById(id);
		return ResponseEntity
				.ok(new ApiResponse<>(Instant.now(clock).toEpochMilli(), SUCCESS));
	}

}
