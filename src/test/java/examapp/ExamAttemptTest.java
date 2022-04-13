package examapp;

import org.junit.Assert;
import org.junit.Test;

public class ExamAttemptTest {

    @Test
    public void testExamAttempt() {
        ExamAttempt examAttempt1 = new ExamAttempt(false);
        ExamAttempt examAttempt2 = new ExamAttempt(true);
        Assert.assertNotSame(examAttempt1, examAttempt2);
    }

    @Test
    public void testSetExam() {
        Exam exam = new Exam();
        ExamAttempt examAttempt = new ExamAttempt(true);
        examAttempt.setExam(exam);
        Assert.assertEquals(exam, examAttempt.getExam());
    }


}