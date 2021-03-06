package examapp;

public class Result {
    private Exam exam;
    private Integer amountCorrect;
    public boolean passed;

    public Result(Exam exam, Integer amountCorrect, boolean passed) {
        this.exam = exam;
        this.amountCorrect = amountCorrect;
        this.passed = passed;
    }

    public Exam getExam() {
        return exam;
    }

    public Integer getAmountCorrect() {
        return amountCorrect;
    }

    public double getGrade() {
        return (double) amountCorrect / exam.getQuestions().size() * 10.0;
    }


}
