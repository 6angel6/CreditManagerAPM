package com.angel.service.impl;


import com.angel.dao.impl.UserDaoImpl;
import com.angel.dto.mapper.UserRequestMapper;
import com.angel.dto.mapper.UserResponseMapper;
import com.angel.dto.request.UserRequest;
import com.angel.dto.response.CommandResponse;
import com.angel.dto.response.UserResponse;
import com.angel.exception.NoSuchElementFoundException;
import com.angel.model.User;
import com.angel.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.angel.common.Constants.*;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	private final UserDaoImpl userDao;
	private final UserRequestMapper userRequestMapper;
	private final UserResponseMapper userResponseMapper;

	public UserServiceImpl(UserDaoImpl userDao, UserRequestMapper userRequestMapper, UserResponseMapper userResponseMapper) {
		this.userDao = userDao;
		this.userRequestMapper = userRequestMapper;
		this.userResponseMapper = userResponseMapper;
	}

	@Transactional(readOnly = true)
	public UserResponse findById(Long id) {
		return userDao.findById(id)
				.map(userResponseMapper::toDto)
				.orElseThrow( () -> new NoSuchElementFoundException(NOT_FOUND_USER));
	}

	@Transactional(readOnly = true)
	public List<UserResponse> findAll() {
		final List<UserResponse> users = userDao.findAll().stream()
				.map(userResponseMapper::toDto)
				.collect(Collectors.toList());
		if (users.isEmpty())
			throw new NoSuchElementException(NOT_FOUND_USER);
		log.info("users found ");
		return users;
	}

	@Transactional
	public CommandResponse create(UserRequest userRequest) {
		final User user = userRequestMapper.toEntity(userRequest);
		userDao.create(user);
		log.info(CREATED_USER);
		return CommandResponse.builder().id(user.getId()).build();

	}

	public CommandResponse update(UserRequest request) {
		final User user = userDao.findById(request.getId())
				.orElseThrow(()-> new NoSuchElementException(NOT_FOUND_USER));

		user.setFirstName(WordUtils.capitalizeFully(request.getFirstName()));
		user.setLastName(WordUtils.capitalizeFully(request.getLastName()));
		user.setMiddleName(WordUtils.capitalizeFully(request.getMiddleName()));
		user.setPhoneNumber(request.getPhoneNumber());
		user.setAddress(request.getAddress());
		user.setEmploymentInfo(request.getEmploymentInfo());

		userDao.save(user, request.getId());
		log.info(UPDATED_USER);
		return CommandResponse.builder().id(user.getId()).build();
	}

	public void deleteById(Long id) {
		final User user = userDao.findById(id)
						.orElseThrow(()-> new NoSuchElementException(NOT_FOUND_USER));
		userDao.delete(user);
	}
}

