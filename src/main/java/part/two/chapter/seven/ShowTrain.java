package part.two.chapter.seven;

import part.one.chapter.four.PassengerRailroadCar;
import java.io.PrintStream;
import java.util.List;

public class ShowTrain implements Command {

    private Menu menu;
    private List<PassengerRailroadCar> train;
    private PrintStream os;

    ShowTrain(Menu menu, List<PassengerRailroadCar> train, PrintStream os) {
        this.menu = menu;
        this.train = train;
        this.os = os;
    }

    public void execute() {
        menu.showTrain(train, os);
    }
}
