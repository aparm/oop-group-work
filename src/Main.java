

import java.util.ArrayList;
import java.util.Date;

public class Main {


    public static void addOrder(Order order) {
        Order.orders.add(order);
    }


    public static void main(String[] args) {

        Product.addProduct();
        Customer.addCostumer();
        Worker.addWorker();


        GUI.menu();






    }
}
