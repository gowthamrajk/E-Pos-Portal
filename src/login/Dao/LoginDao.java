package login.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao 
{
    public static boolean validate(String accno, String pass) 
    {        
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "demo";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "Killer@1207";
        try
        {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            pst = conn.prepareStatement("select * from users2 where accountnumber=? and password=?");
            pst.setString(1, accno);
            pst.setString(2, pass);

            rs = pst.executeQuery();
            status = rs.next();

        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
        finally 
        {
            if (conn != null) 
            {
                try 
                {
                    conn.close();
                } 
                catch (SQLException e) 
                {
                    e.printStackTrace();
                }
            }
            if (pst != null) 
            {
                try
                {
                    pst.close();
                } 
                catch (SQLException e) 
                {
                    e.printStackTrace();
                }
            }
            if (rs != null) 
            {
                try
                {
                    rs.close();
                } 
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return status;
    }
}