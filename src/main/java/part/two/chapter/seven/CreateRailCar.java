package part.two.chapter.seven;

import part.one.chapter.four.PassengerRailroadCar;

public class CreateRailCar implements Command{

    public boolean execute() {
        return true;
    }

    private PassengerRailroadCar createRailCar() {
        return new PassengerRailroadCar();
    }

}
