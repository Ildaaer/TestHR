--answers
DROP SEQUENCE IF EXISTS answer_seq;
CREATE SEQUENCE answer_seq START WITH 1 INCREMENT BY 1;

DROP TABLE IF EXISTS answers CASCADE;
CREATE TABLE answers
(
    score INTEGER NOT NULL,
    id BIGINT NOT NULL,
    question_id BIGINT,
    answer VARCHAR(255),
    PRIMARY KEY (id)
);
ALTER TABLE IF EXISTS answers ADD CONSTRAINT answer_fk_questions
    FOREIGN KEY (question_id) REFERENCES questions;

--questions
DROP SEQUENCE IF EXISTS questions_seq;
CREATE SEQUENCE questions_seq START WITH 1 INCREMENT BY 1;

DROP TABLE IF EXISTS questions CASCADE;
CREATE TABLE questions
(
    id BIGINT NOT NULL,
    test_id BIGINT,
    question VARCHAR(255),
    PRIMARY KEY (id)
);
ALTER TABLE IF EXISTS questions ADD CONSTRAINT question_test
    FOREIGN KEY (test_id) REFERENCES tests;

--results
DROP SEQUENCE IF EXISTS results_seq;
CREATE SEQUENCE results_seq START WITH 1 INCREMENT BY 1;

DROP TABLE IF EXISTS results CASCADE;
CREATE TABLE results
(
    score_max INTEGER NOT NULL,
    score_min INTEGER NOT NULL,
    id BIGINT NOT NULL,
    test_id BIGINT UNIQUE,
    result VARCHAR(255),
    PRIMARY KEY (id)
);
ALTER TABLE IF EXISTS results ADD CONSTRAINT results_fk_tests
    FOREIGN KEY (test_id) REFERENCES tests;

--tests
DROP SEQUENCE IF EXISTS test_seq;
CREATE SEQUENCE test_seq START WITH 1 INCREMENT BY 1;

DROP TABLE IF EXISTS tests CASCADE;
CREATE TABLE tests
(
    id BIGINT NOT NULL,
    result_id BIGINT UNIQUE,
    title VARCHAR(255),
    PRIMARY KEY (id)
);
ALTER TABLE IF EXISTS tests ADD CONSTRAINT tests_fk_result
    FOREIGN KEY (result_id) REFERENCES results;

--user
DROP SEQUENCE IF EXISTS user_seq;
CREATE SEQUENCE user_seq START WITH 1 INCREMENT BY 1;

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
    PRIMARY KEY (id)
);

--questions_answers
DROP TABLE IF EXISTS questions_answers CASCADE;
CREATE TABLE questions_answers
(
    answers_id BIGINT NOT NULL UNIQUE,
    question_id BIGINT NOT NULL
);
ALTER TABLE IF EXISTS questions_answers ADD CONSTRAINT answer_fk_question
    FOREIGN KEY (question_id) REFERENCES questions;
ALTER TABLE IF EXISTS questions_answers ADD CONSTRAINT questions_fk_answer
    FOREIGN KEY (answers_id) REFERENCES answers;

--tests_questions
DROP TABLE IF EXISTS tests_questions CASCADE;
CREATE TABLE tests_questions
(
    questions_id BIGINT NOT NULL UNIQUE,
    test_id BIGINT NOT NULL
);
ALTER TABLE IF EXISTS tests_questions ADD CONSTRAINT tests_fk_questions
    FOREIGN KEY (questions_id) REFERENCES questions;
ALTER TABLE IF EXISTS tests_questions ADD CONSTRAINT questions_fk_tests
    FOREIGN KEY (test_id) REFERENCES tests;
