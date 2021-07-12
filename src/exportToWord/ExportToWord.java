package exportToWord;

import java.io.*;
import java.sql.*;

import org.apache.poi.wp.usermodel.CharacterRun;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class ExportToWord 
{
	//public static void main(String[] args)throws Exception 
	public ExportToWord(String acc_no) throws Exception 
	{
		  Class.forName("com.mysql.cj.jdbc.Driver");
	       XWPFDocument document = new XWPFDocument();
	      
	       XWPFParagraph paragraph = document.createParagraph();
	       XWPFRun paragraph1 = paragraph.createRun();
	       paragraph1.setBold(true);
	       paragraph1.setItalic(true);
	       paragraph1.setText("Hello "+acc_no+", this is Your Transaction History");
	       paragraph1.setTextPosition(10);
	       paragraph1.setFontSize(20);
	       paragraph1.addBreak();
	       
	       
	      FileOutputStream out = new FileOutputStream(new File("C:\\Users\\HP\\eclipse-workspace\\registration\\TransactionHistory.docx"));
	      XWPFTable table = document.createTable();
	      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "Killer@1207");
	       Statement st=con.createStatement();
	       ResultSet rs=st.executeQuery("Select distinct * from customer where Account_Number='" + acc_no + "'");
	       	       
	       XWPFTableRow tableRow = table.getRow(0);
		   tableRow.getCell(0).setText("Ref_Number");
	       tableRow.addNewTableCell().setText("Account_Number");
 	       tableRow.addNewTableCell().setText("Date_Time");
		   tableRow.addNewTableCell().setText("Description");
	       tableRow.addNewTableCell().setText("Withdrawals");
    	   tableRow.addNewTableCell().setText("Credit");
		   tableRow.addNewTableCell().setText("runningBalance");
		      
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
	    	   
	    	   XWPFTableRow tableRowTwo = table.createRow();
	    	   tableRowTwo.getCell(0).setText(Ref_Number);
	    	   tableRowTwo.getCell(1).setText(Account_Number);
	           tableRowTwo.getCell(2).setText(Date_Time);
	           tableRowTwo.getCell(3).setText(Description);
	    	   tableRowTwo.getCell(4).setText(Withdrawals);
	           tableRowTwo.getCell(5).setText(Credit);
	           tableRowTwo.getCell(6).setText(runningBalance);
	       }
	      document.write(out);
	      out.close();
	      System.out.println("Document written successully");
	   }

}
