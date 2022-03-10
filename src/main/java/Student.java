public class Student {
    private String naam;
    private Integer studentnummer;
    private static Integer volgNummer = 1; // TODO: Uniek maken, lees uit tekst bestand

    public Student(String naam) {
        this.naam = naam;
        this.studentnummer = volgNummer;
        volgNummer++;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
