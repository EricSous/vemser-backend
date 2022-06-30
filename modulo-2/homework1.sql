
CREATE TABLE VEM_SER.ESTUDANTE (
	ID NUMBER NOT NULL,
	NOME VARCHAR2(200) NOT NULL,
	DATA_NASCIMENTO DATE NOT NULL,
	NR_MATRICULA VARCHAR2(10) unique,
	ATIVO CHAR(1),
	PRIMARY KEY(id)
);

CREATE SEQUENCE seq_estudante START WITH 1 INCREMENT BY 1;

INSERT INTO VEM_SER.ESTUDANTE (ID, NOME, DATA_NASCIMENTO, NR_MATRICULA , ATIVO)
			VALUES (seq_estudante.nextval, 'Eric', '18/FEB/1998', '5445645', 'S');
		
INSERT INTO VEM_SER.ESTUDANTE (ID, NOME, DATA_NASCIMENTO, NR_MATRICULA , ATIVO)
			VALUES (seq_estudante.nextval, 'Lucas', '30/MAR/1998', '999999999', 'S');
		
INSERT INTO VEM_SER.ESTUDANTE (ID, NOME, DATA_NASCIMENTO, NR_MATRICULA , ATIVO)
			VALUES (seq_estudante.nextval, 'Gustavo', '5/DEC/1998', '888888888', 'S');
		
INSERT INTO VEM_SER.ESTUDANTE (ID, NOME, DATA_NASCIMENTO, NR_MATRICULA , ATIVO)
			VALUES (seq_estudante.nextval, 'Joao', '9/OCT/1998', '777777777', 'S');
		
INSERT INTO VEM_SER.ESTUDANTE (ID, NOME, DATA_NASCIMENTO, NR_MATRICULA , ATIVO)
			VALUES (seq_estudante.nextval, 'Josy', '24/NOV/1998', '66666666', 'N');
		
INSERT INTO VEM_SER.ESTUDANTE (ID, NOME, DATA_NASCIMENTO, NR_MATRICULA , ATIVO)
			VALUES (seq_estudante.nextval, 'Paulo', '23/NOV/1998', '55555555', 'N');
		
INSERT INTO VEM_SER.ESTUDANTE (ID, NOME, DATA_NASCIMENTO, NR_MATRICULA , ATIVO)
			VALUES (seq_estudante.nextval, 'Eva', '15/APR/1998', '44444444', 'N');
		
INSERT INTO VEM_SER.ESTUDANTE (ID, NOME, DATA_NASCIMENTO, NR_MATRICULA , ATIVO)
			VALUES (seq_estudante.nextval, 'Sevy', '28/JAN/1998', '3333333', 'N');
		
INSERT INTO VEM_SER.ESTUDANTE (ID, NOME, DATA_NASCIMENTO, NR_MATRICULA , ATIVO)
			VALUES (seq_estudante.nextval, 'Suzana', '8/JUL/1998', '222222222', 'S');
		
INSERT INTO VEM_SER.ESTUDANTE (ID, NOME, DATA_NASCIMENTO, NR_MATRICULA , ATIVO)
			VALUES (seq_estudante.nextval, 'Gisele', '10/JUN/1998', '54456345', 'N');
		
		
SELECT * FROM VEM_SER.ESTUDANTE e;
