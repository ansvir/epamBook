package part.two.chapter.seven;

import part.one.chapter.four.PassengerRailroadCar;

public class CreateRailCar implements Command{

    public boolean execute() {
        return true;
    }

    private PassengerRailroadCar createRailCar() {
//        int id;
//        String model;
//        int wheels;
//        int passengers;
//        double luggage;
//        double amenities;
//
//        os.println("Enter: 1. id (int)");
//        if ((id = readInt(is.readLine())) == -1) {
//            break;
//        }
//        os.println("2. model (string)");
//        model = is.readLine();
//        os.println("3. wheels (int)");
//        if ((wheels = readInt(is.readLine())) == -1) {
//            break;
//        }
//        os.println("4. passengers (int)");
//        if ((passengers = readInt(is.readLine())) == -1) {
//            break;
//        }
//        os.println("5. luggage (double)");
//        if ((luggage = readDouble(is.readLine())) == -1) {
//            break;
//        }
//        os.println("6. amenities (double)");
//        if ((amenities = readDouble(is.readLine())) == -1) {
//            break;
//        }
//        train.add(new PassengerRailroadCar(id, model, wheels, passengers, luggage, amenities));
        return new PassengerRailroadCar();
    }

}
