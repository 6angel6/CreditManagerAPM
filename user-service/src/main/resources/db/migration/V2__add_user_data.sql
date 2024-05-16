-- Insert data for the first user
INSERT INTO Person (middle_name, first_name, last_name, address, employment_info, phone_number, credit_status)
VALUES ('Smith', 'John', 'Doe', '123 Main Street', 'Software Engineer', '+12345678901', 'NULL');

INSERT INTO passport (passport_number, user_id)
VALUES ('AB123456', 1);

-- Insert data for the second user
INSERT INTO Person (middle_name, first_name, last_name, address, employment_info, phone_number, credit_status)
VALUES ('Johnson', 'Alice', 'Smith', '456 Elm Street', 'Doctor', '+12345678902', 'NULL');

INSERT INTO passport (passport_number, user_id)
VALUES ('CD789012', 2);

-- Insert data for the third user
INSERT INTO Person (middle_name, first_name, last_name, address, employment_info, phone_number, credit_status)
VALUES ('Williams', 'Robert', 'Jones', '789 Oak Street', 'Teacher', '+12345678903', 'NULL');

INSERT INTO passport (passport_number, user_id)
VALUES ('EF345678', 3);