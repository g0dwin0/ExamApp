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

    public String getStudentName() {return studentName;}

    public String getStudentnumber() {return  studentNumber;}

    public void setStudentName(String name) {this.studentName = name;}

    public void addResult(Result result) {this.studentResults.add(result);}

    public Result getResult(){
        return studentResults.get(studentResults.size() - 1);
    }

    public ArrayList<Result> getStudentResultsList() { return  this.studentResults; }

    public int getAmountSuccesses() {
        int amountSuccess = 0;
        for (Result studentResult : studentResults) {
            if (studentResult.passed) {
                amountSuccess++;
            }
        }
        return amountSuccess;
    }

    public Result getResult(Result result) {
        return result;
    }
}
