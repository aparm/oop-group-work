import Worker.*;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrdersList {

    //Tellimuse listi loomine.
    public static ArrayList<Order> orders = new ArrayList<>();

    //Tellimuse lisamine.
    public static void addOrder(Order order){
        orders.add(order);
    }

    //Salvestame listi faili
    //сохраняет лист в файл
    public static void saveToFile() {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("orders.dat"));

            dos.writeInt(orders.size());

            for (Order order : orders) {
                dos.writeUTF(order.getWorker().getName());

                DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                String date = df.format(order.getDate());
                dos.writeUTF(date);

                dos.writeDouble(order.getTotalSum());

                if (order instanceof OrderWithCustomer) {
                    dos.writeBoolean(true);
                    dos.writeInt(((OrderWithCustomer) order).getCustomer().getCode());
                }
                else dos.writeBoolean(false);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //Laadimee listi failist
    //загружает лист из файла
    public static void loadFromFile() {

        try {
            DataInputStream dos = new DataInputStream(new FileInputStream("orders.dat"));
            int n = dos.readInt();
            for (int i = 0; i < n; i++) {
                String workerName = dos.readUTF();
                String dateStr = dos.readUTF();
                double totalSum = dos.readDouble();
                boolean onOrderWithCustomer = dos.readBoolean();
                Integer customerCode = null;
                if (onOrderWithCustomer) {
                    customerCode = dos.readInt();
                }

                Date date;
                try {
                    date = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse(dateStr);
                } catch (ParseException e) {
                    date = new Date();
                    e.printStackTrace();
                }

                if (WorkersList.findWorker(workerName) != null) {
                    Worker worker = WorkersList.findWorker(workerName);

                    if (onOrderWithCustomer) {
                        Customer customer = CustomersList.findCustomer(customerCode);
                        if (customer != null) {
                            OrderWithCustomer orderWithCustomer = new OrderWithCustomer(customer, worker, date, new ArrayList<>());
                            orderWithCustomer.setTotalSum(totalSum);
                            orders.add(orderWithCustomer);
                        }
                        else {
                            Order order = new Order(worker, date, new ArrayList<>());
                            order.setTotalSum(totalSum);
                            orders.add(order);
                        }
                    }
                    else {
                        Order order = new Order(worker, date, new ArrayList<>());
                        order.setTotalSum(totalSum);
                        orders.add(order);
                    }

                }
                else {
                    Worker worker = new Worker(workerName, "");
                    WorkersList.addWorker(worker);

                    if (onOrderWithCustomer) {
                        Customer customer = CustomersList.findCustomer(customerCode);
                        if (customer != null) {
                            OrderWithCustomer orderWithCustomer = new OrderWithCustomer(customer, worker, date, new ArrayList<>());
                            orderWithCustomer.setTotalSum(totalSum);
                            orders.add(orderWithCustomer);
                        }
                        else {
                            Order order = new Order(worker, date, new ArrayList<>());
                            order.setTotalSum(totalSum);
                            orders.add(order);
                        }
                    }
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