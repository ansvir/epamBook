package part.two.chapter.six;

import part.one.chapter.four.PassengerRailroadCar;

import java.sql.*;
import java.util.List;

public class RailroadPassengerCarDAO extends RailroadPassengerCarAbstractDAO {


    public static final String SUM_PASSENGERS = "SELECT SUM(passengers) FROM passenger_car";
    public static final String SUM_LUGGAGE = "SELECT SUM(luggage) FROM passenger_car";
    public static final String SORT_BY_AMENITIES = "SELECT * FROM passenger_car ORDER BY amenities";
    public static final String FIND_FROM_RANGE = "SELECT * FROM passenger_car WHERE passengers >= ? AND passengers <= ?";
    private static RailroadPassengerCarDAO instance = null;
    private Connection connection = null;

    /**
     * @return sum of number of passengers. If set is empty returns -1
     */
    public int sumPassengers() {
        if (connection == null) throw new IllegalArgumentException("Connection wasn't established");
        ResultSet rs = null;
        Statement s = null;
        int result = -1;
        try {
            s = connection.createStatement();
            rs = s.executeQuery(SUM_PASSENGERS);
            rs.next();
            result = rs.getInt(1);
        } catch (SQLException exc) {
            System.err.println(exc.toString());
        }
        return result;
    }

    /**
     * @return total weight of luggage. If set is empty returns -1
     */
    public double sumLuggage() {
        if (connection == null) throw new IllegalArgumentException("Connection wasn't established");
        ResultSet rs = null;
        Statement s = null;
        double result = -1.0;
        try {
            s = connection.createStatement();
            rs = s.executeQuery(SUM_LUGGAGE);
            rs.next();
            result = rs.getDouble(1);
        } catch (SQLException exc) {
            System.err.println(exc.toString());
        }
        return result;
    }

    public List<PassengerRailroadCar> sortByAmenities() {
        return null;
    }

    public List<PassengerRailroadCar> findFromRange(int from, int to) {
        return null;
    }

    public static synchronized RailroadPassengerCarDAO getInstance() throws SQLException {
        if (instance == null) {
            instance = new RailroadPassengerCarDAO();
            if (!instance.setConnection()) {
                System.err.println("Connection wasn't established");
            };
        }
        return instance;
    }

    private boolean setConnection() {
        boolean connectionEstablished = false;
        final String URL = "jdbc:mysql://localhost:3306/railway_car";
        try {
            connection = DriverManager.getConnection(URL, "root", "root");
            connectionEstablished = true;
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage()
                    + "SQLState: " + e.getSQLState());
        }

        return connectionEstablished;
    }
}
