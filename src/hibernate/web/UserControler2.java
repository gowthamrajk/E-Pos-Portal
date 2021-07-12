package hibernate.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.DAO.UserDao2;


@WebServlet("/login")
public class UserControler2 extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    private UserDao2 loginDao;

    public void init() 
    {
        loginDao = new UserDao2();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            authenticate(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response)
    throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (loginDao.validate(username, password)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login-success.jsp");
            dispatcher.forward(request, response);
        } else {
            throw new Exception("Login not successful..");
        }
    }
}