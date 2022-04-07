import java.util.ArrayList;
import java.util.Scanner;


public class Exam {
    private String name;
    private Integer amountOfCorrectAnswers = 0;
    private ArrayList<Question> questions;
    private ArrayList<Result> results;
    private Integer minimumCorrect;
    private static final Scanner READERs = new Scanner(System.in);


    public Exam(String name, ArrayList<Question> questions) {
        this.name = name;
        this.questions = questions;
    }


    public Double finalGrade(double punten) {
        double eindCijfer = punten / 15.0 * 10.0;
        return eindCijfer;

    }

    public String getName() {
        return name;
    }


/*


    public static void addExam1() {
        Exam exam = new Exam();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wat is de naam van het examen?");
        String examName = scanner.nextLine();
        if (!examName.isEmpty()) {
            ArrayList<Question> questions = new ArrayList<>();
            while (true) {
                System.out.println("Wat voor type vraag wil je toevoegen?");
                System.out.println("[M]ultiple Choice of [O]pen vragen? of het menu [v]erlaten?");
                String choice = scanner.nextLine().toLowerCase();
                System.out.println("Choice: " + choice);


                switch (choice) {
                    case "m":
                        break;
                    case "o":
                        break;
                    case "v":
                        if(!questions.isEmpty()) {
                            exam.setName(examName);
                            exam.setQuestions(questions);
                            ExamList.ExamList.add(exam);
                            System.out.println("All exams: ");
                            for (Exam exam1 :
                                    ExamList.ExamList) {
                                System.out.println(exam1.getName());
                            }
                        }
                        return;
                    default:
                        System.out.println("Ongeldige invoer.");
                        return;
                }

                System.out.println("Wat is de vraag?");
                String question = scanner.nextLine();

                System.out.println("Hoeveel punten horen bij deze vraag?");
                int points = scanner.nextInt();

                if (choice.equals("m")) {
                    System.out.println("Vul de vier vragen in.");
                    scanner.nextLine();

                    System.out.println("A: ");

                    String A = scanner.nextLine();
                    if (A.isEmpty()) {
                        System.out.println("Antwoord veld is leeg.");
                    }
                    System.out.println("B: ");
                    String B = scanner.nextLine();
                    if (B.isEmpty()) {
                        System.out.println("Antwoord veld is leeg.");
                    }
                    System.out.println("C: ");
                    String C = scanner.nextLine();
                    if (C.isEmpty()) {
                        System.out.println("Antwoord veld is leeg.");
                    }
                    System.out.println("D: ");
                    String D = scanner.nextLine();
                    if (D.isEmpty()) {
                        System.out.println("Antwoord veld is leeg.");
                    }
                    System.out.println("Selecteer het juiste antwoord (alleen de letter.)");
                    System.out.println("Juiste antwoord: ");
                    String answer = scanner.nextLine();

                    switch (answer) {
                        case "A":
                            Question a = new Question(question, Question.questionOptions(A, B, C, D), "A", points);
                            questions.add(a);
                            System.out.println("Question toegevoegd.");
                            break;
                        case "B":
                            Question b = new Question(question, Question.questionOptions(A, B, C, D), "B", points);
                            questions.add(b);
                            System.out.println("Question toegevoegd.");
                            break;
                        case "C":
                            Question c = new Question(question, Question.questionOptions(A, B, C, D), "C", points);
                            questions.add(c);
                            System.out.println("Question toegevoegd.");
                            break;
                        case "D":
                            Question d = new Question(question, Question.questionOptions(A, B, C, D), "D", points);
                            questions.add(d);
                            System.out.println("Question toegevoegd.");
                            break;
                        default:
                            System.out.println("Ongeldige optie meegeven.");
                    }
                } else {
                    System.out.println("Wat is het antwoord?");
                    String answer = scanner.nextLine();
                    if (answer.isEmpty()) {
                        System.out.println("Ongeldige invoer.");
                        break;
                    }
                    questions.add(new Question(question, answer, points));
                }
            }

        } else {
            System.out.println("Ongeldige naam");
        }
    }
*/

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmountOfCorrectAnswers() {
        return amountOfCorrectAnswers;
    }

    public void setAmountOfCorrectAnswers(Integer amountOfCorrectAnswers) {
        this.amountOfCorrectAnswers = amountOfCorrectAnswers;
    }


    public Exam() {
        this("", null);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

}
