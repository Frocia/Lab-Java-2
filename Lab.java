import java.util.Arrays;
import java.util.Scanner;

public class Lab {

    // Метод безопасного считывания целого числа
    private int readInt(Scanner scanner, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                break;
            } else {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next(); // пропускаем некорректный ввод
            }
        }
        return value;
    }

    // 1.1 — Точки
    public void task11(Scanner scanner) {
        Point[] points = new Point[3];
        System.out.println("Введите координаты 3 точек (X Y):");
        for (int i = 0; i < 3; i++) {
            int x = readInt(scanner, "X: ");
            int y = readInt(scanner, "Y: ");
            points[i] = new Point(x, y);
        }
        System.out.println("Созданные точки:");
        for (Point p : points) System.out.println(p);
    }

    // 2.1 — Линии
    public void task21(Scanner scanner) {
        Line line1 = new Line(new Point(1, 3), new Point(23, 8));
        Line line2 = new Line(new Point(5, 10), new Point(25, 10));
        Line line3 = new Line(line1.getStart(), line2.getEnd());

        System.out.println("Исходные линии:");
        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3: " + line3);

        System.out.println("\nИзменяем линии:");
        line1.setStart(new Point(readInt(scanner, "Линия 1, начало X: "), readInt(scanner, "Y: ")));
        line1.setEnd(new Point(readInt(scanner, "Линия 1, конец X: "), readInt(scanner, "Y: ")));

        line2.setStart(new Point(readInt(scanner, "Линия 2, начало X: "), readInt(scanner, "Y: ")));
        line2.setEnd(new Point(readInt(scanner, "Линия 2, конец X: "), readInt(scanner, "Y: ")));

        line3 = new Line(line1.getStart(), line2.getEnd());

        System.out.println("\nПосле изменений:");
        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3: " + line3);
    }

    // 3.1 — Студенты
    public void task31() {
        int[] vasyaGrades = {3,4,5};
        Student vasya = new Student("Вася", vasyaGrades);
        Student petya = new Student("Петя", vasyaGrades);
        petya.getGrades()[0] = 5;

        System.out.println("Вася: " + vasya);
        System.out.println("Петя: " + petya);
        System.out.println("Объяснение: Пети и Вася используют один массив оценок, поэтому изменение Пети влияет на Васю.");

        int[] andreyGrades = Arrays.copyOf(vasyaGrades, vasyaGrades.length);
        Student andrey = new Student("Андрей", andreyGrades);
        System.out.println("Андрей: " + andrey);
    }

    // 4.1 — Точки
    public void task41(Scanner scanner) {
        Point p1 = new Point(readInt(scanner, "Точка 1, X: "), readInt(scanner, "Y: "));
        Point p2 = new Point(readInt(scanner, "Точка 2, X: "), readInt(scanner, "Y: "));

        System.out.println("Точка 1: " + p1);
        System.out.println("Точка 2: " + p2);
    }

    // 4.2 — Линии
    public void task42(Scanner scanner) {
        Line line1 = new Line(
                readInt(scanner, "Линия 1, начало X: "), readInt(scanner, "Y: "),
                readInt(scanner, "Линия 1, конец X: "), readInt(scanner, "Y: ")
        );

        Line line2 = new Line(
                readInt(scanner, "Линия 2, начало X: "), readInt(scanner, "Y: "),
                readInt(scanner, "Линия 2, конец X: "), readInt(scanner, "Y: ")
        );

        Line line3 = new Line(line1.getStart(), line2.getEnd());

        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3: " + line3);
    }

    // 5.3 — Длина линии
    public void task53(Scanner scanner) {
        Line line = new Line(
                readInt(scanner, "Начало линии X: "), readInt(scanner, "Y: "),
                readInt(scanner, "Конец линии X: "), readInt(scanner, "Y: ")
        );

        System.out.println("Линия: " + line);
        System.out.println("Длина линии: " + line.getLength());
    }
}
