package steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaSteps extends BaseClass {
	@When ("Mouseover on the Brand")
	public void brand() throws InterruptedException {
		Thread.sleep(2000);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='menu-dropdown-icon']//a[contains(text(),'brands')]")));
	WebElement brands = driver.findElementByXPath("//li[@class='menu-dropdown-icon']//a[contains(text(),'brands')]");
	 builder=new Actions(driver);
	builder.moveToElement(brands).perform();
	}
	
	@When ("Mouseover on the Popular")
	public void popular() {
	WebElement popular = driver.findElement(By.xpath("//a[contains(text(),'Popular')]"));
	 builder=new Actions(driver);
	builder.moveToElement(popular).perform();
	}
	@When ("Click the L'oreal Paris")
	public void clickLoreal(){
	driver.findElementByXPath("//ul[@class='l-vertical-list']//li[5]//a").click();
	}
	
	@Then ("verify new window opened")
	public void verifyNewWindow() {
	System.out.println("Navigated to new Window");
	}
	
	@Then ("Verify title contains L'oreal Paris")
	public void verifyTitle() {
		 windowHandles=driver.getWindowHandles();
		 windowOpens=new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowOpens.get(1));
	List<WebElement> title = driver.findElementsByXPath("//span[contains(text(),'Paris')]");
	int count = title.size();
	System.out.println("Title Count:"+count);
	for (int i = 1; i < title.size(); i++) {
		String titleName = title.get(i).getText();
		System.out.println(titleName);
		if(titleName.contains("L'Oreal Paris")) {
			System.out.println("Title Contains L'Oreal Paris");
			}
		else {
			System.out.println("Title doesnot Contains L'Oreal Paris");
		
			}
		}
	}
	
	@When ("click sort by customer top rated")
	public void sortBy() throws InterruptedException {
		js=(JavascriptExecutor)driver;
		js.executeScript("javascript:window.scrollBy(0,500)");
		driver.findElement(By.xpath("//i[@class='fa fa-angle-down']")).click();
		driver.findElement(By.xpath("(//div[@class='control__indicator radio'])[4]")).click();
		Thread.sleep(2000);
	}
	@Then ("verify the sorted product")
	public void verifySortedProduct() {
		System.out.println("Producted Sorted Succesfully by Customer Top rating");
	}
	@When("click category")
	public void clickCategory() {
		js.executeScript("javascript:window.scrollBy(0,500)");
		driver.findElementByXPath("//div[@class='pull-right filter-options-toggle']").click();
	}
	@Then("verify whether it is expanded")
	public void verifyExpanded() {
		System.out.println("Category Succesfully Expanded");
	}
	
	@When ("click Shampoo")
	public void clickShampoo() {
		driver.findElement(By.xpath("//span[contains(text(),'Shampoo')]")).click();
	}
	
	@Then("Verify the filter is applied with shampoo")
	public void verifyFilter() {
		String filterVerify = driver.findElement(By.xpath("//ul[@class='pull-left applied-filter-lists']//li")).getText();
		System.out.println("Verify Filter Applied with " +filterVerify);	
	}
	@When ("click on Loreal Paris colour protect Shampoo")
	public void clickColourProtect() throws InterruptedException {
		js=(JavascriptExecutor)driver;
		js.executeScript("javascript:window.scrollBy(0,700)");
		Thread.sleep(2000);
		List<WebElement> colourProtect = driver.findElementsByXPath("//span[contains(text(),'Paris Colour Protect Shampoo')]");
		for (int i = 1; i < colourProtect.size(); i++) {
			driver.findElementByXPath("(//span[contains(text(),'Paris Colour Protect Shampoo')])["+i+"]").click();
		}
	}
	@Then ("Verify new windows opened")
	public void verifyWindowOpened() {
		System.out.println("Successfully new windows opened");
	}
	
	@And ("Select size as 175ml in the new window")
	public void selctSize() {
		windowHandles=driver.getWindowHandles();
		 windowOpens=new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowOpens.get(2));
		driver.findElement(By.xpath("//span[@class='size-pallets']")).click();
	}
	@And ("Print the Mrp of the product")
	public void printProductPrize() {
		String Price = driver.findElement(By.xpath("//span[@class='post-card__content-price-offer']")).getText();
		System.out.println("MRP:"+Price);
	}
	@When ("click on Add to Bag")
	public void clickAddToBag() throws InterruptedException {
		driver.findElementByXPath("//button[@class='combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  ']").click();
		Thread.sleep(2000);
	}
	@Then ("verify the bag")
	public void verifyBag() {
		System.out.println("Verified bag succesfully");
	}
	@When ("click the shopping bag")
	public void clickShoppingBag() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
		Thread.sleep(2000);
	}
	@Then ("Print the grand total")
	public void printTotal() throws InterruptedException {
		String GrandTotal = driver.findElement(By.xpath("//div[@class='sticky-bottom proceed-cart-btn']//div[@class='value']")).getText();
		System.out.println("Grand Total:"+GrandTotal);
		Thread.sleep(2000);
	}

	@When ("click proceed")
	public void clickProceed() throws InterruptedException {
		driver.findElementByXPath("//div[@class='second-col']//button[@type='button']").click();
		Thread.sleep(2000);
	}
	@Then ("verify the login page")
	public void verifyLoginPage() {
		System.out.println("Verified Login Page succesfully");
	}
	@When ("click on continue Guest")
	public void clickContinueasGuest() {
		driver.findElementByXPath("//button[@class='btn full big']").click();
	}
	@Given ("Enter the Name as {string}")
	public void enterName(String name) {

		driver.findElementByName("name").sendKeys(name,Keys.TAB);

	}
	@And ("Enter th Email as {string}")
	public void enterEmail(String Email) {
		   driver.findElementByName("email").sendKeys(Email,Keys.TAB);
		   
	}
	@And ("Enter the Phone number as{string}")
	public void enterPhoneNumber(String phonenumber) {
		driver.findElementByName("phoneNumber").sendKeys(phonenumber,Keys.TAB);
		   
	}
	@And ("Enter Pincode as {string}")
	public void enterPincode(String pincode) {
		driver.findElementByName("pinCode").sendKeys(pincode,Keys.TAB);
	}
	@And ("Enter Address as {string}")
	public void enterAddress(String address) {

		   driver.findElementByXPath("//textarea [@class='textarea-control prl10']").sendKeys(address,Keys.TAB);
	}
	
	@When ("Click Submit")
	public void clickSubmit() throws InterruptedException {
		   driver.findElementByXPath("//button [@type='submit']").click();
		   Thread.sleep(2000);


		
	}
	@Then ("Verify Payment page")
	public void verifyPaymentPage() {
		 System.out.println("Verified Payment Page Succesfully");
	}
	@And ("Verify the warning Message")
	public void verifyWarningMsg() {
		   String warningMessage = driver.findElementByXPath("//div[@class='layout horizontal center message flex-1']").getText();
		   System.out.println(warningMessage);
	}


}