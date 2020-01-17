package part.two.chapter.seven;
import part.one.chapter.four.PassengerRailroadCar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class Menu {

    public void createRailCar(List<PassengerRailroadCar> train, PrintStream os, BufferedReader is) throws IOException{
        int id;
        String model;
        int wheels;
        int passengers;
        double luggage;
        double amenities;

        os.println("Enter:\n1. id (int)\n");
        os.flush();
        if ((id = readInt(is.readLine())) == -1) {
            os.append("Incorrect input");
            return;
        }
        os.println("2. model (string)\n");
        os.flush();
        model = is.readLine();
        os.println("3. wheels (int)\n");
        os.flush();
        if ((wheels = readInt(is.readLine())) == -1) {
            os.append("Incorrect input");
            return;
        }
        os.println("4. passengers (int)\n");
        os.flush();
        if ((passengers = readInt(is.readLine())) == -1) {
            os.append("Incorrect input");
            return;
        }
        os.println("5. luggage (double)\n");
        os.flush();
        if ((luggage = readDouble(is.readLine())) == -1) {
            os.append("Incorrect input");
            return;
        }
        os.println("6. amenities (double)\n");
        os.flush();
        if ((amenities = readDouble(is.readLine())) == -1) {
            os.append("Incorrect input");
            return;
        }
        train.add(new PassengerRailroadCar(id, model, wheels, passengers, luggage, amenities));
    }

    public void sumPassengers(List<PassengerRailroadCar> train, PrintStream os) {
        os.append("Number of passengers on the train: " + new PassengerRailroadCar().sumPassengers(train) + "\n");
    }

    public void sumLuggage(List<PassengerRailroadCar> train, PrintStream os) {
        os.append("Total weight of luggage: " + new PassengerRailroadCar().sumLuggage(train) + "\n");
    }

    public void sortRailCarsByAmenities(List<PassengerRailroadCar> train, PrintStream os) {
        List<PassengerRailroadCar> list = new PassengerRailroadCar().sortByAmenities(train);
        os.append("Rail cars sorted by amenities\n");
        for (PassengerRailroadCar rpc : list) {
            os.append(rpc.toString() + "\n");
        }
    }

    public void listRailCarsByPassengersRange(List<PassengerRailroadCar> train, PrintStream os, BufferedReader is) throws IOException {
        int from;
        int to;

        os.println("Enter passengers range:\n" +
                "1. From:\n");

        if (((from = readInt(is.readLine())) == -1) || (from < 0)) {
            os.append("Incorrect input\n");
            return;
        }

        os.println("2. To:\n");
        if (((to = readInt(is.readLine())) == -1) || (to < 0)) {
            os.append("Incorrect input\n");
            return;
        }
        if (from > to) {
            os.append("Incorrect range\n");
            return;
        }
        List<PassengerRailroadCar> sortedTrain = new PassengerRailroadCar().listCarsByPassengersRange(train, from, to);
        for (PassengerRailroadCar rpc : sortedTrain) {
            os.append(rpc.toString() + "\n");
        }
    }

    public void showTrain(List<PassengerRailroadCar> train, PrintStream os) {
        StringBuilder result = new StringBuilder();
        int resultLength;
        result.append("                   ______________________\n" +
                "       _____      |     __   __   __     |\n" +
                "       |   |     |     |__| |__| |__|    |\n" +
                "       |   |____|                        |\n" +
                "     /                                   |\n" +
                "   /                                     |\n" +
                " /_______________________________________|\n");
        for (PassengerRailroadCar rpc : train) {
            resultLength = rpc.toString().length();
            for (int i = 0; i < resultLength + 4; i++) {
                result.append("-");
            }
            result.append("\n|");
            for (int i = 0; i <= resultLength + 1; i++) {
                result.append(" ");
            }
            result.append("|\n| ");
            result.append(rpc.toString()).append(" |\n|");
            for (int i = 0; i <= resultLength + 1; i++) {
                result.append(" ");
            }
            result.append("|\n");
            for (int i = 0; i < resultLength + 4; i++) {
                result.append("-");
            }
            result.append("\n");
        }
        os.append(result.toString());
    }
    private int readInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exc) {
            System.err.println("Cannot create rail car: "+exc.getMessage());
            return -1;
        }
    }

    private double readDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException exc) {
            System.err.println("Cannot create rail car: "+exc.getMessage());
            return -1;
        }
    }

}
