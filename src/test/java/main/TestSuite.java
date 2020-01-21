package main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import part.two.chapter.nine.TestChapterNine;
import part.two.chapter.seven.TestChapterSeven;
import part.two.chapter.thirteen.TestChapterThirteen;
import part.two.chapter.twelve.TestChapterTwelve;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        part.one.chapter.one.TestChapterOne.class,
        part.one.chapter.two.TestChapterTwo.class,
        part.one.chapter.three.TestBoolMatrix.class,
        part.one.chapter.three.TestStringMatrix.class,
        part.one.chapter.four.TestChapterFour.class,
        TestChapterSeven.class,
        TestChapterNine.class,
        TestChapterTwelve.class,
        TestChapterThirteen.class
})

public class TestSuite {
}
