import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {
    @Test
    public void fullJustifyTest1() {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> expected = new ArrayList<>(List.of(
                "This    is    an",
                "example  of text",
                "justification.  "
        ));
        List<String> actual = new Solution().fullJustify(words, maxWidth);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void fullJustifyTest2() {
        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth = 16;
        List<String> expected = new ArrayList<>(List.of(
                "What   must   be",
                "acknowledgment  ",
                "shall be        "
        ));
        List<String> actual = new Solution().fullJustify(words, maxWidth);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void fullJustifyTest3() {
        String[] words = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        int maxWidth = 20;
        List<String> expected = new ArrayList<>(List.of(
                "Science  is  what we",
                "understand      well",
                "enough to explain to",
                "a  computer.  Art is",
                "everything  else  we",
                "do                  "
        ));
        List<String> actual = new Solution().fullJustify(words, maxWidth);

        Assert.assertEquals(expected, actual);
    }
}
