package Quiz;
import java.util.ArrayList;
import java.util.Scanner;
public class ValidateuserInputs {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student(101, "Priya", 75));
        studentList.add(new Student(102, "Seema", 69));
        studentList.add(new Student(103, "John", 92));
        Scanner sc = new Scanner(System.in);
        int id = -1;
        while (true) {
            System.out.print("Enter Student ID: ");
            String input = sc.nextLine();
            try {
                id = Integer.parseInt(input);
                if (id <= 0) {
                    System.out.println("ID must be a positive number. Try again.");
                    continue;
                }
                break; 
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }
        boolean found = false;
        for (Student s : studentList) {
            if (s.id == id) {
                System.out.println("Name: " + s.name);
                System.out.println("Score: " + s.score);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found!");
        }
        sc.close();
    }
}