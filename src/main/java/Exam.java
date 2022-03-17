import java.util.ArrayList;
import java.util.Scanner;


public class Exam {
    private String naam;
    private Integer aantalJuisteAntwoorden = 0;
    private ArrayList<Vraag> vragen;
    private ArrayList<Resultaat> resultaten;
    private Integer minimumCorrect;

    public Exam(String naam, ArrayList<Vraag> vragen){
        this.naam = naam;
        this.vragen = vragen;
    }
    public void startExam(Student student) {

        this.vragen.add(new Vraag("Is een jaar 12 maanden?", "Ja", 25));
        this.vragen.add(new Vraag("Bestaat de kerstman?", "Ja",25));
        this.vragen.add(new Vraag("Is 1+1 2?", "Ja",25));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Deze toets heeft alleen ja/nee vragen.");
        for (Vraag vraag : vragen) {
            System.out.println(vraag.getVraag());
            String antwoord = scanner.nextLine();
            if(antwoord.equals(vraag.getAntwoord())) {
                System.out.println("Correct!");
                setAantalJuisteAntwoorden(aantalJuisteAntwoorden + 1);
            } else {
                System.out.println("Onjuist!");
            }
            if(vragen.indexOf(vraag) == vragen.size() - 1) {
                if(aantalJuisteAntwoorden < minimumCorrect) {
                    System.out.println("Je hebt het examen niet gehaald.");
                    System.out.printf("Dit is jouw cijfer: %.1f", finalCijfer(aantalJuisteAntwoorden));

                } else {
                    System.out.println("Goed gedaan! Je hebt het gehaald.");
                    System.out.printf("Dit is jouw cijfer: %.1f", finalCijfer(aantalJuisteAntwoorden));
                }
            }
        }
    }
    public Double finalCijfer(double punten){
        double eindCijfer = punten / 15.0 * 10.0;
        return eindCijfer;

    }

    public String getNaam() {
        return naam;
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





    public Exam(){this("",null);}

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
