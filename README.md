# Rühmatöö nr. 1

## Autorid:
Aleksei Parm, Aleksander Daniel Veske

## Projekti põhjalik kirjeldus:
See projekt on kohvikus mädžeri programm.
Sel programmis saab mänedžer vaadata kõike tooteid/töötajaid/kliente/tellimusi ja lisada uusi.
Samuti saad teha uut tellimust aknas Make Order, kus ta lisab erinevaid tooteid korvi.
Kasutusjuhist minu arvates ei ole vaja, selle pärast töötamine selles programmis on intuitiivne, kõik nuppud on tekstiga, mis iseloomustab tegevusi, mis saab teha selle nuppuga.

## Klassid:

### Customer - see klass on klientide klass, kus on list, kus on kõik registreeritud klientid olemas

#### Meetodid

addPurchasesSum() - kõike tellimuste summa

updateDiscount() - allahindlus kliendile sõltuv summast

toString() - kliendi tabeli printimine aknasse Show clients

addCostumer() - uue registreeritud klienti lisamine

findCustomer() - kliendi otsimine, et allahindlust anda ja vajadusel arve emaili saada


### GUI - klass, mis kujutab kõik, mis on tehtud projektis

#### Meetodid

menu() - GUI peaaken, koos kõigete nuppudega

makeOrder() - aken, et teha uut tellimust

showOrders() - kõige eksisteerivate tellimuste näitamine

showWorkers() - kõige eksisteerivate töötajate näitamine

addWorker() - uue töötajate lisamine

showCustomers() - kõige eksisteerivate registreeritud kliendide näitamine

addCustomer() - uute kliendi lisamine

showProducts() - kõige eksisteerivate toote näitamine

addProduct() - uute toote lisamine

### Main - peameetod

#### Meetodid

GUI.menu() - GUI kävitamine

### Order - klass, kus toimuvad arvutused tellimustele

#### Meetodid

productsSum() - kõige toote summa

toString() -  tellimuste tabeli prindimine aknasse Show orders

addOrder() - uue tellimuste lisamine

### OrderWithCustomer - klass, kust me võtame andmed

#### Meetodid

getCustomer() - kui juba registreeritud klient tegi tellimust, tema andmete võtmine

### Product - klass, kus asuvad tooted

#### Meetodid

addProduct() - uute toote lisamine

### Product_<Product_Name> - klassid, kus asuvad erineva tüübiga tooted

#### Meetodid

toString() - toote tabeli prindimine aknasse Show products

### Worker - klass, kus asuvad töötajad

#### Meetodid

toString() - töötajate tabeli prindimine aknasse Show workers

addWorker() - uue töötajate lisamine

### Worker_<Worker_Name> - klassid, kus asuvad erineva tüübiga töötajad

#### Meetodid

toString() - töötaja tabeli prindimine aknasse Show workers

## Tegemise protsess:
1. Idee loomine.
2. Mõtlemine, kuidas seda teha.
3. Kohustuse jagamine.
4. Töö algus.
5. Veade eemaldus.
6. Koodi lihtsustamine.
7. Töö lõpp.

## Rühmaliikme panus:

**Aleksei** - GUI kood, Customer kood, Order kood, Product kood, Worker kood.

Tööaeg:  tundi

**Aleksander** - Main lihtsustamine, Worker ja Product lihtsustamine, Product_<Product_name>, Worker_<Worker_Name>, README

Tööaeg: 10 tundi

**Koos** - Vea eemaldus, soovitused kuidas teha parem või lihtsustada

## Tegemise mured:

Ei saanud lisada workingTime andmeid ja samuti kuidas lisada Product_<Product_name>, Worker_<Worker_Name> (et kasutaks vastavaid klasse toote ja töötajate lisamises)

## Hinnang:

Me oleme rahul sellega, mida tegime. Saab arendada seda, millega olid mured.

## Korrektne töötamine:

Pärast GUI käivitamise vaatasime, kas on tulemus, mida me ootasime, või mitte. Samuti vaatasime kas on errorit või mitte.
