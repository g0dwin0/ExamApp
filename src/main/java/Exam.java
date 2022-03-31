import java.util.ArrayList;
import java.util.Scanner;


public class Exam {
    private String naam;
    private Integer aantalJuisteAntwoorden = 0;
    private ArrayList<Vraag> vragen;
    private ArrayList<Resultaat> resultaten;
    private Integer minimumCorrect;

    public Exam(String naam, ArrayList<Vraag> vragen) {
        this.naam = naam;
        this.vragen = vragen;
    }

    public void startExam(Student student) {

        this.vragen.add(new Vraag("Is een jaar 12 maanden?", "Ja", 25));
        this.vragen.add(new Vraag("Bestaat de kerstman?", "Ja", 25));
        this.vragen.add(new Vraag("Is 1+1 2?", "Ja", 25));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Deze toets heeft alleen ja/nee vragen.");
        for (Vraag vraag : vragen) {
            System.out.println(vraag.getVraag());
            String antwoord = scanner.nextLine();
            if (antwoord.equals(vraag.getAntwoord())) {
                System.out.println("Correct!");
                setAantalJuisteAntwoorden(aantalJuisteAntwoorden + 1);
            } else {
                System.out.println("Onjuist!");
            }
            if (vragen.indexOf(vraag) == vragen.size() - 1) {
                if (aantalJuisteAntwoorden < minimumCorrect) {
                    System.out.println("Je hebt het examen niet gehaald.");
                    System.out.printf("Dit is jouw cijfer: %.1f", finalCijfer(aantalJuisteAntwoorden));

                } else {
                    System.out.println("Goed gedaan! Je hebt het gehaald.");
                    System.out.printf("Dit is jouw cijfer: %.1f", finalCijfer(aantalJuisteAntwoorden));
                }
            }
        }
    }

    public Double finalCijfer(double punten) {
        double eindCijfer = punten / 15.0 * 10.0;
        return eindCijfer;

    }

    public String getNaam() {
        return naam;
    }

    public static void addExam() {
        Exam exam = new Exam();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wat is de naam van het examen?");
        String examName = scanner.nextLine();
        if (!examName.isEmpty()) {
            ArrayList<Vraag> questions = new ArrayList<>();
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
                            exam.setNaam(examName);
                            exam.setVragen(questions);
                            ExamList.ExamList.add(exam);
                            System.out.println("All exams: ");
                            for (Exam exam1 :
                                    ExamList.ExamList) {
                                System.out.println(exam1.getNaam());
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
                            Vraag a = new Vraag(question, Vraag.optie(A, B, C, D), "A", points);
                            questions.add(a);
                            System.out.println("Vraag toegevoegd.");
                            break;
                        case "B":
                            Vraag b = new Vraag(question, Vraag.optie(A, B, C, D), "B", points);
                            questions.add(b);
                            System.out.println("Vraag toegevoegd.");
                            break;
                        case "C":
                            Vraag c = new Vraag(question, Vraag.optie(A, B, C, D), "C", points);
                            questions.add(c);
                            System.out.println("Vraag toegevoegd.");
                            break;
                        case "D":
                            Vraag d = new Vraag(question, Vraag.optie(A, B, C, D), "D", points);
                            questions.add(d);
                            System.out.println("Vraag toegevoegd.");
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
                    questions.add(new Vraag(question, answer, points));
                }
            }

        } else {
            System.out.println("Ongeldige naam");
        }
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Integer getAantalJuisteAntwoorden() {
        return aantalJuisteAntwoorden;
    }

    public void setAantalJuisteAntwoorden(Integer aantalJuisteAntwoorden) {
        this.aantalJuisteAntwoorden = aantalJuisteAntwoorden;
    }


    public Exam() {
        this("", null);
    }

    public ArrayList<Vraag> getVragen() {
        return vragen;
    }

    public void setVragen(ArrayList<Vraag> vragen) {
        this.vragen = vragen;
    }

    public ArrayList<Resultaat> getResultaten() {
        return resultaten;
    }

    public void setResultaten(ArrayList<Resultaat> resultaten) {
        this.resultaten = resultaten;
    }

    public Integer getMinimumCorrect() {
        return minimumCorrect;
    }

    public void setMinimumCorrect(Integer minimumCorrect) {
        this.minimumCorrect = minimumCorrect;
    }
}
