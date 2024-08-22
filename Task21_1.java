package guvSele;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task21_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		try {

			// Navigate to the jQueryUI date picker demo website

			driver.get("https://jqueryui.com/datepicker/");

			// Maximize the browser window

			driver.manage().window().maximize();

			// Switch to the iframe that contains the date picker

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='demo-frame']")));

			driver.switchTo().frame(frame);

			// Click on the date picker input field to open the date picker

			WebElement datepicker = driver.findElement(By.id("datepicker"));

			datepicker.click();

			// Click on the next month button

			WebElement nextmonth = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));

			nextmonth.click();

			// Wait for the date picker to load the next month

			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("22")));

			// Select the date "22" from the date picker
			
			WebElement datetoselect = driver.findElement(By.linkText("22"));
			
			datetoselect.click();
			
			// Get the selected date from the date picker input field
			
			String selecteddate = datepicker.getAttribute("value");
			
			System.out.println("Selected date is " + selecteddate);
		}

		catch (Exception e) {

			e.printStackTrace();

		}
		
		finally {
			
			driver.quit();
		}

	}

}
