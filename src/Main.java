

import java.util.ArrayList;
import java.util.Date;

public class Main {

    static ArrayList<Order> orders = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Worker> workers = new ArrayList<>();
    static ArrayList<Product> products = new ArrayList<>();


    public static void addOrder(Order order) {
        orders.add(order);
    }


    public static void main(String[] args) {

        products.add(new Product_Coffee("Kohv", 1.2, "Americano"));
        products.add(new Product_Coffee("Kohv", 1.55, "Cappucino"));
        products.add(new Product_Bakery("Pirukas", 1.35, "Moosiga"));
        products.add(new Product_Bakery("Pirukas", 1.49, "Juustuga"));
        products.add(new Product_Hamburger("Burger", 4.5, "Klassika"));
        products.add(new Product_Hamburger("Burger", 5.7, "Toppelt"));
        products.add(new Product_Sandwich("Võileib", 3.49, "Tuunikala"));
        products.add(new Product_Sandwich("Võileib", 3.79, "Lõhe"));

        customers.add(new Customer("no", "", "", new Date(), false));
        customers.add(new Customer("Aleksei", "aparm@@gmail.com", "", new Date(), false));

        workers.add(new Worker_Manager("Volodja", "123"));
        workers.add(new Worker_Worker("Afanasij", "1234"));
        workers.add(new Worker_Security("Dmitri", "1234"));
        workers.add(new Worker_Coffeeman("Anatolij", "1234"));
        workers.add(new Worker_Cleaner("Roman", "1234"));



        GUI.menu();






    }
}
