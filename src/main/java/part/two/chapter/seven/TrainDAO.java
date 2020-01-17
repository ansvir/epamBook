package part.two.chapter.seven;

import part.one.chapter.four.PassengerRailroadCar;

import java.util.LinkedList;
import java.util.List;

public class TrainDAO {
    private List<PassengerRailroadCar> train;

    TrainDAO(List<PassengerRailroadCar> train) {
        this.train = train;
    }

    TrainDAO() {
        train = new LinkedList<>();
        train.add(new PassengerRailroadCar(1,"aaaa",4,150,5.5,8.8));
        train.add(new PassengerRailroadCar(2, "bbbb", 4, 200, 8.8, 7.0));
        train.add(new PassengerRailroadCar(4, "bbbb", 4, 50, 4.8, 8.0));
        train.add(new PassengerRailroadCar(5, "aaaa", 4, 170, 5.8, 7.5));
    }

    public void addRailCar(PassengerRailroadCar railCar) {
        train.add(railCar);
    }

    public PassengerRailroadCar removeRailCar(int index) {
        if (!train.isEmpty()) {
            return train.remove(index);
        }
        return null;
    }

    public List<PassengerRailroadCar> getTrain() {
        return train;
    }

    public void setTrain(List<PassengerRailroadCar> train) {
        this.train = train;
    }
}
