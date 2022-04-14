package examapp;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;


class MenuTest {

    private Menu menuUnderTest;

    @BeforeEach
    void setUp() {
        menuUnderTest = new Menu();
    }

    @Test
    void testGetChoise() {
        // Setup
        // Run the test
        menuUnderTest.getChoise("choice");

        // Verify the results
    }

    @Test
    void testAddExam() {
        // Setup
        // Run the test
        menuUnderTest.addExam();

        // Verify the results
    }

    @Test
    void testAddOpenQuestionExam() {
        // Setup
        // Run the test
        menuUnderTest.addOpenQuestionExam("examName", 0);

        // Verify the results
    }

    @Test
    void testDidStudentPassExam() {
        // Setup
        // Run the test
        menuUnderTest.didStudentPassExam();

        // Verify the results
    }

    @Test
    void testIsExamAvailable() {
        // Setup
        // Run the test
        final boolean result = menuUnderTest.isExamAvailable(0);

        // Verify the results
        //assertThat(result).isTrue();
    }

    @Test
    void testAddCandidateResult() {
        // Setup
        final ArrayList<Question> examQuestions = new ArrayList<>(
                List.of(new Question("question", new ArrayList<>(List.of("value")), "answer", 0)));
        final Student candidate = new Student("studentName", "studentNumber");

        // Run the test
        menuUnderTest.addCandidateResult(0, examQuestions, candidate);

        // Verify the results
    }

    @Test
    void testShowStudentList() {
        // Setup
        // Run the test
        final String result = menuUnderTest.showStudentList();

        // Verify the results
        //assertThat(result).isEqualTo("result");
    }

    @Test
    void testShowExamList() {
        // Setup
        // Run the test
        final String result = menuUnderTest.showExamList();

        // Verify the results
        //assertThat(result).isEqualTo("result");
    }

    @Test
    void testHasPassed() {
        // Setup
        final Exam exam = new Exam("examName", new ArrayList<>(
                List.of(new Question("question", new ArrayList<>(List.of("value")), "answer", 66))));

        // Run the test
        final boolean result = menuUnderTest.hasPassed(exam, 0);
        //Assert.assertThat(menuUnderTest.hasPassed(exam,0))isTrue());

    }

    @Test
    void testShowMenu() {
        // Setup
        // Run the test
        Menu.showMenu();

        // Verify the results
    }
}
