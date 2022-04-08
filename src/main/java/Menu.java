import java.util.*;

import static java.lang.System.*;

public class Menu {

    private final Scanner READER = new Scanner(in);
    private final ArrayList<Student> STUDENTLIST = new ArrayList<>();
    private final ExamList EXAMLIST = new ExamList();
    private final ArrayList<Exam> EXAMS = EXAMLIST.getExamList();

    private final ExamAttempt EXAMATTEMPT = new ExamAttempt(false);
    private Exam EXAMTOTAKE = new Exam();
    private final StringChecker stringChecker = new StringChecker();


    public static void showMenu() {
        out.println();
        for (String s : Arrays.asList("[1] Examen lijst", "[2] Studenten lijst", "[3] Student registreren", "[4] Student verwijderen", "[5] Examen doen", "[6] Heeft de student het examen gehaald?", "[7] Welke examens heeft de student gehaald?", "[8] Welk student heeft de meeste examens gehaald?", "[9] Examen toevoegen", "[X] Programma afsluiten", "Voor uw keuze in:")) {
            out.println(s);
        }

    }


     public void getChoise(String Choice) {
        switch (Choice) {
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
                passedStudents();
                break;
            case "8":
                bestStudent();
            case "9":
                addExam();
                break;
            case "`":
                break;

            default: Menu.showMenu();
        }
    }

    public void addExam() {
        out.println("Voer de naam van het nieuwe examen in");
        String examName = READER.nextLine();
        out.println("Voer het aantal vragen die je wilt maken in");
        int amountOfQuestions = Integer.parseInt(READER.nextLine()); // Fixes problem that happens due to next int not going to the next line
            out.println("[1] Meerkeuze vragen");
            out.println("[2] Open vragen");
            String b = READER.nextLine();

            if (b.equals("1")) {
                addMultipleChoiceExam(examName, amountOfQuestions);
            } else {
                if (b.equals("2")) {
                    addOpenQuestionExam(examName, amountOfQuestions);
                }
            }

    }

    public void addOpenQuestionExam(String examName, int amountOfQuestions) {
        ArrayList<Question> openQuestions = new ArrayList<>();
        for(int i = 0; i <= amountOfQuestions -1 ; i ++){
            out.println("Voer vraag in");
            String question = READER.nextLine();
            out.println("Voer antwoord in");
            String answer = READER.nextLine();
            out.println("Voer aantal punten in");
            int points = Integer.parseInt(READER.nextLine()); // Fixes problem that happens due to next int not going to the next line
            openQuestions.add(new Question(question,answer,points));
        }
        ExamList.ExamList.add(new Exam(examName,openQuestions));
        out.println("Exam added to list");

    }

