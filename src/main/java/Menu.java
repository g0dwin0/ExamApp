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
    private Student candidate;
    private final StringChecker stringChecker = new StringChecker();


    public static void showMenu() {
        System.out.println("");
        System.out.println("[1] Examen lijst");
        System.out.println("[2] Studenten lijst");
        System.out.println("[3] Student registreren");
        System.out.println("[4] Student verwijderen");
        System.out.println("[5] Examen doen");
        System.out.println("[6] Heeft de student het examen gehaald?");
        System.out.println("[7] Welke examens heeft de student gehaald?");
        System.out.println("[8] Welk student heeft de meeste examens gehaald?");
        System.out.println("[9] Examen toevoegen");

        System.out.println("[X] Programma afsluiten");
        System.out.println("Voor uw keuze in:");
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
                selectStudent();
                break;
            case "6":
                didStudentPassExam();
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
            System.out.println("Vul jouw studentnummer in:");
            String studentNumber = READER.nextLine();
            System.out.println("Vul jouw volledige naam in:");
            String studentName = READER.nextLine();

            if(STUDENTLIST.removeIf(student -> student.getNaam().equals(studentName) && student.getStudentnummer().equals(studentNumber))) {
                System.out.println("Student " + studentName + " is verwijderd!");
            } else {
                System.out.println("Deze student staat niet in het systeem.");
                removeStudents();
            }
        } else {
            System.out.println("Geen geregistreerde studenten gevonden...");
        }
    }

    public void didStudentPassExam() {
        System.out.println(showStudentList());
        Student student = null;
        if (!STUDENTLIST.isEmpty()) {
            System.out.println("Van welk student wilt u een resultaat zien?");

            while (student == null) {
                System.out.println("Vul zijn/haar studentnummer in:");
                String studentNumber = READER.nextLine();
                student = findStudentWithNumber(studentNumber);
                if (student == null) {
                    System.out.println("Student niet gevonden.");
                }
            }

            System.out.println("En van welk examen wilt u het resultaat van deze student zien?");
            System.out.println(showExamList());

            while (!READER.hasNextInt()) {
                READER.next();
            }
            int choice = READER.nextInt();

            System.out.println(student.getStudentResults().passed);
        }
    }

    /***
     * Checks if in menu selected exam is available for exam attempt
     */
    public void isExamAvailable(int examChoice){
        try {
            Exam exam = EXAMS.get(examChoice - 1);
            EXAMTOTAKE = exam;
            System.out.println("test");
        } catch (Exception e) {
            System.out.println("Examen niet beschikbaar!");
        }
    }

    /***
     * If exam candidate is registered show the list of exams
     */

    private void selectStudent() {
        System.out.println(showStudentList());
        Student candidate = null;
        if (!STUDENTLIST.isEmpty()) {


            while (candidate == null) {
                System.out.println("Vul jouw studentnummer in:");
                String studentNumber = READER.nextLine();
                candidate = findStudentWithNumber(studentNumber);
                selectExam(candidate);
                if (candidate == null) {
                    System.out.println("Student niet gevonden.");
                }
            }
        } else {
            System.out.println("Registreer eerst een student om een examen te doen...");
            READER.nextLine();
        }

    }

    private void selectExam(Student candidate){
            System.out.println(showExamList());

            int number = 0;
            String choice = READER.nextLine();
            try {
                number = Integer.parseInt(choice);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }

            isExamAvailable(number);
            EXAMATTEMPT.setExam(EXAMTOTAKE);
            System.out.println(EXAMTOTAKE.getName());
            takeExam(candidate);
    }
    private void takeExam(Student candidate) {

            ArrayList<Question> examQuestions = EXAMTOTAKE.getQuestions();
            Collections.shuffle(examQuestions);

            int amountCorrect = 0;
            for (Question question : examQuestions) {
                System.out.println(question.getQuestion());

                if (question.getChoice() != null) {
                    for (String choise : question.getChoice()) {
                        System.out.println(choise);
                    }
                }
                String answer = READER.nextLine();
                if (question.getAnswer().equals(answer)) {
                    amountCorrect++;
                    System.out.println("Goed!");
                }
            }
            addCandidateResult(amountCorrect,examQuestions, candidate);

        }
    public void addCandidateResult(int amountCorrect, ArrayList<Question> examQuestions, Student candidate){
        candidate.addResult(new Result(EXAMTOTAKE, amountCorrect, hasPassed(EXAMTOTAKE, amountCorrect)));
        double questionSize = examQuestions.size();
        if (candidate.getStudentResults().passed) {
            System.out.printf("Je hebt de toets gehaald! Dit is jouw resultaat: %.1f", ((double)amountCorrect / questionSize * 10.0));
        } else {
            System.out.printf("Je hebt de toets niet gehaald... Dit is jouw resultaat: %.1f", ((double) amountCorrect / questionSize * 10.0));
        }
    }


    /***
     * Goes through each student in the student list and inserts them into the terminal with an ascending number
     */
    private String showStudentList() {
        StringBuilder students = new StringBuilder();
        students.append("Geregistreerde studenten: \n");
        if (STUDENTLIST.size() == 0) {
            System.out.println("Geen geregistreerde studenten gevonden...\nU word doorgestuurd naar student registratie");
            studentRegister();
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
        exams.append("Kies een examen: \n");
        int i = 0;
        for (Exam exam : EXAMS){
            if (i++ == EXAMS.size() - 1) {
                exams.append("[").append(i).append("] ").append(exam.getName());
            } else {
                exams.append("[").append(i).append("] ").append(exam.getName()).append("\n");
            }
        }
        return exams.toString();
    }

    /***
     * Registers new students with their full name and student number into the exam program
     */

    private void studentRegister() {
        String studentName = "";
        String studentNumber = "";

        while (studentName.equals("")) {
            System.out.println("Vul jouw volledige naam in >");
            String scanName = READER.nextLine().trim();
            if (stringChecker.isFullName(scanName)) {
                studentName = scanName;
            } else {
                System.out.println("\033[0;31m" + "Vul een geldige naam in!" + "\033[0m");
            }
        }
        while (studentNumber.equals("")) {
            System.out.println("Vul jouw studentnummer in >");
            String scanNumber = READER.nextLine().trim();
            if (stringChecker.isStudentNumber(scanNumber)) {
                studentNumber = scanNumber;
            } else {
                System.out.println("\033[0;31m" + "Vul een geldig studentnummer in!!" + "\033[0m");
            }
        }

        try {
            Student student = new Student(studentName, studentNumber);
            STUDENTLIST.add(student);
            System.out.println("\033[0;32m" + "De student is met succes geregistreerd!" + "\033[0m");
        } catch (Exception e) {
            System.out.println("\033[0;31m" + "Er ging iets fout. Probeer het opnieuw!" + "\033[0m");
        }
    }

    /***
     *
     * Function that looks up an exam candidate in the student list
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

    public boolean hasPassed(Exam exam, int amountPassed) {
        boolean result = false;
        ArrayList<Question> questions = exam.getQuestions();
        double cijfer = (double) amountPassed / questions.size() * 10.0;
        if ( 5.5 <= cijfer) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}