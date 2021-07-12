package export.excel;

import java.io.*;
import java.sql.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class DatabaseToExcel 
{
	public static void main(String[] args)
	//public void convertExcel(String acc_no) throws ClassNotFoundException
	//public DatabaseToExcel(String acc_no) throws ClassNotFoundException
	{
		//Class.forName("com.mysql.jdbc.Driver");
        String jdbcURL = "jdbc:mysql://localhost:3306/demo";
        String username = "root";
        String password = "Killer@1207";
        String excelFilePath = "Output.xlsx";
        String acc_no="74300259";
        
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) 
        {
            String sql = "SELECT DISTINCT * FROM customer where Account_Number= '" + acc_no + "'";
 
            Statement statement = connection.createStatement();
 
            ResultSet result = statement.executeQuery(sql);
 
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Output");
 
            writeHeaderLine(sheet);

            writeDataLines(result, workbook, sheet);
 
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            System.out.println("File Export successfull...");
            workbook.write(outputStream);
            workbook.close();
            statement.close();
        } 
        catch (SQLException e) 
        {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            System.out.println("File IO error:");
            e.printStackTrace();
        }
    }
	private static void writeHeaderLine(XSSFSheet sheet)
	{		 
        Row headerRow = sheet.createRow(0);
        
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Ref_Number");
 
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Account_Number");
 
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Date_Time");
        
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("Description");
        
        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("Withdrawals");
        
        headerCell = headerRow.createCell(5);
        headerCell.setCellValue("Credit");
        
        headerCell = headerRow.createCell(6);
        headerCell.setCellValue("runningBalance");

    }
 
    private static void writeDataLines(ResultSet result, XSSFWorkbook workbook,XSSFSheet sheet) throws SQLException 
    {
        int rowCount = 1;
        while (result.next())
        {
            String Ref_Number = result.getString("Ref_Number");
            int Account_Number = result.getInt("Account_Number");
            Timestamp Date_time = result.getTimestamp("Date_Time");
            String Description = result.getString("Description");
            int withdraw = result.getInt("Withdrawals");
            int credit = result.getInt("Credit");
            int runningBalanace=result.getInt("runningBalance");
 
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(Ref_Number);
 
            cell = row.createCell(columnCount++);
            cell.setCellValue(Account_Number);
            
            cell = row.createCell(columnCount++);
            CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper creationHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
            cell.setCellStyle(cellStyle);
            cell.setCellValue(Date_time);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(Description);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(withdraw);
 
            cell = row.createCell(columnCount++);
            cell.setCellValue(credit);
            
            cell = row.createCell(columnCount);
            cell.setCellValue(runningBalanace);
        }
    }
}
