//позже станет суперклассом для классов "Кофе", "Пироженные", "Завтраки" и тд

import java.util.ArrayList;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
    static ArrayList<Product> products = new ArrayList<>();

    public static void addProduct(){
        products.add(new Product_Coffee("Americano", 1.2));
        products.add(new Product_Coffee("Cappucino", 1.55));
        products.add(new Product_Coffee("Latte", 2.09));
        products.add(new Product_Bakery("Pirukas Moosiga", 1.35));
        products.add(new Product_Bakery("Pirukas Juustuga", 1.49));
        products.add(new Product_Hamburger("Burger ", 4.5));
        products.add(new Product_Hamburger("Toppeltburger", 5.7));
        products.add(new Product_Sandwich("Võileib Tuunikala", 3.49));
        products.add(new Product_Sandwich("Võileib Lõhe", 3.79));
    }
    /*
    public void addNewProduct(Product product, String name, String price){
        products.add(product, "lol", 1.2);
    }

     */
}
