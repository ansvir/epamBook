package part.two.chapter.one;

import org.junit.Test;
import part.two.ChapterOne;

import static org.junit.Assert.fail;

public class TestChapterOne {

    @Test
    public void testString() {
        String str="helloooo wooooorld";
        String expected="hel2o4 wo5rld";

        String result=ChapterOne.task4(str);

        if(!expected.equals(result)) fail();
    }

    @Test
    public void testString2() {
        String str="kldkjpppppppslksl;dkqqqqqqqqls.k;ls;';tttttttttttt";
        String expected="kldkjp7slksl;dkq8ls.k;ls;';t12";

        String result=ChapterOne.task4(str);

        if(!expected.equals(result)) fail();
    }

    @Test
    public void testString4() {
        String str="        11111222224444444555557777777         ";
        String expected="        11111222224444444555557777777         ";

        String result=ChapterOne.task4(str);

        if(!expected.equals(result)) fail();
    }
}
