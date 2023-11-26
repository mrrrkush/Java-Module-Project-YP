import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    static int peopleAmount;
    static double sum, price;
    static String input = "", totalProducts = "", name, products = "";
    public static void main(String[] args) {
        scanner.useLocale(Locale.ENGLISH);
        amount();
    }
       public static void amount() {

            while (true){
                System.out.println("На какое количество человек Вы планируете разделить счёт?");
                try {
                    peopleAmount = Main.scanner.nextInt();
                    break;
                } catch (Exception peopleAmount) {
                    System.out.println("Некорректное значение! Пожалуйста, повторите ввод");
                    scanner.nextLine();
                }
            }
            biggerThan();
        }


    public static class Calculator {
        public static void calculator() {
            sum = 0.0;
            while (true) {
               try {
                   innerLogic();
                   totalProducts = products;
                   break;
               } catch (Exception e) {
                   System.out.println("Некорректное значение! Пожалуйста, повторите ввод");
                   scanner.nextLine();
               }
           }
           scanner.close();
           System.out.println("Добавленные товары:" + totalProducts);
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
    public static void innerLogic() {
        while (!input.equalsIgnoreCase("Завершить")) {
            System.out.println("Введите название товара");
            name = scanner.next();
            System.out.println("Введите стоимость товара с копейками\nНапример, 25.10");
            price = scanner.nextDouble();

            if (price > 0) {
                sum += price;
                System.out.println(name + " успешно добавлен!\nХотите добавить ещё один товар?\nДля завершения введите: \"Завершить\"");
                input = scanner.next();
                products += "\n" + name;
            } else {
                System.out.println("Некорректное значение! Пожалуйста, повторите ввод");
            }
        }
    }
    public static void biggerThan (){
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
}