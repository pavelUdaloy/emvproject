CREATE TABLE users
(
    id         INT NOT NULL IDENTITY(1,1) UNIQUE,
    email      VARCHAR(100) NOT NULL UNIQUE,
    password   VARCHAR(100) NOT NULL,
    title      VARCHAR(100) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name  VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO users (email, password, title, first_name, last_name)
VALUES ('dzianis.zakharych@viden.com', '1234', 'VIDEN FOUNDER', 'Dzianis', 'Zakharych'),
       ('elizaveta.tsypenkova@viden.com', '1234', 'VIDEN ANALYST', 'Elizaveta', 'Tsypenkova'),
       ('jack.jackson@google.com', '1234', 'GOOGLE ANALYST', 'Jack', 'Jackson');
