/*==============================================================*/
/*  DROP TALBES                                                 */
/*==============================================================*/

alter table ANSWER
   drop primary key cascade;

drop table ANSWER cascade constraints;

alter table BRIGADE
   drop primary key cascade;
   
drop table BRIGADE cascade constraints;

alter table BRIGADE_PROFILE
   drop primary key cascade;

drop table BRIGADE_PROFILE cascade constraints;

alter table CARD_CALL
   drop primary key cascade;

drop table CARD_CALL cascade constraints;

alter table DEPARTMENT
   drop primary key cascade;

drop table DEPARTMENT cascade constraints;

alter table LOOKUP_SECTION
   drop primary key cascade;

drop table LOOKUP_SECTION cascade constraints;

drop index LOOKUP_CARD_CALL_ID;

alter table MEDIC
   drop primary key cascade;

drop table MEDIC cascade constraints;

alter table MEDIC_POSITION
   drop primary key cascade;

drop table MEDIC_POSITION cascade constraints;

alter table MEDIC_USER
   drop primary key cascade;

drop table MEDIC_USER cascade constraints;

alter table QUESTION
   drop primary key cascade;

drop table QUESTION cascade constraints;

alter table SECTION
   drop primary key cascade;

drop table SECTION cascade constraints;

alter table USER_ROLE
   drop primary key cascade;

drop table USER_ROLE cascade constraints;


alter table ANSWER
   drop constraint FK_ANSWER_QUESTION;

alter table BRIGADE
   drop constraint FK_BRIGADE_PROFILE;

alter table BRIGADE
   drop constraint FK_BRIGADE_DEPARTMET;

alter table CARD_CALL
   drop constraint FK_CARD_CALL_BRIGADE;

alter table CARD_CALL
   drop constraint FK_CARD_CAL_REFERENCE_MEDIC;

alter table COMPOSITION
   drop constraint FK_COMPOSIT_BRIGADE;

alter table COMPOSITION
   drop constraint FK_COMPOSIT_REFERENCE_MEDIC;

alter table LOOKUP_SECTION
   drop constraint FK_LOOKUP_CARD_CALL;

alter table LOOKUP_SECTION
   drop constraint FK_LOOKUP_SECTION;

alter table LOOKUP_SECTION
   drop constraint FK_LOOKUP_QUESTION;

alter table LOOKUP_SECTION
   drop constraint FK_LOOKUP_S_REFERENCE_ANSWER;

alter table MEDIC
   drop constraint FK_MEDIC_POSITION;

alter table MEDIC
   drop constraint FK_MEDIC_USER;

alter table MEDIC_ROLE
   drop constraint FK_ROLE_MEDIC;

alter table MEDIC_ROLE
   drop constraint FK_MEDIC_ROLE;

alter table QUESTION
   drop constraint FK_QUESTION_SECTION;

drop index COMPOSITION_BRIGADE_ID;

drop index COMPOSITION_MEDIC_ID;

alter table COMPOSITION
   drop primary key cascade;

drop table COMPOSITION cascade constraints;

drop index USER_ROLE_ID;

drop index USER_MEDIC_ID;

alter table MEDIC_ROLE
   drop primary key cascade;

drop table MEDIC_ROLE cascade constraints;

drop sequence SEQ_ANSWER_ID;

drop sequence SEQ_BRIGADE_ID;

drop sequence SEQ_CARD_ID;

drop sequence SEQ_DEP_ID;

drop sequence SEQ_LOOKUP_ID;

drop sequence SEQ_MEDIC_ID;

drop sequence SEQ_POSITION_ID;

drop sequence SEQ_PROFILE_ID;

drop sequence SEQ_QUESTION_ID;

drop sequence SEQ_ROLE_ID;

drop sequence SEQ_SECTION_ID;

drop sequence SEQ_USER_ID;

create sequence SEQ_ANSWER_ID
increment by 1
start with 1;

create sequence SEQ_BRIGADE_ID
increment by 1
start with 1;

create sequence SEQ_CARD_ID
increment by 1
start with 1;

create sequence SEQ_DEP_ID
increment by 1
start with 1;

create sequence SEQ_LOOKUP_ID
increment by 1
start with 1;

create sequence SEQ_MEDIC_ID
increment by 1
start with 1;

create sequence SEQ_POSITION_ID
increment by 1
start with 1;

create sequence SEQ_PROFILE_ID
increment by 1
start with 1;

create sequence SEQ_QUESTION_ID
increment by 1
start with 1;

create sequence SEQ_ROLE_ID
increment by 1
start with 1;

create sequence SEQ_SECTION_ID
increment by 1
start with 1;

create sequence SEQ_USER_ID
increment by 1
start with 1;


