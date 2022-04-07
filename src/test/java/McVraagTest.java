import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class McVraagTest {


    @Test
    public void testMcVragen() {
        ArrayList<String> choises = new ArrayList<>();
        choises.add("Rusland");
        choises.add("China");
        choises.add("France");
        choises.add("America");
        Vraag vraag = new Vraag("Which country has the most nukes",choises,"A",10);
        Assertions.assertEquals("Which country has the most nukes",vraag.getVraag());
    }
    @Test
    public void testMcVragenAnswer() {
        ArrayList<String> choises = new ArrayList<>();
        choises.add("Rusland");
        choises.add("China");
        choises.add("France");
        choises.add("America");
        Vraag vraag = new Vraag("Which country has the most nukes",choises,"A",10);
        Assertions.assertEquals("A",vraag.getAntwoord());
    }
    @Test
    public void testMcVragenpunten() {
        ArrayList<String> choises = new ArrayList<>();
        choises.add("Rusland");
        choises.add("China");
        choises.add("France");
        choises.add("America");
        Vraag vraag = new Vraag("Which country has the most nukes",choises,"A",10);
        Assertions.assertEquals("A",vraag.getAntwoord());
    }
}
