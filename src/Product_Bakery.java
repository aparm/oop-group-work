public class Product_Bakery extends Product{
    public Product_Bakery(String name, double price, String type) {
        super(name, price, type);
    }

    @Override
    public String toString() {
        return "Bakery{" + getName() + "; " + getType() + "; " + getPrice() + "}";
    }
}
