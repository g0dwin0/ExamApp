package examapp;

import java.util.ArrayList;

public class Student {

    private String studentName;
    private final String studentNumber;
    public ArrayList<Result> studentResults = new ArrayList<>();



    public Student(String studentName, String studentNumber) {
        this.studentName = studentName;
        this.studentNumber = studentNumber;

    }

    public String getNaam() {return studentName;}

    public String getStudentnummer() {return  studentNumber;}

    public void setNaam(String name) {this.studentName = name;}

    public void addResult(Result result) {this.studentResults.add(result);}

    public Result getStudentResults(){
        return studentResults.get(studentResults.size() - 1);
    }

    public ArrayList<Result> getStudentResultsList() { return  this.studentResults; }

    public int getAmountSuccesses() {
        int amountSuccess = 0;
        for (int i = 0; i < studentResults.size(); i++) {
            if (studentResults.get(i).passed) {
                amountSuccess++;
            }
        }
        return amountSuccess;
    }
}
