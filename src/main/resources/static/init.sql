DROP TABLE MEMBER;
DROP TABLE NOTICE;
DROP TABLE PRIVATEGAME;
DROP TABLE CHAMPION;
DROP TABLE PRIVATEGAME_DETAIL;
DROP TABLE FRIEND;
DROP SEQUENCE SEQ_MNO;
DROP SEQUENCE SEQ_PNO;
DROP SEQUENCE SEQ_NNO;
DROP SEQUENCE SEQ_FNO;
CREATE TABLE MEMBER (
  USER_NO     NUMBER PRIMARY KEY,
  NICKNAME    VARCHAR2(30) NOT NULL UNIQUE,
  USER_ID     VARCHAR2(30) NOT NULL UNIQUE,
  USER_PW     VARCHAR2(30) NOT NULL
);
CREATE SEQUENCE SEQ_MNO
NOCACHE;
CREATE TABLE FRIEND (
    USER_NO NUMBER,
    FRIEND_NO NUMBER,
    STATUS CHAR(1),

    CONSTRAINT FRD_PK PRIMARY KEY(USER_NO, FRIEND_NO)
);
CREATE SEQUENCE SEQ_FNO
NOCACHE;



CREATE TABLE PRIVATEGAME (
  PGAME_NO NUMBER PRIMARY KEY,
  USER_NO NUMBER,
  PGAME_TITLE varchar2(60),
  PGAME_COLOR NUMBER,
  PGAME_POSITION NUMBER,
  PGAME_CHAMPION NUMBER,
  PGAME_K NUMBER,
  PGAME_D NUMBER,
  PGAME_A NUMBER,
  PGAME_WINLOSE number,
  PGAME_MVP VARCHAR2(30),
   FOREIGN KEY(USER_NO) REFERENCES MEMBER(USER_NO)
);
CREATE SEQUENCE SEQ_PNO
NOCACHE;

CREATE TABLE CHAMPION (
    CHAMPION_NO NUMBER ,
    CHAMPION_NAME VARCHAR2(30)
);

CREATE TABLE NOTICE (
  NOTICE_NO NUMBER PRIMARY KEY,
  NOTICE_TITLE VARCHAR2(60),
  NOTICE_CONTENT VARCHAR2(300),
  WRITER VARCHAR2(30),
  WRITE_DATE DATE,
  NOTICE_COUNT NUMBER
   );
   CREATE SEQUENCE SEQ_NNO
NOCACHE;