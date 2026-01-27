SELECT * FROM dept_emp;
SELECT * FROM departments;
SELECT * FROM employees;
-- 10번 --
CREATE TABLE position (
	id int PRIMARY KEY auto_increment,
	position_name varchar(50)
);
-- id, name, age, gender, dept, salary, position_id

-- 11번 --
SELECT name, dept FROM employees;

-- 12번 --
INSERT INTO employees 
VALUES (
		1,
		'짱구',
		5,
		'M',
		'개발팀',
		9800,
		5
);

-- 13번 --
UPDATE employees 
SET salary = 3500 
WHERE name = '김민수';

-- 14번 --
DELETE FROM employees WHERE name = '김민수';

-- 15번 --
SELECT name FROM employees
WHERE dept = '개발팀' AND salary >= 3000;

-- 16번 --
SELECT name FROM employees
WHERE dept = '기획팀' OR dept = '마케팅팀';

-- 17번 --
SELECT name FROM employees
WHERE name LIKE '김%';

-- 18번 --
SELECT e.name, p.position_name
FROM employees e
JOIN position p ON e.id = p.id;
