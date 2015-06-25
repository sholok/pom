package pomandlog4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Pomcontrol2 {
@Test
public void datadriverTest() throws IOException
{
	FileInputStream f=new FileInputStream("C:\\Users\\qdge\\Desktop\\testng\\sample\\src\\com\\qedge\\excelfiles\\registration1.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(f);
	XSSFSheet ws=wb.getSheet("sheet1");
	Iterator<Row> row=ws.iterator();
	row.next();
	ProfilesIni pr=new ProfilesIni();
	FirefoxProfile fp=pr.getProfile("SeleniumUser");
	FirefoxDriver driver=new FirefoxDriver(fp);
	driver.get("http://newtours.demoaut.com");
	WelcomeMercuryTours wm=PageFactory.initElements(driver,WelcomeMercuryTours.class);
	ResisterMercuryTours1 rm1=PageFactory.initElements(driver,ResisterMercuryTours1.class);
	ResisterMercuryTours2 rm2=PageFactory.initElements(driver,ResisterMercuryTours2.class);
	wm.menu.register();
	while(row.hasNext())
	{
		Row r=row.next();
		rm1.contactInformation(r);
		boolean b=rm2.validateRegistration(r.getCell(9).getStringCellValue());
		if(b==true){
			r.createCell(12).setCellValue("passed");
		}
		else
		{
			r.createCell(12).setCellValue("failed");
		}
		driver.navigate().back();
		FileOutputStream f1=new FileOutputStream("C:\\Users\\qdge\\Desktop\\testng\\sample\\src\\com\\qedge\\resultexcelfiles\\registration1.xlsx");
		wb.write(f1);
		f1.close();
	}
	
	}
			
			
			
}

