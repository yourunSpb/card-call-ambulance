--------------------------------------------------------------------------------
-- Руководство по созданию простых таблиц
--------------------------------------------------------------------------------
--1.создание сиквенса
--create sequence SEQ_NAME_ID
--increment by 1
--start with 1;

--2.удаление сиквенса
--drop sequence SEQ_NAME_ID;

--3. создать таблицу
--create table TABLE_NAME
--(
--    PK_NAME       NUMBER               not null,
--    SK_NAME       NUMBER               not null,
--    VARCHAR_EXAMPLE   VARCHAR2(20),
--    DATE_EXAMPLE DATE
--)
--tablespace "${ts_table}";

--4. удалить таблицу  
--drop table PERSONS cascade constraint;

   
--5. создать приватный ключ
--alter table TABLE_NAME
--    add constraint PK_TABLE_NAME primary key (PK_NAME)
--        using index tablespace "${ts_index}";

--6. удалить первичный ключ
--alter table TABLE_NAME
--        drop primary key cascade;
--------------------------------------------------------------------------------

-- создание таблицы checklist
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

-- создание таблицы question
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

-- создание таблицы answer
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