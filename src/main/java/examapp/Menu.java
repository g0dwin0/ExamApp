package examapp;

import java.util.*;

import static java.lang.System.*;

public class Menu {

    private final Scanner reader = new Scanner(in);
    private final ArrayList<Student> studentArrayList = new ArrayList<>();
    private final ExamList examList = new ExamList();
    private final ArrayList<Exam> examArrayList = examList.getExamList();

    private final ExamAttempt examAttempt = new ExamAttempt(false);
    private Exam examToTake = new Exam();
    private final StringChecker stringChecker = new StringChecker();

    /**
     * Displays plain text list of selectable options from the menu
     */
    public static void showMenu() {
        out.println();
        for (String s : Arrays.asList("[1] Examen lijst", "[2] Studenten lijst", "[3] Student registreren", "[4] Student verwijderen", "[5] Examen doen", "[6] Heeft de student het examen gehaald?", "[7] Welke examens heeft de student gehaald?", "[8] Welk student heeft de meeste examens gehaald?", "[9] Examen toevoegen", "[X] Programma afsluiten", "Voor uw keuze in:")) {
            out.println(s);
        }

    }

    /**
     * Redirects to the selected option from showMenu
     */
     public void getChoise(String choice) {
        switch (choice) {
            case "1":
                out.println(showExamList());
                break;
            case "2":
                out.println(showStudentList());
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
                passedExams();
                break;
            case "8":
                bestStudent();
                break;
            case "9":
                addExam();
                break;
            case "`":
                break;

            default:
        }
    }

    /**
     * Startup of adding exams by making your first choices like the name, amount of questions and the type of exam you would like to create
     */
    public void addExam() {
        out.println("Voer de naam van het nieuwe examen in");
        String examName = reader.nextLine();
        out.println("Voer het aantal vragen die je wilt maken in");
        int amountOfQuestions = Integer.parseInt(reader.nextLine()); // Fixes problem that happens due to next int not going to the next line
            out.println("[1] Meerkeuze vragen");
            out.println("[2] Open vragen");
            String b = reader.nextLine();

            if (b.equals("1")) {
                addMultipleChoiceExam(examName, amountOfQuestions);
            } else {
                if (b.equals("2")) {
                    addOpenQuestionExam(examName, amountOfQuestions);
                }
            }

    }

    /**
     *
     * @param examName Takes the inserted name chosen for the exam to be implemented
     * @param amountOfQuestions Takes the inserted question amount for the exam to be implemented
     *  Furthermore this method will allow the user to create an open question exam.
     */
    public void addOpenQuestionExam(String examName, int amountOfQuestions) {
        ArrayList<Question> openQuestions = new ArrayList<>();
        for(int i = 0; i <= amountOfQuestions -1 ; i ++){
            out.println("Voer vraag in");
            String question = reader.nextLine();
            out.println("Voer antwoord in");
            String answer = reader.nextLine();
            out.println("Voer aantal punten in");
            int points = Integer.parseInt(reader.nextLine()); // Fixes problem that happens due to next int not going to the next line
            openQuestions.add(new Question(question,answer,points));
        }
        ExamList.examArrayList.add(new Exam(examName,openQuestions));
        out.println("Exam added to list");

    }

    /**
     *
     * @param examName Takes the inserted name chosen for the exam to be implemented
     * @param amountOfQuestions Takes the inserted question amount for the exam to be implemented
     * Furthermore this method will allow the user to create a multiple choice exam
     */
    private  void addMultipleChoiceExam(String examName, int amountOfQuestions) {
        ArrayList<Question> multipleChoiceQuestions = new ArrayList<>();
        for(int i = 0; i <= amountOfQuestions -1 ; i ++) {

            out.println("Voer vraag in");
            String question = reader.nextLine();
            out.println("Voer antwoord optie in");
            String a = reader.nextLine();
            out.println("Voer antwoord optie in");
            String b = reader.nextLine();
            out.println("Voer antwoord optie in");
            String c = reader.nextLine();
            out.println("Voer antwoord optie in");
            String d = reader.nextLine();
            out.println("Vul het juiste antwoord hoofdletter in");
            String antwoord = reader.nextLine();
            out.println("Voer aantal optie punten in");
            int points = Integer.parseInt(reader.nextLine());// Fixes problem that happens due to next int not going to the next line

            multipleChoiceQuestions.add(new Question(question, Question.questionOptions(a, b, c, d), antwoord, points));
        }

        ExamList.examArrayList.add(new Exam(examName,multipleChoiceQuestions));
        out.println("Exam added to list");
    }

