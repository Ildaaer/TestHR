DROP TABLE IF EXISTS roles_users CASCADE;
CREATE TABLE roles_users
(
    user_id BIGINT NOT NULL UNIQUE,
    role_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id)
);

