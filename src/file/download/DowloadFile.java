package file.download;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class DowloadFile extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
        String filePath = "C:\\Users\\HP\\eclipse-workspace\\registration\\Output.xlsx";
        File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);
        response.setContentLength((int) downloadFile.length());        
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);
        OutputStream outStream = response.getOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inStream.read(buffer)) != -1)
        {
            outStream.write(buffer, 0, bytesRead);
        }
        System.out.println("File downloaded successfully");
        inStream.close();
        outStream.close();     
    }
}