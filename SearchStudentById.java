package Quiz;
import java.util.ArrayList;
import java.util.Scanner;
public class SearchStudentById {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student(101, "Priya", 75));
        studentList.add(new Student(102, "Seema", 69));
        studentList.add(new Student(103, "John", 92));
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        for (Student s : studentList) {
            if (s.id == id) {
                System.out.println("Name: " + s.name);
                System.out.println("Score: " + s.score);
                sc.close();
                return;
            }
        }
        System.out.println("Student not found!");
        sc.close();
    }
}