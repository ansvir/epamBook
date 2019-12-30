package part.one.chapter.four;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestChapterFour {

    private List<PassengerRailroadCar> passengerTrain = new ArrayList<>();
    {
        passengerTrain.add(new PassengerRailroadCar(1,"Model-1",8,80,200.0, 8.0));
        passengerTrain.add(new PassengerRailroadCar(2,"Model-1",8,75,187.5,8.5));
        passengerTrain.add(new PassengerRailroadCar(3,"Model-2",8,100,250.0,7.8));
        passengerTrain.add(new PassengerRailroadCar(4,"Model-1",8,110,275.0,7.7));
        passengerTrain.add(new PassengerRailroadCar(5,"Model-2",8,50,125.0,8.1));
    }

    @Test
    public void testSumPassengers() {
        int expectedResult=415;
        int result;

        result=new PassengerRailroadCar().sumPassengers(passengerTrain);

        assertEquals(result, expectedResult);
    }

    @Test
    public void testSumLuggage() {
        double expectedResult=1037.5;
        double result;

        result=new PassengerRailroadCar().sumLuggage(passengerTrain);

        if (Double.compare(result,expectedResult)!=0) {
            fail();
        }
    }

    @Test
    public void testSortByAmenities() {
        List<PassengerRailroadCar> result = new PassengerRailroadCar().sortByAmenities(passengerTrain);

        List<Integer> idsOrder = new ArrayList<>();
        idsOrder.add(4);
        idsOrder.add(3);
        idsOrder.add(1);
        idsOrder.add(5);
        idsOrder.add(2);

        assertEquals(result.size(), idsOrder.size());

        for (int i=0;i<result.size();i++) {
            assertEquals(idsOrder.get(i), (Integer) result.get(i).getId());
        }
    }

    @Test
    public void testCarsByPassengersRange70To100() {
        List<PassengerRailroadCar> result = new PassengerRailroadCar()
                .listCarsByPassengersRange(passengerTrain,70,100);
        Map<Integer, Integer> expectedResult = new HashMap<>();

        expectedResult.put(1,80);
        expectedResult.put(2,75);
        expectedResult.put(3,100);

        if (result.size()!=expectedResult.size()) {
            fail();
        }

        for (PassengerRailroadCar prc: result) {
            if ((!expectedResult.containsKey(prc.getId()))
                    || (prc.getPassengers() != expectedResult.get(prc.getId()))) {
                fail();
            }
        }
    }
}
