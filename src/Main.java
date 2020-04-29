import Product.*;
import Worker.*;

//Peameetod.
public class Main {
    public static void main(String[] args) {

        //Lisame juba antud tooteid klassist Product.Product.
        ProductsList.addProduct();
        //Lisame juba antud kliente klassist Customer.
        CustomersList.loadFromFile();
        //Lisame juba antud töötajaid klassist Töötaja.
        WorkersList.addWorker();

        OrdersList.loadFromFile();

        //Käivitame GUI, kus toimuvad kõik teised asjad.
        GUI.menu();
    }
}
