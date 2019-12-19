package part.one;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestChapterTwo {

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testEmptyMatrix() {
        int[][] matrix={{}};
        ChapterTwo.task10(matrix);
    }
}
