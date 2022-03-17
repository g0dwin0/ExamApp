import java.awt.*;
import java.lang.reflect.Array;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        System.out.println("[6] Did student succeed?");
        System.out.println("[7] Which exams did student succeed in?");
        System.out.println("[8] Which student succeeded in most exams?");
        System.out.println("[X] Close program");
        System.out.println("Your choice:");
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
        Collections.shuffle(examQuestions);

        for (Vraag vraag : examQuestions) {
            System.out.println(vraag.getVraag());

            if (vraag.getKeuze() != null) {
                for (String choise : vraag.getKeuze()) {
                    System.out.println(choise);
                }
            }
            String answer = READER.nextLine();
            if (vraag.getAntwoord().equals(answer)) {
                System.out.println("Goed");
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
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(studentNumber);
        if(studentNumber.length() > 8 || studentNumber.length() == 0) {
            System.out.println("Student nummer is te lang, of te kort.");
            return;
        }
        boolean matchFound = matcher.matches();
        if(matchFound) {
            for(Student student : STUDENTLIST) {
                if(Objects.equals(student.getStudentnummer(), studentNumber)) {
                    System.out.println("Nummer is niet uniek.");
                    return;
                }
            }
            Student student = new Student(studentName, studentNumber);
            STUDENTLIST.add(student);
        } else {
            System.out.println("Uw invoer is geen nummer, of is langer dan 8 nummers.");
            return;
        }
        // TODO - ADDING REGEX


    }
}