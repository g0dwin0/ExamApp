package examapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {
    private Student studentUnderTest;

    @BeforeEach
    void setUp() {
        studentUnderTest = new Student("Rowin Hartog", "19092113");
        final Result result = new Result(new Exam("name", new ArrayList<>(
                List.of(new Question("question", new ArrayList<>(List.of("value")), "answer", 100)))), 10, true);
        final Result result1 = new Result(new Exam("name", new ArrayList<>(
                List.of(new Question("question", new ArrayList<>(List.of("value")), "answer", 100)))), 10, false);
        studentUnderTest.addResult(result);
        studentUnderTest.addResult(result1);
    }
    /**
     * Checks if student name is returned correctly
     */
    @Test
    void testGetStudentName() {
        assertEquals("Rowin Hartog", studentUnderTest.getStudentName());
    }
    /**
     * Checks if student number is returned correctly
     */
    @Test
    void testGetStudentnumber() {
        assertEquals("19092113", studentUnderTest.getStudentnumber());
    }

    /**
     * Checks if student name sets and is returned correctly
     */
    @Test
    void testSetStudentName() {

        studentUnderTest.setStudentName("Rowin Hartogg");
        assertEquals("Rowin Hartogg",studentUnderTest.getStudentName());
    }
    /**
     * Checks if student result is added correctly
     */
    @Test
    void testAddResult() {

        final Result result = new Result(new Exam("cxzxcxxc", new ArrayList<>(
                List.of(new Question("question", new ArrayList<>(List.of("value")), "answer", 100)))), 10, true);

        studentUnderTest.addResult(result);
        Assertions.assertEquals(result,studentUnderTest.getResult());
    }

    /**
     * Checks if student exam outcome is a success
     */
    @Test
    void testGetAmountSuccesses() {
        final int outcome = studentUnderTest.getAmountSuccesses();

        assertEquals(1, outcome);
    }
    /**
     * Checks the results of a student
     */
    @Test
    void testGetResult() {
        // Setup
        final Result result = new Result(new Exam("name1", new ArrayList<>(
                List.of(new Question("question", new ArrayList<>(List.of("value")), "answer", 0)))), 12, true);
        studentUnderTest.addResult(result);

        final Result result2 = studentUnderTest.getResult();
        Assertions.assertEquals(result2,studentUnderTest.getResult());
        Assertions.assertTrue(studentUnderTest.getStudentResultsList().get(2).passed);
        assertEquals("name1",studentUnderTest.getStudentResultsList().get(2).getExam().getName());
        assertEquals(12,studentUnderTest.getStudentResultsList().get(2).getAmountCorrect());

    }
}
