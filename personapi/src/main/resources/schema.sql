CREATE TABLE person (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    cpf VARCHAR(11),
    birth_date DATE
);


CREATE TABLE phone (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    number VARCHAR(20) NOT NULL,
    type VARCHAR(20) NOT NULL,
    person_id BIGINT NOT NULL,
    CONSTRAINT fk_person FOREIGN KEY (person_id) REFERENCES person(id) ON DELETE CASCADE
);