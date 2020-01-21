package part.two.chapter.twelve;

import org.junit.Test;
import part.one.chapter.four.PassengerRailroadCar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TestChapterTwelve {
    @Test
    public void testSumPassengers() {

        int expectedResult = 415;
        int result;
        RailroadPassengerCarDAO rpc = RailroadPassengerCarDAO.getInstance();
        result = rpc.sumPassengers();

        assertEquals(expectedResult, result);
    }

    @Test
    public void testSumLuggage() {

        double expectedResult = 1037.5;
        double result;
        RailroadPassengerCarDAO rpc = RailroadPassengerCarDAO.getInstance();
        result = rpc.sumLuggage();

        if (Double.compare(expectedResult, result) != 0) {
            fail();
        }
    }

    @Test
    public void testSortByAmenities() {

        List<PassengerRailroadCar> result;
        RailroadPassengerCarDAO rpc = RailroadPassengerCarDAO.getInstance();
        result = rpc.sortByAmenities();
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
        List<PassengerRailroadCar> result;
        RailroadPassengerCarDAO rpc = RailroadPassengerCarDAO.getInstance();
        result = rpc.findFromRange(70,100);
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
        List<PassengerRailroadCar> result;
        RailroadPassengerCarDAO rpc = RailroadPassengerCarDAO.getInstance();
        result = rpc.findFromRange(-100,100);

        assertNull(result);
    }
}
