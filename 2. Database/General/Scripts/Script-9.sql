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

