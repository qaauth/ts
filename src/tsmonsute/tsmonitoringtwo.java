//This project is about Truthscreen .
package tsmonsute;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class tsmonitoringtwo {
	static StringBuilder body = new StringBuilder();
	static StringBuilder body1 = new StringBuilder();
	static StringBuilder body2 = new StringBuilder();
	static boolean r=false;
	static boolean s=false;
	static boolean v=false;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		File fl=new File("/home/shariq.abbas/tsbrstchk/report.html");
		int i=300;
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
		FileInputStream fstream = new FileInputStream("/home/shariq.abbas/tsbrstchk/filename.txt");
			DataInputStream in = new DataInputStream(fstream);
	          BufferedReader br = new BufferedReader(new InputStreamReader(in));
		 String str=null;
		 List<String> zoom = new ArrayList<>();
	         while ((str=br.readLine()) != null) {
	         
	        zoom.add(str);
	         }
	         in.close();
	         
	         for(int pi=0;pi<zoom.size();pi++) {
					if(zoom.get(pi).contains("TestFailed Name")) {
				v =true;
				break;
					}
				}
	         
	         System.out.println(zoom.size());
		
		
		File testfile=new File("/home/shariq.abbas/tsbrstchk/filename.txt");
		testfile.createNewFile();
		FileWriter fw = new FileWriter(testfile);
		BufferedWriter bw = new BufferedWriter(fw);
		//testfile.createNewFile();
		boolean d = false;
		boolean t=false;
		System.setProperty("webdriver.chrome.driver","/home/shariq.abbas/tsbrstchk/chromedriver");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--headless");
		WebDriver dri=new ChromeDriver(options);
    	dri.get("file:///home/shariq.abbas/tsbrstchk/report.html");
    	List<WebElement> lst=dri.findElements(By.className("panel-body"));
    	List<WebElement> lstl=dri.findElements(By.className("panel-heading"));
    	
		
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
    			int im=1;
     		try {
     			 System.out.println(zoom.size());
     	          if(zoom.size()!=0 && v==false) {
     	        	 System.out.println("in if"+zoom.size());
     			for(int p=0;p<zoom.size();p++) {
     				if(elm.getText().contains(zoom.get(p))){
     					bw.write(elm.getText());
     					bw.newLine();
    			
     				}
     			}
     			}else {
     				 System.out.println("in else"+zoom.size());
     				bw.write(elm.getText());
 					bw.newLine();
     			}

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
