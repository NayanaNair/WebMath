

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class GeneralMath extends TestBase{
	
	//Page Factory or Object Repository 
	
	@FindBy(id="topicItem")
	WebElement mathHelpdropDown;

	@FindBy(xpath="//div[@class='d-quickJumpRight']/a")
	WebElement goBtn;

	@FindBy(xpath="//div[@id=\"d-logo\"]/a/img")
	WebElement webMathLogo;

	@FindBy(name="number")
	WebElement number;
	
	//Initializing Page objects:

		public GeneralMath() {
			PageFactory.initElements(driver, this);
		}


		//Actions:
		
		public String validateGeneralMathTitle() {
			return driver.getTitle();
		}

		public boolean validateWebMathLogo() {
			return webMathLogo.isDisplayed();
		}
		
		public Answer numbersPronouncing(int num) {

			// Selecting the drop-down 
			Select drop_down = new Select(driver.findElement(By.cssSelector("select[id *='topicItem']")));

			// matching the desired option[ Conversion, Volume]
			drop_down.selectByVisibleText("Numbers, Pronouncing");

			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

			//Enter the principal amount
			number.sendKeys(String.valueOf(num));

			//Click on Find the Amount of interest 
			WebElement convertBtn = driver.findElement(By.xpath("//input[@type='submit']"));
			convertBtn.click();

			return new Answer();
		}

}