/*==============================================================*/
/* Table: ANSWER                                                */
/*==============================================================*/
create table ANSWER 
(
   ANSWER_ID            NUMBER               not null,
   QUESTION_ID          NUMBER,
   ANSWER_VALUE         VARCHAR2(255)
);

alter table ANSWER
   add constraint PK_ANSWER primary key (ANSWER_ID);


/*==============================================================*/
/* Table: BRIGADE                                               */
/*==============================================================*/
create table BRIGADE 
(
   BRIGADE_ID           NUMBER               not null,
   DEPARTMENT_ID        NUMBER,
   PROFILE_ID           NUMBER
);

alter table BRIGADE
   add constraint PK_BRIGADE primary key (BRIGADE_ID);

/*==============================================================*/
/* Table: BRIGADE_PROFILE                                       */
/*==============================================================*/
create table BRIGADE_PROFILE 
(
   PROFILE_ID           NUMBER               not null,
   REDUCTION            VARCHAR2(7),
   TRANSCRIPT           VARCHAR2(20)
);

alter table BRIGADE_PROFILE
   add constraint PK_BRIGADE_PROFILE primary key (PROFILE_ID);

/*==============================================================*/
/* Table: CARD_CALL                                             */
/*==============================================================*/
create table CARD_CALL 
(
   CARD_CALL_ID         number               not null,
   CREATE_DATE_TIME     DATE,
   STATUS               VARCHAR2(20),
   UPDATED_BY           NUMBER,
   UPDATE_DATE_TIME     DATE,
   CARD_CALL_CONTENT    BLOB,
   BRIGADE_ID           NUMBER
);

alter table CARD_CALL
   add constraint PK_CARD_CALL primary key (CARD_CALL_ID);

/*==============================================================*/
/* Table: COMPOSITION                                           */
/*==============================================================*/
create table COMPOSITION 
(
   MEDIC_ID             NUMBER               not null,
   BRIGADE_ID           NUMBER               not null
);

alter table COMPOSITION
   add constraint PK_COMPOSITION primary key (MEDIC_ID, BRIGADE_ID);

/*==============================================================*/
/* Index: COMPOSITION_MEDIC_ID                                  */
/*==============================================================*/
create index COMPOSITION_MEDIC_ID on COMPOSITION (
   MEDIC_ID ASC
);

/*==============================================================*/
/* Index: COMPOSITION_BRIGADE_ID                                */
/*==============================================================*/
create index COMPOSITION_BRIGADE_ID on COMPOSITION (
   BRIGADE_ID ASC
);

/*==============================================================*/
/* Table: DEPARTMENT                                            */
/*==============================================================*/
create table DEPARTMENT 
(
   DEPARTMENT_ID        NUMBER               not null,
   DEPARTMENT_NAME      VARCHAR2(100)
);

alter table DEPARTMENT
   add constraint PK_DEPARTMENT primary key (DEPARTMENT_ID);

/*==============================================================*/
/* Table: LOOKUP_SECTION                                        */
/*==============================================================*/
create table LOOKUP_SECTION 
(
   LOOKUP_ID            NUMBER               not null,
   CARD_CALL_ID         NUMBER               not null,
   SECTION_ID           NUMBER,
   QUESTION_ID          NUMBER,
   ANSWER_ID            NUMBER,
   ANSWER_VALUE         VARCHAR2(1000)
);

alter table LOOKUP_SECTION
   add constraint PK_LOOKUP_SECTION primary key (LOOKUP_ID);

/*==============================================================*/
/* Index: LOOKUP_CARD_CALL_ID                                   */
/*==============================================================*/
create index LOOKUP_CARD_CALL_ID on LOOKUP_SECTION (
   CARD_CALL_ID ASC
);

/*==============================================================*/
/* Table: MEDIC                                                 */
/*==============================================================*/
create table MEDIC 
(
   MEDIC_ID             NUMBER               not null,
   POSITION_ID          NUMBER,
   USER_ID              NUMBER
);

alter table MEDIC
   add constraint PK_MEDIC primary key (MEDIC_ID);

/*==============================================================*/
/* Table: MEDIC_POSITION                                        */
/*==============================================================*/
create table MEDIC_POSITION 
(
   POSITION_ID          NUMBER               not null,
   POSITION_VALUE       VARCHAR2(100)
);

alter table MEDIC_POSITION
   add constraint PK_MEDIC_POSITION primary key (POSITION_ID);

/*==============================================================*/
/* Table: MEDIC_ROLE                                            */
/*==============================================================*/
create table MEDIC_ROLE 
(
   MEDIC_ID             NUMBER               not null,
   ROLE_ID              NUMBER               not null
);

alter table MEDIC_ROLE
   add constraint PK_MEDIC_ROLE primary key (MEDIC_ID, ROLE_ID);

