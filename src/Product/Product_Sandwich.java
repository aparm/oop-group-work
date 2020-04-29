package Product;

public class Product_Sandwich extends Product{
    public Product_Sandwich(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Võileib " + getName() + " - " + getPrice();
    }
}
