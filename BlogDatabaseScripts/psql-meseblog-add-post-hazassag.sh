#!/bin/bash
export PGPASSWORD=1234

psql postgresql://blog@localhost:5432/blog << tag
-- id, user_id, cat_id, category, title, title_long, posted, logo, content;
INSERT INTO "public"."story" ("id","user_id","cat_id","category","title","title_long","posted","logo","content") \
VALUES (nextval('story_sequence'),'1','3','mesekrol','A házasság eredete','A házasság eredete, dél-afrikai mese',\
CURRENT_TIMESTAMP,'', \
-- ================================================================================
'
A boldog élet része jó párkapcsolat. Milyen nehézségeket kell legyőzni férfinek és nőnek, hogy ezt elérje, elérjék? Erről szól ez a mese.
<br>
Gondolataim a meséről<br>
A mese a fiúk férfivá érését, a lányok nővé érését mondja el szimbolikusan.<br>
A fiúk és a lányok életük egy szakaszában azonos nemű csoportokat alkotnak, legtöbbször nincsenek jó véleménnyel a másik nemről. 
Egy bizonyos korban, – itt a vadászat szimbolizálja, hogy elérték a kort, – már képesek önállóan gondoskodni magukról, akkor kezdenek keresni valamit, ami hiányzik, ahhoz, hogy elköltsék az ételt, az életet. 
A hiányzó dolgot itt a tűz szimbolizálja. A tűzet a nők őrzik, el kell menni, kérni tőlük. De veszélyes az út odáig, gondolják. A legbátrabb elindul, hogy megtegye azt az utat, ami nőt és férfit elválaszt. A faluba érkezve találkozik egy nővel, tüzet kér.
A nőnek is meg kell mutatnia, hogy érett a kapcsolatra, tud gondoskodni a párjáról. Ételt ad a férfinek, a férfi jónak találja, és ott marad. 
A többiek a barlangban aggódva lesik a társukat, az éhség – ami analógiába hozható a szeretet iránti vággyal – újabb férfit indít a nők faluja felé. 
A társak aggódva várnak, nem hisznek a jóslatnak, hiszen úgy tudják a síkságon démonok laknak. Elindul az utolsó előtti férfi is, megesküszik, hogy ő tűzzel tér vissza. De a tűz, amiért elindul csak nő és férfi között lobbanhat lángra, és nem adható tovább. 
Az utolsónak maradt férfi nem tudta legyőzni a félelmét, hogy megtegye az utat, inkább világgá ment.
Valaki hiába várt a faluban.
<br>
<br>


Az oroszlán-menyasszonyok. Dél-afrikai népmesék. (Válogatta az utószót és a jegyzeteket írta Bodrogi Tibor, fordította Borbás Mária , rajzolta Lóránt Péterné.) Bp. 1961, Európa. 175 p. 6 t.\
'
-- ==================================================================================
);

tag
