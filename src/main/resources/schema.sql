SET ALLOW_LITERALS ALL;

DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS topic;
DROP TABLE IF EXISTS thread;
DROP TABLE IF EXISTS post;

CREATE TABLE account(
                        id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
                        creationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                        firstName VARCHAR(255) NOT NULL,
                        lastName VARCHAR(255) NOT NULL,
                        email VARCHAR(255) NOT NULL,
                        password VARCHAR(255) NOT NULL,
                        role VARCHAR(255) DEFAULT 'member' NOT NULL
);

CREATE TABLE review(
                       id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
                       accountId INTEGER NOT NULL,
                       creationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                       rating INTEGER DEFAULT 5 NOT NULL,
                       content VARCHAR(255),
                       FOREIGN KEY(accountId) REFERENCES account(id)
);

CREATE TABLE topic(
                      id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
                      name VARCHAR(255) NOT NULL,
                      description VARCHAR(255) NOT NULL
);

CREATE TABLE thread(
                       id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
                       accountId INTEGER NOT NULL,
                       topicId INTEGER NOT NULL,
                       creationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                       name VARCHAR(255) DEFAULT 'new thread' NOT NULL,
                       FOREIGN KEY(topicId) REFERENCES topic(id),
                       FOREIGN KEY(accountId) REFERENCES account(id)
);

CREATE TABLE post(
                     id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
                     accountId INTEGER NOT NULL,
                     threadId INTEGER NOT NULL,
                     creationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                     content VARCHAR(255),
                     FOREIGN KEY(accountId) REFERENCES account(id),
                     FOREIGN KEY(threadId) REFERENCES thread(id)
);
