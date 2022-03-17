public class Student {

    private String studentName;
    private String studentNumber;



    public Student(String studentName, String studentNumber) {
        this.studentName = studentName;
        this.studentNumber = studentNumber;
    }

    public String getNaam() {
        return studentName;
    }

    public String getStudentnummer() { return  studentNumber;}

    public void setNaam(String naam) {
        this.studentName = naam;
    }
}