    /**
     * Checks for student(s) with the most exams passed
     */
    private void bestStudent() {
        ArrayList<Student> bestStudents = new ArrayList<>();
        Student bestStudent = null;
        for (Student student : studentArrayList) {
            if (bestStudent == null) {
                bestStudent = student;
            } else {
                if (bestStudent.getAmountSuccesses() < student.getAmountSuccesses()) {
                    bestStudent = student;
                }
            }
        }
        assert bestStudent != null;

        int highestNumberOfSuccesses = bestStudent.getAmountSuccesses();
        for (Student student : studentArrayList) {
            if (student.getAmountSuccesses() == highestNumberOfSuccesses) {
                out.println(student.getNaam());
                bestStudents.add(student);
            }
        }
        if (bestStudents.size() == 1) {
            out.println("Deze student heeft de meest behaalde examens: " + bestStudent.getNaam() + "\n" +
                    "Deze student heeft " + bestStudent.getAmountSuccesses() + " examens gehaald!");
        } else {
            out.println("Dit zijn de studenten met de meest behaalde examens:");
            for (Student student : bestStudents) { out.println(student.getNaam()); }
            out.println("Zij hebben ieder " + bestStudent.getAmountSuccesses() + " examens gehaald!");
        }

    }

    /**
     *
     */
    private void passedExams() {
        out.println(showStudentList());
        Student student = null;
        if (!studentArrayList.isEmpty()) {
            out.println("Van welk student wilt u de resultaten zien?");

            while (student == null) {
                out.println("Vul zijn/haar studentnummer in:");
                String studentNumber = reader.nextLine();
                student = findStudentWithNumber(studentNumber);
                if (student == null) {
                    out.println("Student niet gevonden.");
                }
            }

            if (!student.getStudentResultsList().isEmpty()) {
                out.println("Dit zijn de resultaten van " + student.getNaam());
                for (int i = 0; i < student.getStudentResultsList().size(); i++) {
                    out.print(student.getStudentResultsList().get(i).getExam().getName() + " | ");
                    if (student.getStudentResultsList().get(i).passed) {
                        out.print("\033[0;32m" + student.getStudentResultsList().get(i).getGrade() + "\033[0m\n");
                    } else {
                        out.print("\033[0;31m" + student.getStudentResultsList().get(i).getGrade() + "\033[0m\n");
                    }
                }
            }
        }
    }

    /**
     * Removes students from the student list if given name and student number are equal to information in the list
     */
    private void removeStudents() {
        if(!studentArrayList.isEmpty()){
            out.println("Vul jouw studentnummer in:");
            String studentNumber = reader.nextLine();
            out.println("Vul jouw volledige naam in:");
            String studentName = reader.nextLine();

            if(studentArrayList.removeIf(student -> student.getNaam().equals(studentName) && student.getStudentnummer().equals(studentNumber))) {
                out.println("Student " + studentName + " is verwijderd!");
            } else {
                out.println("Deze student staat niet in het systeem.");
                removeStudents();
            }
        } else {
            out.println("Geen geregistreerde studenten gevonden...");
        }
    }

    public void didStudentPassExam() {
        out.println(showStudentList());
        Student student = null;
        if (!studentArrayList.isEmpty()) {
            out.println("Van welk student wilt u een resultaat zien?");

            while (student == null) {
                out.println("Vul zijn/haar studentnummer in:");
                String studentNumber = reader.nextLine();
                student = findStudentWithNumber(studentNumber);
                if (student == null) {
                    out.println("Student niet gevonden.");
                }
            }

            out.println("En van welk examen wilt u het resultaat van deze student zien?");
            out.println(showExamList());

            int number = 0;
            String choice = reader.nextLine();
            try {
                number = Integer.parseInt(choice);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }

            Result results = null;
            for (int i = 0; i < student.getStudentResultsList().size(); i++) {
                if (examArrayList.get(number - 1) == student.getStudentResultsList().get(i).getExam()) {
                    results = student.getStudentResultsList().get(i);
                }
            }
            if (results == null) {
                out.println("De gekozen student heeft dit examen nog niet geprobeerd.");
            } else {
                if (results.passed) {
                    out.printf("De gekozen student heeft de toets gehaald! Dit is zijn/haar cijfer: %.1f", results.getGrade());
                } else {
                    out.printf("De gekozen student heeft de toets niet gehaald! Dit is zijn/haar cijfer: %.1f", results.getGrade());
                }
            }
        }
    }

    /**
     * Checks if in menu selected exam is available for exam attempt
     * @param examChoice
     * @return
     */
    public boolean isExamAvailable(int examChoice){
        try {
            examToTake = examArrayList.get(examChoice - 1);
        } catch (Exception e) {
            out.println("Examen niet beschikbaar!");
        }
        return false;
    }

    /**
     * If exam candidate is registered show the list of exams
     */

    private void selectStudent() {
        out.println(showStudentList());
        Student candidate = null;
        if (!studentArrayList.isEmpty()) {

            while (candidate == null) {
                out.println("Vul jouw studentnummer in:");
                String studentNumber = reader.nextLine();
                candidate = findStudentWithNumber(studentNumber);
                if (candidate == null) {
                    out.println("Student niet gevonden.");
                }
            }
        } else {
            out.println("Registreer eerst een student om een examen te doen...");
            reader.nextLine();
        }
        selectExam(candidate);

    }

