import java.util.Locale;
import java.util.Scanner;
public class Main {
    static int peopleAmount;
    static double sum;
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("На какое количество человек Вы планируете разделить счёт?");
        peopleAmount = scanner.nextInt();
        if (peopleAmount > 1) {
            Calculator.calculator();
        } else {
            while (peopleAmount <= 1) {
                System.out.println("Некорректное значение! Пожалуйста, повторите ввод");
                peopleAmount = scanner.nextInt();
            }
            Calculator.calculator();
        }
    }

    public static class Calculator {
        public static void calculator() {
            Scanner scanner = new Scanner(System.in);
            String input = "";
            String products = "";
            sum = 0.0;
            while (!input.equalsIgnoreCase("Завершить")) {
                System.out.println("Введите название товара");
                String name = scanner.next();
                products += "\n" + name;
                System.out.println("Введите стоимость товара с копейками\nНапример, 25.10");
                double price = scanner.nextDouble();
                sum += price;
                System.out.println(name + " успешно добавлен!\nХотите добавить ещё один товар?\nДля завершения введите: \"Завершить\"");
                input = scanner.next();
            }
            scanner.close();
            System.out.println("Добавленные товары:" + products);
            Format.format();
        }
    }
    public static class Format {
        public static void format() {
            double total = Math.floor(sum / peopleAmount);
            double totalPrice = sum / peopleAmount;
            if (total == 1) {
                System.out.printf("Каждый должен заплатить: %.2f рубль", totalPrice);
            } else if (total <=4){
                System.out.printf("Каждый должен заплатить: %.2f рубля", totalPrice);
            } else {
                System.out.printf("Каждый должен заплатить: %.2f рублей", totalPrice);
            }
        }
    }
}