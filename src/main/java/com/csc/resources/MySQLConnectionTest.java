package com.csc.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import junit.framework.TestCase;

//public class MySQLConnectionTest extends TestCase {
public class MySQLConnectionTest {
		
    //public void testConnect() {
    public static void main(String[] args){	
    String dbUrl = "jdbc:mysql://localhost/sakila";
    String dbClass = "com.mysql.jdbc.Driver";
    String query = "Select actor_id from actor";
    String username = "root";
    String password = "1234";
    try {

        Class.forName(dbClass);
        Connection connection = DriverManager.getConnection(dbUrl,
            username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
        String tableName = resultSet.getString(1);
        System.out.println("Table name : " + tableName);
        }
        connection.close();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
}
