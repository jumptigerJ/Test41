import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class no1 {
	public static void main(String[] args) {
		try {
			//File file  = new File("SampleChapter1.pdf");
			URL url = new URL("http://www.manning.com/gsmith/SampleChapter1.pdf");
			URLConnection connection = url.openConnection();
			InputStream is = connection.getInputStream();
			FileOutputStream fos = new FileOutputStream("SampleChapter1.pdf");
			
			BufferedInputStream in  =   null ;
		    BufferedOutputStream out  =   null ;
		    byte buffer[]  = new byte[8192];
		        
            in = new BufferedInputStream(is, buffer.length);
            out = new BufferedOutputStream(fos, buffer.length);
            int total = 0;
            for (int bytesRead = 0; (bytesRead = in.read(buffer)) != - 1 ;) {
               out.write(buffer, 0, bytesRead);
                total  +=  bytesRead;
            }
            
            in.close();
            out.close();
            fos.close();
            is.close();
		
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
