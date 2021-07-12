package searchdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchDb
{
	public static int SearchInDb(int AccNum, int entry, Connection connection)
	{
		int balance = 0;
		try 
		{
			System.out.println("Inside search DB");
			String accSearchSql = "select * from Customer";
			PreparedStatement statement = connection.prepareStatement(accSearchSql);
			ResultSet rs = statement.executeQuery(accSearchSql);
			while (rs.next())
			{
				int accountNum = rs.getInt(2);
				if (accountNum == AccNum)
				{
					System.out.println("account number - " + accountNum);
					balance = rs.getInt(7);
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
