import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lab lab = new Lab();

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Задание 1.1 — Точки");
            System.out.println("2. Задание 2.1 — Линии");
            System.out.println("3. Задание 3.1 — Студенты");
            System.out.println("4. Задание 4.1 — Создание точек");
            System.out.println("5. Задание 4.2 — Создание линий");
            System.out.println("6. Задание 5.3 — Длина линии");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт: ");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Ошибка ввода. Введите число.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1: lab.task11(scanner); break;
                case 2: lab.task21(scanner); break;
                case 3: lab.task31(); break;
                case 4: lab.task41(scanner); break;
                case 5: lab.task42(scanner); break;
                case 6: lab.task53(scanner); break;
                case 0:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Ошибка ввода. Попробуйте снова.");
            }
        }
    }
}
