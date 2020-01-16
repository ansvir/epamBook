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
        train.add(new PassengerRailroadCar(1,"aaaa",4,150,5.5,8.8));
        train.add(new PassengerRailroadCar(2, "bbbb", 4, 200, 8.8, 7.0));
        train.add(new PassengerRailroadCar(4, "bbbb", 4, 50, 4.8, 8.0));
        train.add(new PassengerRailroadCar(5, "aaaa", 4, 170, 5.8, 7.5));
        start();
    }
    public void run() {
        String menuChoice;
        try {
            while (true) {
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
//                        Command command = new CreateRailCar();
//                        command.execute();
                        int id;
                        String model;
                        int wheels;
                        int passengers;
                        double luggage;
                        double amenities;

                        os.println("Enter:\n1. id (int)\n");
                        os.flush();
                        if ((id = readInt(is.readLine())) == -1) {
                            break;
                        }
                        os.println("2. model (string)\n");
                        os.flush();
                        model = is.readLine();
                        os.println("3. wheels (int)\n");
                        os.flush();
                        if ((wheels = readInt(is.readLine())) == -1) {
                            break;
                        }
                        os.println("4. passengers (int)\n");
                        os.flush();
                        if ((passengers = readInt(is.readLine())) == -1) {
                            break;
                        }
                        os.println("5. luggage (double)\n");
                        os.flush();
                        if ((luggage = readDouble(is.readLine())) == -1) {
                            break;
                        }
                        os.println("6. amenities (double)\n");
                        os.flush();
                        if ((amenities = readDouble(is.readLine())) == -1) {
                            break;
                        }
                        train.add(new PassengerRailroadCar(id, model, wheels, passengers, luggage, amenities));
                        break;
                    }
                    case "\\21": {
                        PassengerRailroadCar rpc = new PassengerRailroadCar();
                        os.append("Number of passengers on the train: " + rpc.sumPassengers(this.train) + "\n");
                        os.flush();
                        break;
                    }
                    case "\\22": {
                        PassengerRailroadCar rpc = new PassengerRailroadCar();
                        os.append("Total weight of luggage: " + rpc.sumLuggage(this.train) + "\n");
                        os.flush();
                        break;
                    }
                    case "\\23": {
                        List<PassengerRailroadCar> list = new PassengerRailroadCar().sortByAmenities(this.train);
                        os.append("Rail cars sorted by amenities\n");
                        os.flush();
                        for (PassengerRailroadCar rpc : list) {
                            os.println(rpc.toString());
                            os.flush();
                        }
                        break;
                    }
                    case "\\24": {
                        int rangeFrom;
                        int rangeTo;
                        os.println("Enter passengers range:\n" +
                                "1. From:\n");

                        if ((rangeFrom = readInt(is.readLine())) == -1) {
                            os.append("Incorrect input\n");
                            break;
                        }

                        os.println("2. To:\n");
                        if ((rangeTo = readInt(is.readLine())) == -1) {
                            os.append("Incorrect input\n");
                            break;
                        }
                        if (rangeFrom > rangeTo) {
                            os.append("Incorrect range\n");
                            break;
                        }
                        List<PassengerRailroadCar> sortedTrain = new PassengerRailroadCar().listCarsByPassengersRange(this.train, rangeFrom, rangeTo);
                        for (PassengerRailroadCar rpc : sortedTrain) {
                            os.append(rpc.toString() + "\n");
                        }
                        break;
                    }
                    case "\\3": {
                        for (PassengerRailroadCar rpc : this.train) {
                            os.append(rpc.toString() + "\n");
                        }
                        break;
                    }
                    case "\\4": {
                        os.println("exit\n");
                        os.flush();
                        disconnect();
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
