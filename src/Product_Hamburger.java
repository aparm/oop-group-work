public class Product_Hamburger extends Product{
    public Product_Hamburger(String name, double price, String type) {
        super(name, price, type);
    }

    @Override
    public String toString() {
        return "Hamburger{" + getName() + "; " + getType() + "; " + getPrice() + "}";
    }
}
