package StepDef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class RegisterPageStep {
	protected static WebDriver driver;
	
	@Given("user is on Register Page")
	public void user_is_on_register_page() {
		
		System.setProperty("webdriver.chrome.driver","E:\\Drivers\\chromedriver-win64\\chromedriver.exe");
//		ChromeOptions co=new ChromeOptions();
//		co.addArguments("--remote-allow-origins=*");
	    driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.get("https://demo.guru99.com/test/newtours/register.php");
		
	}

	@When("user enter firstname,lastname,phone and email")
	public void user_enter_firstname_lastname_phone_and_email() {
		driver.findElement(By.name("firstName")).sendKeys("pooja");
		driver.findElement(By.name("lastName")).sendKeys("natekar");
		driver.findElement(By.name("phone")).sendKeys("7028237859");
		driver.findElement(By.name("userName")).sendKeys("pooja@gmail.com");
	
	}

	@When("user enter address,city,state,postal code and select country")
	public void user_enter_address_city_state_postal_code_and_select_country() {
		driver.findElement(By.name("address1")).sendKeys("pune");
		driver.findElement(By.name("city")).sendKeys("moshi");
		driver.findElement(By.name("state")).sendKeys("Maharashtra");
		driver.findElement(By.name("postalCode")).sendKeys("416204");
		WebElement wb=driver.findElement(By.name("country"));
		Select sel=new Select(wb);
		sel.selectByVisibleText("BHUTAN");
		
	    	}

	@When("user enter username,password,confirm password and click on submit button")
	public void user_enter_username_password_confirm_password_and_click_on_submit_button() {
		driver.findElement(By.name("email")).sendKeys("pooja@gmail.com");
		driver.findElement(By.name("password")).sendKeys("pooja1995");
		driver.findElement(By.name("confirmPassword")).sendKeys("pooja1995");
		driver.findElement(By.name("submit")).click();
	    	}

	@Then("us and er is on Register success page and validate success page url")
	public void us_and_er_is_on_register_success_page_and_validate_success_page_url() {
		String actualUrl=driver.getCurrentUrl();
		boolean a=actualUrl.contains("sucess");
		Assert.assertEquals(a,true);
		
	    	}

	@When("user click on sign in link")
	public void user_click_on_sign_in_link() {
		driver.findElement(By.xpath("//a[text()=' sign-in ']")).click();
	}

	@When("user enter username,password and click on submit button")
	public void user_enter_username_password_and_click_on_submit_button() {
		driver.findElement(By.name("userName")).sendKeys("pooja@gmail.com");
		driver.findElement(By.name("password")).sendKeys("pooja1995");
		driver.findElement(By.name("submit")).click();
	   }

	@Then("user is on Login Successfully page and validate url")
	public void user_is_on_login_successfully_page_and_validate_url() {
		String actualUrl=driver.getCurrentUrl();
		boolean a=actualUrl.contains("login_sucess");
		Assert.assertEquals(a, true);
	 
	}

	@Then("user validate successfully keword in login success page")
	public void user_validate_successfully_keword_in_login_success_page() {
	    String a=driver.findElement(By.xpath("//h3[text()='Login Successfully']")).getText();
	Assert.assertEquals(a,"Login Successfully");
	}


}
