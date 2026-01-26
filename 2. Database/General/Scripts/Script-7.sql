-- 사번, 이름, 연봉 조회
SELECT *
FROM employees e
JOIN salaries s
ON e.emp_no = s.emp_no
WHERE s.to_date='9999-01-01';

-- 사번, 이름, 직무 조회 (현재 재직중인)
SELECT e.emp_no, first_name, title, to_date
FROM employees e
JOIN titles t
ON e.emp_no = t.emp_no 
WHERE to_date = '1999-01-01';

SELECT * FROM employees;
SELECT * FROM salaries;
SELECT * FROM titles;
-- 사번, 이름, 연봉, 직무
SELECT e.emp_no, e.first_name, s.salary, t.title
FROM employees e
JOIN salaries s
ON e.emp_no = s.emp_no
JOIN titles t
ON e.emp_no = t.emp_no; 

SELECT * 
FROM departments d
LEFT JOIN dept_manager dm
ON d.dept_no = dm.dept_no;

SELECT *
FROM dept_manager dm
RIGHT JOIN departments d
ON dm.dept_no = d.dept_no;






