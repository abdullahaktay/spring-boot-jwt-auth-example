CREATE
EXTENSION IF NOT EXISTS citext;

CREATE TABLE users
(
    id         BIGSERIAL PRIMARY KEY,
    username   CITEXT       NOT NULL,
    password   VARCHAR(255) NOT NULL,
    enabled    BOOLEAN      NOT NULL DEFAULT TRUE,
    created_at TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ,
    deleted_at TIMESTAMPTZ
);

CREATE TABLE roles
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(50) NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ,
    deleted_at TIMESTAMPTZ
);

CREATE TABLE privileges
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    created_at TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ,
    deleted_at TIMESTAMPTZ
);

CREATE TABLE user_roles
(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES roles (id)
);

CREATE TABLE role_privileges
(
    role_id      BIGINT NOT NULL,
    privilege_id BIGINT NOT NULL,
    PRIMARY KEY (role_id, privilege_id),
    CONSTRAINT fk_role_privilege FOREIGN KEY (role_id) REFERENCES roles (id),
    CONSTRAINT fk_privilege FOREIGN KEY (privilege_id) REFERENCES privileges (id)
);

CREATE UNIQUE INDEX IF NOT EXISTS uq_users_username_active
    ON users (username) WHERE deleted_at IS NULL;

CREATE UNIQUE INDEX IF NOT EXISTS uq_roles_name_active
    ON roles (name) WHERE deleted_at IS NULL;

CREATE UNIQUE INDEX IF NOT EXISTS uq_privileges_name_active
    ON privileges (name) WHERE deleted_at IS NULL;

CREATE INDEX IF NOT EXISTS ix_user_roles_user_id
    ON user_roles (user_id);

CREATE INDEX IF NOT EXISTS ix_user_roles_role_id
    ON user_roles (role_id);

CREATE INDEX IF NOT EXISTS ix_role_privileges_role_id
    ON role_privileges (role_id);
CREATE INDEX IF NOT EXISTS ix_role_privileges_privilege_id
    ON role_privileges (privilege_id);