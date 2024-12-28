CREATE TABLE access_tokens
(
    id         INT          NOT NULL IDENTITY (1,1) UNIQUE,
    token      VARCHAR(255) NOT NULL,
    created_at DATETIME     NOT NULL,
    expired_at DATETIME     NOT NULL,
    user_id    INT          NOT NULL,
    CONSTRAINT fk_user
        FOREIGN KEY (user_id)
            REFERENCES users (id)
            ON DELETE CASCADE
);

CREATE TABLE refresh_tokens
(
    id              INT          NOT NULL IDENTITY (1,1) UNIQUE,
    token           VARCHAR(255) NOT NULL,
    created_at      DATETIME     NOT NULL,
    expired_at      DATETIME     NOT NULL,
    access_token_id INT          NOT NULL,
    CONSTRAINT fk_access_token
        FOREIGN KEY (access_token_id)
            REFERENCES access_tokens (id)
            ON DELETE CASCADE
);