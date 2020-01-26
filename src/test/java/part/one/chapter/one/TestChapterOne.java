package part.one.chapter.one;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestChapterOne {

    @Test
    public void testInt() {
        int number = 10;
        int result;
        int expectedResult=55;
        result=ChapterOne.task12(number);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testBigNumber() {
        int number=100000000;
        int result;
        int expectedResult=-1;
        result=ChapterOne.task12(number);
        assertEquals(expectedResult, result);
    }
}
