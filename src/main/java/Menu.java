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
            System.out.println("Vul jouw studentnummer in:");
            String studentnumber = READER.nextLine();
            System.out.println("Vul jouw volledige naam in:");
            String studentname = READER.nextLine();

            if(STUDENTLIST.removeIf(student -> student.getNaam().equals(studentname) && student.getStudentnummer().equals(studentnumber))) {
                System.out.println("Student " + studentname + " is verwijderd!");
            } else {
                System.out.println("Deze student staat niet in het systeem.");
                removeStudents();
            }
        } else {
            System.out.println("Geen geregistreerde studenten gevonden...");
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
        if (!STUDENTLIST.isEmpty()) {


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
                    String b = "Meerkeuze Vragen";
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
                    System.out.println("Goed!");
                }
            }
            candidate.addResult(new Resultaat(EXAMTOTAKE, aantalJuist));
            double aantalJuist2 = aantalJuist;
            double vragenSize = examQuestions.size();
            if (candidate.getStudentResults().isGehaald()) {
                System.out.printf("Je hebt de toets gehaald! Dit is jouw resultaat: %.1f", (aantalJuist2 / vragenSize * 10.0));
            } else {
                System.out.printf("Je hebt de toets niet gehaald... Dit is jouw resultaat: %.1f", (aantalJuist2 / vragenSize * 10.0));
            }
        } else {
            System.out.println("Registreer eerst een student om een examen te doen...");
            READER.nextLine();
        }
    }



    /***
     * Goes through each student in the student list and inserts them into the terminal with an ascending number
     */
    private String showStudentList() {
        StringBuilder students = new StringBuilder();
        students.append("Geregistreerde studenten: \n");
        if (STUDENTLIST.size() == 0) {
            students.append("Geen geregistreerde studenten gevonden...");
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
            System.out.println("Vul jouw volledige naam in >");
            String scanName = READER.nextLine().trim();
            if (stringChecker.isFullName(scanName)) {
                studentName = scanName;
            } else {
                System.out.println("\033[0;31m" + "Vul een geldige naam in!" + "\033[0m");
            }
        }

        String studentNumber = "";
        while (studentNumber == "") {
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