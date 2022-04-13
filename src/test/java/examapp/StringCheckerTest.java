package examapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StringCheckerTest {

    private StringChecker stringCheckerUnderTest;

    @BeforeEach
    void setUp() {
        stringCheckerUnderTest = new StringChecker();
    }

    @Test
    void testIsFullName_true() {
        assertTrue(stringCheckerUnderTest.isFullName("Rowin Hartog"));
    }
    @Test
    void testIsFullName_Partly(){
        assertFalse(stringCheckerUnderTest.isFullName("Rowin"));
    }
    @Test
    void testIsFullName_forbidden_characters(){
        assertFalse(stringCheckerUnderTest.isFullName("3244% 9ah"));
    }

    @Test
    void testIsFullName_forbidden_numbers(){
        assertFalse(stringCheckerUnderTest.isFullName(("R0win H4rtog")));
        // Numbers are still allowed
        // EDIT: Numbers are no longer allowed

    }
    @Test
    void testIsStudentNumber() {
        assertTrue(stringCheckerUnderTest.isStudentNumber("19092113"));
    }
    @Test
    void testIsStudentNumber_letters(){
        assertFalse(stringCheckerUnderTest.isStudentNumber("A19O22113"));
        // Letters still allowed
        // EDIT: Letters are no longer allowed
    }
    @Test
    void testIsStudentNumber_characters(){
        assertFalse(stringCheckerUnderTest.isStudentNumber("$19092!!3"));
        // Characters still allowed
        // EDIT: Characters are no longer allowed
    }
    @Test
    void testIsStudentNumber_short(){
        assertFalse(stringCheckerUnderTest.isStudentNumber("1234"));
    }
}
