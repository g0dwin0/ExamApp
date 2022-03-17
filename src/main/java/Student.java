import java.util.ArrayList;

public class Student {

    private String studentName;
    private String studentNumber;
    private ArrayList<Resultaat> studentResults = new ArrayList<>();



    public Student(String studentName, String studentNumber) {
        this.studentName = studentName;
        this.studentNumber = studentNumber;
    }

    public String getNaam() {return studentName;}

    public String getStudentnummer() {return  studentNumber;}

    public void setNaam(String naam) {this.studentName = naam;}

    public void addResult(Resultaat result) {this.studentResults.add(result);}
}
