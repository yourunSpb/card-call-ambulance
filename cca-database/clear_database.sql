declare
	cursor packages_cursor is select object_name from user_objects where object_type = 'PACKAGE';
	cursor procedures_cursor is select object_type, object_name from user_procedures;
	cursor sequences_cursor is select sequence_name from user_sequences;
	cursor views_cursor is select object_name from user_objects where object_type = 'VIEW';
	cursor tables_cursor is select table_name from user_tables;
	cursor types_cursor is select type_name from user_types;
	cursor programs_cursor is select program_name from user_scheduler_programs;
	cursor jobs_cursor is select job_name from user_scheduler_jobs;
	cursor mview_cursor is select object_name from user_objects where object_type = 'MATERIALIZED VIEW';
begin

	-- drop programs
	for i in programs_cursor loop
		SYS.DBMS_SCHEDULER.DISABLE(name => i.program_name);
		SYS.DBMS_SCHEDULER.DROP_PROGRAM(program_name => i.program_name);
	end loop;
	
	-- drop jobs
	for i in jobs_cursor loop
		SYS.DBMS_SCHEDULER.DISABLE(name => i.job_name);
		SYS.DBMS_SCHEDULER.DROP_JOB(job_name => i.job_name);
	end loop;
	
	-- drop packages_cursor
	for i in packages_cursor loop
		execute immediate 'DROP PACKAGE ' || i.object_name;
	end loop;
	
	-- drop procedures
	for i in procedures_cursor loop
		execute immediate 'DROP ' || i.object_type || ' ' || i.object_name;
	end loop;
	
	-- drop types
	for i in types_cursor loop
		execute immediate 'DROP TYPE ' || i.type_name || ' FORCE';
	end loop;
	
	-- drop sequnce
	for i in sequences_cursor loop
		execute immediate 'DROP SEQUENCE ' || i.sequence_name;
	end loop;
	
	-- drop views
	for i in views_cursor loop
		execute immediate 'DROP VIEW ' || i.object_name;
	end loop;

	--drop tables
	for i in tables_cursor loop
		execute immediate 'DROP TABLE ' || i.table_name || ' CASCADE CONSTRAINTS PURGE';
	end loop;
	
	-- drop mview
	for i in mview_cursor loop
		execute immediate 'DROP MATERIALIZED VIEW ' || i.object_name;
	end loop;
	
	
	execute immediate 'PURGE RECYCLEBIN';
END;
/
COMMIT;	
	