ALTER TABLE refresh_tokens DROP CONSTRAINT fk_access_token;
ALTER TABLE refresh_tokens ALTER COLUMN access_token_id INT NULL;