import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private final Scanner READER = new Scanner(System.in);
    private ArrayList<Student> STUDENTLIST = new ArrayList<>();

    public static void showMenu() {

        System.out.println("""

                ███████╗██╗░░██╗░█████╗░███╗░░░███╗  ██████╗░░█████╗░███╗░░██╗███████╗██╗░░░░░  ███████╗░█████╗░
                ██╔════╝╚██╗██╔╝██╔══██╗████╗░████║  ██╔══██╗██╔══██╗████╗░██║██╔════╝██║░░░░░  ╚════██║██╔══██╗
                █████╗░░░╚███╔╝░███████║██╔████╔██║  ██████╔╝███████║██╔██╗██║█████╗░░██║░░░░░  ░░░░██╔╝███████║
                ██╔══╝░░░██╔██╗░██╔══██║██║╚██╔╝██║  ██╔═══╝░██╔══██║██║╚████║██╔══╝░░██║░░░░░  ░░░██╔╝░██╔══██║
                ███████╗██╔╝╚██╗██║░░██║██║░╚═╝░██║  ██║░░░░░██║░░██║██║░╚███║███████╗███████╗  ░░██╔╝░░██║░░██║
                ╚══════╝╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░░░░╚═╝  ╚═╝░░░░░╚═╝░░╚═╝╚═╝░░╚══╝╚══════╝╚══════╝  ░░╚═╝░░░╚═╝░░╚═╝""");

        System.out.println("1. Exam list");
        System.out.println("2. Student list");
        System.out.println("3. Register students");
        System.out.println("4. Remove students");
        System.out.println("5. Take exam");
        System.out.println("6. Option 6");
        System.out.println("X. Close program");
    }

    public void getChoise(String choise) {
        switch (choise) {
            case "1":
                System.out.println(showExamList());
                break;
            case "2":
                System.out.println(showStudentList());
                break;
            case "3":
                studentRegister();
                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                break;
            default:
                System.out.println(" is not a valid option choose again");
        }
    }

    private String showStudentList() {
        StringBuilder students = new StringBuilder();
        for(int i = 0; i < STUDENTLIST.size(); i ++) {
            students.append("\n[").append(i + 1).append("]").append(" ").append(STUDENTLIST.get(i).getNaam()).append(" ").append(STUDENTLIST.get(i).getStudentnummer());
        }
        return students.toString();
    }

    private String showExamList() {
        String exams ="";
        return exams;
    }

    private void studentRegister() {
        System.out.println("Type in your name >");
        String studentName = READER.nextLine().trim();
        // TODO - ADDING REGEX
        System.out.println("Type in your student number >");
        String studentNumber = READER.nextLine().trim();
        // TODO - ADDING REGEX

        Student student = new Student(studentName, studentNumber);
        STUDENTLIST.add(student);
    }
}