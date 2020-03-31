import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private String name;
    private String email;
    private String phoneNumber;
    private Date birthday;
    private boolean receiptToEmail; //если сумма покупки меньше 15 и тру, то отправить чек на почту (вывести сообщение об этом)

    private int code; //код чтобы назвать на кассе для скидки
    private static int count; //количество клиентов

    private double purchasesSum; //сумма покупок по которой рассчитывается скидка
    private double discount;

    public Customer(String name, String email, String phoneNumber, Date birthday, boolean receiptToEmail) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.receiptToEmail = receiptToEmail;

        count++;
        code = count; //пока код это просто нормер этого клиента, можно сделать что-то через рандом
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public boolean isReceiptToEmail() {
        return receiptToEmail;
    }

    public void setReceiptToEmail(boolean receiptToEmail) {
        this.receiptToEmail = receiptToEmail;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getCode() {
        return code;
    }

    public double getPurchasesSum() {
        return purchasesSum;
    }

    public double getDiscount() {
        return discount;
    }



    public void addPurchasesSum(double purchaseSum) {
        purchasesSum += purchaseSum;
        updateDiscount();
    }

    private void updateDiscount() {
        if (purchasesSum < 25) {
            discount = 0.03;
        }
        else if (purchasesSum < 50) {
            discount = 0.04;
        }
        else if (purchasesSum < 100) {
            discount = 0.05;
        }
        else discount = 0.07;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthday=" + birthday +
                ", receiptToEmail=" + receiptToEmail +
                ", code=" + code +
                ", purchasesSum=" + purchasesSum +
                ", discount=" + discount +
                '}';
    }
    static ArrayList<Customer> customers = new ArrayList<>();

    public static void addCostumer(){
        customers.add(new Customer("no", "", "", new Date(), false));
        customers.add(new Customer("Aleksei", "aparm@@gmail.com", "", new Date(), false));
    }
}
