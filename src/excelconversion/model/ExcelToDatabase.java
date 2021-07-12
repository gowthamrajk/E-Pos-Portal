package excelconversion.model;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.sql.*;
import addtodb.AddToDbClass;
import searchdb.SearchDb;

public class ExcelToDatabase
{
	public ExcelToDatabase() throws ClassNotFoundException
	{
        try
        {
        	String jdbcURL = "jdbc:mysql://localhost:3306/demo";
			String username = "root";
			String password = "Killer@1207";
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = null;
			connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);
            String sql = "INSERT INTO customer (Ref_Number, Account_Number, Date_Time, Description, Withdrawals, Credit) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
            FileInputStream input = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\registration\\Students.xlsx");
            Workbook workbook = new XSSFWorkbook(input);
            Sheet sheet = workbook.getSheetAt(0);
            Row row;
            int Entry = 1;
            for(int i=1; i<=sheet.getLastRowNum(); i++)
            {
                row = sheet.getRow(i);
                String Ref_number=row.getCell(0).getStringCellValue();
                int Account_Number = (int) row.getCell(1).getNumericCellValue();
                java.util.Date Date_Time =  row.getCell(2).getDateCellValue();
                String Description= row.getCell(3).getStringCellValue();
                int Withdrawals = (int) row.getCell(4).getNumericCellValue();
                int credit = (int) row.getCell(5).getNumericCellValue();
                int runningBalance = credit - Withdrawals;
				if (runningBalance <= 0) {
					System.out.println("balance in negative..." + runningBalance);
					runningBalance *= -1;
				}
				System.out.println(Ref_number + "-" + Account_Number + "-" + Date_Time + "-" + Description + "-"
						+ Withdrawals + "-" + credit + "- " + runningBalance);
				if (Entry == 1) 
				{
					System.out.println("adding to DB...Entry no - " + Entry);
					AddToDbClass.addToDb(Ref_number, Account_Number, Date_Time, Description, Withdrawals, credit, runningBalance, connection);
				} 
				else 
				{
					System.out.println("adding to DB...Entry no - " + Entry);
					System.out.println("calling search function...");
					int AvailableBalance = SearchDb.SearchInDb(Account_Number, Entry, connection);
					int ActualBalance = runningBalance + AvailableBalance;
					System.out.println("actual balance after Transaction - " + ActualBalance);
					AddToDbClass.addToDb(Ref_number, Account_Number, Date_Time, Description, Withdrawals, credit, ActualBalance, connection);
				}
				Entry++;
            }
            connection.commit();
            statement.close();
            connection.close();
            input.close();
            System.out.println("Success import excel to mysql table");
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        catch(IOException ioe)
        {
            System.out.println(ioe);
        }
	}
}
