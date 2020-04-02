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


### GUI - GUI

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

### Main - main

#### Meetodid

GUI.menu() - GUI kävitamine

### Order - order

#### Meetodid

productsSum() - kõige toote summa

toString() -  tellimuste tabeli prindimine aknasse Show orders

addOrder() - uue tellimuste lisamine

### OrderWithCustomer -

#### Meetodid

getCustomer() - kui juba registreeritud klient tegi tellimust, tema andmete võtmine

### Product - pr

#### Meetodid

addProduct() - uute toote lisamine

### Product_<Product_Name> -

#### Meetodid

toString() - toote tabeli prindimine aknasse Show products

### Worker -

#### Meetodid

toString() - töötajate tabeli prindimine aknasse Show workers

addWorker() - uue töötajate lisamine

### Worker_<Worker_Name> -

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

## Tegemise mured:

## Hinnang:

## Korrektne töötamine:
