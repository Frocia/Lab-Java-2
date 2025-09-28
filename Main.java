import java.util.Scanner;
import java.util.Arrays;

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}

class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() { return start; }
    public Point getEnd() { return end; }

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}

class Student {
    private String name;
    private int[] grades;

    public Student(String name, int[] grades) {
        this.name = name;
        this.grades = grades;
    }

    public void setGrade(int index, int value) {
        if (index >= 0 && index < grades.length) {
            grades[index] = value;
        }
    }

    public int[] getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return name + ": " + Arrays.toString(grades);
    }
}

class Lab {

    // ========== ЗАДАНИЕ 1.1 ==========
    public void taskPoint() {
        Scanner scanner = new Scanner(System.in);
        Point[] points = new Point[3];

        System.out.println("Введите координаты 3 точек (X и Y через пробел):");
        for (int i = 0; i < 3; i++) {
            System.out.print("Точка " + (i + 1) + ": ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points[i] = new Point(x, y);
        }

        System.out.println("\nСозданные точки:");
        for (Point p : points) {
            System.out.println(p);
        }
    }

    // ========== ЗАДАНИЕ 2.1 ==========
    public void taskLine() {
        // Линия 1
        Point start1 = new Point(1, 3);
        Point end1 = new Point(23, 8);
        Line line1 = new Line(start1, end1);

        // Линия 2
        Point start2 = new Point(5, 10);
        Point end2 = new Point(25, 10);
        Line line2 = new Line(start2, end2);

        // Линия 3 (связана с line1.start и line2.end)
        Line line3 = new Line(start1, end2);

        System.out.println("Исходные линии:");
        System.out.println("1: " + line1);
        System.out.println("2: " + line2);
        System.out.println("3: " + line3);

        // Меняем координаты первой и второй линии
        start1.setX(10);
        start1.setY(20);
        end2.setX(40);
        end2.setY(10);

        System.out.println("\nПосле изменения 1 и 2:");
        System.out.println("1: " + line1);
        System.out.println("2: " + line2);
        System.out.println("3: " + line3);

        // Меняем первую линию полностью (новые точки)
        Point newStart = new Point(100, 200);
        Point newEnd = new Point(300, 400);
        line1 = new Line(newStart, newEnd);

        System.out.println("\nПосле замены точек у линии 1:");
        System.out.println("1: " + line1);
        System.out.println("3 (не изменился): " + line3);
    }

    // ========== ЗАДАНИЕ 3.1 ==========
    public void taskStudent31() {
        int[] vasyaGrades = {3, 4, 5};
        Student vasya = new Student("Вася", vasyaGrades);

        Student petya = new Student("Петя", vasya.getGrades());
        petya.setGrade(0, 5);

        System.out.println("После изменения Пети:");
        System.out.println(vasya);
        System.out.println(petya);
        System.out.println("Объяснение: у Васи тоже изменились оценки, так как массив общий.");

        int[] andreyGrades = Arrays.copyOf(vasyaGrades, vasyaGrades.length);
        Student andrey = new Student("Андрей", andreyGrades);

        vasya.setGrade(1, 2);

        System.out.println("\nПосле изменения Васи:");
        System.out.println(vasya);
        System.out.println(andrey);
        System.out.println("Объяснение: у Андрея оценки не изменились, так как массив скопирован.");
    }

    // ========== ЗАДАНИЕ 4.1 ==========
    public void taskStudent41() {
        System.out.println("Задание 4.1 (аналог 3.1):");
        taskStudent31();
    }

    // ========== ЗАДАНИЕ 4.2 ==========
    public void taskStudent42() {
        System.out.println("Задание 4.2 (аналог 3.1):");
        taskStudent31();
    }

    // ========== ЗАДАНИЕ 5.3 ==========
    public void taskStudent53() {
        System.out.println("Задание 5.3 (аналог 3.1):");
        taskStudent31();
    }

}

public class Main {
    public static void main(String[] args) {
        Lab lab = new Lab();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\nМеню:");
                System.out.println("1. Точка (1.1)");
                System.out.println("2. Линия (2.1)");
                System.out.println("3. Студент (3.1, 4.1, 4.2, 5.3)");
                System.out.println("0. Выход");
                System.out.print("Выберите задание: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> lab.taskPoint();
                    case 2 -> lab.taskLine();
                    case 3 -> {
                        System.out.println("\nПодменю студентов:");
                        System.out.println("1. 3.1");
                        System.out.println("2. 4.1");
                        System.out.println("3. 4.2");
                        System.out.println("4. 5.3");
                        System.out.print("Выберите подзадание: ");
                        int sub = scanner.nextInt();
                        switch (sub) {
                            case 1 -> lab.taskStudent31();
                            case 2 -> lab.taskStudent41();
                            case 3 -> lab.taskStudent42();
                            case 4 -> lab.taskStudent53();
                            default -> System.out.println("Ошибка: неверный ввод.");
                        }
                    }
                    case 0 -> {
                        System.out.println("Выход...");
                        return;
                    }
                    default -> System.out.println("Ошибка: неверный ввод.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода: " + e.getMessage());
                scanner.nextLine(); // очистка
            }
        }
    }
}
