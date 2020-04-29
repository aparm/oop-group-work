import Product.Product;
import Worker.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class OrdersList {

    //Tellimuse listi loomine.
    public static ArrayList<Order> orders = new ArrayList<>();

    //Tellimuse lisamine.
    public static void addOrder(Order order){
        orders.add(order);
    }


    //сохраняет лист в файл
    public static void saveToFile() {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("orders.dat"));

            dos.writeInt(orders.size());

            for (Order order : orders) {
                dos.writeUTF(order.getWorker().getName());
                dos.writeUTF(order.getDate().toString());
                dos.writeDouble(order.getTotalSum());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //загружает лист из файла
    public static void loadFromFile() {

        try {
            DataInputStream dos = new DataInputStream(new FileInputStream("orders.dat"));
            int n = dos.readInt();
            for (int i = 0; i < n; i++) {
                String workerName = dos.readUTF();
                String dateStr = dos.readUTF();
                double totalSum = dos.readDouble();

                if (WorkersList.findWorker(workerName) != null) {
                    Worker worker = WorkersList.findWorker(workerName);
                    //Date date = Date.parse(dateStr);
                    //TODO: Date.parse https://www.javatpoint.com/java-string-to-date
                    Order order = new Order(worker, new Date(), new ArrayList<>());
                    order.setTotalSum(totalSum);
                    orders.add(order);
                }
                else {
                    Worker worker = new Worker(workerName, "");
                    WorkersList.addWorker(worker);
                    Order order = new Order(worker, new Date(), new ArrayList<>());
                    order.setTotalSum(totalSum);
                    orders.add(order);
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
