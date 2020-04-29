import java.util.ArrayList;

public class OrdersList {

    //Tellimuse listi loomine.
    public static ArrayList<Order> orders = new ArrayList<>();

    //Tellimuse lisamine.
    public static void addOrder(Order order){
        orders.add(order);
    }


    //сохраняет лист в файл
    public static void saveToFile() {

    }

    //загружает лист из файла
    public static void loadFromFile() {

    }
}
