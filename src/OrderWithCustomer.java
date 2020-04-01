import java.util.ArrayList;
import java.util.Date;

public class OrderWithCustomer extends Order {
    private Customer customer;

    public OrderWithCustomer(Customer customer, Worker worker, Date date, ArrayList<Product> products) {
        super(worker, date, products);
        this.customer = customer;
        this.setTotalSum(this.getTotalSum() * (1 - customer.getDiscount()));
    }

    public Customer getCustomer() {
        return customer;
    }
}
