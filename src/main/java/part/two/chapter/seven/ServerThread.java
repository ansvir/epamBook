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
        String input;
        boolean correctInput = true;
        try {
            do {
                os.println("Choose: ");
                os.println("1 Create rail car (\\1)");
                os.println("2 Actions:");
                os.println("2.1 Sum passengers (\\21)");
                os.println("2.2 Sum luggage (\\22)");
                os.println("2.3 Sort rail cars by amenities (\\23)");
                os.println("2.4 List rail cars by passengers range (\\24)");
                os.println("3 Show train (\\3)");
                os.println("4 Disconnect (\\4)");

                if ((menuChoice = is.readLine()) != null && is.ready()) {
                    switch (menuChoice) {
                        case "\\1": {
                            correctInput = true;
                            int id = -1;
                            String model = "";
                            int wheels = -1;
                            int passengers = -1;
                            double luggage = -1.0;
                            double amenities = -1.0;

                            os.println("Enter: ");
                            os.println("1. id (int)");
                            os.flush();
                            while ((input = is.readLine()) != null) {
                                id = readInt(input);
                                if (id == -1) {
                                    correctInput = false;
                                }
                            }
                            if (correctInput) {
                                os.println("2. model (string)");
                                os.flush();
                                while((input = is.readLine()) != null) {
                                    model = input;
                                }
                            }
                            if (correctInput) {
                                os.println("3. wheels (int)");
                                os.flush();
                                while((input = is.readLine()) != null) {
                                    wheels = readInt(input);
                                    if (wheels == -1) {
                                        correctInput = false;
                                    }
                                }
                            }
                            if (correctInput) {
                                os.println("4. passengers (int)");
                                os.flush();
                                while((input = is.readLine()) != null) {
                                    passengers = readInt(input);
                                    if (passengers == -1) {
                                        correctInput = false;
                                    }
                                }
                            }
                            if (correctInput) {
                                os.println("5. luggage (double)");
                                os.flush();
                                while((input = is.readLine()) != null) {
                                    luggage = readDouble(input);
                                    if (luggage == -1) {
                                        correctInput = false;
                                    }
                                }
                            }
                            if (correctInput) {
                                os.println("6. amenities (double)");
                                os.flush();
                                while((input = is.readLine()) != null) {
                                    amenities = readDouble(input);
                                    if (amenities == -1) {
                                        correctInput = false;
                                    }
                                }
                            }
                            if(correctInput) {
                                train.add(new PassengerRailroadCar(id, model, wheels, passengers, luggage, amenities));
                            }
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
                            os.println("Trains sorted by amenities");
                            for (PassengerRailroadCar rpc : list) {
                                os.println(rpc.toString());
                            }
                            os.flush();
                            break;
                        }
                        case "\\24": {

                        }
                        case "\\3": {

                        }
                        case "\\4": {
                            disconnect();
                        }
                        default: {
                            os.println("Incorrect choice");
                            os.println("Use \\21 to choose sum passengers or \\1 to create new rail car");
                            os.flush();
                        }
                    }
                }
            } while ((menuChoice = is.readLine()) != null);
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
