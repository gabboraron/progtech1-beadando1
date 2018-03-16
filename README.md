Egy bolygón különböző fajtájú növények élnek, minden növény tápanyagot használ. Ha egy növény tápanyaga elfogy (a mennyiség 0 lesz), a növény elpusztul. A bolygón három fajta sugárzást különböztetünk meg: alfa sugárzás, delta sugárzás, ni
ncs sugárzás. A sugárzásra a különböző  fajtájú  növények  eltérő  módon  reagálnak.  A  reakció  tartalmazza  a  tápanyag 
változását, illetve a következő napi sugárzás befolyásolását. A másnapi  sugárzás alakulása: ha az alfa sugárzásra beérkezett igények összege legalább hárommal meghaladja a delta sugárzás igényeinek összegét, akkor alfa sugárzás lesz; ha a delta s
ugárzásra igaz ugyanez, akkor delta sugárzás lesz; ha a két igény  közti  eltérés háromnál kisebb, akkor nincs sugárzás. Az első nap 
sugárzás nélküli. 

# Szimuláljuk a növények viselkedését és minden lépésben írjuk ki az összes növényt a rájuk jellemző tulajdonságokkal, valamint az aktuális sugárzást! 
Minden növény jellemzői: az egyedi neve (String), a rendelkezésre álló tápanyag mennyisége (egész),  hogy  él-e  (logikai).  A  szimulációban  részt  vevő  növények  fajtái  a  következők: puffancs, deltafa, parabokor.  A  következőkben  megadjuk,  hogy  miként  reagálnak  a különböző  sugárzásokra.  Először  a  tápanyag  változik,  és  ha  a  növény ezután  él,  akkor befolyásolhatja a sugárzást. 

## Puffancs: 
    - Alfa sugárzás hatására a tápanyag mennyisége kettővel nő, sugárzás mentes napon a  tápanyag  eggyel  csökken,  delta  sugárzás  esetén  a  tápanyag  kettővel  csökken.  
    - Minden esetben  úgy  befolyásolja  a  másnapi  sugárzást,  hogy  10-tápanyag értékben  növeli  az  alfa sugárzás  bekövetkezését.  
    - Ez  a  fajta  akkor  is  elpusztul,  ha  a  tápanyag  mennyisége  10  fölé emelkedik. 

## Deltafa:
    - Alfa sugárzás hatására a tápanyag mennyisége hárommal csökken, sugárzás nélküli napon  a  tápanyag  eggyel  csökken,  delta  sugárzás  hatására  a  tápanyag  néggyel  nő.  
    - Ha  a tápanyag mennyisége 5-nél kisebb, akkor 4 értékben növeli a delta sugárzás bekövetkezését, ha 5 és 10 közé esik, akkor 1 értékben növeli a delta sugárzás bekövetkezését, ha 10-nél több, akkor nem befolyásolja a másnapi sugárzást. 

## Parabokor:
    - Akár  alfa,  akár  delta  sugárzás  hatására  a  tápanyag  mennyisége  eggyel  nő. 
    - Sugárzásnélküli napon a tápanyag eggyel csökken. 
    - A másnapi sugárzást nem befolyásolja. 

A  program  egy  szövegfájlból  olvassa  be  a  szimuláció  adatait!  Az  első  sorban  a  növények száma szerepel. A következő sorok tartalmazzák a növények adatait szóközökkel elválasztva: a növény nevét, a fajtáját és a kezdetben rendelkezésére álló tápanyag mennyiségét. 
A fajtát egy karakter azonosít: a – puffancs, d – deltafa, p – parabokor. 
A növényeket leíró részt követő sorban a szimuláció napjainak száma adott egész számként. A program kérje be a fájl nevét, majd jelenítse meg a túlélők nevét! (Feltehetjük, hogy a fájl formátuma helyes.) 

### Egy lehetséges bemenet: 
    4 
    Falánk a 7 
    Sudár d 5 
    Köpcös p 4 
    Nyúlánk d 3 
    10 
    
Javaslat:
    
    Hozza  létre  az  absztrakt  növény  osztályt,  amelyből  az  egyes  fajták  osztályait.  
    A konstruktor paramétere legyen a név és a tápanyag kezdeti mennyisége.  
    Egy nap elteltére is vezessen  be  művelet(ek)et,  a  visszatérő  érték  adja  meg,  hogy  a  növény  milyen  módon befolyásolja a következő nap sugárzását. 
    A befolyásolás lehet egy egész szám, ami pozitív alfa sugárzás esetén, negatív delta sugárzás esetén, nulla, ha a növény nem befolyásolja a másnapi sugárzást. 
    A végeredmény meghatározásához kell még 2 művelet: él-e a lény, illetve a név lekérdezés.
