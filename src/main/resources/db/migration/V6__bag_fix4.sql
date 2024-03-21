DROP TABLE IF EXISTS roles_users CASCADE;
CREATE TABLE roles_users
(
    users_id BIGINT NOT NULL UNIQUE,
    role_id BIGINT NOT NULL,
    FOREIGN KEY (users_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id)
);
