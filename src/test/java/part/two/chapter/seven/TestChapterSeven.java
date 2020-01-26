package part.two.chapter.seven;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestChapterSeven {

    @Test
    public void testString() {
        String str="helloooo wooooorld";
        String expected="hel2o4 wo5rld";

        String result= ChapterSeven.task4(str);

        assertEquals(expected,result);
    }

    @Test
    public void testString2() {
        String str="kldkjpppppppslksl;dkqqqqqqqqls.k;ls;';tttttttttttt";
        String expected="kldkjp7slksl;dkq8ls.k;ls;';t12";

        String result= ChapterSeven.task4(str);

        assertEquals(expected,result);
    }

    @Test
    public void testString3() {
        String str="aaaa-aaaaaaaa-aaaaaaaaaaaaaaaaa-aaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String expected="a4-a8-a17-a27";

        String result= ChapterSeven.task4(str);

        assertEquals(expected,result);
    }
}
