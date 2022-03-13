import java.util.ArrayList;

public class ExamList {

    private final ArrayList<Exam> ExamList = new ArrayList<>();


    public ExamList(){
        ExamList.add(new Exam("Open Vragen", Vraag.vragen()));
        ExamList.add(new Exam("MC Vragen",Vraag.McVragen()));
    }

    public ArrayList<Exam> getExamList(){return ExamList;}
}
