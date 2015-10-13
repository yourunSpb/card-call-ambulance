--------------------------------------------------------------------------------
-- ����������� �� �������� ������� ������
--------------------------------------------------------------------------------
--1.�������� ��������
--create sequence SEQ_NAME_ID
--increment by 1
--start with 1;

--2.�������� ��������
--drop sequence SEQ_NAME_ID;

--3. ������� �������
--create table TABLE_NAME
--(
--    PK_NAME       NUMBER               not null,
--    SK_NAME       NUMBER               not null,
--    VARCHAR_EXAMPLE   VARCHAR2(20),
--    DATE_EXAMPLE DATE
--)
--tablespace "${ts_table}";

--4. ������� �������  
--drop table PERSONS cascade constraint;

   
--5. ������� ��������� ����
--alter table TABLE_NAME
--    add constraint PK_TABLE_NAME primary key (PK_NAME)
--        using index tablespace "${ts_index}";

--6. ������� ��������� ����
--alter table TABLE_NAME
--        drop primary key cascade;
--------------------------------------------------------------------------------

-- �������� ������� checklist
create table CHECKLIST
(
    CHECKLIST_ID            NUMBER          not null,
    CHECKLIST_NAME          VARCHAR2(255),
    CHECKLIST_DESCRIPTION   VARCHAR2(20)
);

alter table CHECKLIST
  add constraint PK_CHECKLIST primary key (CHECKLIST_ID);

create sequence SEQ_CHECKLIST_ID
  increment by 1
    start with 1;

-- �������� ������� question
create table QUESTION
(
    QUESTION_ID             NUMBER          not null,
    CHECKLIST_ID            NUMBER          not null,
    QUESTION_ORDER          NUMBER,
    QUESTION_TEXT           VARCHAR2(255)
);

alter table QUESTION
  add constraint PK_QUESTION primary key (QUESTION_ID);

create sequence SEQ_QUESTION_ID
  increment by 1
    start with 1;

-- �������� ������� answer
create table ANSWER
(
    ANSWER_ID               NUMBER          not null,
    QUESTION_ID             NUMBER          not null,
    ANSWER_VALUE            VARCHAR2(255)
);

alter table ANSWER
  add constraint PK_ANSWER primary key (ANSWER_ID);

create sequence SEQ_ANSWER_ID
  increment by 1
    start with 1;
    
commit;