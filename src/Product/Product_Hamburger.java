package Product;

public class Product_Hamburger extends Product{
    public Product_Hamburger(String name, double price) {
        super(name, price);
    }

    @Override
    public String getName() {return "Hamburger:" + super.getName(); }

    @Override
    public String toString() {
        return "Hamburger " + super.getName() + " - " + getPrice();
    }
}
