import java.util.Arrays;
import java.util.Scanner;

public class Lab {

    /** ---------------- Точка ---------------- */
    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() { return x; }
        public int getY() { return y; }

        public void setX(int x) { this.x = x; }
        public void setY(int y) { this.y = y; }

        @Override
        public String toString() {
            return "{" + x + ";" + y + "}";
        }
    }

    /** ---------------- Линия ---------------- */
    static class Line {
        private Point start;
        private Point end;

        public Line(Point start, Point end) {
            this.start = start;
            this.end = end;
        }

        public Line(int x1, int y1, int x2, int y2) {
            this.start = new Point(x1, y1);
            this.end = new Point(x2, y2);
        }

        public Point getStart() { return start; }
        public Point getEnd() { return end; }

        public void setStart(Point start) { this.start = start; }
        public void setEnd(Point end) { this.end = end; }

        @Override
        public String toString() {
            return "Линия от " + start + " до " + end;
        }

        public int getLength() {
            int dx = end.getX() - start.getX();
            int dy = end.getY() - start.getY();
            return (int) Math.sqrt(dx * dx + dy * dy);
        }
    }

    /** ---------------- Студент ---------------- */
    static class Student {
        private String name;
        private int[] grades;

        public Student(String name, int[] grades) {
            this.name = name;
            this.grades = grades;
        }

        public void setGrades(int[] grades) { this.grades = grades; }
        public int[] getGrades() { return grades; }
        public String getName() { return name; }

        @Override
        public String toString() {
            return name + ": " + Arrays.toString(grades);
        }
    }

    /** ---------------- Методы ---------------- */

    // 1.1 — Точки (пользовательский ввод)
    public void task11(Scanner scanner) {
        Point[] points = new Point[3];
        System.out.println("Введите координаты 3 точек (X Y):");
        for (int i = 0; i < 3; i++) {
            System.out.print("Точка " + (i + 1) + ": ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points[i] = new Point(x, y);
        }
        System.out.println("Созданные точки:");
        for (Point p : points) System.out.println(p);
    }

    // 2.1 — Линии (пользовательский ввод)
    public void task21(Scanner scanner) {
        Line line1 = new Line(new Point(1, 3), new Point(23, 8));
        Line line2 = new Line(new Point(5, 10), new Point(25, 10));
        Line line3 = new Line(line1.getStart(), line2.getEnd());

        System.out.println("Исходные линии:");
        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3: " + line3);

        System.out.println("\nИзменяем линии:");
        System.out.print("Линия 1, начало (X Y): ");
        line1.setStart(new Point(scanner.nextInt(), scanner.nextInt()));
        System.out.print("Линия 1, конец (X Y): ");
        line1.setEnd(new Point(scanner.nextInt(), scanner.nextInt()));

        System.out.print("Линия 2, начало (X Y): ");
        line2.setStart(new Point(scanner.nextInt(), scanner.nextInt()));
        System.out.print("Линия 2, конец (X Y): ");
        line2.setEnd(new Point(scanner.nextInt(), scanner.nextInt()));

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

    // 4.1 — Точки (пользовательский ввод)
    public void task41(Scanner scanner) {
        System.out.print("Введите координаты точки 1 (X Y): ");
        Point p1 = new Point(scanner.nextInt(), scanner.nextInt());
        System.out.print("Введите координаты точки 2 (X Y): ");
        Point p2 = new Point(scanner.nextInt(), scanner.nextInt());

        System.out.println("Точка 1: " + p1);
        System.out.println("Точка 2: " + p2);
    }

    // 4.2 — Линии (пользовательский ввод)
    public void task42(Scanner scanner) {
        System.out.print("Линия 1, начало (X Y): ");
        int x1 = scanner.nextInt(), y1 = scanner.nextInt();
        System.out.print("Линия 1, конец (X Y): ");
        int x2 = scanner.nextInt(), y2 = scanner.nextInt();
        Line line1 = new Line(x1, y1, x2, y2);

        System.out.print("Линия 2, начало (X Y): ");
        int x3 = scanner.nextInt(), y3 = scanner.nextInt();
        System.out.print("Линия 2, конец (X Y): ");
        int x4 = scanner.nextInt(), y4 = scanner.nextInt();
        Line line2 = new Line(x3, y3, x4, y4);

        Line line3 = new Line(line1.getStart(), line2.getEnd());

        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3: " + line3);
    }

    // 5.3 — Длина линии (пользовательский ввод)
    public void task53(Scanner scanner) {
        System.out.print("Введите начало линии (X Y): ");
        int x1 = scanner.nextInt(), y1 = scanner.nextInt();
        System.out.print("Введите конец линии (X Y): ");
        int x2 = scanner.nextInt(), y2 = scanner.nextInt();

        Line line = new Line(x1, y1, x2, y2);
        System.out.println("Линия: " + line);
        System.out.println("Длина линии: " + line.getLength());
    }
}