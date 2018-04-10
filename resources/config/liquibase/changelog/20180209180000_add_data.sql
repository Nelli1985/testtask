

INSERT INTO employee(id, employee_name, hire_date, type, position) VALUES (nextval('employee_seq'), 'Mr. Exec', '2015-12-15', 'EXECUTIVE', 'Senjor VP');
INSERT INTO executive_employee(employee_id, email, phone_number, parking_space_code) VALUES (currval('employee_seq'), 'mr.exec@elbonia.elb', '549861169', 'L5216');
INSERT INTO employee_salary(employee_id, assign_date, salary) VALUES (currval('employee_seq'), '2015-12-15', '1500.00');
INSERT INTO employee_salary(employee_id, assign_date, salary) VALUES (currval('employee_seq'), '2017-02-15', '1700.00');
INSERT INTO employee_salary(employee_id, assign_date, salary) VALUES (currval('employee_seq'), '2017-02-19', '1600.00');
INSERT INTO employee_salary(employee_id, assign_date, salary) VALUES (currval('employee_seq'), '2017-05-19', '2600.50');

INSERT INTO employee_bonus(employee_id, bonus_date, bonus_amount) VALUES (currval('employee_seq'), '2016-11-15', '1500.00');
INSERT INTO employee_bonus(employee_id, bonus_date, bonus_amount) VALUES (currval('employee_seq'), '2017-03-15', '1700.00');
INSERT INTO employee_bonus(employee_id, bonus_date, bonus_amount) VALUES (currval('employee_seq'), '2017-03-19', '1600.00');
INSERT INTO employee_bonus(employee_id, bonus_date, bonus_amount) VALUES (currval('employee_seq'), '2017-06-19', '2900.50');
INSERT INTO employee_bonus(employee_id, bonus_date, bonus_amount) VALUES (currval('employee_seq'), '2017-07-19', '2600.50');

---

INSERT INTO employee(id, employee_name, hire_date, type, position) VALUES (nextval('employee_seq'), 'Regular Joe', '2016-02-25', 'ASSOCIATE', 'Writer of papers');
INSERT INTO associate_employee(employee_id, favourite_tool, coffee_preference) VALUES (currval('employee_seq'), 'Pencil', 'Boiling hot with a hint of cinnamon');
INSERT INTO employee_salary(employee_id, assign_date, salary) VALUES (currval('employee_seq'), '2016-02-25', '1400.00');
INSERT INTO employee_salary(employee_id, assign_date, salary) VALUES (currval('employee_seq'), '2017-02-12', '1100.00');
INSERT INTO employee_salary(employee_id, assign_date, salary) VALUES (currval('employee_seq'), '2017-02-14', '1550.00');
INSERT INTO employee_salary(employee_id, assign_date, salary) VALUES (currval('employee_seq'), '2017-05-16', '2900.50');

INSERT INTO employee_bonus(employee_id, bonus_date, bonus_amount) VALUES (currval('employee_seq'), '2017-09-19', '20.50');

