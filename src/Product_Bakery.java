public class Product_Bakery extends Product{
    public Product_Bakery(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Pirukas{" + getName() + "; " + getPrice() + "}";
    }
}
