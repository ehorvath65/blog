#!/bin/bash
export PGPASSWORD=1234

psql postgresql://blog@localhost:5432/blog << tag
-- \x
\echo Teszt Elek user létrehozása:
INSERT INTO "public"."users" ("id","email","full_name","password","activation","enabled") \
VALUES ('1','teszt.elek@teszt.hu','Teszt Elek',crypt('1234', gen_salt('bf', 8)),'true','true');

\echo Teszt Elek user-nek admin jog biztosítása:
INSERT INTO "public"."roles" ("id","role") VALUES ('1','admin');

\echo Teszt Elek bejegyzése a user_roles táblába:
INSERT INTO "public"."users_roles" ("user_id","roles_id") VALUES ('1','1');

\echo categories kitöltése
INSERT INTO "public"."cat" ("id","cat","catname","catcolor") \
VALUES ('1','celok','-Célok-','#ff8700');
INSERT INTO "public"."cat" ("id","cat","catname","catcolor") \
VALUES ('2','helyzetek','-Helyzetek-','#4BB92F');
INSERT INTO "public"."cat" ("id","cat","catname","catcolor") \
VALUES ('3','mesekrol','-Mesékről-','#8d00ff');


tag
#IlonA
read -p "Press [Enter] key..."
