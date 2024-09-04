package testScenarios;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class MultipleListBox {
@Test
	public void multiList() throws InterruptedException {
		// TODO Auto-generated method stub
		ArrayList<String> exp_cars=new ArrayList<String>();
		exp_cars.add("volvo");
		exp_cars.add("saab");
		exp_cars.add("audi");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		driver.switchTo().frame("iframeResult");
		WebElement ele=driver.findElement(By.id("cars"));
		Select opts=new Select(ele);
		opts.selectByIndex(0);
		opts.selectByValue("saab");
		opts.selectByVisibleText("Audi");
		driver.findElement(By.xpath("/html/body/form/input")).click();
		Thread.sleep(4000);
		String selCars=driver.findElement(By.xpath("/html/body/div[1]")).getText();
		System.out.println("Selected Cars="+selCars);
		
		//assignment
		//Using Split Method
		String[] array_cars = selCars.split("&");
		for (String x:array_cars)
		{
			System.out.println(x);
		}
	
		String[] carname={"volvo","saab","audi"};	//This block can be used
		String[] array_cars1 = carname;
		for (String a:array_cars1)
		{
			System.out.println(a);
		}

		
/*		String[] str_array = array_cars;	//Example using list.remove
		List<String> list = new ArrayList<String>(Arrays.asList(str_array));
		list.remove("cars");
		str_array = list.toArray(new String[0]);
*/	
		
/*		int i=0;
		
		for(String a: array_cars)
		{
			String[] array_x = a.split("=");
			
			for(String b: array_x)
			{
				if(b!="cars") 
				{
					i=i+1;
				}
			}
			
		}
*/
		
/*		String a1 = array_cars [0];
		String b1 = array_cars [1];
		String c1 = array_cars [2];
		
		String[] a2 = a1.split("=");
		String[] b2 = b1.split("=");
		String[] c2 = c1.split("=");
	
		if (a1 != "cars")
		{
			for (String t1:a2)
			{
				System.out.println(t1);
			}
		}
		if (b1 != "cars")
		{
			for (String t2:b2)
			{
				System.out.println(t2);
			}
		}
		if (c1 != "cars")
		{
			for (String t3:c2)
			{
				System.out.println(t3);
			}
		}
*/		
		Reporter.log("Passed");
		driver.quit();
	}

}
