public class Product_Coffee extends Product{
    private String type;

    public Product_Coffee(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Coffee{" + getName() + "; " + getType() + "; " + getPrice() + "}";
    }
}
