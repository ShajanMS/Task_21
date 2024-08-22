package guvSele;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task21_3 {

	public static void main(String[] args) {
	
		
		// Set the path to the ChromeDriver executable

				System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver.exe");

				// Initialize a new instance of the ChromeDriver

				WebDriver driver = new ChromeDriver();

				try {

					// Launch the website

					driver.get("https://www.guvi.in/");

					// Maximize the browser window
					
					driver.manage().window().maximize();
					
					// Wait until the Signup button is visible and click on it
					
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					
					WebElement signup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='bg-green-500 hover:bg-green-600 text-white font-normal py-2 px-4 rounded text-base min-h-8 h-8 align-middle mr-6']")));
					
					signup.click();
					 
					// Fill in the signup form with required details
					
					WebElement Fullname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
					
					Fullname.sendKeys("Test User");
					
					WebElement email = driver.findElement(By.id("email"));
					
					email.sendKeys("bcat12123@gmail.com");
					
					WebElement Password = driver.findElement(By.id("password"));
					
					Password.sendKeys("Temp@1234");
					
					WebElement Mobile = driver.findElement(By.xpath("//input[@id='mobileNumber']"));
					
					Mobile.sendKeys("8072715417");
					
					WebElement signup1 = driver.findElement(By.id("signup-btn"));
					
					signup1.click();
					
					WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
					
					WebElement Later = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("laterBtn")));
					
					Later.click();
					
					wait.until(ExpectedConditions.titleContains("GUVI"));
					
					String SignupTitle = driver.getTitle();
					
					if (SignupTitle.contains("GUVI")) {
						
					    System.out.println("User logged in successfully with title: " + SignupTitle) ;
					} 
					
					else 
					{
					    System.out.println("Login failed with title: " + SignupTitle);
					}
					
					Thread.sleep(2000);

				   driver.navigate().back();
				   
				   WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
				   
				   WebElement Login = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-btn")));
				   
				   Login.click();
				   
				   WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
				   
				   WebElement Email = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
				   
				  Email.sendKeys("emailshajan.er@gmail.com");
				  
				  WebElement Password1 = driver.findElement(By.id("password"));
				  
				  Password1.sendKeys("Shajan97@GUVI");
				  
				  WebElement Login1 = driver.findElement(By.xpath("//a[@class='btn login-btn']"));
				  
				  Login1.click();
				  
				  wait.until(ExpectedConditions.titleContains("GUVI"));
					
					String loginTitle = driver.getTitle();
					
					if (loginTitle.contains("GUVI")) {
						
					    System.out.println("User logged in successfully with title: " + loginTitle);
					    
					} 
					
					else 
					{
					    System.out.println("Login failed with title: " + loginTitle);
					}

					Thread.sleep(2000);
				}

				catch (Exception e) {
					
					e.printStackTrace();
					
				}
				
				finally {
					
					driver.quit();
				}
			}

		}