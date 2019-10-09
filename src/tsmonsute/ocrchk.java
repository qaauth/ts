package tsmonsute;

import java.io.File;
import java.io.IOException;
import org.testng.annotations.Test;
import com.asprise.ocr.Ocr;

public class ocrchk  
{  
	@Test
	public void start() throws IOException
	{
		Ocr.setUp(); // one time setup
	    Ocr ocr = new Ocr(); // create a new OCR engine
	    ocr.startEngine("eng", Ocr.SPEED_FASTEST); // English
	    String s = ocr.recognize(new File[] {new File("C:\\Users\\shariq.abbas.ABRSPL\\Desktop\\Neetika\\Aadhaar&PAN\\img2.jpg")},
	      Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT);
	    System.out.println("Result: " + s);
	    ocr.stopEngine();
	}  
}