package com.example._30092023;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JDBCExample {
    public static List<List<String>> run() {

        List<List<String>> ans = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
//            Statement command = conn.createStatement();
//            command.executeUpdate(CREATE_TABLE);
//            command.close();
            /*
            stmt.executeUpdate("insert into SUPPLIERS " +
                    "values(49, 'Superior Coffee', '1 Party Place', " +
                    "'Mendocino', 'CA', '95460')");
            stmt.executeUpdate("insert into SUPPLIERS " +
                    "values(101, 'Acme, Inc.', '99 Market Street', " +
                    "'Groundsville', 'CA', '95199')");
            stmt.executeUpdate("insert into SUPPLIERS " +
                    "values(150, 'The High Ground', '100 Coffee Lane', " +
                    "'Meadows', 'CA', '93966')");
            */

            //alt + j

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from SUPPLIERS");

            while ( rs.next() ) {

                String sup_id = rs.getString("SUP_ID");

                String sup_name = rs.getString("SUP_NAME");

                String street  = rs.getString("STREET");
                String city  = rs.getString("CITY");
                String state  = rs.getString("STATE");
                String zip  = rs.getString("ZIP");

                ans.add(Arrays.asList(sup_id, sup_name, street, city, state, zip));
            }
            return ans;

            /*if (conn != null) {
                return "Connected to the database!";
            } else {
                return "Failed to make connection!";
            }*/

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }

    public final static String CREATE_TABLE =
            "create table SUPPLIERS " + "(SUP_ID integer NOT NULL, " +
                    "SUP_NAME varchar(40) NOT NULL, " + "STREET varchar(40) NOT NULL, " +
                    "CITY varchar(20) NOT NULL, " + "STATE char(2) NOT NULL, " +
                    "ZIP char(5), " + "PRIMARY KEY (SUP_ID))";
    public static String addToTable (String table, String[] values) {
        String ans = "insert into "+ table +
                "values";
        ans += "(";
        for(int i = 0; i < values.length; i++) {
            ans += (i > 0 ? ", " : "") + values[i];
        }
        ans += ")";

        return ans;
    }
    public static final String testAdd = "insert into SUPPLIERS " +
            "values(49, 'Superior Coffee', '1 Party Place', " +
            "'Mendocino', 'CA', '95460')";

    public static void addToSuppliers(int id, String name, String street, String city, String state, int zip) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO SUPPLIERS (sup_id, sup_name, street, city, state, zip) values (?, ?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, street);
            preparedStatement.setString(4, city);
            preparedStatement.setString(5, state);
            preparedStatement.setInt(6, zip);

            preparedStatement.addBatch();

            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
