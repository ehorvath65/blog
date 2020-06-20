#!/bin/bash
export PGPASSWORD=1234

psql postgresql://blog@localhost:5432/blog << tag
--\x

\echo törlés:

DROP TABLE story;
DROP TABLE users;
DROP TABLE users_roles;
DROP TABLE roles;
Drop TABLE cat;
DROP SEQUENCE story_sequence;
-- DROP SEQUENCE hibernate_sequence;
DROP EXTENSION pgcrypto;

/* több soros 
kommentek */
-- csak egy sor komment
-- ezek mégse kellenek:
-- SET search_path TO public;
-- ALTER USER blog SET search_path to public;

\echo létrehozás:

CREATE SEQUENCE story_sequence START 1;

CREATE EXTENSION pgcrypto;

CREATE TABLE users (\
id integer NOT NULL, \
email character varying(100) NOT NULL, \
full_name character varying(100) NOT NULL, \
password text NOT NULL, \
activation character varying(10), \
enabled character varying(10));

CREATE TABLE roles (\
id integer NOT NULL, \
role character varying(100) NOT NULL);

CREATE TABLE users_roles (\
user_id integer NOT NULL, \

roles_id integer NOT NULL);
CREATE TABLE story (\
id integer NOT NULL, \
user_id integer, \
cat_id integer, \
category character varying(30), \
title character varying(100) NOT NULL, \
title_long character varying(150), \
content text, \
posted timestamp, \
logo character varying(50));

CREATE TABLE cat (id integer NOT NULL, cat character varying(32), \
catname character varying(32), catcolor character varying(32));

tag

read -p "Press [Enter] key..."
