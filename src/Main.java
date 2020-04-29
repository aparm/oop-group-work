import Product.Product;
import Worker.Worker;

//Peameetod.
public class Main {
    public static void main(String[] args) {

        //Lisame juba antud tooteid klassist Product.Product.
        Product.addProduct();
        //Lisame juba antud kliente klassist Customer.
        CustomersList.loadFromFile();
        //Lisame juba antud töötajaid klassist Töötaja.
        Worker.addWorker();

        //Käivitame GUI, kus toimuvad kõik teised asjad.
        GUI.menu();
    }
}
