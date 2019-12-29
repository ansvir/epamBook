package part.two.chapter.six;

import part.one.chapter.four.PassengerRailroadCar;

import java.util.List;

public abstract class RailroadPassengerCarAbstractDAO {

    public abstract int sumPassengers();

    public abstract double sumLuggage();

    public abstract List<PassengerRailroadCar> sortByAmenities();

    public abstract List<PassengerRailroadCar> findFromRange(int from, int to);

}
