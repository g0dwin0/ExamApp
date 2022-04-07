import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;

public class VraagTest extends TestCase {

    public void testGetVraag() {
        Vraag vraag = new Vraag("Wat is 1 + 1","2",10);
        Assert.assertEquals("Wat is 1 + 1", vraag.getVraag());
    }

    public void testSetVraag() {
    }

    public void testGetAntwoord() {
        Vraag vraag = new Vraag("Wat is 1 + 1","2",10);
        Assert.assertEquals("2",vraag.getAntwoord());
    }

    public void testSetAntwoord() {
    }

    public void testGetPunten() {
        Vraag vraag = new Vraag("Wat is 1 + 1","2",10);
        Assert.assertEquals(10,vraag.getPunten());
    }

    public void testGetKeuze() {
    }

    public void testVragen() {
    }



    public void testOptie() {
    }
}