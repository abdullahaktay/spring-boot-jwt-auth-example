ALTER TABLE users ALTER COLUMN username TYPE VARCHAR(50) USING username::VARCHAR;

DROP INDEX IF EXISTS uq_users_username_active;

CREATE UNIQUE INDEX uq_users_username_active ON users (LOWER(username)) WHERE deleted_at IS NULL;