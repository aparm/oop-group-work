

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

        products.add(new Product("Kohv 1", 1.2));
        products.add(new Product("Kohv 2", 1.55));
        products.add(new Product("Pirukas 1", 1.35));
        products.add(new Product("Pirukas 2", 1.49));

        customers.add(new Customer("no", "", "", new Date(), false));
        customers.add(new Customer("Aleksei", "aparm@@gmail.com", "", new Date(), false));

        workers.add(new Worker("Volodja-worker", "123"));
        workers.add(new Worker("Afanasij-worker", "1234"));



        GUI.menu();






    }
}
