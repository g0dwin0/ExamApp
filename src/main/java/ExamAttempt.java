public class ExamAttempt {

    private final boolean passed;
    private Exam exam;

    public ExamAttempt(boolean passed){this.passed = passed;}


    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Exam getExam(){return exam;}

}
