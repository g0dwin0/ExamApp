package examapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ExamListTest {
    ExamList examList;

    @BeforeEach
    void setUp() {
        examList = new ExamList();
    }

    @Test
    public void testExamListExam1() {
        Assertions.assertEquals("Open Vragen", examList.examArrayList.get(0).getName());
    }

    @Test
    public void testExamListExam2() {
        Assertions.assertEquals("Meerkeuze Vragen", examList.examArrayList.get(1).getName());
    }

    @Test
    public void testExamListExam3() {
        examList.examArrayList.add(new Exam("Meerkeuze Toets", Question.multipleChoiceQuestion()));
        Assertions.assertEquals("Meerkeuze Toets", examList.examArrayList.get(2).getName());
    }

    @Test
    public void testGetExamList() {
        ArrayList<Exam> exams = new ArrayList<>();
        exams.add(new Exam("Open Vragen", Question.openQuestion()));
        exams.add(new Exam("Meerkeuze Vragen", Question.multipleChoiceQuestion()));
        for (int i = 0; i < exams.size(); i++) {
            Assertions.assertEquals(exams.get(i).getName(), examList.getExamList().get(i).getName());
        }
    }

    @Test
    public void testGetExamList_openQuestions() {
        ArrayList<Question> openQuestions = Question.openQuestion();
        for (int i = 0; i < openQuestions.size(); i++) {
            Question listQuestion = examList.getExamList().get(0).getQuestions().get(i);
            Assertions.assertEquals(openQuestions.get(i).getQuestion(), listQuestion.getQuestion());
        }

    }

    @Test
    public void testGetExamList_multipleChoiceQuestions() {
        ArrayList<Question> openQuestions = Question.multipleChoiceQuestion();
        for (int i = 0; i < openQuestions.size(); i++) {
            Question listQuestion = examList.getExamList().get(1).getQuestions().get(i);
            Assertions.assertEquals(openQuestions.get(i).getQuestion(), listQuestion.getQuestion());
        }

    }
}