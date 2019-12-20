package part.one;

import org.junit.Test;

import static org.junit.Assert.fail;

public class TestChapterTwo {

    @Test
    public void testEmptyMatrix() {
        int[][] matrix={{}};

        int[][] expectedResult={{}};

        int[][] result=ChapterTwo.task10(matrix);

        if(!resultsEqual(result, expectedResult)) fail();
    }

    @Test
    public void testResults() {
        int[][] matrix={
                {8,5,4,7,5},
                {1,8,1,2,7},
                {0,7,1,7,7},
                {1,2,8,10,8},
                {4,5,4,2,4}
        };

        int[][] expectedResult = {
                {8,5,4,5},
                {1,8,1,7},
                {0,7,1,7},
                {4,5,4,4}
        };

        int[][] result = ChapterTwo.task10(matrix);

        if(!resultsEqual(result, expectedResult)) fail();
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

        if(!resultsEqual(result, expectedResult)) fail();
    }

    @Test
    public void testMultiSizedArray() {
        int[][] array = {
                {8,10,5},
                {1,4,5,8,0,4,1,5},
                {4,5,2,7,2},
                {1},
                {4,5,1,1}
        };

        int[][] expectedResult={{}};

        int[][] result=ChapterTwo.task10(array);

        if(!resultsEqual(result, expectedResult)) fail();
    }

    @Test
    public void testRowEqual() {
        int[][] matrix = {
                {4,5,7,2,2},
                {7,2,1,4,8},
                {10,10,10,10,10},
                {1,2,4,5,7},
                {7,5,4,2,1}
        };

        int[][] expectedResult={{}};

        int[][] result=ChapterTwo.task10(matrix);

        if(!resultsEqual(result, expectedResult)) fail();
    }

    @Test
    public void testColumnEqual() {
        int[][] matrix = {
                {7, 1, 10, 8, 4},
                {5, 2, 10, 5, 5},
                {4, 4, 10, 7, 1},
                {2, 5, 10, 8, 8},
                {1, 7, 10, 1, 0}
        };

        int[][] expectedResult={{}};

        int[][] result=ChapterTwo.task10(matrix);

        if(!resultsEqual(result, expectedResult)) fail();
    }

    public boolean resultsEqual(int[][] result, int[][] expected) {
        if(result.length!=expected.length) return false;
        if(result[0].length!=expected[0].length) return false;
        for(int i=0;i<result.length;i++) {
            for(int j=0;j<result[0].length;j++) {
                if(result[i][j]!=expected[i][j]) return false;
            }
        }

        return true;
    }

}
