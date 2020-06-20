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

-- CREATE TABLE story (id, user_id, title, title_long, content, posted, cat_id, category, logo);
\echo story-k bejegyzése
INSERT INTO "public"."story" ("id","user_id","cat_id","category","title","title_long","content","posted","logo") \
VALUES (nextval('story_sequence'),'1','4','java','J1 című','Title long J1','Content J1',CURRENT_TIMESTAMP,'');

INSERT INTO "public"."story" ("id","user_id","cat_id","category","title","title_long","content","posted","logo") \
VALUES (nextval('story_sequence'),'1','4','java','J2 című','Title long J2','Content J2',CURRENT_TIMESTAMP,'');

INSERT INTO "public"."story" ("id","user_id","cat_id","category","title","title_long","content","posted","logo") \
VALUES (nextval('story_sequence'),'1','1','R','R1 című','Title long R1','Content R1',CURRENT_TIMESTAMP,'');

INSERT INTO "public"."story" ("id","user_id","cat_id","category","title","title_long","content","posted","logo") \
VALUES (nextval('story_sequence'),'1','1','R','R2 című','Title long R2','Content R2',CURRENT_TIMESTAMP,'');

INSERT INTO "public"."story" ("id","user_id","cat_id","category","title","title_long","content","posted","logo") \
VALUES (nextval('story_sequence'),'1','3','gis','D1 című','Title long D1','Content D1',CURRENT_TIMESTAMP,'');


\echo categories kitöltése
-- CREATE TABLE cat (id, cat, catname, catcolor)
INSERT INTO "public"."cat" ("id","cat","catname","catcolor") \
VALUES ('1','r','-Rű-','#ff8700');
INSERT INTO "public"."cat" ("id","cat","catname","catcolor") \
VALUES ('2','springboot','-Spring-Boot-','#212631');
INSERT INTO "public"."cat" ("id","cat","catname","catcolor") \
VALUES ('3','gis','-Gis-','#8d00ff');
INSERT INTO "public"."cat" ("id","cat","catname","catcolor") \
VALUES ('4','java','-Jáva-','#4BB92F');
INSERT INTO "public"."cat" ("id","cat","catname","catcolor") \
VALUES ('5','sql','-SQL-','#0078ff');

tag
#IlonA
read -p "Press [Enter] key..."
