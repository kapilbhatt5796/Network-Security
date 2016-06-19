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
public class EmpDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public void insert(EmpDto emp){
        try{
            con = MySql.getConnection();
            ps = con.prepareStatement("insert into emp(name , emailid , password)"
                    + "values(?,?,?)");
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmailid());
            ps.setString(3, emp.getPassword());
            System.out.println(" Data inserted ....." + ps.executeUpdate());
        }catch(Exception e){
            System.out.println("Exception caught");
        }
    }
}