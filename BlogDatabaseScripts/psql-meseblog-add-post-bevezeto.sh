#!/bin/bash
export PGPASSWORD=1234

psql postgresql://blog@localhost:5432/blog << tag
-- id, user_id, cat_id, category, title, title_long, posted, logo, content;
INSERT INTO "public"."story" ("id","user_id","cat_id","category","title","title_long","posted","logo","content") \
VALUES (nextval('story_sequence'),'1','1','celok','Bevezető','Bevezető',CURRENT_TIMESTAMP,'',\
-- ================================================================================
'
A mesék ott végződnek, ahol az élet kezdődik. ‒ mondják sokan.
<br>
Igen, de ezzel azt is mondják, hogy nem ismernek elég mesét és nem ismerik a meséket kellő mélységben.
<br>
A "Magyar népmesekatalógus" kötetek címeit nézve látjuk, hogy hányféle mesetípus létezik: állatmesék, tündérmesék, legendamesék, novellamesék, rászedett ördög-mesék, magyar János szolga-mesék, rátótiádák, tréfás mesék, trufák és anekdoták, hazugságmesék, formulamesék.
Ebben a végtelen gazdagságban kell, hogy legyen az emberi élet minden helyzetére, nehézségére, örömére példa.
<br>
Ezt a gazdagságot szeretném megmutatni úgy, ahogy látom. A mese maga az élet, mert értő szemmel felfedezhetünk a párhuzamokat egy-egy mese, mesei helyzet és a saját sorsunk között.
Mesékről mesélni jó.
<br>
<br>

'
-- ==================================================================================
);

tag
