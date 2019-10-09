//This project is about Truthscreen .
package tsmonsute;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class tsmonitoringone {
	private static final String FILENAME = "C:/Users/shariq.abbas.ABRSPL/Desktop/Crucial/filename.txt";
	static MimeBodyPart messageBodyPart;
	static Multipart multipart;
	static Message message;
	static StringBuilder body = new StringBuilder();
	static StringBuilder body1 = new StringBuilder();
	static StringBuilder body2 = new StringBuilder();
	static boolean r=false;
	static boolean s=false;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		File fl=new File("C:/Users/shariq.abbas.ABRSPL/Desktop/Crucial/report.html");int i=300;
		while(i>0) {
			i=i-1;
			if((System.currentTimeMillis()-fl.lastModified())< 900000) {
		maintwo();
		break;
	}
		else {
			Thread.currentThread().sleep(60000);
		}
		}
		
		

	}
	public static void maintwo() throws IOException, InterruptedException {
		
		File testfile=new File("C:/Users/shariq.abbas.ABRSPL/Desktop/Crucial/filename.txt");
		
		boolean b=testfile.createNewFile();
		boolean d = false;
		if(b) {
			System.out.println("File Created");
		}
		else {
			System.out.println("File could not be created");
		}
		BufferedWriter bw = null;
		FileWriter fw = null;
		boolean t=false;
		// D:\\Selenium Jars\\geckodriver-v0.19.1-win64\\geckodriver.exe
		System.setProperty("webdriver.chrome.driver","C:/Users/shariq.abbas.ABRSPL/Desktop/Crucial/chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--headless");
		//WebDriver dri=new FirefoxDriver(new FirefoxOptions().setHeadless(true));
		WebDriver dri=new ChromeDriver(options);
    	dri.get("file://C:/Users/shariq.abbas.ABRSPL/Desktop/Crucial/report.html");
    	List<WebElement> lst=dri.findElements(By.className("panel-body"));
    	List<WebElement> lstl=dri.findElements(By.className("panel-heading"));
    	//fw = new FileWriter(FILENAME);
    	fw = new FileWriter(testfile);
		bw = new BufferedWriter(fw);
		
    	for(int i=0;i<lst.size();i++) {
    		List<WebElement> lstone=lst.get(i).findElements(By.tagName("div"));
    		WebElement elm=lstl.get(i).findElement(By.tagName("a"));
    		if(elm.getAttribute("href").contains("failure")) {
    			break;
    		}else {
    		if(lstone.get(17).getText().contains("0")) {
    			d=true;
    		}else {
    			d=false;
    		}
    		
    		if(d==false) {
    			r=true;
     		try {
         
    			bw.write(elm.getText());
    			
    			bw.newLine();
    			

    		} catch (IOException e) {

    			e.printStackTrace();

    		}
    		}
    		}
    	    }
     	bw.close();
    	fw.close();
        dri.close();
        
        if(r==true) {
        	//readfile();
        }
        
	}
	
	
}
