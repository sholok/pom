package pomandlog4j;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;


public class log4jgmail {
private static Logger log=Logger.getLogger(log4jgmail.class);
public static void main(String[] args) throws InterruptedException
{
	DOMConfigurator.configure("log4j.xml");
	FirefoxDriver driver=new FirefoxDriver();
	log.info("Browswe launched");;
	driver.get("http://gmail.com");
	log.info("Navigate to url");
	driver.findElement(By.name("Email")).sendKeys("sholok7");
	log.info("Entered the username");
	driver.findElement(By.id("next")).click();
	log.info("Clicked on next button");
	Thread.sleep(3000);
	driver.findElement(By.name("Passwd")).sendKeys("pass123");
	log.info("Entered the password");;
	driver.findElement(By.id("signIn")).click();
	log.info("clicked on signin");
	
	                                  

}

}
