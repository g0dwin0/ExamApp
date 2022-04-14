package examapp;

import org.junit.jupiter.api.AfterEach;
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

    @AfterEach
    void close(){
        examList.getExamList().clear();
    }

    /***
     * Test het opvragen van een naam van een examen in de arraylist in een specifieke positie
     */
    @Test
    public void testExamListExam1() {
        Assertions.assertEquals("Open Vragen", examList.examArrayList.get(0).getName());
    }

    /***
     * Test het opvragen van een naam van een examen in de arraylist in een specifieke positie
     */
    @Test
    public void testExamListExam2() {
        Assertions.assertEquals("Meerkeuze Vragen", examList.examArrayList.get(1).getName());
    }

    /***
     * Test of een nieuw toegevoegd examen in de examenlijst staat
     */
    @Test
    public void testExamListExam3() {
        examList.examArrayList.add(new Exam("Meerkeuze Toets", Question.multipleChoiceQuestion()));
        Assertions.assertEquals("Meerkeuze Toets", examList.examArrayList.get(2).getName());
    }

    /***
     * Test het ophalen van de examenlijst
     */
    @Test
    public void testGetExamList() {
        ArrayList<Exam> exams = new ArrayList<>();
        exams.add(new Exam("Open Vragen", Question.openQuestion()));
        exams.add(new Exam("Meerkeuze Vragen", Question.multipleChoiceQuestion()));
        for (int i = 0; i < exams.size(); i++) {
            Assertions.assertEquals(exams.get(i).getName(), examList.getExamList().get(i).getName());
        }
    }

    /***
     * Test het ophalen van examen met open vragen
     */
    @Test
    public void testGetExamList_openQuestions() {
        ArrayList<Question> openQuestions = Question.openQuestion();
        for (int i = 0; i < openQuestions.size(); i++) {
            Question listQuestion = examList.getExamList().get(0).getQuestions().get(i);
            Assertions.assertEquals(openQuestions.get(i).getQuestion(), listQuestion.getQuestion());
        }

    }

    /***
     * Test het ophalen van een examen met meerkeuze vragen
     */
    @Test
    public void testGetExamList_multipleChoiceQuestions() {
        ArrayList<Question> openQuestions = Question.multipleChoiceQuestion();
        for (int i = 0; i < openQuestions.size(); i++) {
            Question listQuestion = examList.getExamList().get(1).getQuestions().get(i);
            Assertions.assertEquals(openQuestions.get(i).getQuestion(), listQuestion.getQuestion());
        }

    }
}