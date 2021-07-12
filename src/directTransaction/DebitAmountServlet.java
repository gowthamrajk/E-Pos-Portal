package directTransaction;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/debitAmountServlet")
public class DebitAmountServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	   
    public DebitAmountServlet() 
    {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		String acc_no=request.getParameter("acc_no");
		String debit_amt=request.getParameter("debit_amount");
		int runningBalance=0,credit=0;
		Date date = new Date();  
		Timestamp Date_Time = new Timestamp(date.getTime());
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "Killer@1207");
		if(SearchAccount.validateAccount(acc_no))
		{
		if(SearchAccount.validateAccount(acc_no))
		{
			int availableBalance=CreditToDatabase.SearchInDb(acc_no,connection);
			runningBalance=availableBalance-Integer.valueOf(debit_amt);
		}
		else
		{
			runningBalance = 0;
		}
			String sql = "INSERT INTO transaction (Account_Number, Date_Time, Credit, Debit, runningBalance) VALUES (?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			System.out.println("Connecting to DB...");
			statement.setInt(1, Integer.valueOf(acc_no));
			statement.setTimestamp(2, new Timestamp(Date_Time.getTime()));
			statement.setInt(3, credit);
			statement.setInt(4, Integer.valueOf(debit_amt));
			statement.setInt(5, runningBalance);
			statement.execute();
			System.out.println("UPDATED...\n\n==================================\n\n");
			request.setAttribute("attributeName",acc_no);
	    	RequestDispatcher requestdispatcher = request.getRequestDispatcher("debitAmountResult.jsp");
	    	requestdispatcher.forward(request,response);
		}
		else
		{
			request.setAttribute("attributeName",acc_no);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("debitAmountErrorResult.jsp");
			requestdispatcher.forward(request,response);
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
