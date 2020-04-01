import java.util.ArrayList;
import java.util.Date;


//не может быть изменен через сеттеры (только для просмотра)
public class Order {
    private Customer customer;
    private Worker worker;
    private Date date;
    private ArrayList<Product> products;

    private double totalSum; // конечная сумма вместе со скидкой

    public Order(Customer customer, Worker worker, Date date, ArrayList<Product> products) {
        this.customer = customer;
        this.worker = worker;
        this.date = date;
        this.products = products;

        totalSum = productsSum(products) * (1 - customer.getDiscount());
    }


    public Customer getCustomer() {
        return customer;
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
                "customer=" + customer +
                ", worker=" + worker +
                ", date=" + date +
                ", products=" + products +
                ", totalSum=" + totalSum +
                '}';
    }

    static ArrayList<Order> orders = new ArrayList<>();

    public static void addOrder(Order order){
        orders.add(order);
    }

}
