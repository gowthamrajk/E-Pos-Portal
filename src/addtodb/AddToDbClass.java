package addtodb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;

public class AddToDbClass 
{
	public static void addToDb(String Ref_number, int Account_Number, Date date_Time, String Description,
			int Withdrawals, int credit, int runningBalance, Connection connection)
	{
		try 
		{
			String sql = "INSERT INTO customer (Ref_Number, Account_Number, Date_Time, Description, Withdrawals, Credit, runningBalance) VALUES (?,?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			System.out.println("Connecting to DB...");
			System.out.println(Ref_number + " - " + Account_Number + " - " + date_Time + "-" + Description + "-"
					+ Withdrawals + "-" + credit + "-" + runningBalance);
			statement.setString(1, Ref_number);
			statement.setInt(2, Account_Number);
			statement.setTimestamp(3, new Timestamp(date_Time.getTime()));
			statement.setString(4, Description);
			statement.setInt(5, Withdrawals);
			statement.setInt(6, credit);
			statement.setInt(7, runningBalance);
			statement.execute();
			System.out.println("UPDATED...\n\n==================================\n\n");
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}		
	}

}
