UPDATE users
SET project_id = (SELECT id FROM projects WHERE name = 'VIDEN')
WHERE email = 'dzianis.zakharych@viden.com';
UPDATE users
SET project_id = (SELECT id FROM projects WHERE name = 'VIDEN')
WHERE email = 'elizaveta.tsypenkova@viden.com';
UPDATE users
SET project_id = (SELECT id FROM projects WHERE name = 'GOOGLE')
WHERE email = 'jack.jackson@google.com';

ALTER TABLE users
    ALTER COLUMN project_id INT NOT NULL;