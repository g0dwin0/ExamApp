import java.util.ArrayList;
import java.util.Scanner;


public class Exam {
    private String naam;
    private Integer aantalJuisteAntwoorden = 0;
    private ArrayList<Vraag> vragen = new ArrayList<>();
    private ArrayList<Resultaat> resultaten;
    private Integer minimumCorrect;

    public void startExam(Student student) {

        this.vragen.add(new Vraag("Is een jaar 12 maanden?", "Ja"));
        this.vragen.add(new Vraag("Bestaat de kerstman?", "Ja"));
        this.vragen.add(new Vraag("Is 1+1 2?", "Ja"));

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
                } else {
                    System.out.println("Goed gedaan! Je hebt het gehaald.");
                }
            }
        }
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
