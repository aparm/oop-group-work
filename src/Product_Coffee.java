public class Product_Coffee extends Product{
    public Product_Coffee(String name, double price, String type) {
        super(name, price, type);
    }

    @Override
    public String toString() {
        return "Coffee{" + getName() + "; " + getType() + "; " + getPrice() + "}";
    }
}
