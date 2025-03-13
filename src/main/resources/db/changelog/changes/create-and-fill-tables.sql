CREATE SEQUENCE roles_SEQ START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE projects_SEQ START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE users_SEQ START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE logs_SEQ START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE notes_SEQ START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE criteries_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE roles
(
    id   INT            NOT NULL IDENTITY (1,1) PRIMARY KEY,
    name NVARCHAR(1000) NOT NULL UNIQUE
);

INSERT INTO roles (name)
VALUES ('VIDEN_ADMIN'),
       ('VIDEN_ANALYST'),
       ('CLIENT');

CREATE TABLE projects
(
    id       INT            NOT NULL IDENTITY (1,1) PRIMARY KEY,
    name     NVARCHAR(1000) NOT NULL UNIQUE,
    approved BIT            NOT NULL DEFAULT 0
);

INSERT INTO projects (name, approved)
VALUES ('VIDEN', 1),
       ('GOOGLE', 1);

CREATE TABLE users
(
    id         INT            NOT NULL IDENTITY (1,1) PRIMARY KEY,
    email      NVARCHAR(1000) NOT NULL UNIQUE,
    password   NVARCHAR(1000) NOT NULL,
    first_name NVARCHAR(1000) NOT NULL,
    last_name  NVARCHAR(1000) NOT NULL,
    project_id INT            NOT NULL,
    role_id    INT            NOT NULL,
    FOREIGN KEY (project_id) REFERENCES projects (id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE
);

INSERT INTO users (email, password, first_name, last_name, role_id, project_id)
VALUES ('dzianis.zakharych@viden.com', '1234', N'Денис', N'Захарич',
        (SELECT id FROM roles WHERE name = 'VIDEN_ADMIN'), (SELECT id FROM projects WHERE name = 'VIDEN')),

       ('elizaveta.tsypenkova@viden.com', '1234', N'Елизавета', N'Цыпенкова',
        (SELECT id FROM roles WHERE name = 'VIDEN_ANALYST'), (SELECT id FROM projects WHERE name = 'VIDEN')),

       ('pavel.pavel@viden.com', '1234', N'Павел', N'Павел',
        (SELECT id FROM roles WHERE name = 'VIDEN_ANALYST'), (SELECT id FROM projects WHERE name = 'VIDEN')),

       ('michael.jackson@google.com', '1234', N'Майкл', N'Джексон',
        (SELECT id FROM roles WHERE name = 'CLIENT'), (SELECT id FROM projects WHERE name = 'GOOGLE'));

CREATE TABLE logs
(
    id        INT            NOT NULL IDENTITY (1,1) PRIMARY KEY,
    type      NVARCHAR(1000) NOT NULL,
    action_at DATETIME2      NOT NULL
);

CREATE TABLE criteries
(
    id   INT            NOT NULL IDENTITY (1,1) PRIMARY KEY,
    name NVARCHAR(1000) NOT NULL UNIQUE
);

INSERT INTO criteries (name)
VALUES (N'Правильная реализация кода'),
       (N'Корректное отслеживание мобильного сайта'),
       (N'Уникальность кода'),
       (N'Корректное отслеживание одностраничного приложения'),
       (N'Настройка междоменного отслеживания'),
       (N'Самоотсылки'),
       (N'Отслеживание процесса оплаты'),
       (N'Маркировка UTM'),
       (N'Отслеживание ошибок страниц 404'),
       (N'Основной домен в списке нежелательных рефералов'),
       (N'Тайм-аут сессии'),
       (N'Окно возврата'),
       (N'Хранение данных пользователей и событий'),
       (N'Точность данных электронной коммерции'),
       (N'Трафик на не заданную целевую страницу'),
       (N'Валюта'),
       (N'Определение внутреннего трафика'),
       (N'Категория отрасли'),
       (N'Часовой пояс для отчетности'),
       (N'Отслеживание событий'),
       (N'Отслеживание конверсий'),
       (N'Стандартная реализация отслеживания покупок в электронной коммерции'),
       (N'Расширенное измерение'),
       (N'Реализация отслеживания идентификатора пользователя'),
       (N'Расширенное отслеживание электронной коммерции'),
       (N'Отслеживание пользовательских измерений и метрик'),
       (N'Детализированный сбор данных о местоположении и устройствах'),
       (N'Расширенные настройки для персонализации рекламы'),
       (N'Имя ресурса'),
       (N'Имя потока'),
       (N'Таксономия отслеживания событий'),
       (N'Связь с Google BigQuery'),
       (N'Библиотека'),
       (N'Связь с Google Ads'),
       (N'Связь с Google Search Console'),
       (N'Связь с Google Merchant Center'),
       (N'Связь с Display & Video 360'),
       (N'Импорт данных'),
       (N'Связь с Ad Manager'),
       (N'Связь с Search Ads 360'),
       (N'Сбор данных Google Signals'),
       (N'Модель атрибуции отчетов'),
       (N'Атрибуция личности для отчетности'),
       (N'Реализация серверного отслеживания'),
       (N'Режим согласия'),
       (N'Отсутствие сбора PII данных');

CREATE TABLE project_criteries
(
    project_id  INT NOT NULL,
    criteria_id INT NOT NULL,
    user_id     INT NOT NULL,
    status      NVARCHAR(1000),
    description NVARCHAR(max),
    deadline    DATETIME2,
    PRIMARY KEY (project_id, criteria_id),
    FOREIGN KEY (project_id) REFERENCES projects (id) ON DELETE CASCADE,
    FOREIGN KEY (criteria_id) REFERENCES criteries (id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE NO ACTION
);

CREATE TABLE notes
(
    id           INT            NOT NULL IDENTITY (1,1) PRIMARY KEY,
    message      NVARCHAR(1000) NOT NULL,
    project_id   INT            NOT NULL,
    criteria_id  INT            NOT NULL,
    root_note_id INT            NULL,
    user_id      INT            NOT NULL,
    sended_at    DATETIME2      NOT NULL,
    FOREIGN KEY (project_id, criteria_id) REFERENCES project_criteries (project_id, criteria_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE NO ACTION,
    FOREIGN KEY (root_note_id) REFERENCES notes (id) ON DELETE NO ACTION
);
