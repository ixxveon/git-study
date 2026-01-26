SELECT * FROM salaries;

SELECT salary+1000 FROM salaries;

SELECT salary - salary*0.9 FROM salaries;

SELECT salary*30 FROM salaries;

SELECT * FROM employees;

SELECT DISTINCT gender FROM employees;

SELECT * FROM titles;

SELECT DISTINCT title FROM titles;

SELECT * FROM employees WHERE year(hire_date) > 1995;

SELECT * FROM dept_emp WHERE emp_no = 'd005';

SELECT * FROM salaries WHERE salary >= 60000 AND salary <= 80000;

SELECT * FROM employees WHERE gender = 'M' OR year(hire_date) < 1990;

SELECT * FROM dept_emp;

SELECT * FROM dept_emp WHERE dept_no = 'd001' and year(to_date) >= 2026;

SELECT * FROM salaries WHERE salary < 40000 OR salary > 100000;

SELECT * FROM employees WHERE gender = 'F' AND year(hire_date) >1995;

SELECT * FROM salaries WHERE salary >= 50000 AND salary<=70000;

select * FROM employees WHERE year(hire_date) >= 1990 AND YEAR(hire_date)<=1995;

SELECT * FROM employees WHERE emp_no IN('d003', 'd004', 'd005', 'd006');

SELECT * FROM employees WHERE last_name LIKE 'A%';

SELECT * FROM employees WHERE last_name LIKE '%n';

SELECT * FROM employees WHERE last_name LIKE '%an%';

SELECT * FROM employees WHERE last_name LIKE '_____';

SELECT * FROM employees WHERE first_name LIKE '%son%';

SELECT * FROM titles WHERE to_date IS NULL;

SELECT * FROM dept_emp WHERE emp_no IN ('d001','d003','d005');

SELECT * FROM employees WHERE emp_no IN (10001, 10005, 10010);

SELECT * FROM departments WHERE dept_name = 'Sales' OR dept_name = 'Development';