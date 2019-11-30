package classes;

import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    int id;
    private String name;
    private String surname;
    private String address;
    private int creditCardNumber;
    private String bankAccountNumber;

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getName() {
        return name;
    }

    public Customer(int id, String name, String surname, String address, int creditCardNumber, String bankAccountNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    @Override
    public String toString() {
        return "\nCustomer\n{" +
                "name: " + name +
                ", surname: " + surname +
                ", address: " + address +
                ", creditCardNumber: " + creditCardNumber +
                ", bankAccountNumber: " + bankAccountNumber +
                "}";
    }

    public static void sort(Customer[] customers) {
        Arrays.sort(customers, (o1, o2) -> o1.getName().compareTo(o2.getName()));
    }

    public static ArrayList<Customer> getCustomersCardInInterval(Customer[] customers, int a, int b){
        ArrayList<Customer> customersCardInInterval = new ArrayList<>();
        if (a > b) {
            for (int i = 0; i < customers.length; i++) {
                if ((customers[i].getCreditCardNumber() > a) && (customers[i].getCreditCardNumber() < b)) {
                    customersCardInInterval.add(customers[i]);
                }
            }
        } else if (a < b) {
            for (int i = 0; i < customers.length; i++) {
                if ((customers[i].getCreditCardNumber() > a) && (customers[i].getCreditCardNumber() < b)) {
                    customersCardInInterval.add(customers[i]);
                }
            }
        } else {
            for (int i = 0; i < customers.length; i++) {
                if ((customers[i].getCreditCardNumber() == a) || (customers[i].getCreditCardNumber() == b)) {
                    customersCardInInterval.add(customers[i]);
                }
            }
        }
        return customersCardInInterval;
    }
}
