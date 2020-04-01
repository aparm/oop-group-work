public class Product_Hamburger extends Product{
    public Product_Hamburger(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Hamburger " + getName() + " - " + getPrice();
    }
}
