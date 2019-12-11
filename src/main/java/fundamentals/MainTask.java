package fundamentals;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Task 1: Приветствовать любого пользователя при вводе его имени через командную строку.
        System.out.println("Введите Ваше имя: ");
        hello(scanner.next());

        //Task 2: Отобразить в окне консоли аргументы командной строки в обратном порядке.
        System.out.println("*******************************");
        args = new String[2];
        args[0] = "1";
        args[1] = "2";
        argsOut(args);

        //Task 3: Вывести заданное количество случайных чисел с переходом и без перехода на новую строку.
        System.out.println("*******************************");
        System.out.println("Введите количество цифр для вывода: ");
        randomNumberOutput(scanner.nextInt());
        System.out.println();


        //Task 4: Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.
        System.out.println("*******************************");
        System.out.println("Введите целые цисла для подсчета суммы и произведения");
        for(int i = 0; i < args.length; i++) {
            args[i] = scanner.next();
        }
        sumAndMultiplication(args);

        //Task 5 : Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.
        System.out.println("*******************************");
        System.out.println("Введите номер месяца (от 1 до 12)");
        setMonth(scanner.nextInt());

        scanner.close();
    }

    public static void hello(String name){
        System.out.println("Здравствуйте, "  + name);
    }

    public static void argsOut(String[] args){
        System.out.println("Обратный вывод аргументов");
        for (int i = args.length - 1 ; i >= 0 ; i--) {
            System.out.println("Аргумент №"+ i + ": " + args[i]);
        }
    }

    public static void randomNumberOutput(int countOfNumbers){
        double[] array = new double[countOfNumbers];
        System.out.println("Каждое на новой строке");
        for (int i = 0; i < array.length; i++){
            array[i] = Math.random();
            System.out.println(array[i]);
        }
        System.out.println("Все на одной строке");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + "  ");
        }
    }

    public static void sumAndMultiplication(String[] args){
        int sum = 0;
        int multiplication = 1;
        for(int i = 0; i < args.length; i++) {
            int number = Integer.parseInt(args[i]);
            sum += number;
            multiplication *= number;
        }
        System.out.println("Сумма = " + sum);
        System.out.println("Произведение = "+ multiplication);
    }

    public static void setMonth(int numberOfMonth){
        String[] months = {"январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};
        try {
            System.out.println("Ваш месяц называется " + months[numberOfMonth - 1]);
        } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
            System.err.println("Такого месяца не существует");
        }
    }
}
