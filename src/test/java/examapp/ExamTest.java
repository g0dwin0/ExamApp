package examapp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ExamTest {


    @Test
    public void testExam() {
        ArrayList<Question> questions = new ArrayList<>();
        Exam exam = new Exam("Taaltoets", questions);
        Assert.assertEquals("Taaltoets", exam.getName());
        Assert.assertEquals(questions, exam.getQuestions());
    }

    @Test
    public void testEmptyExam() {
        Exam exam = new Exam();
        Assert.assertEquals("", exam.getName());
        Assert.assertNull(exam.getQuestions());
    }

    /**
     * Checks if exam name is requested correctly
     */
    @Test
    public void testGetName() {
        Exam exam = new Exam("Security",null);
        Assert.assertEquals("Security",exam.getName());
    }
    /**
     * Checks if exam questions are returned correctly
     */
    @Test
    public void testGetQuestions() {
        ArrayList<Question> questions = new ArrayList<>();
        Exam exam = new Exam("Exam", questions);
        Assert.assertEquals(questions, exam.getQuestions());
    }
}