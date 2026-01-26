SELECT * FROM employees
ORDER BY birth_date DESC;

SELECT * FROM titles
ORDER BY to_date DESC;

SELECT max(salary) FROM salaries;
SELECT min(salary) FROM salaries;
SELECT avg(salary) FROM salaries;
SELECT sum(salary) FROM salaries;
SELECT count(salary) FROM salaries;

SELECT count(*) AS '직원 수' FROM employees;

SELECT count(*) AS '직원 수' FROM titles WHERE title = 'Engineer';

SELECT count(*) AS '직원 수' FROM employees WHERE year(hire_date) > 1964;

-- birth_date를 그룹화시켰을 때 max(emp_no)가 가장 큰 값이 출력됨
SELECT max(emp_no), birth_date FROM employees
GROUP BY birth_date;

-- 부서별 직원 수 구하기
-- - 부서 번호(dept_no) 조회
SELECT * FROM dept_emp;

SELECT count(*) AS '부서별 직원 수', dept_no FROM dept_emp 
GROUP BY dept_no; 

SELECT dept_no FROM dept_emp;

SELECT count(dept_no) FROM dept_emp;

SELECT count(DISTINCT dept_no) FROM dept_emp;

SELECT count(*), gender AS 'cnt' FROM employees 
GROUP BY gender;

SELECT * FROM titles;

SELECT  title, count(*) AS '직원 수' FROM titles 
GROUP BY title
HAVING count(*) >= 100000
ORDER BY title DESC;

-- dept_emp에서 직원 수가 5만 이상인 부서만 조회
SELECT * FROM dept_emp;

SELECT count(*), dept_no FROM dept_emp
GROUP BY dept_no 
HAVING count(*) >= 50000;

-- 현재 재직중인 직원들 중 직무별 직원 수가 200명 미만인 직무만 조회
-- to_date가 9999-01-01이 재직중
SELECT title, count(*) FROM titles
WHERE to_date = '9999-01-01'
GROUP BY title
HAVING count(*) < 200;



