package excelconversion.model;

import java.io.*;
import java.sql.*;
import java.util.*;
 
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;


public class Demo
{ 
    public static void main(String[] args) 
    {
        String jdbcURL = "jdbc:mysql://localhost:3306/demo";
        String username = "root";
        String password = "Killer@1207";
 
        String excelFilePath = "Students.xlsx";
 
        int batchSize = 20;
 
        Connection connection = null;
 
        try {
            long start = System.currentTimeMillis();
             
            FileInputStream inputStream = new FileInputStream(excelFilePath);
 
            Workbook workbook = new XSSFWorkbook(inputStream);
 
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = firstSheet.iterator();
 
            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);
  
            String sql = "INSERT INTO students (Ref_Number, Account_Number, Date_Time, Description, Withdrawals, Credit) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);    
             
            int count = 0;
             
            rowIterator.next(); // skip the header row
             
            while (rowIterator.hasNext()) 
            {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
 
                while (cellIterator.hasNext()) 
                {
                    Cell nextCell = cellIterator.next();
 
                    int columnIndex = nextCell.getColumnIndex();
 
                    switch (columnIndex) 
                    {
                    case 0:
                        String Ref_number = nextCell.getStringCellValue();
                        statement.setString(1, Ref_number);
                        break;
                    case 1:
                        int Account_number = (int) nextCell.getNumericCellValue();
                        statement.setInt(2, Account_number);
                    case 2:
                        java.util.Date Date_time = nextCell.getDateCellValue();
                        statement.setTimestamp(3, new Timestamp(Date_time.getTime()));
                    case 3:
                        String description = nextCell.getStringCellValue();
                        statement.setString(4, description);
                    case 4:
                        int withdraw = (int) nextCell.getNumericCellValue();
                        statement.setInt(5, withdraw);
                    case 5:
                        int credit = (int) nextCell.getNumericCellValue();
                        statement.setInt(6, credit);
                    }
                }
                statement.addBatch(); 
                if (count % batchSize == 0) {
                    statement.executeBatch();
                }              
 
            }
 
            workbook.close();
             
            // execute the remaining queries
            statement.executeBatch();
  
            connection.commit();
            connection.close();
             
            long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));
             
        } catch (IOException ex1) {
            System.out.println("Error reading file");
            ex1.printStackTrace();
        } catch (SQLException ex2) {
            System.out.println("Database error");
            ex2.printStackTrace();
        }
 
    }
}