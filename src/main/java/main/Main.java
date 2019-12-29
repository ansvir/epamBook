package main;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/example";

        DataBaseHelper dbh=null;
        PreparedStatement preps=null;

        try {
            dbh=new DataBaseHelper(url);
            ResultSet rs=dbh.findById(5);
            User u2=null;
            while(rs.next()) {
                u2=new User(rs.getInt(1),rs.getString(2),rs.getString(3));
            }
            if(u2!=null) {
                System.out.println(u2.toString());
            }
        } catch (SQLException exc) {
            System.out.println(exc.toString());
        } finally {
            if(dbh!=null) {
                dbh.closeStatement(preps);
            }
        }

    }
}
