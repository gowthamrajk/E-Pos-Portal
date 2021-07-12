package exportToPDf;

import java.io.*;
import java.sql.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ExportToPDf
{
    //public static void main(String arg[])throws Exception
	public ExportToPDf(String acc_no) throws Exception
    {
	   Class.forName("com.mysql.cj.jdbc.Driver");
       Document document=new Document();
       PdfWriter.getInstance(document,new FileOutputStream("C:\\Users\\HP\\eclipse-workspace\\registration\\TransactionHistory.pdf"));
       document.open();
       //String acc_no="74300256";
       document.add(new Paragraph("Hello "+acc_no+", this is your Transaction History"));
	   document.add(new Paragraph(" "));
       PdfPTable table=new PdfPTable(7);
       table.addCell("Ref_Number");
       table.addCell("Account_Number");
       table.addCell("Ref_Number");
       table.addCell("Address");
       table.addCell("Ref_Number");
       table.addCell("Address");
       table.addCell("Ref_Number");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "Killer@1207");
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery("Select distinct * from customer where Account_Number='" + acc_no + "'");
       while(rs.next())
       {
    	   String Ref_Number=rs.getString("Ref_Number");
    	   String Account_Number=Integer.toString(rs.getInt("Account_Number"));
    	   Timestamp Time=rs.getTimestamp("Date_Time");
    	   String Date_Time=Time.toString();
    	   String Description=rs.getString("Description");
    	   String Withdrawals=Integer.toString(rs.getInt("Withdrawals"));
    	   String Credit=Integer.toString(rs.getInt("Credit"));
    	   String runningBalance=Integer.toString(rs.getInt("runningBalance"));
           table.addCell(Ref_Number);
           table.addCell(Account_Number);
           table.addCell(Date_Time);
           table.addCell(Description);
           table.addCell(Withdrawals);
           table.addCell(Credit);
           table.addCell(runningBalance);
       }
       System.out.println("PDf created succesfully");
       document.add(table);
       document.close();
   }
}