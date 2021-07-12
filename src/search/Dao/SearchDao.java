package search.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchDao 
{
	public static boolean validate(String result) 
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
            String SQL= "select * from customer where Account_Number='" + result + "'";
            Statement stmt=conn.createStatement();
   
            rs = stmt.executeQuery(SQL);
            if(rs.next())
                status=true;
            else
            	status=false;
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
