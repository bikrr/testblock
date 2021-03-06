package main.webapp;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


@Controller
public class JDBCPostgreSQL {

    //  Database credentials

    //   static final String DB_URL = "jdbc:postgresql://192.168.19.129:5432/testblock";
    //  static final String DB_URL = "jdbc:postgresql://192.168.188.130:5432/testblock";


    @RequestMapping(value = "/commandJDBCconnect", method = RequestMethod.POST)
    @ResponseBody
    public static String JDBConnect(String[] argv) throws IOException {

        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return "PostgreSQL JDBC Driver is not found. Include it in your library path ";
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection(WebConfig.DB_URL, WebConfig.DB_USER, WebConfig.DB_PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return "Connection Failed";
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
            return "You successfully connected to database now";
        } else {
            System.out.println("Failed to make connection to database");
        }
        return "Failed to make connection to database";
    }
}