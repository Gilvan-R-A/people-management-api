CREATE TABLE person (
    id BIGINT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    cpf VARCHAR(11),
    birth_date DATE
);


CREATE TABLE phone (
    id BIGINT PRIMARY KEY,
    number VARCHAR(20),
    type VARCHAR(20),
    person_id BIGINT,
    CONSTRAINT fk_person FOREIGN KEY (person_id) REFERENCES person(id) ON DELETE CASCADE
);