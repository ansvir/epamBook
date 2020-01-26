package main;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestMain {

    private final static String DONE="\u001B[32m";
    private final static String FAIL="\u001B[31m";
    private final static String END ="\u001B[0m";

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestSuite.class);
        System.out.println(result.wasSuccessful() ? DONE+"Tests passed"+END : FAIL+"Tests failed"+END);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }
}
