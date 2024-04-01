DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users
(
    age INTEGER NOT NULL,
    id BIGINT NOT NULL,
    email VARCHAR(255),
    lastname VARCHAR(255),
    name VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255) CHECK (role IN ('MANAGER','USER')),
    team VARCHAR(255),
    username varchar(255),
    PRIMARY KEY (id)
);