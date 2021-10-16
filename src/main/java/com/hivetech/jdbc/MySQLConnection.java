package com.hivetech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/nation";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "19022001";


    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

//    public static void main(String[] args) {
//        MySQLConnection conn = new MySQLConnection();
//        if(conn.getConnection() != null){
//            System.out.println("viuegscuw");
//        }
//    }

}
