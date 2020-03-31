//осторожно - говнокод, работает плохо, но работает
//но работает не правильно
//в общем перепишу

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class GUI {

    public static void menu(){
        JFrame fm =new JFrame("Menu");

        JButton showWorkersButton = new JButton("Show workers");
        showWorkersButton.setBounds(20, 20, 120, 40);
        showWorkersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                showWorkers();
            }
        });
        fm.add(showWorkersButton);


        JButton addWorkerButton = new JButton("Add worker");
        addWorkerButton.setBounds(160, 20, 120, 40);
        addWorkerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addWorker();
            }
        });
        fm.add(addWorkerButton);


        JButton showCustomersButton = new JButton("Show customers");
        showCustomersButton.setBounds(20, 80, 120, 40);
        showCustomersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                showCustomers();
            }
        });
        fm.add(showCustomersButton);


        JButton addCustomerButton = new JButton("Add customer");
        addCustomerButton.setBounds(160, 80, 120, 40);
        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addCustomer();
            }
        });
        fm.add(addCustomerButton);


        JButton showOrdersButton = new JButton("Show orders");
        showOrdersButton.setBounds(20, 160, 120, 40);
        showOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                showOrders();
            }
        });
        fm.add(showOrdersButton);


        JButton showProductsButton = new JButton("Show products");
        showProductsButton.setBounds(20, 220, 120, 40);
        showProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                showProducts();
            }
        });
        fm.add(showProductsButton);


        JButton addProductButton = new JButton("Add product");
        addProductButton.setBounds(160, 220, 120, 40);
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addProduct();
            }
        });
        fm.add(addProductButton);

        JButton makeOrderButton = new JButton("Make order");
        makeOrderButton.setBounds(600, 300, 120, 40);
        makeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                makeOrder();

            }
        });
        fm.add(makeOrderButton);


        fm.setSize(800,400);
        fm.setLayout(null);
        fm.setVisible(true);
    }

    public static void makeOrder() {
        ArrayList<Product> products = Main.products;
        ArrayList<Product> orderProducts = new ArrayList<>();

        JFrame f=new JFrame("Make Order");

        for (int i = 0; i < products.size(); i++) {
            JButton productButton = new JButton(products.get(i).getName() +  " " + products.get(i).getType() + " - " + products.get(i).getPrice());
            productButton.setBounds(50, 50 + 50 * i, 520, 40);

            int finalI = i;
            productButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    orderProducts.add(products.get(finalI));

                    JButton orderProductButton = new JButton(orderProducts.get(orderProducts.indexOf(products.get(finalI))).getName());
                    orderProductButton.setBounds(400, 50 * orderProducts.size(), 120, 40);
                    orderProductButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            orderProducts.remove(orderProducts.indexOf(products.get(finalI)));
                            f.remove(orderProductButton);
                            f.repaint();
                        }
                    });


                    f.add(orderProductButton);
                    /** repaint - перерисовать окно!
                     * После добавления новой кнопки перерисавываем окно */
                    f.repaint();

                }
            });
            f.add(productButton);
        }



        JButton makeOrderButton = new JButton("Make order");
        makeOrderButton.setBounds(600, 300, 120, 40);
        makeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.addOrder(new Order(Main.customers.get(0), Main.workers.get(0), new Date(), orderProducts));
            }
        });
        f.add(makeOrderButton);



        f.setSize(800,400);
        f.setLayout(null);
        f.setVisible(true);


    }


    //открывает в новом окне табличку со всеми заказами
    public static void showOrders(){
        JFrame fo = new JFrame("All orders");

        int n = Main.orders.size();


        Object[][] array = new String[n][4];
        for (int i = 0; i < n; i++) {
            array[i][0] = Main.orders.get(i).getCustomer().getEmail();
            array[i][1] = Main.orders.get(i).getWorker().getName();
            array[i][2] = Main.orders.get(i).getDate().toString();
            array[i][3] = Double.toString(Main.orders.get(i).getTotalSum());
        }


        Object[] columnsHeader = new String[] {"Customer", "Worker", "Date", "Total sum"};


        JTable table = new JTable(array, columnsHeader);


        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(table));


        fo.setContentPane(contents);
        fo.setSize(800,400);
        fo.setVisible(true);
    }


    //открывает в новом окне табличку со всеми работниками
    public static void showWorkers(){
        JFrame fo = new JFrame("Workers");

        int n = Main.workers.size();


        Object[][] array = new String[n][1];
        for (int i = 0; i < n; i++) {
            array[i][0] = Main.workers.get(i).toString();
        }


        Object[] columnsHeader = new String[] {"Worker"};


        JTable table = new JTable(array, columnsHeader);


        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(table));


        fo.setContentPane(contents);
        fo.setSize(800,400);
        fo.setVisible(true);
    }

    public static void addWorker() {

    }


    public static void showCustomers() {
        JFrame fc = new JFrame("Customers");

        int n = Main.customers.size();


        Object[][] array = new String[n][1];
        for (int i = 0; i < n; i++) {
            array[i][0] = Main.customers.get(i).toString();
        }


        Object[] columnsHeader = new String[] {"Customer"};


        JTable table = new JTable(array, columnsHeader);


        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(table));


        fc.setContentPane(contents);
        fc.setSize(800,400);
        fc.setVisible(true);
    }


    public static void addCustomer() {

    }

    public static void showProducts() {
        JFrame fp = new JFrame("Products");

        int n = Main.products.size();


        Object[][] array = new String[n][1];
        for (int i = 0; i < n; i++) {
            array[i][0] = Main.products.get(i).toString();
        }


        Object[] columnsHeader = new String[] {"Product"};


        JTable table = new JTable(array, columnsHeader);


        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(table));


        fp.setContentPane(contents);
        fp.setSize(800,400);
        fp.setVisible(true);
    }

    public static void addProduct() {

    }
}
