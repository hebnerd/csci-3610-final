INSERT INTO account (firstName, lastName, email, password, role)
VALUES (
           'SUPER',
           'USER',
           'admin@lol.com',
           'admin',
           'admin'
       );

INSERT INTO account (creationDate, firstName, lastName, email, password, role)
VALUES (
           '2020-04-01 16:32:48',
           'Matt',
           'Harrison',
           'cletus8888@mailinator.com',
           'LOLAssembly',
           'admin'
       );

INSERT INTO account (creationDate, firstName, lastName, email, password, role)
VALUES (
           '2020-04-01 19:00:00',
           'Jake',
           'Gillenwater',
           'not_an_email@mailinator.com',
           'VRKeyboardWoo',
           'admin'
       );

INSERT INTO account (creationDate, firstName, lastName, email, password, role)
VALUES (
           '2020-04-03 12:35:21',
           'Ed',
           'Hall',
           'hallandoates@mailinator.com',
           'LovesJavaHotspot',
           'member'
       );

INSERT INTO account (firstName, lastName, email, password, role)
VALUES (
           'Freddy',
           'Finagle',
           'freddy4444@mailinator.com',
           'freddo',
           'member'
       );

INSERT INTO account (firstName, lastName, email, password, role)
VALUES (
           'Annie',
           'Arn',
           'annie_git@mailinator.com',
           'ann',
           'member'
       );

INSERT INTO review (accountId, creationDate, rating, content)
VALUES (
           2,
           '2020-04-01 19:30:18',
           5,
           'Best lizards anywhere in the US!'
       );

INSERT INTO review (accountId, creationDate, rating, content)
VALUES (
           2,
           '2020-04-01 19:42:20',
           1,
           'Nevermind, just found a rat tail in my lizard soup!'
       );

INSERT INTO review (accountId, creationDate, rating, content)
VALUES (
           2,
           '2020-04-01 19:43:42',
           5,
           'Nevermind to my nevermind: the rat tail adds a certain je ne sais quoi to the lizard soup...'
       );

INSERT INTO review (accountId, creationDate, rating, content)
VALUES (
           4,
           '2020-04-03 12:11:57',
           4,
           'Everything Harrison says is wrong. Also, the lizard kebab is acceptable.'
       );

INSERT INTO review (accountId, rating, content)
VALUES (
           1,
           3,
           'Testing123'
       );
