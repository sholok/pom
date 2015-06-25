package pomandlog4j;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResisterMercuryTours2 {

	@FindBy(xpath="html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")
	WebElement regText;
	public boolean validateRegistration(String text)
	{
		String actText=regText.getText();
		if(actText.contains(text))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
