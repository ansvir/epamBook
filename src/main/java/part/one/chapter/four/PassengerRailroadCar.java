package part.one.chapter.four;

import java.util.*;

public class PassengerRailroadCar extends RailroadCar {

    /**
     * variable describes the number of passengers
     */
    private int passengers;
    /**
     * variable describes the total weight of a luggage
     */
    private double luggage;
    /**
     * variable describes a level of amenities in scores (0.0-10.0)
     */
    private double amenities;

    public PassengerRailroadCar(int id, String model, int wheels, int passengers, double luggage, double amenities) {
        super(id, model, wheels);
        this.passengers = passengers;
        this.luggage=luggage;
        this.amenities=amenities;
    }

    PassengerRailroadCar() {}

    public int sumPassengers(List<PassengerRailroadCar> passengerTrain) {
        int sum=0;
        for(PassengerRailroadCar prc: passengerTrain) {
            sum+=prc.getPassengers();
        }
        return sum;
    }

    public double sumLuggage(List<PassengerRailroadCar> passengerTrain) {
        double sum=0.0;
        for(PassengerRailroadCar prc: passengerTrain) {
            sum+=prc.getLuggage();
        }
        return sum;
    }

    public List<PassengerRailroadCar> sortByAmenities(List<PassengerRailroadCar> passengerTrain) {
        List<PassengerRailroadCar> result=new ArrayList<>(passengerTrain);
        result.sort(new AmenitiesComparator());
        return result;
    }

    public List<PassengerRailroadCar> listCarsByPassengersRange(List<PassengerRailroadCar> passengerTrain, int from, int to) {
        List<PassengerRailroadCar> result=new ArrayList<>();
        for(PassengerRailroadCar prc: passengerTrain) {
            if (prc.getPassengers()>=from&&prc.getPassengers()<=to) {
                result.add(prc);
            }
        }

        return result;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public double getLuggage() {
        return luggage;
    }

    public void setLuggage(int luggage) {
        this.luggage = luggage;
    }

    public double getAmenities() {
        return amenities;
    }

    public void setAmenities(double amenities) {
        this.amenities = amenities;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        PassengerRailroadCar prc = (PassengerRailroadCar) obj;

        return ((this.getId() == prc.getId())
                && (this.getModel().equals(prc.getModel()))
                && (this.getWheels() == prc.getWheels())
                && (this.getPassengers() == prc.getPassengers())
                && (Double.compare(this.getLuggage(), prc.getLuggage()) == 0)
                && (Double.compare(this.getAmenities(), prc.getAmenities()) == 0));
    }
    public class AmenitiesComparator implements Comparator<PassengerRailroadCar> {
        @Override
        public int compare(PassengerRailroadCar a, PassengerRailroadCar b) {
            return Double.compare(a.getAmenities(), b.getAmenities());
        }
    }
}
