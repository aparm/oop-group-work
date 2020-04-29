import java.util.ArrayList;

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

    //сохраняет лист в файл
    public static void saveToFile() {

    }

    //загружает лист из файла
    public static void loadFromFile() {

    }

}
