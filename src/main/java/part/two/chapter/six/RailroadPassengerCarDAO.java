package part.two.chapter.six;

import part.one.chapter.four.PassengerRailroadCar;
import sun.java2d.pipe.SpanShapeRenderer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RailroadPassengerCarDAO extends RailroadPassengerCarAbstractDAO {


    public static final String SUM_PASSENGERS = "SELECT SUM(passengers) FROM passenger_car";
    public static final String SUM_LUGGAGE = "SELECT SUM(luggage) FROM passenger_car";
    public static final String SORT_BY_AMENITIES = "SELECT * FROM passenger_car ORDER BY amenities";
    public static final String FIND_FROM_RANGE = "SELECT * FROM passenger_car WHERE passengers >= ? AND passengers <= ?";
    private static RailroadPassengerCarDAO instance = null;

    /**
     * @return sum of number of passengers. If set is empty returns -1
     */
    public int sumPassengers() {
        int result = -1;
       try (Connection connection = getConnection(); Statement s = connection.createStatement(); ResultSet rs = s.executeQuery(SUM_PASSENGERS);) {
            rs.next();
            result = rs.getInt(1);
            closeConnection(connection);
        } catch (SQLException exc) {
            System.err.println(exc.toString());
        }
        return result;
    }

    /**
     * @return total weight of luggage. If set is empty returns -1
     */
    public double sumLuggage() {
        double result = -1.0;
        try (Connection connection = getConnection(); Statement s = connection.createStatement(); ResultSet rs = s.executeQuery(SUM_LUGGAGE);){
            rs.next();
            result = rs.getDouble(1);
            closeConnection(connection);
        } catch (SQLException exc) {
            System.err.println(exc.toString());
        }
        return result;
    }

    public List<PassengerRailroadCar> sortByAmenities() {
        List<PassengerRailroadCar> result = null;
        try (Connection connection = getConnection(); Statement s = connection.createStatement(); ResultSet rs = s.executeQuery(SORT_BY_AMENITIES);){
            result = new ArrayList<>();
            while(rs.next()) {
                result.add(new PassengerRailroadCar(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getDouble(5),
                        rs.getDouble(6)
                        )
                );
            }

            closeConnection(connection);
        } catch (SQLException exc) {
            System.err.println(exc.toString());
        }

        return result;
    }

    public List<PassengerRailroadCar> findFromRange(int from, int to) {
        if (from < 0 || to < 0 ) {
            return null;
        }
        List<PassengerRailroadCar> result = null;
        try (Connection connection = getConnection(); PreparedStatement prep = connection.prepareStatement(FIND_FROM_RANGE)) {
            prep.setInt(1,from);
            prep.setInt(2,to);
            try (ResultSet rs = prep.executeQuery()) {
                result = new ArrayList<>();
                while (rs.next()) {
                    result.add(new PassengerRailroadCar(
                                    rs.getInt(1),
                                    rs.getString(2),
                                    rs.getInt(3),
                                    rs.getInt(4),
                                    rs.getDouble(5),
                                    rs.getDouble(6)
                            )
                    );
                }

                closeConnection(connection);
            }
        } catch (SQLException exc) {
            System.err.println(exc.toString());
        }

        return result;
    }

    public static synchronized RailroadPassengerCarDAO getInstance() throws SQLException {
        if (instance == null) {
            instance = new RailroadPassengerCarDAO();
        }
        return instance;
    }

    private Connection getConnection() {
        final String URL = "jdbc:mysql://localhost:3306/railway_car";
        try {
            return DriverManager.getConnection(URL, "root", "root");
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage()
                    + "SQLState: " + e.getSQLState());
        }
        return null;
    }

    private boolean closeConnection(Connection connection) {
        boolean connectionClosed = false;
        try {
            connection.close();
            connectionClosed = true;
        } catch (SQLException exc) {
            System.err.println("SQLException: "+exc.toString());
        }

        return connectionClosed;
    }
}
