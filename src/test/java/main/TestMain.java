package main;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import part.two.chapter.one.TestChapterOne;
import part.one.chapter.three.TestBoolMatrix;
import part.one.chapter.three.TestStringMatrix;
import part.one.chapter.two.TestChapterTwo;
import part.two.chapter.three.TestChapterThree;

public class TestMain {

    private final static String PART="\u001B[43m";
    private final static String CHAPTER="\u001B[34m";
    private final static String DONE="\u001B[32m";
    private final static String FAIL="\u001B[31m";
    private final static String END ="\u001B[0m";


    public static void main(String[] args) {
        Result result;

        System.out.println(PART+"Part one"+ END);
        result= JUnitCore.runClasses(TestChapterTwo.class);
        toConsole(result, "ChapterTwo: task10");

        result= JUnitCore.runClasses(TestBoolMatrix.class);
        toConsole(result, "ChapterThree: BoolMatrix");

        result= JUnitCore.runClasses(TestStringMatrix.class);
        toConsole(result, "ChapterThree: StringMatrix");

        System.out.println(PART+"Part two"+ END);
        result= JUnitCore.runClasses(TestChapterOne.class);
        toConsole(result, "ChapterOne: task4");

        result=JUnitCore.runClasses(TestChapterThree.class);
        toConsole(result,"ChapterThree: task10");
    }

    private static void toConsole(Result result, String chapterAndTask) {

        System.out.println(CHAPTER+chapterAndTask+ END +" - "+(result.wasSuccessful()?DONE+"done"+ END :FAIL+"fail"+ END));

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }
}
