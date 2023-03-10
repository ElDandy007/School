# School

DROP DATABASE school;
CREATE DATABASE school;

\c school;

CREATE TABLE department (
    code_department INTEGER NOT NULL,
    name VARCHAR (30) NOT NULL,
    phone VARCHAR (10) NOT NULL,
    CONSTRAINT pk_code_department PRIMARY KEY (code_department)
);


CREATE TABLE teacher (
    id_teacher INTEGER NOT NULL,
    firstname VARCHAR (30) NOT NULL,
    lastname VARCHAR (30) NOT NULL,
    email VARCHAR (30) NOT NULL,
    code_department INTEGER NOT NULL,
    CONSTRAINT pk_teacher PRIMARY KEY (id_teacher),
    CONSTRAINT fk_code_department FOREIGN KEY (code_department) REFERENCES department (code_department)
);    

CREATE TABLE subject (

    code_subject VARCHAR (60) NOT NULL,
    description VARCHAR (30) NOT NULL,
    CONSTRAINT pk_code_subject PRIMARY KEY (code_subject)
    );

CREATE TABLE groups (
    code_group VARCHAR (30) NOT NULL,
    curriculum VARCHAR (100) NOT NULL,
    course VARCHAR (20) NOT NULL,
    CONSTRAINT pk_code_group PRIMARY KEY (code_group)
    );

CREATE TABLE session (
    id_teacher INTEGER NOT NULL,
    code_subject VARCHAR (60) NOT NULL,
    code_group VARCHAR (30) NOT NULL,
    week_day VARCHAR (30) NOT NULL,
    starts TIME NOT NULL,
    finishes TIME NOT NULL,
    CONSTRAINT pk_session PRIMARY KEY (id_teacher, code_subject, code_group, week_day),
    CONSTRAINT fk_id_teacher FOREIGN KEY (id_teacher) REFERENCES teacher (id_teacher),
    CONSTRAINT fk_code_subject FOREIGN KEY (code_subject) REFERENCES subject (code_subject),
    CONSTRAINT fk_code_group FOREIGN KEY (code_group) REFERENCES groups (code_group)
     );

INSERT INTO department VALUES ('1','Informatica','123456790');
INSERT INTO department VALUES ('2','Numeros','9876545671');
INSERT INTO department VALUES ('3','Lengua','7654323432');
INSERT INTO department VALUES ('4','Sociales','6583970326');
INSERT INTO department VALUES ('5','Naturales','9820351628');

INSERT INTO teacher VALUES ('1','Manolo','Gimenez','manolito@gmail.com','4');
INSERT INTO teacher VALUES ('2','Francisca','Lombarda','francisca@gmail.com','3');
INSERT INTO teacher VALUES ('3','Joan','Laporta','joan@gmail.com','1');
INSERT INTO teacher VALUES ('4','Ernesto','Fernandez','ernesto@gmail.com','5');
INSERT INTO teacher VALUES ('5','Antonia','Murcia','antonia@gmail.com','2');

INSERT INTO subject VALUES ('MP01','Programacion');
INSERT INTO subject VALUES ('MP02','Mates');
INSERT INTO subject VALUES ('MP03','Gramatica');
INSERT INTO subject VALUES ('MP04','Historia');
INSERT INTO subject VALUES ('MP05','Biologia');

INSERT INTO groups VALUES ('DAM1A’,’DAM','1A');
INSERT INTO groups VALUES ('ESO2D','ESO','2D');
INSERT INTO groups VALUES ('Primaria3C','Primaria','3C');
INSERT INTO groups VALUES ('BACHC2A','BACHC','2A');
INSERT INTO groups VALUES ('BACHS1B','BACHS','1B');

INSERT INTO session VALUES ('3','MP01','DAM1A','Lunes','20:00:00','21:00:00');
INSERT INTO session VALUES ('2','MP03','ESO2D','Martes','12:00:00','13:00:00');
INSERT INTO session VALUES ('1','MP04','BACHS1B','Miercoles','10:00:00','11:00:00’);
INSERT INTO session VALUES ('4','MP05','Primaria3C','Jueves','13:00:00','14:00:00');
INSERT INTO session VALUES ('5','MP02','BACHC2A','Viernes','09:00:00','10:00:00');
