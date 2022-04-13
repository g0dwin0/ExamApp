import examapp.Exam;
import examapp.Question;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ExamTest extends TestCase {

    public void testExam() {
        ArrayList<Question> questions = new ArrayList<>();
        Exam exam = new Exam("Taaltoets", questions);
        assertEquals("Taaltoets", exam.getName());
        assertEquals(questions, exam.getQuestions());
    }

    public void testEmptyExam() {
        Exam exam = new Exam();
        assertEquals("", exam.getName());
        assertNull(exam.getQuestions());
    }

    public void testGetName() {
        Exam exam = new Exam("Security",null);
        Assert.assertEquals("Security",exam.getName());
    }

    public void testGetQuestions() {
        ArrayList<Question> questions = new ArrayList<>();
        Exam exam = new Exam("Exam", questions);
        assertEquals(questions, exam.getQuestions());
    }
}