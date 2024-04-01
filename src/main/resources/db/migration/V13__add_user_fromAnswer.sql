DROP TABLE IF EXISTS answers CASCADE;
CREATE TABLE answers
(
    score INTEGER NOT NULL,
    id BIGINT NOT NULL,
    question_id BIGINT,
    answer VARCHAR(255),
    PRIMARY KEY (id),
    users_id BIGINT
);
ALTER TABLE IF EXISTS answers ADD CONSTRAINT answer_fk_questions
    FOREIGN KEY (question_id) REFERENCES questions;
ALTER TABLE IF EXISTS answers ADD CONSTRAINT answer_fk_users
    FOREIGN KEY (users_id) REFERENCES users;

