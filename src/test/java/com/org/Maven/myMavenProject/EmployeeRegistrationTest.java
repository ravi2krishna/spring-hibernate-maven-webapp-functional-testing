package com.org.Maven.myMavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmployeeRegistrationTest 

{
@Test(dataProvider="employeeData")
	
	//WebDriver driver;

    public void registeringEmployees(String Name, String JoiningDate, String Salary, String SSN) throws InterruptedException
    {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		Thread.sleep(3000);
		
		WebDriver driver=new ChromeDriver();
		
		Thread.sleep(2500);
		
		driver.manage().window().maximize();
		//driver.get("https://wordpress.com/log-in");
		driver.get("http://104.197.156.171:8686/SpringHibernateExample/new");
		
		driver.findElement(By.id("name")).sendKeys(Name);
		Thread.sleep(2000);
		
		driver.findElement(By.name("joiningDate")).sendKeys(JoiningDate);
		Thread.sleep(2000);
	
		driver.findElement(By.id("salary")).sendKeys(Salary);
		Thread.sleep(2000);
		
		driver.findElement(By.id("ssn")).sendKeys(SSN);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(".//*[@id='employee']/table/tbody/tr[5]/td/input")).click();
	
		System.out.println(driver.getTitle());
		
		WebElement element=driver.findElement(By.xpath("html/body"));
		
		String result=element.getText();
		
		// Validations
		
		//for(int i=1;i<=2;i++)
		//{
		if (result.contains("successfully"))
		{
			System.out.println("Employee added successfully");
			Reporter.log("Employee added successfully");
		}
		else
		{
			System.out.println("Employee not added due to invalid credentials");
			Reporter.log("Employee not added due to invalid credentials");
		}
		//}
		driver.quit();

    }
    
	@DataProvider(name="employeeData")
	public Object[][] passData()
	{
		Object[][] data= new Object[3][4];
		
		data[0][0]="xkkjh3";
		
		data[0][1]="01/02/2001";
		
		data[0][2]="10000";
		
		data[0][3]="092";
		
        data[1][0]="ysfd4";
		
		data[1][1]="01/04/2004";
		
		data[1][2]="20000";
		
		data[1][3]="091";
		
		//Negative credentials
		
        data[2][0]="xuez3";
		
		data[2][1]="01/02/2010";
		
		data[2][2]="1000";
		
		
		return data;
	}
	

}
