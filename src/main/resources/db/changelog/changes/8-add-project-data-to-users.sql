ALTER TABLE users
    ADD project_id INT;
ALTER TABLE users
    ADD CONSTRAINT fk_users_projects
        FOREIGN KEY (project_id)
            REFERENCES projects (id)
            ON DELETE CASCADE;