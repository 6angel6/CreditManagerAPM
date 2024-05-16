package com.angel.service;

import com.angel.dto.request.UserRequest;
import com.angel.dto.response.CommandResponse;
import com.angel.dto.response.UserResponse;

import java.util.List;

public interface UserService {

	UserResponse findById(Long id);

	List<UserResponse> findAll();

	CommandResponse create(UserRequest userRequest);

	CommandResponse update(UserRequest userRequest);

	void deleteById(Long id);


}
