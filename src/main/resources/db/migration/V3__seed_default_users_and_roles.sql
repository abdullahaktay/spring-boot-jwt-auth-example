INSERT INTO users (username, password)
VALUES ('admin', '$2a$12$k/R0TVPoAqVmUZg9vPi4beoXz8PN/3rCzdLQebuWe9OkUP3hrrcJK'),
       ('user', '$2a$12$DkxU1MQR6jNIkHOHLCSlV.ZhO9hN/bzHoBjl/SKQNwniPwHnDK.DC');

INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM users u,
     roles r
WHERE (u.username = 'admin' AND r.name = 'ADMIN')
   OR (u.username = 'user' AND r.name = 'USER');