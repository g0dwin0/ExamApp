import junit.framework.TestCase;
import org.junit.Assert;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ExamTest extends TestCase {

    public void testStartExam() {
    }

    public void testFinalCijfer() {
    }

    public void testGetNaam() {
        Exam exam = new Exam("Security",null);
        Assert.assertEquals("Security",exam.getNaam());
    }

    public void testAddExam() {

    }

    public void testSetNaam() {
    }

    public void testGetAantalJuisteAntwoorden() {
    }

    public void testSetAantalJuisteAntwoorden() {
    }

    public void testGetVragen() {
    }

    public void testSetVragen() {
    }

    public void testGetResultaten() {
    }

    public void testSetResultaten() {
    }

    public void testGetMinimumCorrect() {
    }

    public void testSetMinimumCorrect() {
    }
}