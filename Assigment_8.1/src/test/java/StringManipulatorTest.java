import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import StringManipulator.StringManipulator;

class StringManipulatorTest {
    @Test
    void testConcatenate() {
        StringManipulator sm = new StringManipulator();
        assertEquals("HelloWorld", sm.concatenate("Hello", "World"));
        assertEquals("OpenAI", sm.concatenate("Open", "AI"));
    }

    @Test
    void testFindLength() {
        StringManipulator sm = new StringManipulator();
        assertEquals(5, sm.findLength("Hello"));
        assertEquals(0, sm.findLength(""));
    }

    @Test
    void testConvertToUpperCase() {
        StringManipulator sm = new StringManipulator();
        assertEquals("HELLO", sm.convertToUpperCase("hello"));
        assertEquals("WORLD", sm.convertToUpperCase("WORLD"));
    }

    @Test
    void testConvertToLowerCase() {
        StringManipulator sm = new StringManipulator();
        assertEquals("hello", sm.convertToLowerCase("HELLO"));
        assertEquals("world", sm.convertToLowerCase("world"));
    }

    @Test
    void testContainsSubstring() {
        StringManipulator sm = new StringManipulator();
        assertTrue(sm.containsSubstring("Hello World", "World"));
        assertFalse(sm.containsSubstring("Hello World", "Universe"));
    }
}