import junit.framework.TestCase;
import org.junit.Assert;

public class QuestionTest extends TestCase {

    public void testGetVraag() {
        Question question = new Question("Wat is 1 + 1","2",10);
        Assert.assertEquals("Wat is 1 + 1", question.getQuestion());
    }

    public void testSetVraag() {
    }

    public void testGetAntwoord() {
        Question question = new Question("Wat is 1 + 1","2",10);
        Assert.assertEquals("2", question.getAnswer());
    }

    public void testSetAntwoord() {
    }

    public void testGetPunten() {
        Question question = new Question("Wat is 1 + 1","2",10);
        Assert.assertEquals(10, question.getPoints());
    }

    public void testGetKeuze() {
    }

    public void testVragen() {
    }



    public void testOptie() {
    }
}