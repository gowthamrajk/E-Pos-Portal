package excelconversion.model;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.sql.*;

public class Demo1
{
	public static void main(String[] args) {
        try
        {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/demo","root","Killer@1207");
            con.setAutoCommit(false);
            String sql = "INSERT INTO customer (Ref_Number, Account_Number, Date_Time, Description, Withdrawals, Credit) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = con.prepareStatement(sql);
            FileInputStream input = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\registration\\Students.xlsx");
            Workbook workbook = new XSSFWorkbook(input);
            Sheet sheet = workbook.getSheetAt(0);
            Row row;
            for(int i=1; i<=sheet.getLastRowNum(); i++)
            {
                row = sheet.getRow(i);
                String ref_num=row.getCell(0).getStringCellValue();
                int acc_no = (int) row.getCell(1).getNumericCellValue();
                java.util.Date Date_time =  row.getCell(2).getDateCellValue();
                String description= row.getCell(3).getStringCellValue();
                int withdraw = (int) row.getCell(4).getNumericCellValue();
                int credit = (int) row.getCell(5).getNumericCellValue();
                statement.setString(1, ref_num);
				statement.setInt(2, acc_no);
				statement.setTimestamp(3, new Timestamp(Date_time.getTime()));
				statement.setString(4, description);
				statement.setInt(5, withdraw);
				statement.setInt(6, credit);
				statement.execute();
                System.out.println("Import rows "+i);
            }
            con.commit();
            statement.close();
            con.close();
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
