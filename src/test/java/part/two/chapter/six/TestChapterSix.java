package part.two.chapter.six;

import org.junit.Test;
import part.one.chapter.four.PassengerRailroadCar;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

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
        }

        if (Double.compare(expectedResult, result) != 0) {
            fail();
        }
    }

    @Test
    public void testSortByAmenities() {

        List<PassengerRailroadCar> result = null;
        try {
            RailroadPassengerCarDAO rpc = RailroadPassengerCarDAO.getInstance();
            result = rpc.sortByAmenities();
        } catch (SQLException exc) {
            System.err.println(exc.toString());
        }
        List<Integer> idsOrder = new ArrayList<>();
        idsOrder.add(4);
        idsOrder.add(3);
        idsOrder.add(1);
        idsOrder.add(5);
        idsOrder.add(2);

        assertEquals(idsOrder.size(), result.size());

        for (int i=0;i<result.size();i++) {
            assertEquals(idsOrder.get(i), (Integer) result.get(i).getId());
        }
    }

    @Test
    public void testFindFromRange70To100() {
        List<PassengerRailroadCar> result = null;
        try {
            RailroadPassengerCarDAO rpc = RailroadPassengerCarDAO.getInstance();
            result = rpc.findFromRange(70,100);
        } catch (SQLException exc) {
            System.err.println(exc.toString());
        }
        Map<Integer, Integer> expectedResult = new HashMap<>();

        expectedResult.put(1,80);
        expectedResult.put(2,75);
        expectedResult.put(3,100);

        assertEquals(expectedResult.size(), result.size());


        for (PassengerRailroadCar prc: result) {
            assertTrue(expectedResult.containsKey(prc.getId())
                    || (prc.getPassengers() != expectedResult.get(prc.getId())));
        }
    }

    @Test
    public void testFindFromNegativeRange() {
        List<PassengerRailroadCar> result = null;
        try {
            RailroadPassengerCarDAO rpc = RailroadPassengerCarDAO.getInstance();
            result = rpc.findFromRange(-100,100);
        } catch (SQLException exc) {
            System.err.println(exc.toString());
        }

        assertNull(result);
    }
}
