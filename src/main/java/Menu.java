import java.awt.*;
import java.lang.reflect.Array;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private final Scanner READER = new Scanner(System.in);
    private ArrayList<Student> STUDENTLIST = new ArrayList<>();
    private final ExamList EXAMLIST = new ExamList();
    private final ArrayList<Exam> EXAMS = EXAMLIST.getExamList();

    private ExamAttempt EXAMATTEMPT = new ExamAttempt(false);
    private Exam EXAMTOTAKE = new Exam();


    public static void showMenu() {

        System.out.println("""

                ███████╗██╗░░██╗░█████╗░███╗░░░███╗  ██████╗░░█████╗░███╗░░██╗███████╗██╗░░░░░  ███████╗░█████╗░
                ██╔════╝╚██╗██╔╝██╔══██╗████╗░████║  ██╔══██╗██╔══██╗████╗░██║██╔════╝██║░░░░░  ╚════██║██╔══██╗
                █████╗░░░╚███╔╝░███████║██╔████╔██║  ██████╔╝███████║██╔██╗██║█████╗░░██║░░░░░  ░░░░██╔╝███████║
                ██╔══╝░░░██╔██╗░██╔══██║██║╚██╔╝██║  ██╔═══╝░██╔══██║██║╚████║██╔══╝░░██║░░░░░  ░░░██╔╝░██╔══██║
                ███████╗██╔╝╚██╗██║░░██║██║░╚═╝░██║  ██║░░░░░██║░░██║██║░╚███║███████╗███████╗  ░░██╔╝░░██║░░██║
                ╚══════╝╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░░░░╚═╝  ╚═╝░░░░░╚═╝░░╚═╝╚═╝░░╚══╝╚══════╝╚══════╝  ░░╚═╝░░░╚═╝░░╚═╝""");

        System.out.println("[1] Exam list");
        System.out.println("[2] Student list");
        System.out.println("[3] Register students");
        System.out.println("[4] Remove students");
        System.out.println("[5] Take exam");
        System.out.println("[6] Option 6");
        System.out.println("[X] Close program");
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
                removeStudents();
                break;
            case "5":
                takeExam();
                break;
            case "`":
                break;
            default:
                System.out.println(" is not a valid option choose again");
        }
    }

    private void removeStudents() {
    }

    public boolean isExamAvailible(String examChoise){
        boolean availible = false;
        for(Exam exam : EXAMS){
            if(exam.getNaam().equals(examChoise)){
                EXAMTOTAKE = exam;
                availible = true;
            }
        }
        return availible;
    }

    private void takeExam() {

        System.out.println(showExamList());
        String Choise = READER.nextLine();

        switch (Choise) {
            case "1":
                String a = "Open Vragen";
                isExamAvailible(a);
                EXAMATTEMPT.setExam(EXAMTOTAKE);
                break;
            case "2":
                String b = "MC Vragen";
                isExamAvailible(b);
                EXAMATTEMPT.setExam(EXAMTOTAKE);
                break;
        }

        ArrayList<Vraag> examQuestions = EXAMTOTAKE.getVragen();
        for (Vraag vraag : examQuestions) {
            System.out.println(vraag.getVraag());

            if (vraag.getKeuze() != null) {
                for (String choise : vraag.getKeuze()) {
                    System.out.println(choise);
                }
            }
            String answer = READER.nextLine();
            if (vraag.getAntwoord().equals(answer)) {
                System.out.println("goe");
            }
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
        StringBuilder exams = new StringBuilder();
        int i = 0;
        for (Exam exam : EXAMS){
            exams.append("[").append(i + 1).append("] ").append(exam.getNaam()).append("\n");
            i++;
        }
        return exams.toString();
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