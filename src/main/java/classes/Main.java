package classes;

import java.util.Arrays;
import java.util.Scanner;

import static classes.Customer.getCustomersCardInInterval;
import static classes.Customer.sort;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите количество клиентов для заполнения: ");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Customer[] customers = new Customer[count];
        System.out.println("Введите данные для каждого клиента");
        for (int i = 0; i < customers.length; i++) {
            System.out.println("Введите id");
            int id = scanner.nextInt();
            System.out.println("Введите имя");
            String name = scanner.next();
            System.out.println("Введите фамилию");
            String surname = scanner.next();
            System.out.println("Введите адрес");
            String address = scanner.next();
            System.out.println("Введите номер кредитной карты");
            int creditCardNumber = scanner.nextInt();
            System.out.println("Введите номер банковского аккаунта");
            String bankAccountNumber = scanner.next();
            customers[i] = new Customer(id, name, surname, address, creditCardNumber, bankAccountNumber);
        }
        sort(customers);
        System.out.println(Arrays.toString(customers));

        System.out.println("Введите интервал для поиска по номеру кредитной карты. От: ");
        int a = scanner.nextInt();
        System.out.println("До: ");
        int b = scanner.nextInt();
        System.out.println(getCustomersCardInInterval(customers, a, b));
    }
}
