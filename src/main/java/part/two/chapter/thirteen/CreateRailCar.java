package part.two.chapter.thirteen;

import part.one.chapter.four.PassengerRailroadCar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class CreateRailCar implements Command {

    private Menu menu;
    private List<PassengerRailroadCar> train;
    private PrintStream os;
    private BufferedReader is;

    public CreateRailCar(Menu menu, List<PassengerRailroadCar> train, PrintStream os, BufferedReader is) {
        this.menu = menu;
        this.train = train;
        this.os = os;
        this.is = is;
    }

    public void execute() throws IOException {
        menu.createRailCar(train, os, is);
    }

}
