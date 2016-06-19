/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author kapil bhatt
 */
public class Record {
    
    public void recadd(int type,String add){
        Connection conn = MySql.getConnection();
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      //Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      //System.out.println("Connecting to a selected database...");
      //conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Inserting records into the table...");
      stmt = conn.createStatement();
      System.out.println("Inserting records into the table...");
      if(type == 1){
      String sql = "INSERT INTO record( ID , CIPHERENC)" +
                   "VALUES ( '"+ CheckUser.id + "','"+ add + "');";
      stmt.executeUpdate(sql);
      }
      if(type == 2){
      String sql = "INSERT INTO record( ID , CIPHERDEC)" +
                   "VALUES ('" + CheckUser.id + "','"+ add + "');";
      stmt.executeUpdate(sql);
      }
      if(type == 3){
      String sql = "INSERT INTO record( ID , FILEENC)" +
                   "VALUES ('" + CheckUser.id + "','"+ add + "');";
      stmt.executeUpdate(sql);
      }
      if(type == 4){
      String sql = "INSERT INTO record( ID , FILEDEC)" +
                   "VALUES ('" + CheckUser.id + "','"+ add + "');";
      stmt.executeUpdate(sql);
      }
      if(type == 5){
      String sql = "INSERT INTO record( ID , RSAPRIMES, RSAe)" +
                   "VALUES ('" + CheckUser.id + "','" + add + "');";
      stmt.executeUpdate(sql);
      }
       System.out.println("done");
      /*stmt.executeUpdate(sql);
      sql = "INSERT INTO Registration " +
                   "VALUES (101, 'Mahnaz', 'Fatma', 25)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Registration " +
                   "VALUES (102, 'Zaid', 'Khan', 30)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Registration " +
                   "VALUES(103, 'Sumit', 'Mittal', 28)";
      stmt.executeUpdate(sql);
              */
    }catch(Exception e){
        e.printStackTrace();
    }
    
}
}
