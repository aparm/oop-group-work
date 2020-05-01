import Product.Product;
import Worker.Worker;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class CustomersList {
    public static ArrayList<Customer> customers = new ArrayList<>();

    public static void addCustumer(Customer customer) {
        customers.add(customer);
    }

    //Vaatame, kas on sisestatud koodiga klient.
    public static Customer findCustomer(int code) {
        for (Customer customer : customers) {
            if (customer.getCode() == code) return customer;
        }
        return null;
    }
    //Salvsestame listi faili
    //сохраняет лист в файл
    public static void saveToFile() {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("customers.dat"));

            dos.writeInt(customers.size());

            for (Customer customer : customers) {
                dos.writeUTF(customer.getName());
                dos.writeUTF(customer.getEmail());
                dos.writeUTF(customer.getPhoneNumber());
                dos.writeInt(customer.getCode());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Laadimee listi failist
    //загружает лист из файла
    public static void loadFromFile() {
        try {
            DataInputStream dos = new DataInputStream(new FileInputStream("customers.dat"));

            int n = dos.readInt();

            for (int i = 0; i < n; i++) {
                String name = dos.readUTF();
                String email = dos.readUTF();
                String pn = dos.readUTF();
                int code = dos.readInt();
                Customer customer = new Customer(name, email, pn, new Date(), false);
                customer.setCode(code);
                customers.add(customer);

            }

        } catch (FileNotFoundException e) {
            System.out.println("Ei ole seda faili");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