    private  void addMultipleChoiceExam(String examName, int amountOfQuestions) {
        ArrayList<Question> multipleChoiceQuestions = new ArrayList<>();
        for(int i = 0; i <= amountOfQuestions -1 ; i ++) {
            out.println("Voer vraag in");
            String question = READER.nextLine();
            out.println("Voer antwoord optie in");
            String a = READER.nextLine();
            out.println("Voer antwoord optie in");
            String b = READER.nextLine();
            out.println("Voer antwoord optie in");
            String c = READER.nextLine();
            out.println("Voer antwoord optie in");
            String d = READER.nextLine();
            out.println("Vul het juiste antwoord hoofdletter in");
            String antwoord = READER.nextLine();
            out.println("Voer aantal optie punten in");
            int points = Integer.parseInt(READER.nextLine());// Fixes problem that happens due to next int not going to the next line

            multipleChoiceQuestions.add(new Question(question, Question.questionOptions(a, b, c, d), antwoord, points));
        }

        ExamList.ExamList.add(new Exam(examName,multipleChoiceQuestions));
        out.println("Exam added to list");
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
        if(!STUDENTLIST.isEmpty()){
            out.println("Vul jouw studentnummer in:");
            String studentNumber = READER.nextLine();
            out.println("Vul jouw volledige naam in:");
            String studentName = READER.nextLine();

            if(STUDENTLIST.removeIf(student -> student.getNaam().equals(studentName) && student.getStudentnummer().equals(studentNumber))) {
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
        if (!STUDENTLIST.isEmpty()) {
            out.println("Van welk student wilt u een resultaat zien?");

            while (student == null) {
                out.println("Vul zijn/haar studentnummer in:");
                String studentNumber = READER.nextLine();
                student = findStudentWithNumber(studentNumber);
                if (student == null) {
                    out.println("Student niet gevonden.");
                }
            }

            out.println("En van welk examen wilt u het resultaat van deze student zien?");
            out.println(showExamList());

            int number = 0;
            String choice = READER.nextLine();
            try {
                number = Integer.parseInt(choice);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }

            Result results = null;
            for (int i = 0; i < student.getStudentResultsList().size(); i++) {
                if (EXAMS.get(number - 1) == student.getStudentResultsList().get(i).getExam()) {
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

    /***
     * Checks if in menu selected exam is available for exam attempt
     * @return
     */
    public void isExamAvailable(int examChoice){
        try {
            EXAMTOTAKE = EXAMS.get(examChoice - 1);
            out.println("test");
        } catch (Exception e) {
            out.println("Examen niet beschikbaar!");
        }
    }

    /***
     * If exam candidate is registered show the list of exams
     */

    private void selectStudent() {
        out.println(showStudentList());
        Student candidate = null;
        if (!STUDENTLIST.isEmpty()) {

            while (candidate == null) {
                out.println("Vul jouw studentnummer in:");
                String studentNumber = READER.nextLine();
                candidate = findStudentWithNumber(studentNumber);
                if (candidate == null) {
                    out.println("Student niet gevonden.");
                }
            }
        } else {
            out.println("Registreer eerst een student om een examen te doen...");
            READER.nextLine();
        }
        selectExam(candidate);

    }

    private void selectExam(Student candidate){
            out.println(showExamList());

            int number = 0;
            String choice = READER.nextLine();
            try {
                number = Integer.parseInt(choice);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }

            isExamAvailable(number);
            EXAMATTEMPT.setExam(EXAMTOTAKE);
            out.println(EXAMTOTAKE.getName());
            takeExam(candidate);
    }
    private void takeExam(Student candidate) {

            ArrayList<Question> examQuestions = EXAMTOTAKE.getQuestions();
            Collections.shuffle(examQuestions);

            int amountCorrect = 0;
            for (Question question : examQuestions) {
                out.println(question.getQuestion());

                if (question.getChoice() != null) {
                    for (String choise : question.getChoice()) {
                        out.println(choise);
                    }
                }
                String answer = READER.nextLine();
                if (question.getAnswer().equals(answer)) {
                    amountCorrect++;
                    out.println("Goed!");
                } else{
                    out.println("Fout, het juiste antwoord was " + question.getAnswer());
                }
            }
            addCandidateResult(amountCorrect,examQuestions, candidate);

        }
    public void addCandidateResult(int amountCorrect, ArrayList<Question> examQuestions, Student candidate){
        candidate.addResult(new Result(EXAMTOTAKE, amountCorrect, hasPassed(EXAMTOTAKE, amountCorrect)));
        double questionSize = examQuestions.size();
        if (candidate.getStudentResults().passed) {
            out.printf("Je hebt de toets gehaald! Dit is jouw resultaat: %.1f", candidate.getStudentResults().getGrade());
        } else {
            out.printf("Je hebt de toets niet gehaald... Dit is jouw resultaat: %.1f", candidate.getStudentResults().getGrade());
        }
    }


    /***
     * Goes through each student in the student list and inserts them into the terminal with an ascending number
     */
    private String showStudentList() {
        StringBuilder students = new StringBuilder();
        students.append("Geregistreerde studenten: \n");
        if (STUDENTLIST.isEmpty()) {
            out.println("Geen geregistreerde studenten gevonden...\nU word doorgestuurd naar student registratie");
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
        for (Exam exam : EXAMS){
            int i = 0;
            if (i ++ == EXAMS.size() - 1) {
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
            out.println("Vul jouw volledige naam in >");
            String scanName = READER.nextLine().trim();
            if (stringChecker.isFullName(scanName)) {
                studentName = scanName;
            } else {
                out.println("\u001B[0;31mVul een geldige naam in!\u001B[0m");
            }
        }
        while (studentNumber.equals("")) {
            out.println("Vul jouw studentnummer in >");
            String scanNumber = READER.nextLine().trim();
            if (stringChecker.isStudentNumber(scanNumber)) {
                studentNumber = scanNumber;
            } else {
                out.println("\u001B[0;31mVul een geldig studentnummer in!!\u001B[0m");
            }
        }

        try {
            Student student = new Student(studentName, studentNumber);
            STUDENTLIST.add(student);
            out.println("\u001B[0;32mDe student is met succes geregistreerd!\u001B[0m");
        } catch (Exception e) {
            out.println("\u001B[0;31mEr ging iets fout. Probeer het opnieuw!\u001B[0m");
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
        result = 5.5 <= cijfer;
        return result;
    }
}