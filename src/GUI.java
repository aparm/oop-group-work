import Product.*;
import Worker.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class GUI {

    //главное окно, все кнопки расписаны отдельно
    //GUI peaaken, kus asuvad kõik nuppud
    public static void menu(){
        //GUI menüü loomine
        JFrame fm = new JFrame("Menu");

        //Nupp, mis näitab eksisteerivaid töötajaid kasutades meetodi showWorkers()
        JButton showWorkersButton = new JButton("Show workers");
        showWorkersButton.setBounds(20, 20, 120, 40);
        showWorkersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                showWorkers();
            }
        });
        fm.add(showWorkersButton);

        //Nupp, mis lisab uut töötajaid kasutades meetodis addWorker()
        JButton addWorkerButton = new JButton("Add worker");
        addWorkerButton.setBounds(160, 20, 120, 40);
        addWorkerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addWorker();
            }
        });
        fm.add(addWorkerButton);

        //Nupp, mis näitab eksisteerivaid kliente kasutades meetodi showCustomers()
        JButton showCustomersButton = new JButton("Show customers");
        showCustomersButton.setBounds(20, 80, 120, 40);
        showCustomersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                showCustomers();
            }
        });
        fm.add(showCustomersButton);

        //Nupp, mis lisab uusi kliente kasutades meetodi addCustomer()
        JButton addCustomerButton = new JButton("Add customer");
        addCustomerButton.setBounds(160, 80, 120, 40);
        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addCustomer();
            }
        });
        fm.add(addCustomerButton);

        //Nupp, mis näitab eksisteerivaid tellimusi kasutades meetodi showOrders()
        JButton showOrdersButton = new JButton("Show orders");
        showOrdersButton.setBounds(20, 160, 120, 40);
        showOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                showOrders();
            }
        });
        fm.add(showOrdersButton);

        //Nupp, mis näitab eksisteerivaid tooteid kasutades meetodi showProducts()
        JButton showProductsButton = new JButton("Show products");
        showProductsButton.setBounds(20, 220, 120, 40);
        showProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                showProducts();
            }
        });
        fm.add(showProductsButton);

        //Nupp, mis lisab uusi tooteid kasutades meetodi addProduct()
        //Lisab klassist Product.Product, teisi ei kasutata
        JButton addProductButton = new JButton("Add product");
        addProductButton.setBounds(160, 220, 120, 40);
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addProduct();
            }
        });
        fm.add(addProductButton);

        //Nupp, mis avad uut akna, kus töötaja saab lisada tellimusele seda, mis klient tahab.
        //Kasutades meetodi makeOrder().
        //Töötaja peab sisestama kliendi koodi, et tellimus töötaks.
        JButton makeOrderButton = new JButton("Make order");
        makeOrderButton.setBounds(600, 300, 120, 40);
        makeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                makeOrder();

            }
        });
        fm.add(makeOrderButton);

        //Programm suletakse, kui vajutad exit nuppu.
        fm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        //Akna mõõtmed.
        fm.setSize(800,400);
        fm.setLayout(null);
        fm.setVisible(true);
    }


    //окно совершения заказа
    //Make Order aken.
    public static void makeOrder() {
        JFrame f=new JFrame("Make Order");

        //Tooteid, mis on vasakul on juba eksisteerivad.
        ArrayList<Product> products = ProductsList.products; //все продукты, которые отображаются слева
        //Tooteid, mis on paremal lisatakse tellimusele.
        ArrayList<Product> orderProducts = new ArrayList<>(); //продукты для заказа, которые отображаются справа


        //отрисовка кнопок продуктов
        //Nuppude kujutis.
        for (int i = 0; i < products.size(); i++) {

            //Tooteid, mis on vasakul.
            JButton productButton = new JButton(products.get(i).toString()); //кнопки для всех продуктов (слева)
            productButton.setBounds(50, 50 + 50 * i, 250, 40);

            int finalI = i;
            productButton.addActionListener(new ActionListener() { //при нажатии на кнопку продукта
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    // Mis iganes toode nuppu vajutades lisame seda toote listi.
                    orderProducts.add(products.get(finalI)); //добавляем продукт в лист

                    //Kujutame nuppu sellele tootele paremal.
                    JButton orderProductButton = new JButton(orderProducts.get(orderProducts.indexOf(products.get(finalI))).toString() + " delete"); //создаем кнопку этого продукта справа
                    orderProductButton.setBounds(400, 50 * orderProducts.size(), 250, 40);
                    orderProductButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) { //при нажатии на кнопку продукта справа
                            //Kui me vajutame mis iganes toote nuppule, mis on paremal, siis kustutame selle toote listist.
                            orderProducts.remove(orderProducts.indexOf(products.get(finalI))); //удаляем продукт из листа
                            //Kustutame nuppu.
                            f.remove(orderProductButton); //удаляем кнопку
                            //Iga kord, kui midagi muutub aknas, me ünberjoonistame seda.
                            f.repaint(); //каждый раз как что-то меняем в окне, перерисовываем окно
                        }
                    });
                    f.add(orderProductButton);
                    f.repaint();
                }
            });
            f.add(productButton);
        }


        //проверка есть ли покупатель в базе
        //Vaatame, kas klient on baasis.
        JTextField customerCodeField = new JTextField("Customer code", 25);
        customerCodeField.setBounds(600,440, 120, 20);
        f.add(customerCodeField);

        JButton checkCustomerButton = new JButton("Check");
        checkCustomerButton.setBounds(600, 470, 120, 20);
        checkCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if ((CustomersList.findCustomer(Integer.parseInt(customerCodeField.getText()))) != null) {
                    checkCustomerButton.setText(CustomersList.findCustomer(Integer.parseInt(customerCodeField.getText())).getName());
                }
                else checkCustomerButton.setText("ei ole");
            }
        });
        f.add(checkCustomerButton);


        //кнопка заказа, если покупатель есть - создаем заказ с покупателем, если нет - обычный заказ
        //Tellimuse nupp, kui on olemas baasist klient - kliendiga tellimus, kui ei ole - tavaline tellimus.
        JButton makeOrderButton = new JButton("Make order");
        makeOrderButton.setBounds(600, 500, 120, 40);
        makeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if ((CustomersList.findCustomer(Integer.parseInt(customerCodeField.getText()))) != null) {
                    Customer thisCustomer = Objects.requireNonNull(CustomersList.findCustomer(Integer.parseInt(customerCodeField.getText())));
                    Order thisOrder = new OrderWithCustomer(thisCustomer, WorkersList.workers.get(0), new Date(), orderProducts);
                    OrdersList.addOrder(thisOrder);
                    thisCustomer.addPurchasesSum(thisOrder.getTotalSum());
                }
                else {
                    OrdersList.addOrder(new Order(WorkersList.workers.get(0), new Date(), orderProducts));
                    OrdersList.saveToFile();
                }

                //закрываем текущее окно
                //Suletame jooksevat akent.
                f.setVisible(false);
                f.dispose();
            }
        });
        f.add(makeOrderButton);

        //Make Order akna mõõtmed.
        f.setSize(800,600);
        f.setLayout(null);
        f.setVisible(true);
    }


    //открывает в новом окне табличку со всеми заказами
    //Uues aknas avad tabelit tellimustega.
    public static void showOrders(){
        JFrame fo = new JFrame("All orders");

        //Tellimuste arv.
        int n = OrdersList.orders.size(); //количество заказов


        //данные таблицы
        //Tabeli andmeid.
        Object[][] array = new String[n][4];
        for (int i = 0; i < n; i++) {
            //Kontrollime tellimust koos baasis klientiga, kui ei ole - siis on null.
            OrderWithCustomer owc = OrdersList.orders.get(i) instanceof OrderWithCustomer ? ((OrderWithCustomer) OrdersList.orders.get(i)) : null; //проверяем заказ с покупателем, если нет то null
            if (owc != null) {
                //Kui ei ole null, siis paneme tellija reale tema emaili.
                array[i][0] = owc.getCustomer().getEmail(); //если не null записываем в строку покупателя емаил
            }
            //Kui on null, siis kirjutame et ei ole kliendi baasist.
            else { array[i][0] = "Ei ole customer"; } //если null то пишем что нет покупателя

            //Töötaja reas kirjutame töötaja nimi.
            array[i][1] = OrdersList.orders.get(i).getWorker().getName(); //в строке работника записываем имя работника
            //Tellimuse kuupäev.
            array[i][2] = OrdersList.orders.get(i).getDate().toString(); //дата совершения заказа
            //Tellimuse summa.
            array[i][3] = Double.toString(OrdersList.orders.get(i).getTotalSum()); //конечная сумма заказа
        }


        //названия столбцов
        //Veerude nimed
        Object[] columnsHeader = new String[] {"Customer", "Worker", "Date", "Total sum"};


        JTable table = new JTable(array, columnsHeader);


        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(table));


        fo.setContentPane(contents);
        fo.setSize(800,400);
        fo.setVisible(true);
    }


    //открывает в новом окне табличку со всеми работниками (просто 1 столбец и выводится туСтринг, позже можно сделать полноценную таблицу)
    //Uues aknas avad tabelit koos kõikededa töötajatega.
    public static void showWorkers() {
        JFrame fo = new JFrame("Workers");

        int n = WorkersList.workers.size();


        Object[][] array = new String[n][1];
        for (int i = 0; i < n; i++) {
            array[i][0] = WorkersList.workers.get(i).toString();
        }


        Object[] columnsHeader = new String[] {"Worker"};
        JTable table = new JTable(array, columnsHeader);


        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(table));


        fo.setContentPane(contents);
        fo.setSize(800,400);
        fo.setVisible(true);
    }

    //окно добавления работника (добавляется обычный работник (Worker.Worker)! не реализовано добавление по классам)
    //Töötaja lisamise aken. (Lisatakse tavalist töötajat (Worker.Worker), erinavete töötajate lisamine ei ole realiseeritud.)
    public static void addWorker(){
        JFrame frame = new JFrame("Add new worker");

        JTextField nameField = new JTextField("Name", 25);
        JTextField passwordField = new JTextField("Password", 25);

        JButton addProductButton = new JButton("Add");
        addProductButton.setBounds(350, 150, 40, 20);
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                WorkersList.addWorker(new Worker(nameField.getText(), passwordField.getText()));
                WorkersList.saveToFile();
                frame.setVisible(false);
                frame.dispose();
            }
        });


        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));

        contents.add(nameField);
        contents.add(passwordField);
        contents.add(addProductButton);

        frame.setContentPane(contents);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }

    //окно со всеми покупателями (через туСтринг, позже можно переделать в полноценную таблицу)
    //Kõike klientidega baasis tabel.
    public static void showCustomers() {
        JFrame fc = new JFrame("Customers");

        int n = CustomersList.customers.size();


        Object[][] array = new String[n][1];
        for (int i = 0; i < n; i++) {
            array[i][0] = CustomersList.customers.get(i).toString();
        }


        Object[] columnsHeader = new String[] {"Customer"};
        JTable table = new JTable(array, columnsHeader);

        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(table));


        fc.setContentPane(contents);
        fc.setSize(800,400);
        fc.setVisible(true);
    }

    //Uue klienti lisamise aken.
    public static void addCustomer() {
        JFrame frame = new JFrame("Add new customer");

        JTextField nameField = new JTextField("Customer name", 25);
        JTextField emailField = new JTextField("Email", 25);
        JTextField phoneField = new JTextField("Phone number", 25);


        JButton addProductButton = new JButton("Add");
        addProductButton.setBounds(350, 150, 40, 20);
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                CustomersList.addCustumer(new Customer(nameField.getText(), emailField.getText(), phoneField.getText(), new Date(), false));
                CustomersList.saveToFile();
                frame.setVisible(false);
                frame.dispose();
            }
        });




        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));

        contents.add(nameField);
        contents.add(emailField);
        contents.add(phoneField);
        contents.add(addProductButton);

        frame.setContentPane(contents);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
    //Aken, mis näitab kõike eksisteerivaid tooteid.
    public static void showProducts() {
        JFrame fp = new JFrame("Products");

        int n = ProductsList.products.size();


        Object[][] array = new String[n][1];
        for (int i = 0; i < n; i++) {
            array[i][0] = ProductsList.products.get(i).toString();
        }


        Object[] columnsHeader = new String[] {"Product"};


        JTable table = new JTable(array, columnsHeader);


        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(table));


        fp.setContentPane(contents);
        fp.setSize(800,400);
        fp.setVisible(true);
    }

    //Aken, kus me lisame uut tooteid.
    public static void addProduct() {
        JFrame frame = new JFrame("Add new product");

        JTextField nameField = new JTextField("Product.Product name", 25);
        JTextField priceField = new JTextField("Price", 10);

        JButton addProductButton = new JButton("Add");
        addProductButton.setBounds(350, 150, 40, 20);
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ProductsList.addProduct(new Product(nameField.getText(), Double.parseDouble(priceField.getText())));
                ProductsList.saveToFile();
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
