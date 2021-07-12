package file.upload;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import excelconversion.model.ExcelToDatabase;

@WebServlet("/upload")
public class FileUpload extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "C:\\UploadTestDoc";
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {      
        if(ServletFileUpload.isMultipartContent(request))
        {
            try 
            {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts)
                {
                    if(!item.isFormField())
                    {
                        String name = new File(item.getName()).getName();
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                }
                request.getRequestDispatcher("/uploadSuccess.jsp").forward(request, response);
                ExcelToDatabase db=new ExcelToDatabase();
            } 
            catch (Exception ex)
            {
               request.setAttribute("message", "File Upload Failed");
               request.getRequestDispatcher("/uploadErrorResult.jsp").forward(request, response);
            }          
        }
        else
        {
            request.setAttribute("message","Sorry this Servlet only handles file upload request");
            request.getRequestDispatcher("/uploadErrorResult.jsp").forward(request, response);
        }
        
    }
}


