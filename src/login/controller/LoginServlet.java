package login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.Dao.LoginDao;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        String accno=request.getParameter("accountnumber");  
        String pass=request.getParameter("password"); 
        
        HttpSession session = request.getSession(false);
        if(session!=null)
        session.setAttribute("name", accno);

        if(LoginDao.validate(accno, pass))
        {  
            RequestDispatcher rd=request.getRequestDispatcher("dashboard.jsp");  
            rd.forward(request,response);  
        }  
        else
        {   
            RequestDispatcher rd=request.getRequestDispatcher("loginErrorResult.jsp");  
            rd.include(request,response);  
        }  
        out.close();  
    }  
}