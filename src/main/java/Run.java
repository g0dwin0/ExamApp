import com.google.gson.Gson;

public class Run {
    public static void main(String[] args) {
        Gson serializer = new Gson();
        Student godwin = new Student("Godwin");
        String json = serializer.toJson(godwin);
        System.out.println(json);
//        new Exam().startExam(godwin);
    }
}
