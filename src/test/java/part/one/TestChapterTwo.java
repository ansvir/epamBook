package part.one;

import org.junit.Test;

import static org.junit.Assert.fail;

public class TestChapterTwo {

    @Test
    public void testEmptyMatrix() {
        int[][] matrix={{}};
        try {
            ChapterTwo.task10(matrix);
        } catch (ArrayIndexOutOfBoundsException exc) {
            fail();
        }
    }

    @Test
    public void testResults() {
        int[][] matrix={
                {5,5,5,5,5},
                {1,1,1,1,1},
                {7,7,7,7,7},
                {8,8,8,10,8},
                {4,4,4,4,4}
        };

        int[][] expectedResult = {
                {5,5,5,5},
                {1,1,1,1},
                {7,7,7,7},
                {4,4,4,4}
        };

        int[][] result = ChapterTwo.task10(matrix);

        if(result.length!=expectedResult.length) fail();
        if(result[0].length!=expectedResult[0].length) fail();
        for(int i=0;i<result.length;i++) {
            for(int j=0;j<result[0].length;j++) {
                if(result[i][j]!=expectedResult[i][j]) fail();
            }
        }
    }

    @Test
    public void testAllEqual() {
        int[][] matrix = {
                {10,10,10,10,10},
                {10,10,10,10,10},
                {10,10,10,10,10},
                {10,10,10,10,10},
                {10,10,10,10,10}
        };

        int[][] expectedResult = {{}};

        int[][] result = ChapterTwo.task10(matrix);

        if(result.length!=expectedResult.length) fail();
        if(result[0].length!=expectedResult[0].length) fail();
        for(int i=0;i<result.length;i++) {
            for(int j=0;j<result[0].length;j++) {
                if(result[i][j]!=expectedResult[i][j]) fail();
            }
        }
    }
}
