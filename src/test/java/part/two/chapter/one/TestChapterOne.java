package part.two.chapter.one;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestChapterOne {

    @Test
    public void testString() {
        String str="helloooo wooooorld";
        String expected="hel2o4 wo5rld";

        String result=ChapterOne.task4(str);

        assertEquals(expected,result);
    }

    @Test
    public void testString2() {
        String str="kldkjpppppppslksl;dkqqqqqqqqls.k;ls;';tttttttttttt";
        String expected="kldkjp7slksl;dkq8ls.k;ls;';t12";

        String result=ChapterOne.task4(str);

        assertEquals(expected,result);
    }

    @Test
    public void testString4() {
        String str="aaaa-aaaaaaaa-aaaaaaaaaaaaaaaaa-aaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String expected="a4-a8-a17-a27";

        String result=ChapterOne.task4(str);

        assertEquals(expected,result);
    }
}
