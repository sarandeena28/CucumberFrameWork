package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static  ChromeDriver driver;
	public static WebDriverWait wait;
	public static Actions builder;
	public Set<String> windowHandles;
	public List<String> windowOpens; 
	public  JavascriptExecutor js;

}
