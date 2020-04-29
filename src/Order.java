import Product.Product;
import Worker.Worker;

import java.util.ArrayList;
import java.util.Date;


//не может быть изменен через сеттеры (только для просмотра)
public class Order {

    private Worker worker;
    private Date date;
    private ArrayList<Product> products;

    //Tellimuse summa koos allahindlusega.
    private double totalSum; // конечная сумма вместе со скидкой

    public Order(Worker worker, Date date, ArrayList<Product> products) {

        this.worker = worker;
        this.date = date;
        this.products = products;

        totalSum = productsSum(products);
    }

    public Worker getWorker() {
        return worker;
    }

    public Date getDate() {
        return date;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    private double productsSum (ArrayList<Product> products) {
        double sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Order{" +
                ", worker=" + worker +
                ", date=" + date +
                ", products=" + products +
                ", totalSum=" + totalSum +
                '}';
    }



}