/*==============================================================*/
/* Index: USER_MEDIC_ID                                         */
/*==============================================================*/
create index USER_MEDIC_ID on MEDIC_ROLE (
   MEDIC_ID ASC
);

/*==============================================================*/
/* Index: USER_ROLE_ID                                          */
/*==============================================================*/
create index USER_ROLE_ID on MEDIC_ROLE (
   ROLE_ID ASC
);

/*==============================================================*/
/* Table: MEDIC_USER                                            */
/*==============================================================*/
create table MEDIC_USER 
(
   USER_ID              NUMBER               not null,
   FIRST_NAME           VARCHAR2(50),
   MIDDLE_NAME          VARCHAR2(50),
   LAST_NAME            VARCHAR2(50),
   E_MAIL_ADDRESS       VARCHAR2(50)
);

alter table MEDIC_USER
   add constraint PK_MEDIC_USER primary key (USER_ID);

/*==============================================================*/
/* Table: QUESTION                                              */
/*==============================================================*/
create table QUESTION 
(
   QUESTION_ID          NUMBER               not null,
   SECTION_ID           NUMBER               not null,
   QUESTION_ORDER       NUMBER,
   QUESTION_TEXT        VARCHAR2(255)
);

alter table QUESTION
   add constraint PK_QUESTION primary key (QUESTION_ID);

/*==============================================================*/
/* Table: SECTION                                               */
/*==============================================================*/
create table SECTION 
(
   SECTION_ID           NUMBER               not null,
   SECTION_NAME         VARCHAR2(255)        not null,
   SECTION_DESCRIPTION  VARCHAR2(20)
);

alter table SECTION
   add constraint PK_SECTION primary key (SECTION_ID);

/*==============================================================*/
/* Table: USER_ROLE                                             */
/*==============================================================*/
create table USER_ROLE 
(
   ROLE_ID              NUMBER               not null,
   ROLE_VALUE           VARCHAR2(50)
);

alter table USER_ROLE
   add constraint PK_USER_ROLE primary key (ROLE_ID);

alter table ANSWER
   add constraint FK_ANSWER_QUESTION foreign key (QUESTION_ID)
      references QUESTION (QUESTION_ID);

alter table BRIGADE
   add constraint FK_BRIGADE_PROFILE foreign key (PROFILE_ID)
      references BRIGADE_PROFILE (PROFILE_ID);

alter table BRIGADE
   add constraint FK_BRIGADE_DEPARTMET foreign key (DEPARTMENT_ID)
      references DEPARTMENT (DEPARTMENT_ID);

alter table CARD_CALL
   add constraint FK_CARD_CALL_BRIGADE foreign key (BRIGADE_ID)
      references BRIGADE (BRIGADE_ID);

alter table CARD_CALL
   add constraint FK_CARD_CAL_REFERENCE_MEDIC foreign key (UPDATED_BY)
      references MEDIC (MEDIC_ID);

alter table COMPOSITION
   add constraint FK_COMPOSIT_BRIGADE foreign key (BRIGADE_ID)
      references BRIGADE (BRIGADE_ID);

alter table COMPOSITION
   add constraint FK_COMPOSIT_REFERENCE_MEDIC foreign key (MEDIC_ID)
      references MEDIC (MEDIC_ID);

alter table LOOKUP_SECTION
   add constraint FK_LOOKUP_CARD_CALL foreign key (CARD_CALL_ID)
      references CARD_CALL (CARD_CALL_ID);

alter table LOOKUP_SECTION
   add constraint FK_LOOKUP_SECTION foreign key (SECTION_ID)
      references SECTION (SECTION_ID);

alter table LOOKUP_SECTION
   add constraint FK_LOOKUP_QUESTION foreign key (QUESTION_ID)
      references QUESTION (QUESTION_ID);

alter table LOOKUP_SECTION
   add constraint FK_LOOKUP_S_REFERENCE_ANSWER foreign key (ANSWER_ID)
      references ANSWER (ANSWER_ID);

alter table MEDIC
   add constraint FK_MEDIC_POSITION foreign key (POSITION_ID)
      references MEDIC_POSITION (POSITION_ID);

alter table MEDIC
   add constraint FK_MEDIC_USER foreign key (USER_ID)
      references MEDIC_USER (USER_ID);

alter table MEDIC_ROLE
   add constraint FK_ROLE_MEDIC foreign key (ROLE_ID)
      references USER_ROLE (ROLE_ID);

alter table MEDIC_ROLE
   add constraint FK_MEDIC_ROLE foreign key (MEDIC_ID)
      references MEDIC (MEDIC_ID);

alter table QUESTION
   add constraint FK_QUESTION_SECTION foreign key (SECTION_ID)
      references SECTION (SECTION_ID);

COMMIT;