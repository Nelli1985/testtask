

CREATE TABLE employee
(
    id IDENTITY NOT NULL PRIMARY KEY,
    employee_name VARCHAR(255) NOT NULL,
    hire_date DATE NOT NULL,
    type VARCHAR(255) NOT NULL,
    position VARCHAR(255) NOT NULL
);
CREATE SEQUENCE employee_seq MINVALUE 1 START WITH 1 INCREMENT BY 1;
ALTER TABLE employee ALTER COLUMN id SET DEFAULT  nextval('employee_seq');

CREATE TABLE employee_salary
(
    id IDENTITY NOT NULL PRIMARY KEY,
    employee_id BIGINT NOT NULL,
    assign_date DATE NOT NULL,
    salary DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employee(id)
);
CREATE SEQUENCE employee_salary_seq MINVALUE 1 START WITH 1 INCREMENT BY 1;
ALTER TABLE employee_salary ALTER COLUMN id SET DEFAULT  nextval('employee_salary_seq');

CREATE TABLE employee_bonus
(
    id IDENTITY NOT NULL PRIMARY KEY,
    employee_id BIGINT NOT NULL,
    bonus_date DATE NOT NULL,
    bonus_amount DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employee(id)
);
CREATE SEQUENCE employee_bonus_seq MINVALUE 1 START WITH 1 INCREMENT BY 1;
ALTER TABLE employee_bonus ALTER COLUMN id SET DEFAULT  nextval('employee_bonus_seq');

CREATE TABLE executive_employee
(
    employee_id  BIGINT   NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL,
    parking_space_code VARCHAR(255) NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employee(id)
);

CREATE TABLE associate_employee
(
    employee_id  BIGINT  NOT NULL,
    favourite_tool VARCHAR(255) NOT NULL,
    coffee_preference VARCHAR(255) NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employee(id)
);
