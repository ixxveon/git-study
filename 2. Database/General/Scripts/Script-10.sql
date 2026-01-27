CREATE TABLE MEMBER_notnull (
	id varchar(50) NOT NULL,
	pwd varchar(250) NOT NULL,
	name varchar(50),
	age int,
	in_date datetime
);

INSERT INTO member_notnull
VALUES ('test', 'qwer1234!', null, null, now());

INSERT INTO member_notnull (id, pwd, in_date)
VALUES ('test2', 'qwer1234!', now());

SELECT * FROM member_notnull;

######################################################################
CREATE TABLE member_unique (
	id varchar(50) NOT NULL UNIQUE,
	pwd varchar(250) NOT NULL 
);

INSERT INTO member_unique values('test', 'qwer1234!');

CREATE TABLE member_check (
	gender varchar(1) CHECK (gender IN('W', 'M'))
);

INSERT INTO member_check VALUES('W');
INSERT INTO member_check VALUES('w');
INSERT INTO member_check VALUES('asdasd');
SELECT * FROM member_check;

######################################################################
CREATE TABLE member_default (
	id varchar(50),
	in_date datetime DEFAULT now()
);

INSERT INTO member_default(id) values('test');
SELECT * FROM member_default;

######################################################################
CREATE TABLE member_pk (
	member_pk_id int PRIMARY KEY auto_increment,
	id varchar(50)
);

DROP TABLE member_pk;

INSERT INTO member_pk(id) VALUES ('test');
INSERT INTO member_pk VALUES (NULL, 'test');
SELECT * FROM member_pk;

########################################################################
CREATE TABLE member_primary(
	member_primary_id int AUTO_INCREMENT PRIMARY KEY,
	id varchar(50)
);

DROP TABLE member_primary;

CREATE TABLE board_foreign(
	board_foreign_id int PRIMARY KEY AUTO_INCREMENT,
	title varchar(300),
	writer_id int,
	CONSTRAINT fk_wriker FOREIGN KEY (writer_id)
	REFERENCES member_primary(member_primary_id)
	ON DELETE CASCADE  
);

DROP TABLE board_foreign;





INSERT INTO member_primary(id)
VALUES('test1'),
	  ('test2'),
	  ('test3');

SELECT * FROM member_primary;

INSERT INTO board_foreign(title, writer_id) VALUES('게시글 제목!!', 1);

SELECT * FROM board_foreign;

DELETE FROM member_primary 
WHERE member_primary_id = 1;

SELECT * FROM member_primary;













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

SELECT emp_no AS '사번', salary / 12 AS '월 급' FROM salaries s ;
SELECT emp_no + 50, first_name FROM employees
WHERE first_name = '길동';

SELECT DISTINCT gender FROM employees;

-- salaries 테이블에서 salary 컬럼의 값을 월급이라고 가정
-- 1. 월급 (기존값)
-- 2. 예상 연봉(salary * 12) 별칭은 "예상 연봉"
-- 3. 5% 인상 후의 예상 연봉 (salary * 12 * 1.05) 별칭은 "인상 후 예상 연봉"
SELECT salary FROM salaries;
SELECT salary * 12 AS '예상 연봉' FROM salaries s ;
SELECT salary * 12 * 1.05 AS '인상 후 예상 연봉' FROM salaries s ;

SELECT salary,
	   salary * 12 AS '예상 연봉',
	   salary * 12 * 1.05 AS '인상 후 예상 연봉'
FROM salaries s ;

SELECT emp_no, salary, from_date, to_date FROM salaries s 
WHERE salary >= 80000;

SELECT * FROM employees
WHERE emp_no < 10005;

-- 입사일이 1960년 1월 1일 이후이면서 성별이 남자인 직원 조회
SELECT * FROM employees
WHERE hire_date > '1960-01-01'
AND gender = 'M';

SELECT * FROM titles
WHERE title = 'Senior Engineer'
OR title = 'Engineer';

-- salaries 테이블에서 연봉이 50000 이상이면서 60000 이하인 직원 조회
SELECT * FROM salaries
WHERE salary >= 50000
AND salary <= 60000;


-- salaries 테이블에서 연봉이 50000 이상이면서 60000 이하인 직원 조회
SELECT * FROM salaries s 
WHERE salary BETWEEN 50000 AND 60000;

SELECT * FROM employees
WHERE hire_date BETWEEN '1995-01-01' AND '1995-12-31';

SELECT * FROM employees
WHERE first_name LIKE 'N%';

SELECT * FROM employees
WHERE first_name LIKE '%en';

SELECT * FROM employees
WHERE first_name LIKE '%ar%';

SELECT * FROM employees
WHERE first_name LIKE '_di__%';

SELECT * FROM employees
WHERE first_name LIKE 'G__';

SELECT * FROM titles
WHERE to_date IS NOT NULL;

SELECT * FROM departments 
WHERE dept_no IN ('d005','d009');








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




SELECT * FROM employees;
SELECT * FROM salaries;

-- Q1. employees 테이블에서 사원을 사번 기준으로 오름차순 정렬하여 조회하세요.
SELECT * FROM employees 
ORDER BY emp_no;

-- Q2. employees 테이블에서 사원을 사번 기준으로 내림차순 정렬하여 조회하세요.
SELECT * FROM employees
ORDER BY emp_no DESC;

-- Q3. salaries 테이블에서 급여를 높은 순으로 정렬하여 조회하세요.
SELECT * FROM salaries
ORDER BY salary DESC;

