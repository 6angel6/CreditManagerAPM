# CreditManagerAPM

## Technologies

This application is built using:

- Spring Boot, Spring Core , Spring Cloud Eureka 
- Hibernate
- PostgreSQL
- FlyWay migrations

## Functionality

### 1) Loan Application

Users can submit loan applications providing client information including name, passport data, marital status, address, contact number, employment details, and desired loan amount.

### 2) Loan Approval

The system randomly approves or rejects loan applications, determining status (approved/rejected), proposed term (1-12 months), and approved loan amount.

### 3) Contract Signing

Once a loan is approved, users can sign a contract. The contract includes application information, signing date, and signing status (signed/not signed).

## Additional Features

In addition to the core functionality, the system provides:

1) Listing of all clients
2) Search functionality by phone, name, and passport data
3) Display of loan applications with approval status
4) Display of all signed loan contracts with signing status

## TODO

- Implement logic for loan service
- Write unit tests for reliability and correctness
