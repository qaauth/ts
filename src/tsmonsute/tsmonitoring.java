package tsmonsute;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class tsmonitoring {
	//private static final String FILENAME = "C:\Users\shariq.abbas.ABRSPL/Desktop/Crucial/filename.txt";
	private static final String FILENAME = "/home/shariq.abbas/tsbrstchk/filename.txt";
	static MimeBodyPart messageBodyPart;
	static Multipart multipart;
	static Message message;
	static StringBuilder body = new StringBuilder();
	static StringBuilder body1 = new StringBuilder();
	static StringBuilder body2 = new StringBuilder();
	static boolean r=false;
	static boolean s=false;
	static boolean v=false;
	/*public static void main(String[] args) throws ClassNotFoundException, InterruptedException, IOException {
		System.out.println("this is for the test");
		body.append("test");
		//File fl=new File("C:\Users\shariq.abbas.ABRSPL/Desktop/Crucial/report.html");int i=300;
		mailsend(body);
	}*/
	//public static void chk() throws IOException, InterruptedException, ClassNotFoundException{
	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException{
		
		File fl=new File("/home/shariq.abbas/tsbrstchk/report.html");int i=300;
		while(i>0) {
			i=i-1;
			if((System.currentTimeMillis()-fl.lastModified())<1800000) {
		body.append("Dear Recipient!!").append(System.getProperty("line.separator"));
	maintwo();
	//mainone();
	body.append("Best Regards").append(System.getProperty("line.separator"));
	body.append("*****This Report contains confidential information and is intended only for the "
			+ "individual and organization it is addressed to. If you are not the intended recipient,"
			+ " do not disseminate, distribute, copy this report (as it may be unlawful for you to do so) or take"
			+ " any action in reliance on it. Please notify the sender immediately by replying to shariq.abbas@authbridge.com "
			+ "and delete this from your system. .");
	
	if(r==true||s==true) {
	 
		mailsend(body);
		//System.out.println(body);
	}
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
	// List<String> zoom1 = new ArrayList<>();
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
		
		File testfile=new File("/home/shariq.abbas/tsbrstchk/filename.txt");
		
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
		System.setProperty("webdriver.chrome.driver","/home/shariq.abbas/tsbrstchk/chromedriver");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--headless");
		//WebDriver dri=new FirefoxDriver(new FirefoxOptions().setHeadless(true));
		WebDriver dri=new ChromeDriver(options);
		/*java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);
		HtmlUnitDriver dri=new HtmlUnitDriver();*/
		//WebDriver dri=new FirefoxDriver();
    	dri.get("file:////home/shariq.abbas/tsbrstchk/report.html");
    	List<WebElement> lst=dri.findElements(By.className("panel-body"));
    	List<WebElement> lstl=dri.findElements(By.className("panel-heading"));
    	//fw = new FileWriter(FILENAME);
    	//bw = new BufferedWriter(fw);
    	fw = new FileWriter(testfile);
		bw = new BufferedWriter(fw);
		
		bw.newLine();
		bw.write("Name & Error Code Of Failed Requests mentioned below for General Users");
		bw.newLine();
		bw.write("____________________________________________");
		bw.newLine();
		
		for(int i=0;i<lst.size();i++) {
    		List<WebElement> lstone=lst.get(i).findElements(By.tagName("div"));
    		WebElement elm=lstl.get(i).findElement(By.tagName("a"));
    		if(elm.getAttribute("href").contains("failure")) {
    			break;
    		}else {
    			//System.out.println("lstone.get(15).getText()"+lstone.get(15).getText()+"lstone.get(16).getText()"+lstone.get(16).getText()+"lstone.get(17).getText()"+lstone.get(17).getText());
    		if(lstone.get(17).getText().contains("0")) {
    			d=true;
    		}else {
    			d=false;
    		}
    		
    		if(d==false) {
    			r=true;
     		try {
     			//new code
     			//zoom1.size()!=0
     			
     			/*if(zoom.size()!=0 && v==false) {
    	        	 System.out.println("in if"+zoom.size());
    			for(int p=0;p<zoom.size();p++) {
    				if(elm.getText().matches(zoom.get(p))){
    					System.out.println("priority one"+elm.getText());
    					System.out.println("priority two"+zoom.get(p));
    					//new code
     			bw.write("TestFailed Name :");
                bw.write(elm.getText());
                System.out.println("elm.getText()"+elm.getText()+"zoom.get(p)"+zoom.get(p));
                bw.write(" , ");
    			bw.write(lstone.get(19).getText());
    			bw.write(":");
    			bw.write(lstone.get(20).getText());
    			bw.newLine();
    				// new code
    				}
     			}
     			}else {*/
     				 //System.out.println("in else"+zoom.size());
     				bw.write("TestFailed Name :");
                    bw.write(elm.getText());
                    System.out.println("elm.getText()"+elm.getText());
                    bw.write(" , ");
        			bw.write(lstone.get(19).getText());
        			bw.write(":");
        			bw.write(lstone.get(20).getText());
        			bw.newLine();
     			//}
    			//new code

    		} catch (IOException e) {

    			e.printStackTrace();

    		}
    		}
    		}
    		}
		
		bw.newLine();
		bw.write("Detailed Description for diagnosis mentioned below for failed request");
		bw.newLine();
		bw.write("____________________________________________");
		bw.newLine();
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
     			//zoom1.size()!=0
     		/*	if(zoom.size()!=0 && v==false) {
   	        	// System.out.println("in if"+zoom.size());
   			for(int p=0;p<zoom.size();p++) {
   				if(elm.getText().contains(zoom.get(p))){
     			bw.write(lstone.get(0).getText());
    			bw.write(":");
    			bw.write(lstone.get(1).getText());
    			bw.write(",");
    			bw.newLine();
   				}
 			}
 			}else {*/
 				 //System.out.println("in else"+zoom.size());
 				bw.write(lstone.get(0).getText());
    			bw.write(":");
    			bw.write(lstone.get(1).getText());
    			bw.write(",");
    			bw.newLine();
 			//}

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
        	readfile();
        }
        
	}
	
	public static void mailsend(StringBuilder stringBuilder) throws InterruptedException, IOException, ClassNotFoundException {
		URL url=new URL("https://www.google.co.in/");
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.connect();
		String response = connection.getResponseMessage();
		int j=18000;
		while(j>0) {
		j=j-1;
		if(response.matches("OK")) {
		final String username = "qa.team@authbridge.com";
	    final String password = "QA@team";
	    

	    Properties props = new Properties();
	    props.put("mail.smtp.auth", true);
	    props.put("mail.smtp.starttls.enable", false);
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "465");
	    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	    Session session = Session.getInstance(props,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });
	     try {
	    	 
	     message = new MimeMessage(session);
	     message.setFrom(new InternetAddress("shariq.abbas@authbridge.com"));
	    /*message.setRecipients(Message.RecipientType.TO,
	                InternetAddress.parse("shariq.abbas@authbridge.com"));*/
	  message.setRecipients(Message.RecipientType.TO,
	                InternetAddress.parse("mayank.garg@authbridge.com,"
	                		+ "truthscreen.support@authbridge.com,\r\n" + 
	                		"vishal.walia@authbridge.com,\r\n" + 
	                		"mukesh.seemawat@authbridge.com,\r\n" + 
	                		"ranjan.kumar@authbridge.com,\r\n" + 
	                		"shariq.abbas@authbridge.com,naved.danish@authbridge.com,\r\n" + 
	                		"sandeep@authbridge.com,bhanujeet.choudhary@authbridge.com"));
	    
	  // message.setSubject("TruthScreen Services Critical Requests Monitoring Suite for Desktop & WebServices Completed || "
	    // 		+ "Problem Detected :Autosender Enabled");
	   message.setSubject("TruthScreen Services Complete Monitoring Suite for Desktop & WebServices Completed || "
	     		+ "Problem Detected :Autosender Enabled");
	    /* message.setSubject("TruthScreen Services Hourly Monitoring Suite for Desktop & WebServices Completed || "
		     		+ "Problem Detected :Autosender Enabled"); */
	     message.setText(stringBuilder.toString());
	     
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(stringBuilder.toString());
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			 messageBodyPart = new MimeBodyPart();
			FileDataSource fds = new FileDataSource("/home/shariq.abbas/tsbrstchk//report.html");
			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setFileName(fds.getName());
			multipart.addBodyPart(messageBodyPart);
	        message.setContent(multipart);
	     Thread.sleep(5000);
	        System.out.println("Sending");
	        Transport.send(message);
	        System.out.println("Done");
	        } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	     break;
		}
		else {
			Thread.currentThread().sleep(1000);
		}
		}
		
		
	}
	
	public static void readfile(){  
		String strLine = null;
		body.append(System.getProperty("line.separator"));
		body.append("Below mentioned links not working on Truthscreen webservices Suite.").append(System.getProperty("line.separator"));
        try{
          FileInputStream fstream = new FileInputStream("/home/shariq.abbas/tsbrstchk/filename.txt");
           DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
while ((strLine = br.readLine()) != null)   {
               // System.out.println (strLine);
                body.append(strLine);
                body.append(System.getProperty("line.separator"));
            }
             in.close();
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
        //return body;
    }
	
	
	public static void mainone() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","/home/shariq.abbas/tsbrstchk/chromedriver");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--headless");
		//WebDriver dri=new FirefoxDriver(new FirefoxOptions().setHeadless(true));
		WebDriver dri=new ChromeDriver(options);
		// WebDriver dri=new HtmlUnitDriver();
			dri.get("http://www.truthscreen.com");
			new WebDriverWait(dri, 50).until
	        (ExpectedConditions.visibilityOfElementLocated
	(By.id("username")));
			dri.findElement(By.id("username")).sendKeys("demo@authbridge.com");
			dri.findElement(By.id("password")).sendKeys("admin@#$123");
			dri.findElement(By.id("submit1")).click();
			try {
			new WebDriverWait(dri,300).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dashboard")));
			}catch(NoSuchElementException e) {
				body.append(System.getProperty("line.separator"));
				body.append("On Desktop Version,User Login either taking too much time or not working .");
			}
			List<WebElement> lst=dri.findElements(By.tagName("a"));
			body.append(System.getProperty("line.separator"));
			body1.append("Below mentioned links not working on Truthscreen Desktop version.").append(System.getProperty("line.separator"));
			for(int i=0;i<lst.size();i++) {
				try {
				if(lst.get(i).getAttribute("href")!=null && lst.get(i).getAttribute("href").contains("truth")) {
				URL url=new URL(lst.get(i).getAttribute("href"));
				HttpURLConnection connection = (HttpURLConnection)url.openConnection();
				connection.connect();
				String response = connection.getResponseMessage();	 
				if(response.matches("OK")) {
					System.out.println("link"+lst.get(i).getAttribute("href"));
					
				}else {
					s=true;
					body2.append(lst.get(i).getAttribute("href"));
	                body2.append(System.getProperty("line.separator"));
				}
	           // connection.disconnect();
			    }
				}catch(Exception e ) {
					
				}
			}
			body2.append(System.getProperty("line.separator"));body2.append(System.getProperty("line.separator"));
			dri.close();
			if(body2.length()>2) {
				body=body.append(body1).append(body2);
			}
		}
}
