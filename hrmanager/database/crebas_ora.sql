/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2012/5/8 0:02:07                             */
/*==============================================================*/


DROP TABLE IF EXISTS HR_AWARD_WINNING;

DROP TABLE IF EXISTS HR_EDUCATION_EXPERIENCE;

DROP TABLE IF EXISTS HR_EMPLOYEE;

DROP TABLE IF EXISTS HR_FAMILY_MEMBERS;

DROP TABLE IF EXISTS HR_ORGNIZATION;

DROP TABLE IF EXISTS HR_VOCATIONAL_CERTIFICATE;

DROP TABLE IF EXISTS HR_WORK_EXPERIENCE;

DROP TABLE IF EXISTS SYS_CODE;

DROP TABLE IF EXISTS SYS_IMAGE;

/*==============================================================*/
/* Table: HR_AWARD_WINNING                                      */
/*==============================================================*/
CREATE TABLE HR_AWARD_WINNING
(
   ID                   VARCHAR(32) NOT NULL COMMENT '唯一ID',
   EMPLOYEEID           VARCHAR(32) NOT NULL COMMENT '员工ID',
   NAME                 VARCHAR(256) COMMENT '奖励名称',
   LEVEL                VARCHAR(32) COMMENT '级别',
   GETDATE              DATE COMMENT '获取时间',
   PRIMARY KEY (ID)
);

ALTER TABLE HR_AWARD_WINNING COMMENT '获奖经历';

/*==============================================================*/
/* Table: HR_EDUCATION_EXPERIENCE                               */
/*==============================================================*/
CREATE TABLE HR_EDUCATION_EXPERIENCE
(
   ID                   VARCHAR(32) NOT NULL COMMENT '员工ID',
   EMPLOYEEID           VARCHAR(32) NOT NULL COMMENT '人员ID',
   SCHOOL               VARCHAR(236) COMMENT '学校',
   SPECIALTY            VARCHAR(128) COMMENT '专业',
   EDUCATIONAL_LEVEL    VARCHAR(32) COMMENT '学历',
   BEGIN_DATE           DATE COMMENT '开始时间',
   END_DATE             DATE COMMENT '结束时间',
   PRIMARY KEY (ID)
);

ALTER TABLE HR_EDUCATION_EXPERIENCE COMMENT '教育经历';

/*==============================================================*/
/* Table: HR_EMPLOYEE                                           */
/*==============================================================*/
CREATE TABLE HR_EMPLOYEE
(
   ID                   VARCHAR(32) NOT NULL COMMENT '员工ID',
   ORGID                VARCHAR(32) COMMENT '部门ID',
   NAME                 VARCHAR(128) NOT NULL COMMENT '姓名',
   GENDER               VARCHAR(1) COMMENT '性别',
   HOMETOWN             VARCHAR(64) COMMENT '籍贯',
   BIRTHDAY             DATE COMMENT '生日',
   ADDRESS              VARCHAR(256) COMMENT '地址',
   ZIPCODE              VARCHAR(16) COMMENT '邮编',
   POLITICAL_LANDSCAPE  VARCHAR(32) COMMENT '政治面貌',
   DEGREE               VARCHAR(32) COMMENT '学位',
   EDUCATIONAL_LEVEL    VARCHAR(32) COMMENT '学历',
   GRADUATE_SCHOOL      VARCHAR(128) COMMENT '毕业学校',
   GRADUATE_DATE        DATE COMMENT '毕业时间',
   SPECIALTY            VARCHAR(32) COMMENT '所学专业',
   TITLES               VARCHAR(32) COMMENT '职称',
   TELEPHONE1           VARCHAR(32) COMMENT '联系电话1',
   TELEPHONE2           VARCHAR(32) COMMENT '联系电话2',
   TELEPHONE3           VARCHAR(32) COMMENT '联系电话3',
   EMAIL                VARCHAR(128) COMMENT '电子邮件地址',
   AVATARID             VARCHAR(32) COMMENT '头像ID',
   PRIMARY KEY (ID)
);

