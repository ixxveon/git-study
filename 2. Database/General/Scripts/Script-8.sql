-- 입사일이 1993년 2월 19일 이면서 생일이 1964년 10월 24일 직원의 이름을 구하고
-- 다시 해당 이름으로 조건을 검색해서 사번(emp_no)을 구해야 하는 경우


SELECT first_name, last_name FROM employees
WHERE hire_date = '1993-02-19'
AND birth_date = '1964-10-24';

SELECT emp_no FROM employees
WHERE first_name = 'Conrado'
AND last_name = 'Serra';

-- 서브쿼리 사용
SELECT emp_no FROM employees
WHERE first_name = (SELECT first_name FROM employees
					WHERE hire_date = '1993-02-19'
					AND birth_date = '1964-10-24')
AND last_name = (SELECT last_name FROM employees
				 WHERE hire_date = '1993-02-19'
				 AND birth_date = '1964-10-24');

SELECT emp_no
FROM employees
WHERE (first_name, last_name) = (SELECT first_name, last_name
								 FROM employees 
								 WHERE hire_date = '1993-02-19'
								 AND birth_date = '1964-10-24');	

-- 직원 중에서 emp_no가 가장 높은 직원 찾기
SELECT first_name, last_name
FROM employees
WHERE emp_no = (SELECT max(emp_no) 
				FROM employees);

-- limit: 조회된 데이터 중 상단 하나만 (order by 필수)
SELECT max(emp_no), first_name, last_name, emp_no
FROM employees
GROUP BY first_name, last_name, emp_no
ORDER BY emp_no DESC
LIMIT 1;

SELECT first_name, last_name
FROM employees
ORDER BY emp_no DESC
LIMIT 1;

SELECT first_name, last_name
FROM employees
WHERE hire_date = (SELECT min(hire_date)
				   FROM employees);

-- 전체 평균보다 높은 연봉을 받는 이름 조회
-- 조인 없이
SELECT first_name, last_name
FROM employees
WHERE emp_no = (SELECT emp_no FROM salaries 
				WHERE salary > (SELECT avg(salary) FROM salaries)
				ORDER BY salary DESC
				LIMIT 1);

-- 평균 사번보다 높은 직원의 이름만 출력
SELECT first_name, last_name
FROM employees
WHERE emp_no >= (SELECT avg(emp_no)
				 FROM employees);

-- SELECT *
-- FROM employees e
-- WHERE hire_date > (SELECT avg(hire_date)
-- 				   FROM employees
-- 				   WHERE emp_no = e.emp_no);

SELECT emp_no, salary
FROM salaries
WHERE salary IN (SELECT salary
				 FROM salaries s
				 ORDER BY salary DESC);




