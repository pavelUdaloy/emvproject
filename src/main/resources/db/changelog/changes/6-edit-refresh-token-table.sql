ALTER TABLE refresh_tokens
    DROP COLUMN access_token_id;
ALTER TABLE refresh_tokens
    ADD user_id INT NOT NULL;
ALTER TABLE refresh_tokens
    ADD CONSTRAINT fk_refresh_tokens_user
        FOREIGN KEY (user_id)
            REFERENCES users (id)
            ON DELETE CASCADE