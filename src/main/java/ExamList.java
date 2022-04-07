import java.util.ArrayList;

public class ExamList {

    public static ArrayList<Exam> ExamList = new ArrayList<>();


    public ExamList(){
        ExamList.add(new Exam("Open Vragen", Question.openQuestion()));
        ExamList.add(new Exam("Meerkeuze Vragen", Question.MultipleChoiceQuestion()));    }

    public ArrayList<Exam> getExamList(){return ExamList;}

}
