package Product;

public class Product_Coffee extends Product{
    public Product_Coffee(String name, double price) {
        super(name, price);
    }

    @Override
    public String getName() {return "Kohv:" + super.getName(); }

    @Override
    public String toString() {
        return "Kohv " + super.getName() + " - " + getPrice();
    }
}
