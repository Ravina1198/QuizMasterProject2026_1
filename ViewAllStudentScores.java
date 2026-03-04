package Quiz;
import java.util.ArrayList;
public class ViewAllStudentScores {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student(101, "Priya", 75));
        studentList.add(new Student(102, "Seema", 69));
        studentList.add(new Student(103, "john", 92));
        System.out.println("---- Student Scores ----");
        for (Student s : studentList) {
            System.out.println("Name: " + s.name + " | Score: " + s.score);
        }
    }
}