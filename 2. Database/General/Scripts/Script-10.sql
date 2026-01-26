SELECT * FROM employees;
-- emp_no, salary_ from_date, to_date
SELECT * FROM salaries;
-- emp_no, dept_no, from_date, to_date
SELECT* FROM dept_emp;
SELECT * FROM titles;
SELECT * FROM departments;

############################################################
-- Q1. 사원의 사번(emp_no)과 급여(salary)를 함께 조회하세요.
SELECT e.emp_no, salary
FROM employees e
JOIN salaries s ON e.emp_no = s.emp_no;

-- Q2. 사원의 사번(emp_no), 이름(first_name)과 부서 정보(dept_name)를 함께 조회하세요.
-- employees.emp_no랑 dept_emp.emp_no 조인 // dept_emp.dept_no랑 department.dept_no 조인
SELECT e.emp_no, e.first_name, d.dept_name
FROM employees e
JOIN dept_emp de ON e.emp_no = de.emp_no
JOIN departments d ON de.dept_no = d.dept_no;

-- Q3. 현재 재직 중인 사원의 이름(first_name)과 부서(dept_name)를 조회하세요.
SELECT e.first_name, d.dept_name
FROM employees e
JOIN dept_emp de ON e.emp_no = de.emp_no
JOIN departments d ON de.dept_no = d.dept_no;

-- Q4. 급여가 80000 이상인 사원의 이름(first_name)과 급여(salary)를 조회하세요. 
SELECT first_name, salary
FROM employees e
JOIN salaries s ON e.emp_no = s.emp_no
WHERE salary >= 80000;

-- Q5. 사원의 이름(first_name)과 급여(salary)를 급여가 높은 순으로 조회하세요.
SELECT first_name, salary
FROM employees e
JOIN salaries s ON e.emp_no = s.emp_no
ORDER BY salary DESC;

-- Q6. 부서 이름(dept_name)과 부서별 사원 수(count)를 조회하세요.
-- - dept_name 컬럼은 departments 테이블에 있음
-- - dept_emp에 사원 수(emp_no의 수)가 있음
SELECT dept_name, count(emp_no) AS '부서별 사원 수'
FROM departments d
JOIN dept_emp de ON d.dept_no = de.dept_no 
GROUP BY de.dept_no;


-- Q7. 부서별 사원 수가 20000명 이상인 부서의 이름(dept_name)과 사원수(count)만 조회하세요.
SELECT dept_name, count(emp_no) AS '사원수'
FROM departments d
JOIN dept_emp de ON d.dept_no = de.dept_no 
GROUP BY de.dept_no 
HAVING count(de.emp_no) >= 20000;

-- Q8. 성별이 F인 사원의 이름(first_name)과 부서(dept_name)를 조회하세요.
SELECT first_name, dept_name
FROM employees e
JOIN dept_emp de ON e.emp_no = de.emp_no 
JOIN departments d ON de.dept_no = d.dept_no 
WHERE gender = 'F';

-- Q9. 입사일이 1995년 이후인 사원의 이름(first_name)과 부서(dept_name)를 조회하세요.
SELECT first_name, dept_name
FROM employees e 
JOIN dept_emp de ON e.emp_no = de.emp_no 
JOIN departments d ON de.dept_no = d.dept_no 
WHERE year(hire_date) >= 1995;

-- Q10. 부서 이름(dept_name)과 부서별 평균 급여(avg_salary)를 조회하세요.
SELECT dept_name, avg(salary) AS avg_salary
FROM departments d
JOIN dept_emp de ON d.dept_no = de.dept_no 
JOIN salaries s ON de.emp_no = s.emp_no 
GROUP BY de.dept_no

-- Q11. 현재 재직 중인 사원의 이름, 부서, 급여를 급여 내림차순으로 조회하세요.
SELECT first_name, dept_name, salary
FROM employees e
JOIN dept_emp de ON e.emp_no = de.emp_no 
JOIN departments d ON de.dept_no = d.dept_no
JOIN salaries s ON de.emp_no = s.emp_no 
WHERE s.to_date = '9999-01-01'
ORDER BY salary DESC;

-- Q12. 부서별 평균 급여가 70000 이상인 부서만 조회하세요.
SELECT dept_name, avg(salary) AS '부서별 평균 급여'
FROM departments d 
JOIN dept_emp de ON d.dept_no = de.dept_no 
JOIN salaries s ON de.emp_no = s.emp_no 
GROUP BY de.dept_no
HAVING avg(salary) >= 70000;

-- Q13. 직급별 사원 수를 조회하세요.
SELECT title, count(title) AS '직급별 사원 수'
FROM titles t
GROUP BY title;

-- Q14. 급여 상위 사원의 이름, 직급, 급여를 조회하세요.
SELECT first_name, title, max(salary)
FROM employees e
JOIN titles t ON e.emp_no = t.emp_no 
JOIN salaries s ON t.emp_no = s.emp_no
GROUP BY first_name, title;


-- --------------------------------------------------------- LEFT JOIN
-- Q15. 모든 사원과 부서 정보를 조회하세요 (부서가 없어도 포함).
SELECT e.emp_no, e.first_name, d.dept_name
FROM employees e
LEFT JOIN dept_emp de ON e.emp_no = de.emp_no
LEFT JOIN departments d ON de.dept_no = d.dept_no;
-- 
-- 
-- 
-- 
-- 
-- 
-- 
-- 
-- 
-- 
-- 
-- 
-- 
