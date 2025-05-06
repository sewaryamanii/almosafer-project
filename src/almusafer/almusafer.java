package almusafer;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class almusafer extends TestData {
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void mysetup() throws InterruptedException {
		driver.get("https://global.almosafer.com/en");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test(priority = 1)
	public void countryslection() {

		WebElement country = driver
				.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		country.click();

	}

	@Test(priority = 2)
	public void checkthedefualtlanguage() {
		String actulalanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");
		Assert.assertEquals(actulalanguage, expectedlanguage);

	}

	@Test(priority = 3)
	public void checkcontactnumber() {
		WebElement contactnumber = driver.findElement(By.className("sc-cjHlYL"));
		String actualcontactnumber = contactnumber.getText();

	}

	@Test(priority = 4)
	public void checkthecurrency() {

		WebElement actualdcurrency = driver.findElement(By.cssSelector(".sc-hUfwpO.kAhsZG"));
		String expectedcurrency = actualdcurrency.getText();
	}

	@Test(priority = 5)
	public void QitafLogo() {

		WebElement qitaflogo = driver.findElement(By.cssSelector("[data-testid='Footer__QitafLogo']"));
		Assert.assertTrue(qitaflogo.isDisplayed(), "Qitaf logo is not displayed in the footer.");

	}

	@Test(priority = 6)
	public void thedefaultisflights() {
		WebElement flightsbutton = driver.findElement(By.cssSelector("[data-rb-event-key='flights']"));
		String selected = flightsbutton.getDomAttribute("aria-selected");
		Assert.assertEquals(selected, "true", "default is flights");
	}
	@Test(priority = 7)
	public void departuredate() {

	    LocalDate date = LocalDate.now();
	    LocalDate tomorrowDate = date.plusDays(1);

	    DateTimeFormatter fullFormat = DateTimeFormatter.ofPattern("dd MM yyyy");
	    String expecteddeparturedate = tomorrowDate.format(fullFormat);

	    List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));
	    String actualdepartureDay = dates.get(0).getText();

	    String actualfullDate = actualdepartureDay + " " + 
	        String.format("%02d", tomorrowDate.getMonthValue()) + " " + 
	        tomorrowDate.getYear();

	    System.out.println("expected departure Date: " + expecteddeparturedate);
	    System.out.println("actual departure Date : " + actualfullDate);

	    Assert.assertEquals(actualfullDate, expecteddeparturedate);
	}

	@Test(priority = 8)
	public void returndate() {

	    LocalDate date = LocalDate.now();
	    LocalDate tomorrowDate = date.plusDays(2);

	    DateTimeFormatter fullFormat = DateTimeFormatter.ofPattern("dd MM yyyy");
	    String expectedreturndate = tomorrowDate.format(fullFormat);

	    List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));
	    String actualDay = dates.get(1).getText();

	    String actualreturndate = actualDay + " " + 
	        String.format("%02d", tomorrowDate.getMonthValue()) + " " + 
	        tomorrowDate.getYear();

	    System.out.println("expected return  Date: " + expectedreturndate);
	    System.out.println("actual return Date : " + actualreturndate);

	    Assert.assertEquals(actualreturndate, expectedreturndate);
	}

	@Test(priority = 9)
	public void testLanguageByUrl() throws InterruptedException {
	    String[] languages = {"ar", "en"};
	    Random rand = new Random();
	    String chosenLanguage = languages[rand.nextInt(languages.length)];

	   
	    driver.get("https://www.almosafer.com/" + chosenLanguage );

	  
	    Thread.sleep(2000);

	   
	    String actualLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");
	    System.out.println(" language on the page: " + actualLanguage);
	    Assert.assertEquals(actualLanguage, chosenLanguage);
	Thread.sleep(2000);

		
	
	}

	@Test(priority = 10)
	public void gotostaysbottun () throws InterruptedException {
		
		
		WebElement staysbottuneng = driver.findElement(By.cssSelector("[data-rb-event-key='hotels']"));
    	staysbottuneng.click();
    	
    	
	 
    	
    	if (driver.getCurrentUrl().contains("en")) {
    		WebElement city = driver.findElement(By.cssSelector("input[data-testid='AutoCompleteInput']"));
    		city.sendKeys(cityen[randomcityen]);
    		Thread.sleep(2000);
    		city.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER));

		} else {
			WebElement city = driver.findElement(By.cssSelector("input[data-testid='AutoCompleteInput']"));
	    	city.click();
			city.sendKeys(cityar[randomcityar]);
			Thread.sleep(2000);
			city.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER));

		}
    	
    	
    	
	}

	@Test (priority = 11)
	public void selectadultsnumber() throws InterruptedException {
		WebElement adultsnumber = driver.findElement(By.cssSelector(".sc-tln3e3-1.gvrkTi"));

		Select mySelector = new Select(adultsnumber);

		mySelector.selectByValue(options[randomnuber]);

		driver.findElement(By.cssSelector(".sc-1vkdpp9-5.btwWVk")).click();

	}


		
	
	

	}
