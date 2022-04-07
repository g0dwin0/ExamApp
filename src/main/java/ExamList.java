import java.util.ArrayList;

public class ExamList {

    public static ArrayList<Exam> ExamList = new ArrayList<>();


    public ExamList(){
        ExamList.add(new Exam("Open Vragen", Vraag.vragen()));
        ExamList.add(new Exam("Meerkeuze Vragen",Vraag.McVragen()));    }

    public ArrayList<Exam> getExamList(){return ExamList;}

}
