import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class McQuestionTest {


    @Test
    public void testMcVragen() {
        ArrayList<String> choices = new ArrayList<>();
        choices.add("Rusland");
        choices.add("China");
        choices.add("France");
        choices.add("America");
        Question question = new Question("Which country has the most nukes",choices,"A",10);
        Assertions.assertEquals("Which country has the most nukes", question.getQuestion());
    }
    @Test
    public void testMcVragenAnswer() {
        ArrayList<String> choices = new ArrayList<>();
        choices.add("Rusland");
        choices.add("China");
        choices.add("France");
        choices.add("America");
        Question question = new Question("Which country has the most nukes",choices,"A",10);
        Assertions.assertEquals("A", question.getAnswer());
    }
    @Test
    public void testMcVragenpunten() {
        ArrayList<String> choices = new ArrayList<>();
        choices.add("Rusland");
        choices.add("China");
        choices.add("France");
        choices.add("America");
        Question question = new Question("Which country has the most nukes",choices,"A",10);
        Assertions.assertEquals("A", question.getAnswer());
    }
}
