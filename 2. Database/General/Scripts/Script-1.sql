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












