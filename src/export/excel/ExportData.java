package export.excel;

import java.io.File;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import it.firegloves.mempoi.builder.MempoiBuilder;
import it.firegloves.mempoi.domain.MempoiSheet;

public class ExportData 
{
	public ExportData(String acc_no)
	//public static void main(String[] args)
	{
        try 
        {
           Class.forName("com.mysql.cj.jdbc.Driver");
           String jdbcURL = "jdbc:mysql://localhost:3306/demo";
           String username = "root";
           String password = "Killer@1207";
           Connection connection = DriverManager.getConnection(jdbcURL, username, password);
           PreparedStatement prepStmt = connection.prepareStatement("SELECT DISTINCT * FROM customer where Account_Number= '" + acc_no + "'");

           File fileDest = new File("C:\\Users\\HP\\eclipse-workspace\\registration\\Output.xlsx");

           new MempoiBuilder()
                .setFile(fileDest)
                .addMempoiSheet(new MempoiSheet(prepStmt))
                .build()
                .prepareMempoiReportToFile()
                .get();
           System.out.println("File exported successfully");
         } 
        catch (Exception e) 
        {
        	System.out.print(e);
         }
    }

}
