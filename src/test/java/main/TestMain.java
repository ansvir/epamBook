package main;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import part.one.chapter.three.TestBoolMatrix;
import part.one.chapter.three.TestStringMatrix;
import part.one.chapter.two.TestChapterTwo;
import part.two.chapter.one.TestChapterOne;

public class TestMain {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestChapterTwo.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println("Part one");
        System.out.println("ChapterTwo: task10");
        System.out.println(result.wasSuccessful());

        result = JUnitCore.runClasses(TestBoolMatrix.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println("ChapterThree: BoolMatrix");
        System.out.println(result.wasSuccessful());

        result = JUnitCore.runClasses(TestStringMatrix.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println("ChapterThree: StringMatrix");
        System.out.println(result.wasSuccessful());

        result = JUnitCore.runClasses(TestChapterOne.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println("Part two");
        System.out.println("ChapterOne: task4");
        System.out.println(result.wasSuccessful());
    }
}
