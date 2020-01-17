package part.two.chapter.seven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class ServerThread extends Thread {
    private PrintStream os;
    private BufferedReader is;
    private InetAddress address;
    private int userId;
    private TrainDAO train;
    public ServerThread(Socket s, int userId) throws IOException {
        os = new PrintStream(s.getOutputStream());
        is = new BufferedReader(new InputStreamReader(s.getInputStream()));
        address = s.getInetAddress();
        this.userId = userId;
        train = new TrainDAO();
        start();
    }
    public void run() {
        String menuChoice;
        boolean exit = false;
        try {
            while (!exit) {
                os.println("Choose:\n" +
                        "1 Create rail car (\\1)\n" +
                        "2 Actions:\n" +
                        "2.1 Sum passengers (\\21)\n" +
                        "2.2 Sum luggage (\\22)\n" +
                        "2.3 Sort rail cars by amenities (\\23)\n" +
                        "2.4 List rail cars by passengers range (\\24)\n" +
                        "3 Show train (\\3)\n" +
                        "4 Disconnect (\\4)\n");
                os.flush();
                menuChoice = is.readLine();
                if (menuChoice == null) {
                    break;
                }
                switch (menuChoice) {
                    case "\\1": {
                        Menu menu = new Menu();
                        Command createRailCar = new CreateRailCar(menu, train.getTrain(), os, is);
                        Execute execute = new Execute(createRailCar);
                        execute.executeCommand();
                        break;
                    }
                    case "\\21": {
                        Menu menu = new Menu();
                        Command sumPassengers = new SumPassengers(menu, train.getTrain(), os);
                        Execute execute = new Execute(sumPassengers);
                        execute.executeCommand();
                        break;
                    }
                    case "\\22": {
                        Menu menu = new Menu();
                        Command sumLuggage = new SumLuggage(menu, train.getTrain(), os);
                        Execute execute = new Execute(sumLuggage);
                        execute.executeCommand();
                        break;
                    }
                    case "\\23": {
                        Menu menu = new Menu();
                        Command sortRailCarsByAmenities = new SortRailCarsByAmenities(menu, train.getTrain(), os);
                        Execute execute = new Execute(sortRailCarsByAmenities);
                        execute.executeCommand();
                        break;
                    }
                    case "\\24": {
                        Menu menu = new Menu();
                        Command sortRailCarsByPassengersRange = new SortRailCarsByPassengersRange(menu, train.getTrain(), os, is);
                        Execute execute = new Execute(sortRailCarsByPassengersRange);
                        execute.executeCommand();
                        break;
                    }
                    case "\\3": {
                        Menu menu = new Menu();
                        Command showTrain = new ShowTrain(menu, train.getTrain(), os);
                        Execute execute = new Execute(showTrain);
                        execute.executeCommand();
                        break;
                    }
                    case "\\4": {
                        os.println("exit\n");
                        os.flush();
                        exit = true;
                        break;
                    }
                    default: {
                        os.append("Incorrect input.\nUse \\1 to create rail car or \\21 to sort train by passengers, for example\n");
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error occurred: "+e.getMessage());
        } finally {
            disconnect();
        }
    }
    public void disconnect() {
        try {
            if (os != null) {
                os.close();
            }
            if (is != null) {
                is.close();
            }
            System.out.println("disconnecting user \"" + userId + "\" on " + address.getHostName());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.interrupt();
        }
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
