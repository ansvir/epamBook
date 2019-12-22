package part.one.chapter.three;

import org.junit.Test;

import static org.junit.Assert.fail;

public class TestStringMatrix {

    @Test
    public void testSortAlphabetically() {
        String[][] matrix = {
                {"Philip","Vitalij","Boris","Nikolaj"},
                {"Ilya","Oleg","Vasilij","Mikhail"},
                {"Vyacheslav","Roman","Ivan","Oleg"},
                {"Grigorij","Anton","Ibragim","Petr"}
        };

        String[][] expectedMatrix = {
                {"Anton", "Boris", "Grigorij", "Ibragim"},
                {"Ilya", "Ivan", "Mikhail", "Nikolaj"},
                {"Oleg", "Oleg", "Petr", "Philip"},
                {"Roman", "Vasilij", "Vitalij", "Vyacheslav"}
        };

        StringMatrix sm=new StringMatrix(matrix);
        StringMatrix sm2=new StringMatrix(expectedMatrix);

        if(!sm.sortAlphabetically().matrixEqualTo(new StringMatrix(expectedMatrix))) fail();
    }
}
