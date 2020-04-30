package Product;

import java.io.*;
import java.util.ArrayList;

public class ProductsList {
    public static ArrayList<Product> products = new ArrayList<>();


    public static void addProduct(Product product){
        products.add(product);
    }


    //сохраняет лист в файл
    public static void saveToFile() {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("products.dat"));

            dos.writeInt(products.size());

            for (Product product : products) {
                dos.writeUTF(product.getName());
                dos.writeDouble(product.getPrice());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //загружает лист из файла
    public static void loadFromFile() {
        try {
            DataInputStream dos = new DataInputStream(new FileInputStream("products.dat"));

            int n = dos.readInt();

            for (int i = 0; i < n; i++) {
                String name = dos.readUTF();
                double price = dos.readDouble();

                if (name.startsWith("Bakery:")) {
                    String bakeryName = name.replace("Bakery:", "");
                    products.add(new Product_Bakery(bakeryName, price));
                } else if (name.startsWith("Kohv:")) {
                    String coffeeName = name.replace("Kohv:", "");
                    products.add(new Product_Coffee(coffeeName,price));
                } else if (name.startsWith("Hamburger:")) {
                    String hambName = name.replace("Hamburger:", "");
                    products.add(new Product_Hamburger(hambName,price));
                } else if (name.startsWith("Võileib:")) {
                    String sandvName = name.replace("Võileib:", "");
                    products.add(new Product_Sandwich(sandvName,price));
                } else {
                    products.add(new Product(name,price));
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("Ei ole seda faili");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
