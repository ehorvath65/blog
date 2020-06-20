#!/bin/bash

sudo -u postgres psql << tag

/*
REVOKE ALL ON ALL TABLES IN SCHEMA public FROM blog;
REVOKE ALL ON ALL SEQUENCES IN SCHEMA public FROM blog;
REVOKE ALL ON ALL FUNCTIONS IN SCHEMA public FROM blog;
alter default privileges in schema public revoke select on tables from blog;
alter default privileges in schema public revoke select ,usage on sequences from blog;
REASSIGN OWNED BY blog TO postgres;
DROP DATABASE blog;
DROP USER blog;
*/

/*
create database meseblog;
create user meseblog with encrypted password 'Katan9kOro';
ALTER DATABASE meseblog OWNER TO meseblog;
grant all privileges on database meseblog to meseblog;
ALTER USER meseblog WITH SUPERUSER;
*/

/*
create database blog;
create user blog with encrypted password '1234';
ALTER DATABASE blog OWNER TO blog;
grant all privileges on database blog to blog;
ALTER USER blog WITH SUPERUSER;
*/

\echo connect:
\c
\echo list:
\l
\echo tables:
\dt+
\echo users, roles:
\du+
tag

read -p "Press [Enter] key..."
