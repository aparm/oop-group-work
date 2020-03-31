public class Product_Hamburger extends Product{
    private String type;

    public Product_Hamburger(String name, double price, String type) {
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
        return "Hamburger{" + getName() + "; " + getType() + "; " + getPrice() + "}";
    }
}
