import java.util.Arrays;

public class Student {
    private String name;
    private int[] grades;

    public Student(String name, int[] grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() { return name; }
    public int[] getGrades() { return grades; }
    public void setGrades(int[] grades) { this.grades = grades; }

    @Override
    public String toString() {
        return name + ": " + Arrays.toString(grades);
    }
}