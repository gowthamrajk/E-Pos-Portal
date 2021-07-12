package file.upload;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Listfiles
{
	public static void main(String[] args) {

        final File folder = new File("C:\\UploadTestDoc");

        List<String> result = new ArrayList<>();

        search(".*\\.xlsx", folder, result);

        for (String s : result) 
        {
            System.out.println(s);
        }
	}
        public static void search(final String pattern, final File folder, List<String> result) {
            for (final File f : folder.listFiles()) 
            {
                if (f.isFile()) 
                {
                    if (f.getName().matches(pattern)) 
                    {
                        result.add(f.getAbsolutePath());
                    }
                }

            }
        }
}
