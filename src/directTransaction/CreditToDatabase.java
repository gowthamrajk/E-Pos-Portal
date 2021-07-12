package directTransaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CreditToDatabase
{
	public static int SearchInDb(String acc_no, Connection connection) 
	{
		int balance = 0;
		try 
		{
			System.out.println("Inside search DB");
			String accSearchSql = "select * from transaction";
			PreparedStatement statement = connection.prepareStatement(accSearchSql);
			ResultSet rs = statement.executeQuery(accSearchSql);
			while (rs.next())
			{
				int accountNum = rs.getInt(1);
				if (accountNum == Integer.valueOf(acc_no))
				{
					System.out.println("account number - " + accountNum);
					balance = rs.getInt(5);
					System.out.println("balance caught -> " + balance);
				}
			}
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		System.out.println("Returning balance to main...");
		return balance;
		
	}

}
