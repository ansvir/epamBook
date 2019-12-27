package main;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/example";
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            cn = DriverManager.getConnection(url,"root","root");
            try {
                st = cn.createStatement();
                try {
                    rs = st.executeQuery("SELECT * FROM user");
                    ArrayList<User> users = new ArrayList<>();
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String name = rs.getString(2);
                        String password = rs.getString(3);
                        users.add(new User(id, name, password));
                    }
                    if (users.size() > 0) {
                        for (User u: users) {
                            System.out.println(u.toString());
                        }
                    } else {
                        System.out.println("Not found");
                    }
                } finally {
                    if (rs != null) {
                        rs.close();
                    } else {
                        System.err.println(
                                "ошибка во время чтения из БД");
                    }
                }
            } finally {
                if (st != null) {
                    st.close();
                } else {
                    System.err.println("Statement не создан");
                }
            }
        } catch (SQLException exc) {
            System.err.println("SQLException occurred: "+exc.toString());
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Сonnection close error: " + e);
                }
            }
        }
    }
}
