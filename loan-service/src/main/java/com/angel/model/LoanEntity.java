package com.angel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class LoanEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long userId;
	private BigDecimal requstedAmount;
	private String decisionStatus;
	private int approvedTerm;
	private BigDecimal approvedAmount;
	private LocalDateTime signingDate;
	private String signingStatus;


}
