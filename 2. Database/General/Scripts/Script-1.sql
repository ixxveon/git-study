-- employees라는 데이터베이스 선택
use employees;

select emp_no, birth_date from employees;
select hire_date from employees;
select emp_no, from_date, to_date from dept_manager;
select * from departments;

insert into employees
values (1,
        '2000-01-01',
        'jaeseop',
        'kim',
        'M',
        now());

select * from employees;

INSERT INTO departments
values('d010',
       'Korea IT Department');

INSERT INTO employees 
VALUES (2,
        '2002-01-01',
        'gayeon',
        'lee',
        'F',
        now());

INSERT INTO dept_emp 
VALUES (1,
        'd010',
        now(),
        '9999-01-01');

SELECT * FROM departments;
SELECT * FROM employees;
SELECT * FROM dept_emp;

UPDATE employees
SET first_name = '길동'
WHERE emp_no = 10001;

UPDATE employees
SET last_name = '홍',
    hire_date = now()
WHERE emp_no = 10001;

SELECT * FROM employees;

UPDATE departments
SET dept_name = 'Tech Sales'
WHERE dept_no = 'd007';

UPDATE employees
SET birth_date = '1977-07-07'
WHERE last_name = 'Erie';

SELECT * FROM departments;

SELECT * FROM employees WHERE last_name='Erie';

DELETE FROM employees
WHERE emp_no = 10005;

DELETE FROM employees 
WHERE hire_date = '1993-05-12';

SELECT * FROM employees WHERE hire_date = '1993-05-12';

DELETE FROM employees 
WHERE emp_no = 28847;

SELECT * FROM employees
WHERE emp_no = 28847;

CREATE TABLE test_member (
	member_id varchar(50) COMMENT '아이디',
-- 	비밀번호는 저장할 때 암호화해서 저장하기 때문에 255
	member_pwd varchar(255) COMMENT '비밀번호',
	member_name varchar(50) COMMENT '이름',
	member_age TINYINT COMMENT '나이',
	member_in_date datetime COMMENT '가입일'
);

DROP TABLE test_member;

CREATE TABLE free_board (
	board_no int COMMENT '게시판 번호',
	board_titile varchar(100) COMMENT '게시판 제목',
	board_content text COMMENT '게시판 내용',
	board_date datetime COMMENT '게시판 작성일',
	board_views int COMMENT '게시판 조회수'
);

INSERT INTO free_board
VALUES (1,
		'개인 게시판',
		'Hello, World!',
		now(),
		10
);

INSERT INTO free_board
VALUES (2,
		'모두의 게시판',
		'Hello, Database!',
		now(),
		3
);

SELECT * FROM free_board;




