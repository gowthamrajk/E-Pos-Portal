package search.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import search.Dao.SearchDao;
import export.excel.DatabaseToExcel;
import export.excel.ExportData;
import exportToPDf.ExportToPDf;
import exportToWord.ExportToWord;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet 
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

        if(SearchDao.validate(result))
        {   
        	request.setAttribute("attributeName",result);
        	RequestDispatcher requestdispatcher = request.getRequestDispatcher("searchAccountResult.jsp");
        	requestdispatcher.forward(request,response);
            ExportData db=new ExportData(result);
            try 
            {
				ExportToPDf pdf=new ExportToPDf(result);
			} 
            catch (Exception e)
            {
				e.printStackTrace();
			}
            try 
            {
				ExportToWord word=new ExportToWord(result);
			} 
            catch (Exception e) 
            {
				e.printStackTrace();
			}
        }  
        else
        { 
            RequestDispatcher rd=request.getRequestDispatcher("searchErrorResult.jsp");  
            rd.include(request,response);  
        }  
        out.close();  
	}

}
