INSERT INTO roles (name)
VALUES ('ADMIN'),
       ('USER');

INSERT INTO privileges (name)
VALUES ('USER_LIST'),
       ('USER_READ'),
       ('USER_CREATE'),
       ('USER_UPDATE'),
       ('USER_DELETE');

INSERT INTO role_privileges (role_id, privilege_id)
SELECT r.id, p.id
FROM roles r
         CROSS JOIN privileges p
WHERE r.name = 'ADMIN';

INSERT INTO role_privileges (role_id, privilege_id)
SELECT r.id, p.id
FROM roles r
         JOIN privileges p ON p.name = 'USER_READ'
WHERE r.name = 'USER';