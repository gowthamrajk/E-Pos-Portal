package hibernate.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.DAO.UserDao;
import hibernate.model.User;


@WebServlet("/register")
public class UserController extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        register(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.sendRedirect("registration.jsp");
    }    

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String UserName = request.getParameter("name");
        String AccountNumber = request.getParameter("accountnumber");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User();
        user.setFirstName(UserName);
        user.setLastName(AccountNumber);
        user.setUsername(email);
        user.setPassword(password);

        userDao.saveUser(user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("register-success.jsp");
        dispatcher.forward(request, response);
    }
}
