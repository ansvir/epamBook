package main;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import part.two.chapter.one.TestChapterOne;
import part.one.chapter.three.TestBoolMatrix;
import part.one.chapter.three.TestStringMatrix;
import part.one.chapter.two.TestChapterTwo;

public class TestMain {

    private final static String PART="\u001B[43m";
    private final static String CHAPTER="\u001B[34m";
    private final static String DONE="\u001B[32m";
    private final static String FAIL="\u001B[31m";
    private final static String RESET="\u001B[0m";


    public static void main(String[] args) {
        Result result=null;

        result= JUnitCore.runClasses(TestChapterTwo.class);
        System.out.println(PART+"Part one"+RESET);
        toConsole(result, "ChapterTwo: task10");

        result= JUnitCore.runClasses(TestBoolMatrix.class);
        toConsole(result, "ChapterThree: BoolMatrix");

        result= JUnitCore.runClasses(TestStringMatrix.class);
        toConsole(result, "ChapterThree: StringMatrix");

        result= JUnitCore.runClasses(TestChapterOne.class);
        System.out.println(PART+"Part two"+RESET);
        toConsole(result, "ChapterOne: task4");
    }

    private static void toConsole(Result result, String chapterAndTask) {

        System.out.println(CHAPTER+chapterAndTask+RESET+" - "+(result.wasSuccessful()?DONE+"done"+RESET:FAIL+"fail"+RESET));

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }
}
