package com.angel.model;

import com.angel.dao.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "person")
public class User implements BaseEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "middle_name", length = 20, nullable = false, unique = true)
	private String middleName;

	@Column(name = "first_name", nullable = false, length = 20)
	private String firstName;

	@Column(name = "last_name" ,nullable = false,length = 20)
	private String lastName;

	@Column(name = "address",nullable = false)
	private String address;

	@Column(name = "employment_info", nullable = false)
	private String employmentInfo;

	@Column(name = "requestedAmount")
	private int requestedAmount;

	@Column(name = "phone_number", nullable = false)
	@Pattern(regexp="^\\+\\d{12}$",message="Invalid phone number format")
	private String phoneNumber;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
     private Passport passportData;


	@Column(name = "credit_status", nullable = false)
	private String creditStatus;
}
