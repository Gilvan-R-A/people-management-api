INSERT INTO person (id, first_name, last_name, cpf, birth_date)
VALUES (1, 'Eduardo', 'Souza', '12345678909', '1990-01-01');

INSERT INTO phone (id, number, type, person_id)
VALUES 
  (1, '11999999999', 'MOBILE', 1),
  (2, '1133334444', 'HOME', 1);


INSERT INTO person (id, first_name, last_name, cpf, birth_date)
VALUES (2, 'Ana', 'Silva', '98765432100', '1995-05-15');

INSERT INTO phone (id, number, type, person_id)
VALUES 
  (3, '11912345678', 'COMMERCIAL', 2),
  (4, '1144443333', 'HOME', 2);


INSERT INTO person (id, first_name, last_name, cpf, birth_date)
VALUES (3, 'Carlos', 'Santos', '11122233344', '1988-08-20');

INSERT INTO phone (id, number, type, person_id)
VALUES 
  (5, '11988887777', 'MOBILE', 3);


INSERT INTO person (id, first_name, last_name, cpf, birth_date)
VALUES (4, 'Juliana', 'Oliveira', '22233344455', '1992-12-10');

INSERT INTO phone (id, number, type, person_id)
VALUES 
  (6, '1122223333', 'COMMERCIAL', 4),
  (7, '11900001111', 'MOBILE', 4),
  (8, '1133224455', 'HOME', 4);
