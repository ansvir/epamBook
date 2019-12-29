package part.two.chapter.six;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestChapterSix {
    @Test
    public void testSumPassengers() {

        int expectedResult = 415;
        int result = -1;
        try {
            RailroadPassengerCarDAO rpc = RailroadPassengerCarDAO.getInstance();
            result = rpc.sumPassengers();
        } catch (SQLException exc) {
            System.err.println(exc.toString());
            fail();
        }

        assertEquals(expectedResult, result);
    }

    @Test
    public void testSumLuggage() {

        double expectedResult = 1037.5;
        double result = -1.0;
        try {
            RailroadPassengerCarDAO rpc = RailroadPassengerCarDAO.getInstance();
            result = rpc.sumLuggage();
        } catch (SQLException exc) {
            System.err.println(exc.toString());
            fail();
        }

        if (Double.compare(expectedResult, result) != 0) {
            fail();
        }
    }
}
