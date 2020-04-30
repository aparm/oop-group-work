import Product.*;
import Worker.*;

//Peameetod.
public class Main {
    public static void main(String[] args) {

        //Lisame juba antud tooteid failist "products.dat".
        ProductsList.loadFromFile();

        //Lisame juba antud kliente failist "customers.dat".
        CustomersList.loadFromFile();

        //Lisame juba antud töötajaid failist "workers.dat".
        WorkersList.loadFromFile();

        //Lisame juba antud orders failist "orders.dat".
        OrdersList.loadFromFile();


        //Käivitame GUI, kus toimuvad kõik teised asjad.
        GUI.menu();
    }
}