/*==============================================================*/
/* Table: HR_FAMILY_MEMBERS                                     */
/*==============================================================*/
CREATE TABLE HR_FAMILY_MEMBERS
(
   ID                   VARCHAR(32) NOT NULL COMMENT '唯一ID',
   EMPLOYEEID           VARCHAR(32) NOT NULL COMMENT '员工ID',
   RELATION_SHIP        VARCHAR(32) COMMENT '关系',
   NAME                 VARCHAR(32) COMMENT '姓名',
   BIRTHDAY             VARCHAR(32) COMMENT '生日',
   COMPANY              VARCHAR(32) COMMENT '所在公司',
   DUTY                 VARCHAR(32) COMMENT '职务',
   TELEPHONE            VARCHAR(32) COMMENT '联系电话',
   PRIMARY KEY (ID)
);

ALTER TABLE HR_FAMILY_MEMBERS COMMENT '家庭成员';

/*==============================================================*/
/* Table: HR_ORGNIZATION                                        */
/*==============================================================*/
CREATE TABLE HR_ORGNIZATION
(
   ID                   VARCHAR(32) NOT NULL COMMENT 'ID',
   SUPERID              VARCHAR(32) COMMENT 'SUPERID',
   CODE                 VARCHAR(32) COMMENT 'CODE',
   NAME                 VARCHAR(100) COMMENT 'NAME',
   PRIMARY KEY (ID)
);

ALTER TABLE HR_ORGNIZATION COMMENT '组织结构';

/*==============================================================*/
/* Table: HR_VOCATIONAL_CERTIFICATE                             */
/*==============================================================*/
CREATE TABLE HR_VOCATIONAL_CERTIFICATE
(
   ID                   VARCHAR(32) NOT NULL COMMENT '唯一ID',
   EMPLOYEEID           VARCHAR(32) NOT NULL COMMENT '员工ID',
   NAME                 VARCHAR(256) COMMENT '名称',
   GETFROM              VARCHAR(256) COMMENT '颁发单位',
   GETDATE              DATE COMMENT '颁发时间',
   PRIMARY KEY (ID)
);

ALTER TABLE HR_VOCATIONAL_CERTIFICATE COMMENT '职业资格证书';

/*==============================================================*/
/* Table: HR_WORK_EXPERIENCE                                    */
/*==============================================================*/
CREATE TABLE HR_WORK_EXPERIENCE
(
   ID                   VARCHAR(32) NOT NULL COMMENT '唯一ID',
   EMPLOYEEID           VARCHAR(32) NOT NULL COMMENT '员工ID',
   COMPANY_NAME         VARCHAR(256) COMMENT '公司名称',
   COMPANY_NATURE       VARCHAR(32) COMMENT '公司性质',
   JOB_NATURE           VARCHAR(32) COMMENT '工作性质',
   DUTY                 VARCHAR(128) COMMENT '职务',
   BEGIN_DATE           DATE COMMENT '开始时间',
   END_DATE             DATE COMMENT '结束时间',
   PRIMARY KEY (ID)
);

ALTER TABLE HR_WORK_EXPERIENCE COMMENT '工作经历';

/*==============================================================*/
/* Table: SYS_CODE                                              */
/*==============================================================*/
CREATE TABLE SYS_CODE
(
   ID                   CHAR(10) NOT NULL COMMENT '唯一ID',
   KEY_CODE             CHAR(10) NOT NULL COMMENT '代码标识',
   CODE                 CHAR(10) COMMENT '代码',
   NAME                 CHAR(10) COMMENT '名称',
   PRIMARY KEY (ID)
);

ALTER TABLE SYS_CODE COMMENT '系统代码';

/*==============================================================*/
/* Table: SYS_IMAGE                                              */
/*==============================================================*/
CREATE TABLE SYS_IMAGE
(
   ID                   VARCHAR(32) NOT NULL COMMENT '唯一ID',
   IMG_DATA             LONGTEXT COMMENT '图片类容',
   PRIMARY KEY (ID)
);

ALTER TABLE SYS_IMAGE COMMENT '系统图片';

