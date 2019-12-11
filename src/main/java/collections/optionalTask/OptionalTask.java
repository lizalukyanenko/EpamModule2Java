package collections.optionalTask;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;


public class OptionalTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Task 2.   Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.
        System.out.println("Введите число");
        int digit = 0;
        try {
            digit = scanner.nextInt();
        } catch (InputMismatchException ex) {
            System.err.println("Ошибка ввода.");
        }
        reverseOrder(digit);
        System.out.println();

        //Task 7. Задана строка, состоящая из символов «(», «)», «[», «]», «{», «}». Проверить правильность расстановки скобок. Использовать стек.
        System.out.println("Введите строку со скобками");
        String strWithParentheses = scanner.next();
        if (parsingOfParentheses(strWithParentheses)) {
            System.out.println("Скобки расставлены верно.");
        } else {
            System.out.println("Скобки расставлены не верно.");
        }
    }

    public static void reverseOrder(int digit){
        Stack stack = new Stack();
        char [] numbers = String.valueOf(digit).toCharArray();
        for (char number: numbers) {
            stack.push(number);
        }

        while (!stack.empty()) {
            char stackNumber;
            stackNumber = (Character) stack.pop();
            System.out.print(stackNumber);
        }
    }

    public static boolean parsingOfParentheses(String str) {
        int check = 0;
        for (int i = 0; i < str.length(); i++) {
            if (check < 0) {
                return false;
            }
            String symbol = str.substring(i, i + 1);
            if (symbol.equals("(") || symbol.equals("{") || symbol.equals("[")) {
                check++;
                continue;
            }
            if (symbol.equals(")") || symbol.equals("}") || symbol.equals("]"))
                check--;
        }
        if (check == 0) {
            return true;
        } else {
            return false;
        }
    }
}
