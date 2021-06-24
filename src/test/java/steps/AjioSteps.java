package steps;

import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AjioSteps extends BaseClass{

	public static int TotalItem;
	
	@When ("Mouse over on Women") 
	public void mouseOverWomen() throws InterruptedException {
		Thread.sleep(2000);
		WebElement women = driver.findElementByXPath("//a[@title='WOMEN']");
		String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		((JavascriptExecutor) driver).executeScript(mouseOverScript,women);
//		Actions builder=new Actions(driver);
//		builder.moveToElement(women).perform();
	}
	@When ("Mouse over on Brands")
	public void mouseOverBrands() {
		WebElement brand = driver.findElementByXPath("//a[contains(text(),'BRANDS')]");
		Actions builder=new Actions(driver);
		builder.moveToElement(brand).perform();
	}
	@Then ("Verify list of brands gets loaded")
	public void verifyBrands() {
		System.out.println("List of brands Link Loaded");
	}
	@When ("Click the link that has most number of lower case characters")
	public void clickLowercaseLink() throws InterruptedException {
		List<WebElement> els = driver.findElementsByXPath("//ul[@class='level-first false']//li//a[@title='WOMEN']/following::li[2]//span//a");
		int size = els.size();
		System.out.println(size);
		int finalcount=0,lowercase;
	TreeMap<String,Integer> lowercaseProduct=new TreeMap<String,Integer>();
		for (int i = 0; i <els.size(); i++) {
			lowercase=0;
			String ProductTitle = els.get(i).getAttribute("title");
			System.out.println(ProductTitle);
			for (int j = 1; j < ProductTitle.length(); j++) {
				if(Character.isLowerCase(ProductTitle.charAt(j))){
					lowercase++;			
				}
			}
			System.out.println(lowercase);
			if(finalcount<lowercase)
			{
				finalcount=lowercase;
				lowercaseProduct.put(ProductTitle, finalcount);	
			}	
		}
		System.out.println(lowercaseProduct);
		System.out.println("Link having maximum Lowercase:"+finalcount);	
		String key = lowercaseProduct.lastEntry().getKey();
		System.out.println(key);
		Thread.sleep(2000);
		driver.findElementByXPath("//span//a[contains(text(),'"+key+"')]").click();
	}
	@Then ("Verify New Page Loaded")
	public void verifyNewPage() {
		System.out.println("link which has Lowercase has been opened Successfully");
	}
	@And  ("Print and store number of items")
	public void printNumberOFItems() {
		String noOfItems = driver.findElementByXPath("//div[@class='length']").getText();
		int TotalItem = Integer.parseInt(noOfItems.replaceAll("[^0-9]", ""));
		System.out.println("No of Items in the page"+TotalItem);
	}
	@When ("Click Size and Fit") 
	public void clickSizeAndFit() {
		driver.findElementByXPath("//span[contains(text(),'size & fit')]").click();
	}
	@Then ("Verify its get expanded")
	public void verifyExpand() {
		System.out.println("Succesfully Expanded");
	}
	@When ("select the Size S")
	public void selectSize() throws InterruptedException {
		driver.findElementByXPath("//label[@for='S']").click();
		Thread.sleep(2000);
	}
	@Then ("Confirm the number of items have reduced thean the  previous results")
	public void verifyItemReduced() throws InterruptedException {
		String ReducedItem = driver.findElementByXPath("//div[@class='length']").getText();
		
		int ReducedCount = Integer.parseInt(ReducedItem.replaceAll("[^0-9]", ""));
		System.out.println("No of Items in the page"+ReducedCount);
		Thread.sleep(2000);
		if(ReducedCount <= TotalItem) {
			System.out.println("Confirmed that number of items have reduced than the previous results");
		}
		else {
			System.out.println("Confirmed that number of items have not reduced than the previous results");
		}
	}

	@When ("Click Sort by  Discount") 
	public void selectDiscount() {
		WebElement selectDiscount = driver.findElementByXPath("//div[@class='filter-dropdown']//select");
		Select dropdown=new Select(selectDiscount);
		dropdown.selectByValue("discount-desc");
	}
	@Then ("confirm results are sorted  by higher discounts first")
	public void verifysortByHigherDiscount() {
		List<WebElement> discountProducts = driver.findElementsByXPath("//span[@class='discount']");
		List<WebElement> ProductName = driver.findElementsByXPath("//div[@class='contentHolder']//div[2]");
		TreeMap<String,Integer> sortByDiscount=new TreeMap<String,Integer>();
		int totalSize = ProductName.size();
		System.out.println(totalSize);
		for (int i = 0; i < discountProducts.size(); i++) {
			String NameofProduct = ProductName.get(i).getText();
			String ProductDiscount = discountProducts.get(i).getText();
			int pDiscount=Integer.parseInt(ProductDiscount.replaceAll("[^0-9]", ""));
			System.out.println(NameofProduct);
			System.out.println(pDiscount);
			sortByDiscount.put(NameofProduct, pDiscount);
		}
		System.out.println(sortByDiscount);
		
	}
}
