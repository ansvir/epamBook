package main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        part.one.chapter.one.TestChapterOne.class,
        part.one.chapter.two.TestChapterTwo.class,
        part.one.chapter.three.TestBoolMatrix.class,
        part.one.chapter.three.TestStringMatrix.class,
        part.one.chapter.four.TestChapterFour.class,
        part.two.chapter.one.TestChapterOne.class,
        part.two.chapter.three.TestChapterThree.class,
        part.two.chapter.six.TestChapterSix.class
})

public class TestSuite {
}