-- Q4. employees 테이블에서 입사일 기준으로 오래된 순서대로 정렬하여 조회하세요.
SELECT * FROM employees
ORDER BY hire_date;

-- Q5. employees 테이블에서 성별 기준으로 정렬한 뒤 사번 기준으로 정렬하여 조회하세요.
SELECT * FROM employees
ORDER BY gender, emp_no;

-- Q6. salaries 테이블에서 가장 높은 급여를 조회하세요.
SELECT max(salary) FROM salaries;

-- Q7. salaries 테이블에서 가장 낮은 급여를 조회하세요.
SELECT min(salary) FROM salaries;

-- Q8. salaries 테이블에서 평균 급여를 조회하세요.
SELECT avg(salary) FROM salaries;

-- Q9. salaries 테이블에서 전체 급여 합계를 조회하세요.
SELECT sum(salary) FROM salaries;

-- Q10. employees 테이블에서 전체 사원 수를 조회하세요.
SELECT count(*) FROM employees;

-- Q11. employees 테이블에서 성별별 사원 수를 조회하세요.
SELECT gender, count(*) FROM employees
GROUP BY gender;

-- Q12. dept_emp 테이블에서 부서별 사원 수를 조회하세요.
SELECT * FROM dept_emp;
SELECT dept_no, count(*) FROM dept_emp
GROUP BY dept_no;

-- Q13. titles 테이블에서 직급별 사원 수를 조회하세요.
SELECT * FROM titles;
SELECT title, count(*) FROM titles
GROUP BY title;

-- Q14. salaries 테이블에서 사번별 평균 급여를 조회하세요.
SELECT emp_no, avg(salary) FROM salaries
GROUP BY emp_no;

-- Q15. employees 테이블에서 입사 연도별 사원 수를 조회하세요.
SELECT YEAR(hire_date), count(*) FROM employees
GROUP BY YEAR(hire_date);

-- Q16. 성별별 사원 수 중 100000명 이상인 경우만 조회하세요.
SELECT gender, count(*) FROM employees
GROUP BY gender 
HAVING count(*) >= 100000;

-- Q17. 부서별 사원 수 중 20000명 이상인 부서만 조회하세요.
SELECT dept_no, count(*) FROM dept_emp
GROUP BY dept_no
HAVING count(*) >= 20000;

-- Q18. 직급별 사원 수 중 50000명 이상인 직급만 조회하세요.
SELECT title, count(*) FROM titles
GROUP BY title 
HAVING count(*) >= 50000;

-- Q19. 사번별 평균 급여가 80000 이상인 사원만 조회하세요.
SELECT emp_no, avg(salary) FROM salaries
GROUP BY emp_no 
HAVING avg(salary) >= 80000;

-- Q20. 입사 연도별 사원 수 중 10000명 이상인 연도만 조회하세요.
SELECT count(*) FROM employees;

SELECT YEAR(hire_date), count(*) AS '사원 수' FROM employees
GROUP BY YEAR(hire_date)
HAVING count(*) >= 10000;


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

SELECT *
FROM salaries s
WHERE (emp_no, salary) IN (SELECT emp_no, max(salary)
						  FROM salaries
						  GROUP BY emp_no);

SELECT emp_no, title, to_date
FROM titles
WHERE (emp_no, to_date) IN (SELECT emp_no, MAX(to_date)
							FROM titles
							GROUP BY emp_no);

SELECT emp_no, salary, to_date
FROM salaries s
WHERE (emp_no, to_date) IN (SELECT emp_no, max(to_date)
							FROM salaries s
							GROUP BY emp_no);

SELECT emp_no, dept_no, from_date
FROM dept_emp
WHERE (emp_no, from_date) IN (SELECT emp_no, min(from_date)
							  FROM dept_emp
							  GROUP BY emp_no);

SELECT * 
FROM (SELECT de.dept_no, avg(s.salary)
	  FROM dept_emp de
	  JOIN salaries s ON de.emp_no = s.emp_no
	  GROUP BY de.dept_no) a;

SELECT *
FROM (SELECT emp_no, salary , salary*1.1 AS increment_salary
	  FROM salaries 
	  ORDER BY increment_salary DESC
	  LIMIT 3) a 
WHERE a.increment_salary >= 170000;

-- dept_no, 평균 연봉(salary)을 조회 (인라인뷰)
-- 메인쿼리에서 평균 연봉이 70000 이상인 부서만 조회
SELECT *
FROM (SELECT dept_no, avg(salary) AS avg_salary
	  FROM dept_emp de
	  JOIN salaries s ON de.emp_no = s.emp_no
	  GROUP BY dept_no) t
WHERE avg_salary >= 70000;

SELECT *
FROM (SELECT emp_no, avg(salary) AS avg_salary
  	  FROM salaries 
	  GROUP BY emp_no) t
WHERE avg_salary >= 80000;  

	  
SELECT * FROM salaries;




SELECT * FROM salaries;
SELECT * FROM dept_emp;

CREATE TABLE db_tcl (
	id varchar(50)
);

INSERT INTO db_tcl VALUES ('test1');
INSERT INTO db_tcl VALUES ('test2');
INSERT INTO db_tcl VALUES ('test3');

SELECT * FROM db_tcl;
COMMIT;

UPDATE db_tcl
SET id = 'test4';

SELECT * FROM db_tcl;
ROLLBACK;


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

