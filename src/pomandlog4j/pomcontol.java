package pomandlog4j;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class pomcontol {
@Test
public void pomtest()
{
	ProfilesIni pr=new ProfilesIni();
	FirefoxProfile fp=pr.getProfile("SeleniumUser");
	FirefoxDriver driver=new FirefoxDriver(fp);
	driver.get("http://newtours.demoaut.com");
	WelcomeMercuryTours wm=PageFactory.initElements(driver, WelcomeMercuryTours.class);
	wm.findAflight("admin", "pass123");
	driver.navigate().back();
	wm.menu.register();
	
}
	
}
