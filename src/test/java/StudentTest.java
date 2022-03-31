import junit.framework.TestCase;
import org.junit.Assert;

public class StudentTest extends TestCase {

    public void testGetNaam() {
        Student student = new Student("Rowin Hartog","19092113");
        Assert.assertEquals("Rowin Hartog",student.getNaam());
    }

    public void testGetStudentnummer() {
        Student student = new Student("Rowin Hartog","19092113");
        Assert.assertEquals("19092113",student.getStudentnummer());
    }

    public void testSetNaam() {

    }

    public void testAddResult() {
    }

    public void testGetStudentResults() {
    }
}