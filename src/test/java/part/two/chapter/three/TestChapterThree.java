package part.two.chapter.three;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestChapterThree {

    @Test
    public void testString() {

        File file=new File("./src/test/java/part/two/chapter/three/test.txt");
        String input="FirstWordInString1 string some words other words symbols lastWordInString1\n"+
                "FirstWordInString2 string some words other words symbols lastWordInString2\n"+
                "FirstWordInString3 string some words other words symbols lastWordInString3\n"+
                "FirstWordInString4 string some words other words symbols lastWordInString4\n"+
                "FirstWordInString5 string some words other words symbols lastWordInString5";

        if(!writeToFile(file, input)) {
            System.err.println("Error while writing to file");
            fail();
        };

        String expectedResult="lastWordInString1 string some words other words symbols FirstWordInString1\n"+
                "lastWordInString2 string some words other words symbols FirstWordInString2\n"+
                "lastWordInString3 string some words other words symbols FirstWordInString3\n"+
                "lastWordInString4 string some words other words symbols FirstWordInString4\n"+
                "lastWordInString5 string some words other words symbols FirstWordInString5";

        String result="";
        try {
            result=ChapterThree.task10(file);
        } catch (InvalidSentenceException exc) {
            System.err.println("Invalid input sentence: "+exc.toString());
            fail();
        }

        if(!file.delete()) {
            System.out.println("File wasn't deleted");
        }

        assertEquals(expectedResult, result);
    }

    @Test
    public void testEmptyString() {

        File file=new File("./src/test/java/part/two/chapter/three/test.txt");
        String input="";

        if(!writeToFile(file, input)) {
            System.err.println("Error while writing to file");
            fail();
        };

        String expectedResult="";

        String result="";
        try {
            result=ChapterThree.task10(file);
        } catch (InvalidSentenceException exc) {
            System.err.println("Invalid input sentence: "+exc.toString());
            fail();
        }

        if(!file.delete()) {
            System.out.println("File wasn't deleted");
        }

        assertEquals(expectedResult, result);
    }

    private static boolean writeToFile(File file, String string) {
        boolean written = false;
        if(file!=null) {
            try (FileWriter fw = new FileWriter(file)){
                fw.write(string);
                written=true;
            } catch (IOException exc) {
                System.err.println("Error while writing to file"+exc.toString());
            }
        }

        return written;

    }
}
