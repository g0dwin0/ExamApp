import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
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
        if(STUDENTLIST.size() != 0){
            System.out.println("Enter your student number");
            String studentnumber = READER.nextLine();
            System.out.println("Enter your name");
            String studentname = READER.nextLine();

            if(STUDENTLIST.removeIf(student -> student.getNaam().equals(studentname) && student.getStudentnummer().equals(studentnumber))) {
                System.out.println("Student " + studentname + " has been removed");
            } else {
                System.out.println("This student does not exist");
                removeStudents();
            }
        } else {
            System.out.println("Studentlist does not contain any students");
        }
    }

    public boolean isExamAvailable(String examChoise){
        boolean available = false;
        for(Exam exam : EXAMS){
            if(exam.getNaam().equals(examChoise)){
                EXAMTOTAKE = exam;
                available = true;
            }
        }
        return available;
    }

    private void takeExam() {

        System.out.println(showStudentList());
        Student candidate = null;
        while (candidate == null) {
            System.out.println("Vul jouw studentnummer in:");
            String studentNumber = READER.nextLine();
            candidate = findStudentWithNumber(studentNumber);
            if (candidate == null) {
                System.out.println("Student niet gevonden.");
            }
        }


        System.out.println(showExamList());
        String Choice = READER.nextLine();

        switch (Choice) {
            case "1":
                String a = "Open Vragen";
                isExamAvailable(a);
                EXAMATTEMPT.setExam(EXAMTOTAKE);
                break;
            case "2":
                String b = "MC Vragen";
                isExamAvailable(b);
                EXAMATTEMPT.setExam(EXAMTOTAKE);
                break;
        }

        ArrayList<Vraag> examQuestions = EXAMTOTAKE.getVragen();
        Collections.shuffle(examQuestions);


        int aantalJuist = 0;
        for (Vraag vraag : examQuestions) {
            System.out.println(vraag.getVraag());

            if (vraag.getKeuze() != null) {
                for (String choise : vraag.getKeuze()) {
                    System.out.println(choise);
                }
            }
            String answer = READER.nextLine();
            if (vraag.getAntwoord().equals(answer)) {
                aantalJuist++;
                System.out.println("goed");
            }
        }
        candidate.addResult(new Resultaat(EXAMTOTAKE, aantalJuist));
        double aantalJuist2 = aantalJuist;
        double vragenSize = examQuestions.size();
        if(candidate.getStudentResults().isGehaald()) {
            System.out.printf("Je hebt de toets gehaald! Dit is jouw resultaat: %.1f", (aantalJuist2 / vragenSize * 10.0));
        }
        else {
            System.out.printf("Je hebt de toets niet gehaald... Dit is jouw resultaat: %.1f", (aantalJuist2 / vragenSize * 10.0));
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

    private Student findStudentWithNumber(String studentNumber) {
        Student candidate;
        for (int i = 0; i < STUDENTLIST.size(); i++) {
            String student = STUDENTLIST.get(i).getStudentnummer();
            if (Objects.equals(studentNumber, student)) {
                candidate = STUDENTLIST.get(i);
                return candidate;
            }
        }
        return null;
    }
}