package part.one.chapter.three;

import org.junit.Test;

import static org.junit.Assert.fail;

public class TestBoolMatrix {

    @Test
    public void testDisjunction() {
        Boolean[][] matrix = {
                {true,false,false,true},
                {false,false,false,true},
                {true,false,true,true},
                {false,false,false,true}
        };

        Boolean[][] matrix2 = {
                {false,true,false,true},
                {true,false,false,true},
                {false,false,false,true},
                {true,false,true,true}
        };

        Boolean[][] expectedMatrix = {
                {true, true, false, true},
                {true, false,false,true},
                {true,false,true,true},
                {true,false,true,true}
        };

        BoolMatrix bm=new BoolMatrix(matrix);
        BoolMatrix bm2=new BoolMatrix(matrix2);
        BoolMatrix result=bm.disjunction(bm2);
        if(!result.matrixEqualTo(new BoolMatrix(expectedMatrix))) fail();

    }

    @Test
    public void testConjunction() {
        Boolean[][] matrix = {
                {true,false,false,true},
                {false,false,false,true},
                {true,false,true,true},
                {false,false,false,true}
        };

        Boolean[][] matrix2 = {
                {false,true,false,true},
                {true,false,false,true},
                {false,false,false,true},
                {true,false,true,true}
        };

        Boolean[][] expectedMatrix = {
                {false, false, false, true},
                {false, false,false,true},
                {false,false,false,true},
                {false,false,false,true}
        };

        BoolMatrix bm=new BoolMatrix(matrix);
        BoolMatrix bm2=new BoolMatrix(matrix2);
        BoolMatrix result=bm.conjunction(bm2);

        if(!result.matrixEqualTo(new BoolMatrix(expectedMatrix))) fail();

    }

    @Test
    public void testInversion() {
        Boolean[][] matrix = {
                {true,false,false,true},
                {false,false,false,true},
                {true,false,true,true},
                {false,false,false,true}
        };

        Boolean[][] expectedMatrix = {
                {false, true, true, false},
                {true, true,true,false},
                {false,true,false,false},
                {true,true,true,false}
        };

        BoolMatrix bm=new BoolMatrix(matrix);
        BoolMatrix result=bm.inverse();
        if(!result.matrixEqualTo(new BoolMatrix(expectedMatrix))) fail();
    }

    @Test
    public void testCountOnes() {
        Boolean[][] matrix = {
                {true,false,false,true},
                {false,false,false,true},
                {true,false,true,true},
                {false,false,false,true}
        };

        int expectedCount = 7;
        int resultCount;
        BoolMatrix bm=new BoolMatrix(matrix);
        resultCount=bm.countOnes();
        if(resultCount!=expectedCount) fail();
    }

}
