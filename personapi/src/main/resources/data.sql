INSERT INTO person (first_name, last_name, cpf, birth_date)
VALUES 
('Eduardo', 'Souza', '12345678909', '1990-01-01'),
('Ana', 'Silva', '98765432100', '1995-05-15'),
('Carlos', 'Santos', '11122233344', '1988-08-20'),
('Juliana', 'Oliveira', '22233344455', '1992-12-10');

INSERT INTO phone (number, type, person_id)
VALUES 
  ('11999999999', 'MOBILE', 1),
  ('1133334444', 'HOME', 1),
  ('11912345678', 'COMMERCIAL', 2),
  ('1144443333', 'HOME', 2),
  ('11988887777', 'MOBILE', 3),
  ('1122223333', 'COMMERCIAL', 4),
  ('11900001111', 'MOBILE', 4),
  ('1133224455', 'HOME', 4);

  
