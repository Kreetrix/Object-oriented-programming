package Task1;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeCheckerTest {
    @Test
    public void testIsPalindrome() {
        PalindromeChecker checker = new PalindromeChecker();

        assertTrue(checker.isPalindrome("radar"));
        assertTrue(checker.isPalindrome("A man, a plan, a canal, Panama"));
        assertTrue(checker.isPalindrome("Madam, I'm Adam"));
        assertTrue(checker.isPalindrome("racecar"));

        assertFalse(checker.isPalindrome("hello"));
        assertFalse(checker.isPalindrome("openai"));
        assertFalse(checker.isPalindrome("This is not a palindrome"));
    }
}