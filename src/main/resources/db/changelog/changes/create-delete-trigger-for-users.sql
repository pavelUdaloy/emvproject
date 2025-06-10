CREATE TRIGGER trg_DeleteUserLog
    ON users
    AFTER
DELETE
    AS
BEGIN
INSERT INTO logs (type, action_at)
SELECT N'Пользователь ' + deleted.email + N' был удален' AS type,
       GETDATE()                                         AS action_at
FROM deleted;
END;