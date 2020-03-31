

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

        products.add(new Product_Coffee("Americano", 1.2));
        products.add(new Product_Coffee("Cappucino", 1.55));
        products.add(new Product_Bakery("Pirukas Moosiga", 1.35));
        products.add(new Product_Bakery("Pirukas Juustuga", 1.49));
        products.add(new Product_Hamburger("Burger ", 4.5));
        products.add(new Product_Hamburger("Toppeltburger", 5.7));
        products.add(new Product_Sandwich("Võileib Tuunikala", 3.49));
        products.add(new Product_Sandwich("Võileib Lõhe", 3.79));

        customers.add(new Customer("no", "", "", new Date(), false));
        customers.add(new Customer("Aleksei", "aparm@@gmail.com", "", new Date(), false));

        workers.add(new Worker_Manager("Volodja", "123"));
        workers.add(new Worker("Afanasij", "1234"));
        workers.add(new Worker_Security("Dmitri", "1234"));
        workers.add(new Worker_Coffeeman("Anatolij", "1234"));
        workers.add(new Worker_Cleaner("Roman", "1234"));



        GUI.menu();






    }
}
