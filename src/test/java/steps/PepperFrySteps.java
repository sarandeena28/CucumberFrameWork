package steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PepperFrySteps extends BaseClass {

	@When("Mouseover on Furniture")
	public void mouseover_on_furniture() {
		WebElement furniture = driver.findElementByLinkText("Furniture");
		builder=new Actions(driver);
		builder.moveToElement(furniture).perform();
	}
	
	
	@When("click Office Chairs under Chairs")
	public void click_office_chairs_under_chairs() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElementByXPath("//a[contains(text(),'Office Chairs')]").click();
	}
	@When("click Executive Chairs")
	public void click_executive_chairs() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElementByXPath("//h5[contains(text(),'Executive Chairs')]").click();
		js=(JavascriptExecutor)driver;
		js.executeScript("javascript:window.scrollBy(0,500)");

	}
	@When("Change the minimum Height as {string} in under Dimensions")
	public void change_the_minimum_height_as_in_under_dimensions(String Dimension) throws InterruptedException {
		driver.findElementByXPath("//input[@class='clipFilterDimensionHeightValue']").clear();
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@class='clipFilterDimensionHeightValue']").sendKeys(Dimension);
		js.executeScript("javascript:window.scrollBy(0,500)");
	}
	

@When("Add Buff High Back Executive Chair In Brown Colour chair to Wishlist")
public void add_chair_to_wishlist() throws InterruptedException {
	Thread.sleep(2000);
	driver.findElementByXPath("//a[@data-productname='Buff High Back Executive Chair in Black Colour']").click();
	js.executeScript("javascript:window.scrollBy(500,0)");
}
@When("Mouseover on Bedroom")
public void mouseover_on_bedroom() {
	WebElement bedroom = driver.findElementByLinkText("Bedroom");
	builder.moveToElement(bedroom).perform();
}

@When("Click Study tables Under Tabels")
public void click_study_tables_under_tabels() throws InterruptedException {
	Thread.sleep(1000);
	driver.findElementByXPath("(//a[contains(text(),'Study Tables')])[3]").click();
}
@When("Select Spacewood as Brand")
public void select_spacewood_as_brand() throws InterruptedException {
	Thread.sleep(2000);
	driver.findElementByXPath("//label[@for='brandsnameSpacewood']").click();
	js.executeScript("javascript:window.scrollBy(0,500)");
}

@When("Select Price as 7000 to 8000")
public void select_price_as_to() throws InterruptedException {
	Thread.sleep(3000);
	js.executeScript("arguments[0].click()", driver.findElementByXPath("//label[@for='price8000-10000']"));
}

@When("Add Winner Hutch Table In Rigato Walnut Finish to Wishlist")
public void add_winner_hutch_table_in_rigato_walnut_finish_to_wishlist() throws InterruptedException {
	Thread.sleep(2000);
	driver.findElementByXPath("//a[@data-productname='Winner Hutch Table in Rigato Walnut Finish']").click();
}
@Then("Verify the number of items in Wishlist")
public void verify_the_number_of_items_in_wishlist() throws InterruptedException {
	Thread.sleep(2000);
	String VerifyWhishlist = driver.findElementByXPath("(//span[@class='header-nav-icon'])[2]").getText();
	System.out.println(VerifyWhishlist);
}
@When ("Navigate to Wishlist")
public void navigate_to_wishlist() throws InterruptedException {
	driver.findElementByXPath("//a[@class='wishlist_bar']").click();
	Thread.sleep(1000);
}
@When ("Move Table to Cart from Wishlist")
public void movetabletoCart() {
	driver.findElementByXPath("//a[@data-tooltip='Add to Cart']").click();
}
@When ("Click Proceed to Pay Securely")
public void clickProceed() throws InterruptedException {
	Thread.sleep(2000);
	driver.findElementByXPath("//div[@id='reg_login_box']//a[@class='popup-close']").click();
	Thread.sleep(1000);
	WebElement frame1 = driver.findElementByXPath("//iframe[@name='notification-frame-22a335763']");
	driver.switchTo().frame(frame1);
	driver.findElementByXPath("//span[@class='wewidgeticon we_close icon-large']").click();
	driver.switchTo().defaultContent();
	driver.findElementByXPath("//div[@id='minicart_footer']//a").click();
}
@Then ("Enter Pincode as {string} in Delivery & Assembly Details")
public void enterPincode(String Pincode) {
	driver.findElementById("pin_code").sendKeys(Pincode);
}

@When ("click Go")
public void clickGo() {
	driver.findElementById("pin_check").click();
}
@When ("Click Place Order")
public void clickPlaceOrder() {
	driver.findElementByLinkText("PLACE ORDER").click();
}

@When ("Capture a screenshot by Clicking on Order Summary")
public void clickOrderSumary() throws IOException {
	driver.findElementById("ordersummary_accordian_header").click();
	File source=driver.getScreenshotAs(OutputType.FILE);
	File target=new File("./snaps/orderSummary.png");
	FileUtils.copyFile(source, target);
}





}
