//осторожно - говнокод, работает плохо, но работает
//но работает не правильно
//в общем перепишу

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;

public class GUI {

    public static void menu(){
        JFrame fm = new JFrame("Menu");

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

        fm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });


        fm.setSize(800,400);
        fm.setLayout(null);
        fm.setVisible(true);
    }

    public static void makeOrder() {
        ArrayList<Product> products = Product.products;
        ArrayList<Product> orderProducts = new ArrayList<>();

        JFrame f=new JFrame("Make Order");

        for (int i = 0; i < products.size(); i++) {
            JButton productButton = new JButton(products.get(i).getName() +  " - " + products.get(i).getPrice());
            productButton.setBounds(50, 50 + 50 * i, 220, 40);

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
                Order.addOrder(new Order(Customer.customers.get(0), Worker.workers.get(0), new Date(), orderProducts));
            }
        });
        f.add(makeOrderButton);



        f.setSize(800,600);
        f.setLayout(null);
        f.setVisible(true);


    }


    //открывает в новом окне табличку со всеми заказами
    public static void showOrders(){
        JFrame fo = new JFrame("All orders");

        int n = Order.orders.size();


        Object[][] array = new String[n][4];
        for (int i = 0; i < n; i++) {
            array[i][0] = Order.orders.get(i).getCustomer().getEmail();
            array[i][1] = Order.orders.get(i).getWorker().getName();
            array[i][2] = Order.orders.get(i).getDate().toString();
            array[i][3] = Double.toString(Order.orders.get(i).getTotalSum());
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

        int n = Worker.workers.size();


        Object[][] array = new String[n][1];
        for (int i = 0; i < n; i++) {
            array[i][0] = Worker.workers.get(i).toString();
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

        int n = Customer.customers.size();


        Object[][] array = new String[n][1];
        for (int i = 0; i < n; i++) {
            array[i][0] = Customer.customers.get(i).toString();
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

        int n = Product.products.size();


        Object[][] array = new String[n][1];
        for (int i = 0; i < n; i++) {
            array[i][0] = Product.products.get(i).toString();
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
        JFrame frame = new JFrame("Add new product");

        JTextField nameField = new JTextField("Product name", 25);
        JTextField priceField = new JTextField("Price", 10);

        JButton addProductButton = new JButton("Add");
        addProductButton.setBounds(350, 150, 40, 20);
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Product.addProduct(new Product(nameField.getText(), Double.parseDouble(priceField.getText())));
                frame.setVisible(false);
                frame.dispose();
            }
        });




        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));

        contents.add(nameField);
        contents.add(priceField);
        contents.add(addProductButton);

        frame.setContentPane(contents);
        frame.setSize(400, 200);
        frame.setVisible(true);

    }

}
