import com.google.gson.Gson;

public class Run {
    public static void main(String[] args) {

        ExamAdministration examAdminstration = new ExamAdministration();
        examAdminstration.startProgram();
        Gson serializer = new Gson();
       // Student godwin = new Student(studentName, "Godwin");
       // String json = serializer.toJson(godwin);
      //  System.out.println(json);
//        new Exam().startExam(godwin);
    }
}
