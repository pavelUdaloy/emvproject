CREATE TRIGGER trg_DeleteProjectLog
    ON projects
    AFTER DELETE
    AS
BEGIN
    INSERT INTO logs (type, action_at)
    SELECT N'Проект ' + deleted.name + N' был удален' AS type,
           GETDATE()                                  AS action_at
    FROM deleted;
END;
