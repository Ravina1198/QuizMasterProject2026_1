package Quiz;
import java.util.Scanner;
public class AddNewQuestion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Question:");
        String question = sc.nextLine();
        System.out.println("Option A:");
        String optionA = sc.nextLine();
        System.out.println("Option B:");
        String optionB = sc.nextLine();
        System.out.println("Option C:");
        String optionC = sc.nextLine();
        System.out.println("Option D:");
        String optionD = sc.nextLine();
        System.out.println("Correct Answer:");
        String correctAnswer = sc.nextLine();
        System.out.println("Question Added Successfully!");
    }
}