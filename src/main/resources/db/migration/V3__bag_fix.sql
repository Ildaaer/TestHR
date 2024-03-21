DROP TABLE IF EXISTS roles_users CASCADE;
CREATE TABLE roles_users
(
    user_id BIGINT NOT NULL UNIQUE,
    roles_id BIGINT NOT NULL
);

ALTER TABLE IF EXISTS roles_users ADD CONSTRAINT user_fk_roles
    FOREIGN KEY (user_id) REFERENCES users;
ALTER TABLE IF EXISTS roles_users ADD CONSTRAINT roles_fk_users
    FOREIGN KEY (roles_id) REFERENCES roles;