package directTransaction;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/searchAccountServlet")
public class SearchAccountServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        String result=request.getParameter("search");  
        
        HttpSession session = request.getSession(false);
        if(session!=null)
        session.setAttribute("name", result);

        if(SearchAccount.validateAccount(result))
        {   
        	request.setAttribute("attributeName",result);
        	RequestDispatcher requestdispatcher = request.getRequestDispatcher("TransactionResult.jsp");
        	requestdispatcher.forward(request,response);
        }  
        else
        { 
            RequestDispatcher rd=request.getRequestDispatcher("searchTransactionErrorResult.jsp");  
            rd.include(request,response);  
        }  
        out.close();  
	}

}
