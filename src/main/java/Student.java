public class Student {

    private String studentName;
    private String studentNumber;
    private static Integer volgNummer = 1; // TODO: Uniek maken, lees uit tekst bestand

    public Student(String studentName, String studentNumber) {
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        volgNummer++;
    }

    public String getNaam() {
        return studentName;
    }

    public String getStudentnummer() { return  studentNumber;}

    public void setNaam(String naam) {
        this.studentName = naam;
    }
}
