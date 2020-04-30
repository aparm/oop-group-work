package Product;

public class Product_Sandwich extends Product{
    public Product_Sandwich(String name, double price) {
        super(name, price);
    }

    @Override
    public String getName() {return "Võileib:" + super.getName(); }

    @Override
    public String toString() {
        return "Võileib " + super.getName() + " - " + getPrice();
    }
}
