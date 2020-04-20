package com.santorini;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start work");

        String url = "jdbc:teradata://host.corp.santorini.com/CHARSET=UTF8,TMODE=TERA";
        String login = "user";
        String password = "pass";
        String queryText = "SELECT 1 FROM dbc.dbase";
        int fetchRowCount = 100000;

        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement statement = connection.prepareStatement(queryText);
            statement.setFetchSize(fetchRowCount);

            if(statement.execute()) {
                ResultSet result = statement.getResultSet();

                while(result.next()) {
                    String val = result.getString(1);
                    System.out.println(val);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Finish work");
    }
}
