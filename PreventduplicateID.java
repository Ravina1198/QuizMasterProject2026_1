package Quiz;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
public class PreventduplicateID {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        HashSet<String> studentNames = new HashSet<>(); 
        Scanner sc = new Scanner(System.in);
        addStudent(studentList, studentNames, 101, "Priya", 75);
        addStudent(studentList, studentNames, 102, "Seema", 69);
        addStudent(studentList, studentNames, 103, "John", 92);
        addStudent(studentList, studentNames, 104, "Seema", 88); 
        int studentId = getValidatedStudentId(sc);
        boolean found = false;
        for (Student s : studentList) {
            if (s.id == studentId) {
                System.out.println("Name: " + s.name);
                System.out.println("Score: " + s.score);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Student not found!");
        sc.close();
    }
    public static void addStudent(ArrayList<Student> list, HashSet<String> names, int id, String name, int score) {
        if (names.contains(name)) {
            System.out.println("Duplicate name detected: " + name + ". Student not added.");
            return;
        }
        list.add(new Student(id, name, score));
        names.add(name);
    }
    public static int getValidatedStudentId(Scanner sc) {
        int id = -1;
        while (true) {
            System.out.print("Enter Student ID: ");
            String input = sc.nextLine();
            try {
                id = Integer.parseInt(input);
                if (id <= 0) {
                    System.out.println("ID must be positive. Try again.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
        return id;
    }
}