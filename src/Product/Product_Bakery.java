package Product;

public class Product_Bakery extends Product{
    public Product_Bakery(String name, double price) {
        super(name, price);
    }

    @Override
    public String getName() {return "Bakery:" + super.getName(); }

    @Override
    public String toString() {
        return "Bakery: " + super.getName() + " - " + getPrice();
    }

}
