package main;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import part.one.chapter.two.TestChapterTwo;

public class TestMain {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestChapterTwo.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
