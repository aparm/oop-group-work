package Product;

import java.util.ArrayList;

public class ProductsList {
    public static ArrayList<Product> products = new ArrayList<>();

    public static void addProduct(){
        products.add(new Product_Coffee("Americano", 1.2));
        products.add(new Product_Coffee("Cappucino", 1.55));
        products.add(new Product_Coffee("Latte", 2.09));
        products.add(new Product_Bakery("Pirukas Moosiga", 1.35));
        products.add(new Product_Bakery("Pirukas Juustuga", 1.49));
        products.add(new Product_Hamburger("Klassika", 4.5));
        products.add(new Product_Hamburger("Toppelt", 5.7));
        products.add(new Product_Sandwich("Tunikala", 3.49));
        products.add(new Product_Sandwich("Lõhe", 3.79));
    }

    public static void addProduct(Product product){
        products.add(product);
    }


    //сохраняет лист в файл
    public static void saveToFile() {

    }

    //загружает лист из файла
    public static void loadFromFile() {

    }
}
