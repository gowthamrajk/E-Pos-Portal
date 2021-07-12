package directTransaction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*; 
import java.util.Date;

@WebServlet("/addNewAccount")
public class AddNewAccount extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public AddNewAccount() 
    {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String acc_no=request.getParameter("acc_no");
		String init_amt=request.getParameter("Init_amt");
		if(SearchAccount.validateAccount(acc_no))
		{
			request.setAttribute("attributeName",acc_no);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("addAccountErrorResult.jsp");
			requestdispatcher.forward(request,response);
		}
		else
		{
		int Credit=0,Debit=0;
		Date date = new Date();  
		Timestamp Date_Time = new Timestamp(date.getTime());
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "Killer@1207");
		String sql = "INSERT INTO transaction (Account_Number, Date_Time, Credit, Debit, runningBalance) VALUES (?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		System.out.println("Connecting to DB...");
		System.out.println(acc_no + " - " + init_amt);
		statement.setInt(1, Integer.valueOf(acc_no));
		statement.setTimestamp(2, new Timestamp(Date_Time.getTime()));
		statement.setInt(3, Credit);
		statement.setInt(4, Debit);
		statement.setInt(5, Integer.valueOf(init_amt));
		statement.execute();
		System.out.println("UPDATED...\n\n==================================\n\n");
		request.setAttribute("attributeName",acc_no);
    	RequestDispatcher requestdispatcher = request.getRequestDispatcher("addAccountResult.jsp");
    	requestdispatcher.forward(request,response);
		}
		catch(Exception e)
		{
		System.out.print(e);
		e.printStackTrace();
		}
		}
	}
}
