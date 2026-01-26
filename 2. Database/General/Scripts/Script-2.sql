SELECT * FROM employees;

SELECT * FROM employees WHERE gender = 'M';

SELECT * FROM employees WHERE YEAR(hire_date) > 1989;

SELECT * FROM employees WHERE first_name = 'Georgi';

SELECT * FROM employees WHERE emp_no = 10010;

SELECT * FROM departments;

SELECT * FROM departments WHERE dept_name = 'Tech Sales';

INSERT INTO departments VALUES ('d011', 'AI Research');

INSERT INTO employees 
VALUES (
	999001,
	'1999-01-01',
	'Jaeseop',
	'Kim',
	'M',
	'2026-01-01'
);

SELECT * FROM titles;

INSERT INTO titles 
VALUES (
	1,
	'Engineer',
	now(),
	null
);

SELECT * FROM salaries;

INSERT INTO salaries 
VALUES(499001, 60000, '2026-01-01', '9999-01-01');

UPDATE salaries SET salary = 65000 WHERE emp_no = 1;

UPDATE employees SET gender = 'F' WHERE emp_no = 1;

UPDATE titles SET title = 'Senior Engineer' WHERE emp_no = 1;

DELETE FROM salaries WHERE emp_no = 10013;

DELETE FROM employees WHERE emp_no = 10013;