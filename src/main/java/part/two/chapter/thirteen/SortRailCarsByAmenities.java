package part.two.chapter.thirteen;

import part.one.chapter.four.PassengerRailroadCar;

import java.io.PrintStream;
import java.util.List;

public class SortRailCarsByAmenities implements Command {

    private Menu menu;
    private List<PassengerRailroadCar> train;
    private PrintStream os;

    SortRailCarsByAmenities(Menu menu, List<PassengerRailroadCar> train, PrintStream os) {
        this.menu = menu;
        this.train = train;
        this.os = os;
    }

    public void execute() {
        menu.sortRailCarsByAmenities(train, os);
    }
}
