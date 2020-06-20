#!/bin/bash
export PGPASSWORD=1234

psql postgresql://blog@localhost:5432/blog << tag
-- \x
\dx
SELECT sequence_name, increment FROM information_schema.sequences;
\l
\dt

SELECT * FROM users;
SELECT * FROM roles;
SELECT * FROM users_roles;
SELECT * FROM cat;
SELECT * FROM story LIMIT 0;
SELECT id,user_id,cat_id,category,title,title_long,posted,logo FROM story; 

tag

read -p "Press [Enter] key..."