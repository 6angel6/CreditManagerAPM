package com.angel.dto.response;

import com.angel.model.Passport;
import lombok.Data;

@Data
public class UserResponse {

	private Long id;
	private String middleName;
	private String firstName;
	private String lastName;
	private String fullName;
	private String employmentInfo;
	private String phoneNumber;
	private Passport passportData;
	private String creditStatus;
}
