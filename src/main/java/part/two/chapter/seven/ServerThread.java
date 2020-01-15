package part.two.chapter.seven;

import part.one.chapter.four.PassengerRailroadCar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ServerThread extends Thread {
    private PrintStream os;
    private BufferedReader is;
    private InetAddress address;
    private List<PassengerRailroadCar> train;
    public ServerThread(Socket s) throws IOException {
        os = new PrintStream(s.getOutputStream());
        is = new BufferedReader(new InputStreamReader(s.getInputStream()));
        address = s.getInetAddress();
        train = new LinkedList<>();
        start();
    }
    public void run() {
        String menuChoice;
        try {
            do {
                os.println("Choose:  " +
                        "1 Create rail car (\\1)  " +
                        "2 Actions:  " +
                        "2.1 Sum passengers (\\21)  " +
                        "2.2 Sum luggage (\\22)  " +
                        "2.3 Sort rail cars by amenities (\\23)  " +
                        "2.4 List rail cars by passengers range (\\24)  " +
                        "3 Show train (\\3)  " +
                        "4 Disconnect (\\4)");
                menuChoice = is.readLine();
                if (menuChoice == null) {
                    break;
                }
                switch (menuChoice) {
                    case "\\1": {
                        Command command = new CreateRailCar();
                        command.execute();
                        break;
                    }
                    case "\\21": {
                        PassengerRailroadCar rpc = new PassengerRailroadCar();
                        os.println("Number of passengers on the train: " + rpc.sumPassengers(this.train));
                        break;
                    }
                    case "\\22": {
                        PassengerRailroadCar rpc = new PassengerRailroadCar();
                        os.println("Total weight of luggage: " + rpc.sumLuggage(this.train));
                        break;
                    }
                    case "\\23": {
                        List<PassengerRailroadCar> list = new PassengerRailroadCar().sortByAmenities(this.train);
                        os.println("Rail cars sorted by amenities");
                        for (PassengerRailroadCar rpc : list) {
                            os.println(rpc.toString());
                        }
                        break;
                    }
                    case "\\24": {
                    }
                    case "\\3": {

                        break;
                    }
                    case "\\4": {
                        os.println("\\4");
                        break;
                    }
                    default: {
                        os.println("Incorrect choice. Use \\21 to choose sum passengers or \\1 to create new rail car");
                        break;
                    }
                }
            } while (true);
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
            System.out.println("disconnecting user "+address.getHostName());
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
