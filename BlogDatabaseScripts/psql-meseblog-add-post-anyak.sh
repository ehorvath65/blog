#!/bin/bash
export PGPASSWORD=1234

psql postgresql://blog@localhost:5432/blog << tag
-- id, user_id, cat_id, category, title, title_long, posted, logo, content;
INSERT INTO "public"."story" ("id","user_id","cat_id","category","title","title_long","posted","logo","content") \
VALUES (nextval('story_sequence'),'1','2','helyzetek','Anyák és lányok','Női mesealakok a népmesékben 1.', \
CURRENT_TIMESTAMP,'', \
-- ================================================================================
'
Női mesealakok a népmesékben 1.
<br>
<br>
Milyen kapcsolatok vannak az egyes női mesealakok között a mesékben?
<br>
Ahhoz, hogy ezt megválaszolhassuk, tudnunk kell, hogy milyen mesealakok fordulnak elő.
<br>
Először is az anya, mostoha anya, lány, testvér, mostoha testvér, anyós, meny, vetélytársnő (a királyfiért), szolgálólány, tündérkeresztanya, vasorrú bába, természeti erők (Nap, Szél, Hold) anyja, Holle anyó (segítő öregasszony), feleség. A lány lehet szegény lány, királykisasszony, hattyú királykisasszony, az ördög lánya, hal királykisasszony. Ha királykisasszony, akkor növényi alakban is jelen lehet, mint tök, nádszál vagy tölgyág.
<br>
Elsődleges az anya lánya kapcsolat.
<br>
Nagyon gyakori mesei helyzet, hogy a lány anyja meghal, az apa mostohát visz a házhoz. Ettől kezdve rosszra fordul a lány sorsa. De halott anya nem hagyja magára a lányát. Gyakran növény alakban segíti boldogulásban, férjhezmenésben. A növényekhez mindig kapcsolódnak állatok is. 
<br>
A Hamupipőke típusú mesék egyik változatában a meghalt anya sírján csipkebokor nő. A csipkebokron találja a lány a ruhát, cipőt, amiben elmehet a bálba. A bálba, ahol beleszeret a királyfi, aki a bál után a lány elveszített cipőjével bejárja az országot, hogy megtalálja választottját. A csipkebokron ülő galambok figyelmeztetik a királyfit, hogy hamis menyasszonyt visz, amikor hazafele menet elmennek az anya sírja mellett.
<br>
A meghalt anya állat képében táplálja a gyermekét, akit otthon éheztetnek. Ennek a mesetípusnak a főhőse általában fiú, de van olyan változat is, amelyben leány a főszereplő. A mese eleje mind a két esetben megegyezik. A mostoha éhezteti a gyermeket, étel nélkül küldi ki a mezőre legeltetni az állatokat. A gyermek sír az éhségtől. Az állatok közt van egy különleges, aki megszánja és csodás módon enni ad neki.
A mostoha nem érti, hogy miért nem veszett éhen a gyermek, és kiküldi a lányait utána, hogy tudják meg mit eszik.
Az Egyszemű és a Kétszemű testvérét sikerül elaltatnia az árvának, de a Háromszemű kilesi a titkát és elmondja a mostohának. A mostoha elhatározza, hogy megöleti az állatot Az állat tudja, hogy itt a vég, és tanáccsal látja el a gyermeket. Nevezetesen, hogy a gyermek ne egyen a húsából, de a vacsora után kérje el a körmét és a csontját és ássa el a küszöb elé. Innen másként folytatódik a mese, ha fiú a főhős és másként ha lány. 
Ha lány ássa el a csontokat másnapra kihajt egy gyönyörű aranyalmafa. Arra jár a királyfi és azt mondja, hogy aki leszakít egy almát neki, azt elveszi feleségül. Hiába erőlködnek a mostohatestvérek, az almát nem érhetik el. Míg a leányhoz lehajol a fa és könnyedén leszakíthat egy almát, ezzel jó férjet kap. (Egy szemű, két szemű, háromszemű)
<br>
Mostoha került a házhoz. A mostoha addig sanyargatja, dolgoztatja férje lányát, míg az világgá megy a kínzások elől. Útközben próbára teszik jó szívét. Szolgálatot talál, ahol szorgalmasan dolgozik, kincsekkel megrakodva tér haza. (Mostohalány, édeslány)
Ha nem kergeti világgá a mostoha a lányt, akkor lehetetlen feladatokat ad neki, hogy ne tudjon lemenni a bálba, esetleg a templomba. De édesanyja sírján növő virág segít, hogy megmutathassa valódi önmagát, és minden ármány ellenére a királyfi rátaláljon és feleségül vegye. (Hamupiőke)
<br>
Van olyan szomorú sorsú királykisasszony, vagy az ördög lánya, akit nem szível az édesanyja. Addig nincs baj, amíg kérő nem érkezik. Mihelyst a királykisasszony megszereti a legényt és segít neki a próbákat kiállni, ellenségévé teszi az édesanyját. A szerelmeseknek menekülniük kell, az úton túljárnak az üdözésükre küldött apa eszén, de a dühös anya előtt éppen csak átérnek a birodalom határán. De még meg kell birkózniuk az anyai átokkal, hogy boldogok lehessenek. (Rózsa és Ibolya)
<br>

A következő fontos kapcsolat a testvérek között lévő. 
'
-- ==================================================================================
);

tag
