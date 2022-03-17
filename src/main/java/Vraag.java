import java.util.ArrayList;

public class Vraag {
    private String vraag;
//    private String antwoorden; // TODO: Abstracte klasse prolly the best here
    private String antwoord;
    private ArrayList<String> keuze;
    private int punten;

    public Vraag(String vraag, String antwoord, int punten) {
        this.vraag = vraag;
        this.antwoord = antwoord;
        this.punten = punten;
    }

    public Vraag(String vraag, ArrayList<String> keuze, String antwoord, int punten){
        this.vraag = vraag;
        this.keuze = keuze;
        this.antwoord = antwoord;
        this.punten = punten;
    }

    public String getVraag() {
        return vraag;
    }

    public void setVraag(String vraag) {
        this.vraag = vraag;
    }

    public String getAntwoord() {
        return antwoord;
    }

    public void setAntwoord(String antwoord) {
        this.antwoord = antwoord;
    }

    public int getPunten() {return punten;}


    public ArrayList<String> getKeuze() {return keuze;}

    public static ArrayList<Vraag> vragen() {
        ArrayList<Vraag> openvragen = new ArrayList<>();
        openvragen.add(new Vraag("Wat is 1 + 1","2",10));
        openvragen.add(new Vraag("Wat is 1 + 3","4",10));
        openvragen.add(new Vraag("Wat is 1 + 4","5",10));
        openvragen.add(new Vraag("Wat is 1 + 1","2",10));

        return openvragen;
    }
    public static ArrayList<Vraag> McVragen(){
        ArrayList<Vraag> mcvragen = new ArrayList<>();
        mcvragen.add(new Vraag("Welk land heeft de grootste landopervlakte",optie("Amerika","Australie","China","Rusland"),"D", 2));
        mcvragen.add(new Vraag("Welk land ",optie("Amerika","Australie","China","Rusland"),"D", 2));
        mcvragen.add(new Vraag("Welk land  grootste landopervlakte",optie("Amerika","Australie","China","Rusland"),"D", 2));
        mcvragen.add(new Vraag("Welk land  landopervlakte",optie("Amerika","Australie","China","Rusland"),"D", 2));

        return mcvragen;
    }

    public static ArrayList<String> optie(String A, String B, String C, String D){
        ArrayList<String> keuze = new ArrayList<>();
        keuze.add("[A] " + A);
        keuze.add("[B] " + B);
        keuze.add("[C] " + C);
        keuze.add("[D] " + D);
        return keuze;
    }

}
