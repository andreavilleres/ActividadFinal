/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConn {
    private String driver = "com.mysql.jdbc.Driver";
    private String host = "jdbc:mysql://localhost:3306/";
    
    public Connection getConnection(String database, String userDB, String passwordDB){
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(host + database, userDB, passwordDB);
        } catch(Exception error) {
            error.printStackTrace();
        }
    return conn;
    }
    
}
