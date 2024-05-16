package com.angel.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserRequest {

	private Long id;

	@NotBlank(message = "Middle name is required")
	private String middleName;

	@NotBlank(message = "First name is required")
	private String firstName;

	@NotBlank(message = "Last name is required")
	private String lastName;

	@NotBlank(message = "Address is required")
	private String address;

	@NotBlank(message = "Employment info is required")
	private String employmentInfo;

	@NotBlank(message = "Phone number is required")
	@Pattern(regexp = "^\\+\\d{12}$", message = "Invalid phone number format")
	private String phoneNumber;
}
