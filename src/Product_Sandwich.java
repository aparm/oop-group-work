public class Product_Sandwich extends Product{
    public Product_Sandwich(String name, double price, String type) {
        super(name, price, type);
    }

    @Override
    public String toString() {
        return "Sandwich{" + getName() + "; " + getType() + "; " + getPrice() + "}";
    }
}
