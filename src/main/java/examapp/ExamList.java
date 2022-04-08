package examapp;

import java.util.ArrayList;

public class ExamList {

    public static ArrayList<Exam> examArrayList = new ArrayList<>();


    public ExamList(){
        examArrayList.add(new Exam("Open Vragen", Question.openQuestion()));
        examArrayList.add(new Exam("Meerkeuze Vragen", Question.multipleChoiceQuestion()));    }

    public ArrayList<Exam> getExamList(){return examArrayList;}

}