    /**
     *
     * @param candidate
     */
    private void selectExam(Student candidate){
            out.println(showExamList());

            int number = 0;
            String choice = reader.nextLine();
            try {
                number = Integer.parseInt(choice);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }

            isExamAvailable(number);
            examAttempt.setExam(examToTake);
            out.println(examToTake.getName());
            takeExam(candidate);
    }

    /**
     *
     * @param candidate
     */
    private void takeExam(Student candidate) {

        ArrayList<Question> examQuestions = examToTake.getQuestions();
        Collections.shuffle(examQuestions);

        int amountCorrect = 0;
        for (Question question : examQuestions) {
            out.println(question.getQuestion());

            if (question.getChoice() != null) {
                for (String choise : question.getChoice()) {
                    out.println(choise);
                }
            }
            String answer = reader.nextLine();
            if (question.getAnswer().equals(answer)) {
                amountCorrect++;
                out.println("Goed!");
            } else {
                out.println("Fout, het juiste antwoord was " + question.getAnswer());
            }
        }
        addCandidateResult(amountCorrect, examQuestions, candidate);

    }

    /**
     *
     * @param amountCorrect
     * @param examQuestions
     * @param candidate
     */
    public void addCandidateResult(int amountCorrect, ArrayList<Question> examQuestions, Student candidate){
        candidate.addResult(new Result(examToTake, amountCorrect, hasPassed(examToTake, amountCorrect)));
        double questionSize = examQuestions.size();
        if (candidate.getStudentResults().passed) {
            out.printf("Je hebt de toets gehaald! Dit is jouw resultaat: %.1f", candidate.getStudentResults().getGrade());
        } else {
            out.printf("Je hebt de toets niet gehaald... Dit is jouw resultaat: %.1f", candidate.getStudentResults().getGrade());
        }
    }


    /**
     * Goes through each student in the student list and inserts them into the terminal with an ascending number
     */
    private String showStudentList() {
        StringBuilder students = new StringBuilder();
        students.append("Geregistreerde studenten: \n");
        if (studentArrayList.isEmpty()) {
            out.println("Geen geregistreerde studenten gevonden...\nU word doorgestuurd naar student registratie");
            studentRegister();
        } else {
            for(int i = 0; i < studentArrayList.size(); i++) {
                students.append("\n[").append(i + 1).append("]").append(" ").append(studentArrayList.get(i).getNaam()).append(" ").append(studentArrayList.get(i).getStudentnummer());
            }
        }
        return students.toString();
    }
    /**
     * Goes through each exam in the exam list and inserts them into the terminal with an ascending number
     */
    private String showExamList() {
        StringBuilder exams = new StringBuilder();
        exams.append("Kies een examen: \n");
        for (Exam exam : examArrayList){
            int i = 0;
            if (i ++ == examArrayList.size() - 1) {
                exams.append("[").append(i).append("] ").append(exam.getName());
            } else {
                exams.append("[").append(i).append("] ").append(exam.getName()).append("\n");
            }
        }
        return exams.toString();
    }

    /**
     * Registers new students with their full name and student number into the exam program
     */

    private void studentRegister() {
        String studentName = "";
        String studentNumber = "";

        while (studentName.equals("")) {
            out.println("Vul jouw volledige naam in >");
            String scanName = reader.nextLine().trim();
            if (stringChecker.isFullName(scanName)) {
                studentName = scanName;
            } else {
                out.println("\u001B[0;31mVul een geldige naam in!\u001B[0m");
            }
        }
        while (studentNumber.equals("")) {
            out.println("Vul jouw studentnummer in >");
            String scanNumber = reader.nextLine().trim();
            if (stringChecker.isStudentNumber(scanNumber)) {
                studentNumber = scanNumber;
            } else {
                out.println("\u001B[0;31mVul een geldig studentnummer in!!\u001B[0m");
            }
        }

        try {
            Student student = new Student(studentName, studentNumber);
            studentArrayList.add(student);
            out.println("\u001B[0;32mDe student is met succes geregistreerd!\u001B[0m");
        } catch (Exception e) {
            out.println("\u001B[0;31mEr ging iets fout. Probeer het opnieuw!\u001B[0m");
        }
    }

    /**
     * Function that looks up an exam candidate in the student list
     * @param studentNumber
     * @return
     */
    private Student findStudentWithNumber(String studentNumber) {
        Student candidate;
        for (Student value : studentArrayList) {
            String student = value.getStudentnummer();
            if (Objects.equals(studentNumber, student)) {
                candidate = value;
                return candidate;
            }
        }
        return null;
    }

    /**
     *
     * @param exam
     * @param amountPassed
     * @return
     */
    public boolean hasPassed(Exam exam, int amountPassed) {
        boolean result = false;
        ArrayList<Question> questions = exam.getQuestions();
        double cijfer = (double) amountPassed / questions.size() * 10.0;
        result = 5.5 <= cijfer;
        return result;
    }
}