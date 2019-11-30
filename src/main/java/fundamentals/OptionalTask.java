package fundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class OptionalTask {
    public static void main(String[] args) {
        //array input from the console
        System.out.println("Введите количество далее введенных чисел n: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] array = new String[n];
        System.out.println("Введите числа");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.next();
        }
        System.out.println("Ваш массив: " + Arrays.toString(array));

        //Task  1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
        int minLength = 10, maxLength = 0;
        String minStr = null, maxStr = null;
        for (String digit : array) {
            if (digit.length() < minLength) {
                minLength = digit.length();
                minStr = digit;
            }
            if (digit.length() > maxLength) {
                maxLength = digit.length();
                maxStr = digit;
            }
        }
        System.out.println("Самое короткое число: " + minStr + ", состоит из " + minLength + " цифр(ы)" +
                "\nСамое динное число: " + maxStr + ", состоит из " + maxLength + " цифр(ы)");


        //Task 2.     Вывести числа в порядке возрастания (убывания) значений их длины.
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j].length() > array[j + 1].length()) {
                    String tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }

    private static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}



