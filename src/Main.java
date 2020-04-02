//Peameetod.
public class Main {
    public static void main(String[] args) {

        //Lisame juba antud tooteid klassist Product.
        Product.addProduct();
        //Lisame juba antud kliente klassist Customer.
        Customer.addCostumer();
        //Lisame juba antud töötajaid klassist Töötaja.
        Worker.addWorker();

        //Käivitame GUI, kus toimuvad kõik teised asjad.
        GUI.menu();
    }
}
