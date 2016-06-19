/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;
import java.sql.*;
/**
 *
 * @author kapil bhatt
 */
public class MySql {

    static Connection con;
    
    public static Connection getConnection(){
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password");
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
    
}
