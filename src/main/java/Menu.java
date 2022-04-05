import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class Menu {

    private final Scanner READER = new Scanner(System.in);
    private final ArrayList<Student> STUDENTLIST = new ArrayList<>();
    private final ExamList EXAMLIST = new ExamList();
    private final ArrayList<Exam> EXAMS = EXAMLIST.getExamList();

    private final ExamAttempt EXAMATTEMPT = new ExamAttempt(false);
    private Exam EXAMTOTAKE = new Exam();

    private StringChecker stringChecker = new StringChecker();


    public static void showMenu() {
        System.out.println("");
        System.out.println("[1] Exam list");
        System.out.println("[2] Student list");
        System.out.println("[3] Register students");
        System.out.println("[4] Remove students");
        System.out.println("[5] Take exam");
        System.out.println("[6] Did student succeed?");
        System.out.println("[7] Which exams did student succeed in?");
        System.out.println("[8] Which student succeeded in most exams?");
        System.out.println("[9] Add exam");

        System.out.println("[X] Close program");
        System.out.println("Your choice:");
    }

    /***
     * Selection buttons for showMenu, proceeds with selected option
     * @param choise
     */
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
            case "7":
                passedStudents();
                break;
            case "8":
                bestStudent();
            case "9":
                Exam.addExam();
                showMenu();
                break;
            case "`":
                break;
            default:
                System.out.println(" is not a valid option choose again\n");
                showMenu();
        }
    }

    /***
     * Checks for student(s) with the most exams passed
     */
    private void bestStudent() {
    }

    private void passedStudents() {
    }

    /***
     * Removes students from the student list if given name and student number are equal to information in the list
     */

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
            System.out.println("No registered students found...");
        }
    }

    /***
     * Checks if in menu selected exam is available for exam attempt
     */
    public void isExamAvailable(String examChoise){
        for(Exam exam : EXAMS){
            if(exam.getNaam().equals(examChoise)){
                EXAMTOTAKE = exam;
            }
        }
    }

    /***
     * If exam candidate is registered show the list of exams
     */
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

 /*       for (Exam exam : EXAMS) {
            if (showExamList().equals(Choice)) {
                String a = exam.getNaam();
                isExamAvailable(a);
                EXAMATTEMPT.setExam(EXAMTOTAKE);
            }

        }*/

        switch (Choice) {
            case "1" -> {
                String a = "Open Vragen";
                isExamAvailable(a);
                EXAMATTEMPT.setExam(EXAMTOTAKE);
            }
            case "2" -> {
                String b = "MC Vragen";
                isExamAvailable(b);
                EXAMATTEMPT.setExam(EXAMTOTAKE);
            }
        }


        // TODO: Replace with foreach to support unlimited exams

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



    /***
     * Goes through each student in the student list and inserts them into the terminal with an ascending number
     */
    private String showStudentList() {
        StringBuilder students = new StringBuilder();
        students.append("Registered students: \n");
        if (STUDENTLIST.size() == 0) {
            students.append("No registered students found...");
        } else {
            for(int i = 0; i < STUDENTLIST.size(); i++) {
                students.append("\n[").append(i + 1).append("]").append(" ").append(STUDENTLIST.get(i).getNaam()).append(" ").append(STUDENTLIST.get(i).getStudentnummer());
            }
        }
        return students.toString();
    }
    /***
     * Goes through each exam in the exam list and inserts them into the terminal with an ascending number
     */
    private String showExamList() {
        StringBuilder exams = new StringBuilder();
        exams.append("Available exams include: \n");
        int i = 0;
        for (Exam exam : EXAMS){
            if (i++ == EXAMS.size() - 1) {
                exams.append("[").append(i).append("] ").append(exam.getNaam());
            } else {
                exams.append("[").append(i).append("] ").append(exam.getNaam()).append("\n");
            }
        }
        return exams.toString();
    }

    /***
     * Registers new students with their full name and student number into the exam program
     */

    private void studentRegister() {
        String studentName = "";
        while (studentName == "") {
            System.out.println("Type in your name >");
            String scanName = READER.nextLine().trim();
            if (stringChecker.isFullName(scanName)) {
                studentName = scanName;
            } else {
                System.out.println("\033[0;31m" + "Please enter a valid full name!" + "\033[0m");
            }
        }

        String studentNumber = "";
        while (studentNumber == "") {
            System.out.println("Type in your student number >");
            String scanNumber = READER.nextLine().trim();
            if (stringChecker.isStudentNumber(scanNumber)) {
                studentNumber = scanNumber;
            } else {
                System.out.println("\033[0;31m" + "Please enter a valid student number!" + "\033[0m");
            }
        }

        try {
            Student student = new Student(studentName, studentNumber);
            STUDENTLIST.add(student);
            System.out.println("\033[0;32m" + "You successfully registered a student!" + "\033[0m");
        } catch (Exception e) {
            System.out.println("\033[0;31m" + "Something went wrong. Try again!" + "\033[0m");
        }
    }

    /***
     *
     * @param studentNumber
     * @return
     */
    private Student findStudentWithNumber(String studentNumber) {
        Student candidate;
        for (Student value : STUDENTLIST) {
            String student = value.getStudentnummer();
            if (Objects.equals(studentNumber, student)) {
                candidate = value;
                return candidate;
            }
        }
        return null;
    }
}