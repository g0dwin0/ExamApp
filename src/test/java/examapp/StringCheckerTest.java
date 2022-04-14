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

    /**
     * Checks if name first and last name for student is given
     */
    @Test
    void testIsFullName_true() {
        assertTrue(stringCheckerUnderTest.isFullName("Rowin Hartog"));
    }
    /**
     * Checks if name first and last name for student is given
     */
    @Test
    void testIsFullName_Partly(){
        assertFalse(stringCheckerUnderTest.isFullName("Rowin"));
    }
    /**
     * Checks if characters are disallowed in full name of student
     */
    @Test
    void testIsFullName_forbidden_characters(){
        assertFalse(stringCheckerUnderTest.isFullName("3244% 9ah"));
    }

    /**
     * Checks if numbers are disallowed in full name of student
     */
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
    /**
     * Checks if letters are disallowed in student number
     */
    @Test
    void testIsStudentNumber_letters(){
        assertFalse(stringCheckerUnderTest.isStudentNumber("A19O22113"));
        // Letters still allowed
        // EDIT: Letters are no longer allowed
    }
    /**
     * Checks if characters are disallowed in full name of student
     */
    @Test
    void testIsStudentNumber_characters(){
        assertFalse(stringCheckerUnderTest.isStudentNumber("$19092!!3"));
        // Characters still allowed
        // EDIT: Characters are no longer allowed
    }
    /**
     * Checks if student number is too short
     */
    @Test
    void testIsStudentNumber_short(){
        assertFalse(stringCheckerUnderTest.isStudentNumber("12344"));
    }
    /**
     * Checks if student number is correct size
     */
    @Test
    void testIsStudentNumber_correct_size(){
        assertTrue(stringCheckerUnderTest.isStudentNumber("19092113"));
    }
    /**
     * Checks if student number is too long
     */
    @Test
    void testIsStudentNumber_too_long(){
        assertFalse(stringCheckerUnderTest.isStudentNumber("190921133"));
    }
}
