
package javaapplication3;
import java.sql.*;
/**
 *
 * @author kapil bhatt
 */
public class CheckUser {

    static int id;
    static String s;
    static ResultSet rs;
    static PreparedStatement ps;
    static Connection con;
    
    public static boolean check(String email, String password){
        try{
            con = MySql.getConnection();
            ps = con.prepareStatement("select ID from emp where EMAILID = ? AND PASSWORD = ?;");
            ps.setString(1 , email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            rs.next();
            String r = new String(rs.getString("ID"));
            int c = Integer.parseInt(r);
            id = c;
            s = email;
            if( c > 4){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}