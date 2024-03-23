/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joak.myCompany.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataBaseConnection {
    
    private static Connection connection;
    private static Statement statement;
    private static final String MYSQLDRIVER = "jdbc:mysql://";
    private static String dock = "localhost:3306";
    private static String user = "root";
    private static String password = "1234";
    private static final String SCHEMA = "internal_status";
    
    

    public DataBaseConnection() {     
        dock = "localhost:3306";
        user = "root";
        password = "1234";
    }

    public DataBaseConnection(String db, String user, String password) {
        DataBaseConnection.dock = db;
        DataBaseConnection.user = user;
        DataBaseConnection.password = password;
    }
   
    public static Boolean connectionToDataBase (){
        Boolean isConnected;
        try {
            connection = DriverManager.getConnection(MYSQLDRIVER + dock, user, password);
            statement = connection.createStatement();
            statement.executeUpdate("USE " + SCHEMA);
            isConnected = true;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            isConnected = false;
        }
        return isConnected;
    }
    
    
    public static void closeConnection(ResultSet resultSet){
        
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void closeConnection(Boolean isConnected){
        
        if(isConnected == true){
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
       

    public static String getDb() {
        return dock;
    }

    public static void setDb(String db) {
        DataBaseConnection.dock = db;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        DataBaseConnection.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DataBaseConnection.password = password;
    }

    public static Statement getStatement() {
        return statement;
    }
    

    
    
    
}
