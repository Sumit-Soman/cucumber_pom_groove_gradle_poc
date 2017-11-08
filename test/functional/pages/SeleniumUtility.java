package pages;

import static org.junit.Assert.assertTrue;
import driver.DriverFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class SeleniumUtility extends DriverFactory {
	public static String MenuSearchStations;
	public static String MenuSearchMediaAssignments;
	public static String MenuSearchMediaAssignmentsQueue;
	public static String MenuCreateTapeFileRequest;
	public static String MenuSearchTapes;
	public static String MenuSearchPerformanceMediaBuyGurantee;
	public static String MenuPerformanceRegular;
	public static String selectLocalDatefrom;
	public static String selectLocalDateTo;
	public static String searchPerformanceRegularXPath;
	public static String searchResponseResultXPath;
	public static String SearchResponseDataSelectProduct;
	public static String ResponseSearchButtonXPath;
	public static String SourcedResponseSearchButtonXPath;
	public static String SearchSourcedResponseDataSelectProduct;
	public static String searchSourcedResponseResultXPath;
	public static String MenuPerformancePI;
	public static String searchPerformancePiXPath;
	public static int verifyColumnNumberSearchSourcedResponseResult;
	public static int verifyColumnNumberPerformancePiResult;
	public static String MenuSearchPerformanceMediaBuyGuranteeLink;
	public static String MenuSearchMediaBuyRegular;
	public static String MenuSearchMediaBuyRegularLink;
	public static String MenuSearchMediaBuyPILink;
	public static String MenuSearchMediaBuyGuaranteeLink;
	public static String SearchPaymentRequestXpath;
	public static String SearchPaymentRequestLink;
	public static String SearchPayoutXpath;
	public static String SearchPayoutLink;
	public static boolean Internal;
	public static int PageLoadTimeout = 20;

	public static String MenuInvoiceUploadHistory;
	public static String MenuInvoiceUploadHistoryLink;
    public static int invoiceUploadHistoryColumn;
    public static String UploadDateFrom;
	public static String UploadDateTo;
	public static String FileType;
	public static String invoiceUploadHistorySearch;
	ExplicitConditionType explicitCondTypeobj = new ExplicitConditionType();
	LocatorType locatorObj = new LocatorType();
	public Boolean stepStatus=false;
	public WebElement testElement=null;
	
	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void setXpath(boolean Internal) {

		if (Internal) {
			MenuSearchStations = "//*[@id=\"megamenu\"]/li[1]";
			MenuSearchMediaAssignments = "//*[@id=\"megamenu\"]/li[2]";
			MenuSearchMediaAssignmentsQueue = "//*[@id=\"megamenu\"]/li[2]";
			MenuCreateTapeFileRequest = "//*[@id=\"megamenu\"]/li[2]";
			MenuSearchTapes = "//*[@id=\"megamenu\"]/li[2]";
			MenuPerformanceRegular = "//*[@id=\"megamenu\"]/li[4]";
			selectLocalDatefrom = "//*[@id=\"performanceResultList\"]/div/div/div/div[14]/div/input";
			selectLocalDateTo = "//*[@id=\"performanceResultList\"]/div/div/div/div[15]/div/input";
			searchPerformanceRegularXPath = "//*[@id=\"pageBody\"]/div/div/div/div[1]/div[2]/div[8]/div/div[2]/div[2]/table/tbody/tr";
			searchResponseResultXPath = "//*[@id=\"searchResultList\"]/div[2]/div[4]/table/tbody/tr";
			SearchResponseDataSelectProduct = "//*[@id=\"searchResponseData\"]/div/div[4]/button";
			SearchSourcedResponseDataSelectProduct = "//*[@id=\"pageBody\"]/div[2]/form/div/div/div/div/div[4]/button";
			ResponseSearchButtonXPath = "//*[@id=\"searchResponseData\"]/div/div[16]/input";
			SourcedResponseSearchButtonXPath = "//*[@id=\"pageBody\"]/div[2]/form/div/div/div/div/div[18]/div/input";
			searchSourcedResponseResultXPath = "//*[@id=\"searchResultList\"]/div[5]/div[2]/table/tbody/tr";
			searchPerformancePiXPath = "//*[@id=\"performanceResultList\"]/div[1]/div[2]/div/table/tbody/tr";
			MenuPerformancePI = "//*[@id=\"megamenu\"]/li[4]";
			verifyColumnNumberSearchSourcedResponseResult = 5;
			verifyColumnNumberPerformancePiResult = 7;
			MenuSearchPerformanceMediaBuyGurantee = "//*[@id=\"megamenu\"]/li[4]";
			MenuSearchMediaBuyRegular = "//*[@id=\"megamenu\"]/li[4]";
			MenuSearchMediaBuyRegularLink = "//*[@id=\"megamenu\"]/li[4]/div/table/tbody/tr[8]/td[1]/a";
			MenuSearchMediaBuyPILink = "//*[@id=\"megamenu\"]/li[4]/div/table/tbody/tr[8]/td[2]/a";
			MenuSearchPerformanceMediaBuyGuranteeLink = "//*[@id=\"megamenu\"]/li[4]/div/table/tbody/tr[3]/td/a";
			MenuSearchMediaBuyGuaranteeLink = "//*[@id=\"megamenu\"]/li[4]/div/table/tbody/tr[9]/td[1]/a";
			SearchPaymentRequestXpath = "//*[@id=\"megamenu\"]/li[5]";
			SearchPaymentRequestLink = "Search Payments";
			SearchPayoutXpath = "//*[@id=\"megamenu\"]/li[5]";
			SearchPayoutLink = "Search Payouts";

			MenuInvoiceUploadHistory = "//*[@id=\"megamenu\"]/li[5]";
			MenuInvoiceUploadHistoryLink ="//*[@id='megamenu']/li[5]/div/table/tbody/tr[4]/td[2]/a";
			invoiceUploadHistoryColumn = 5;
			UploadDateFrom = "//*[contains(@class,'searchFormBox')]/div[2]/div/input";
			UploadDateTo = "//*[contains(@class,'searchFormBox')]/div[3]/div/input";
			FileType = "//*[contains(@class,'searchFormBox')]/div[4]/select";
			invoiceUploadHistorySearch = "//*[contains(@class,'searchFormBox')]/div[5]/input";
			

		} else {
			MenuSearchStations = "//*[@id=\"megamenu\"]/li[2]";
			MenuSearchMediaAssignments = "//*[@id=\"megamenu\"]/li";
			MenuSearchMediaAssignmentsQueue = "//*[@id=\"megamenu\"]/li";
			MenuCreateTapeFileRequest = "//*[@id=\"megamenu\"]/li[4]";
			MenuSearchTapes = "//*[@id=\"megamenu\"]/li[4]";
			MenuSearchPerformanceMediaBuyGurantee = "//*[@id=\"megamenu\"]/li[5]";
			MenuSearchMediaBuyRegular = "//*[@id=\"megamenu\"]/li[5]";
			MenuSearchMediaBuyRegularLink = "//*[@id=\"megamenu\"]/li[5]/div/table/tbody/tr[5]/td[1]/a";
			MenuSearchMediaBuyPILink = "//*[@id=\"megamenu\"]/li[5]/div/table/tbody/tr[5]/td[2]/a";
			MenuSearchPerformanceMediaBuyGuranteeLink = "//*[@id=\"megamenu\"]/li[5]/div/table/tbody/tr[3]/td/a";
			MenuSearchMediaBuyGuaranteeLink = "//*[@id=\"megamenu\"]/li[5]/div/table/tbody/tr[6]/td/a";
			SearchPaymentRequestXpath = "//*[@id=\"megamenu\"]/li[6]";
			SearchPaymentRequestLink = "Search Payment Requests";
			// ////////////////////////////
			MenuPerformanceRegular = "//*[@id=\"megamenu\"]/li[5]";
			selectLocalDatefrom = "//*[@id=\"performanceResultList\"]/div/div/div/div[13]/div/input";
			selectLocalDateTo = "//*[@id=\"performanceResultList\"]/div/div/div/div[14]/div/input";
			searchPerformanceRegularXPath = "//*[@id=\"pageBody\"]/div/div/div[2]/div[8]/div/div[2]/div[2]/table/tbody/tr";
			searchResponseResultXPath = "//*[@id=\"searchResultList\"]/div[2]/div[4]/table/tbody/tr";
			SearchResponseDataSelectProduct = "//*[@id=\"searchResponseData\"]/div/div/div[4]/button";
			SearchSourcedResponseDataSelectProduct = "//*[@id=\"pageBody\"]/div[2]/form/div/div/div/div/div[4]/button";
			ResponseSearchButtonXPath = "//*[@id=\"searchResponseData\"]/div/div[5]/div[4]/input";
			SourcedResponseSearchButtonXPath = "//*[@id=\"pageBody\"]/div[2]/form/div/div/div/div/div[18]/div/input";
			searchSourcedResponseResultXPath = "//*[@id=\"searchResultList\"]/div[5]/div[2]/table/tbody/tr";
			searchPerformancePiXPath = "//*[@id=\"performanceResultList\"]/div[1]/div[2]/div/table/tbody/tr";
			MenuPerformancePI = "//*[@id=\"megamenu\"]/li[5]";
			verifyColumnNumberSearchSourcedResponseResult = 4;
			verifyColumnNumberPerformancePiResult = 6;
			SearchPayoutXpath = "//*[@id=\"megamenu\"]/li[6]";
			SearchPayoutLink = "Search Payout";

			MenuInvoiceUploadHistory = "//*[@id=\"megamenu\"]/li[6]";
			MenuInvoiceUploadHistoryLink ="//*[@id='megamenu']/li[6]/div/table/tbody/tr[3]/td/a";
			invoiceUploadHistoryColumn = 4;
			UploadDateFrom = "//*[contains(@class,'searchFormBox')]/div[1]/div/input";
			UploadDateTo = "//*[contains(@class,'searchFormBox')]/div[2]/div/input";
			FileType = "//*[contains(@class,'searchFormBox')]/div[3]/select";
			invoiceUploadHistorySearch = "//*[contains(@class,'searchFormBox')]/div[4]/input";

		}
	}

	
	public void enterDropDownID(String id, String visibleText) {
		explicitWait(explicitCondTypeobj.elementisvisible, locatorObj.id, id, null);

		WebElement w = driver.findElement(By.id(id));
		Select drop1 = new Select(w);
		drop1.selectByVisibleText(visibleText);
	}
	
	public void selectValueFromDD(int locatorType, String locator, String visibleText) {
		explicitWait(explicitCondTypeobj.elementisvisible, locatorType, locator, null);

		testElement = driver.findElement(byLocator(locatorType, locator));
		Select dd = new Select(testElement);
		dd.selectByVisibleText(visibleText);
		
	}
	//temp
	public void enterDropDownXpath(String xpath, String visibleText) {
		explicitWait(explicitCondTypeobj.elementisvisible, locatorObj.xpath, xpath, null);

		WebElement w = driver.findElement(By.xpath(xpath));
		Select drop1 = new Select(w);
		drop1.selectByVisibleText(visibleText);
	}
	

	public void enterDropDownCheckBox(String xpathLocation, String xpathOption) {
		explicitWait(explicitCondTypeobj.elementisvisible, locatorObj.xpath, xpathLocation, null);

		driver.findElement(By.xpath(xpathLocation)).click();

		(new WebDriverWait(driver, 20)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(xpathOption)));

		driver.findElement(By.xpath(xpathOption)).click();

		driver.findElement(By.xpath(xpathOption)).sendKeys(Keys.ESCAPE);
	}

	public void enterTextBoxIDEsc(String id, String value) {
		explicitWait(explicitCondTypeobj.elementisvisible, locatorObj.id, id, null);

		WebElement w = driver.findElement(By.id(id));
		sleep(1000);
		w.clear();
		sleep(1000);
		w.sendKeys(value);
		sleep(1000);
		w.sendKeys(Keys.ESCAPE);
	}
	
	public void enterTextBoxID(String id, String value) {
		explicitWait(explicitCondTypeobj.elementisvisible, locatorObj.id, id, null);
		
		WebElement w = driver.findElement(By.id(id));
		w.clear();
		w.sendKeys(value);
		sleep(2000);

		w.sendKeys(Keys.ARROW_DOWN);
		w.sendKeys(Keys.ENTER);
	}
	/*
	 * Description: Function id used in case when the text box is behaving abruptly.
	 * 
	 * */
	public void enterTextAuto(int locatorType,String locator ,String value) {
		explicitWait(explicitCondTypeobj.elementisvisible,locatorType,locator,null);

		testElement = driver.findElement(byLocator(locatorType, locator));
		testElement.clear();
		testElement.sendKeys(value);
		sleep(2000);
		testElement.sendKeys(Keys.ARROW_DOWN);
		testElement.sendKeys(Keys.ENTER);
	}
	
	public void enterTextBoxIDPerformance(String xPath, String value) {
		explicitWait(explicitCondTypeobj.elementisvisible, locatorObj.xpath, xPath , null);
		
		WebElement w = driver.findElement(By.xpath(xPath));
		w.clear();
		w.sendKeys(value);

		sleep(2000);

		w.sendKeys(Keys.ARROW_DOWN);
		w.sendKeys(Keys.ENTER);
	}

	public void verifyColumn(String value, int column, String message,
			int limit, String pageName) {
		
		assertTrue("No Results Found ", limit != 0);
		String result=null;
		for (int i = 1; i <= limit; i++) {
			result = driver
					.findElement(
							By.xpath("//*[@id=\"searchResultList\"]/div[2]/table/tbody/tr["
									+ i + "]/td[" + column + "]")).getText();

			 assertTrue("Results do not Match According to " + message,
			 result.equals(value));
		}
	}

	public void verifyColumnSearchMediaBuy(String value, int column,
			String message, int limit, String pageName) {
		
		String result=null;
		if (SeleniumUtility.Internal) {
			for (int i = 1; i <= limit; i++) {

				result = driver
						.findElement(
								By.xpath("//*[@id=\"searchResultList\"]/div[4]/div[2]/table/tbody/tr["
										+ i + "]/td[" + column + "]"))
						.getText();

				 assertTrue("Results do not Match According to " + message,
				 result.equals(value));
			}
		} else {
			for (int i = 1; i <= limit; i++) {

				result = driver
						.findElement(
								By.xpath("//*[@id=\"searchResultList\"]/div[3]/div[2]/table/tbody/tr["
										+ i + "]/td[" + column + "]"))
						.getText();
				 assertTrue("Results do not Match According to " + message,
				 result.equals(value));
			}
		}
	}

	public void verifyColumnPartial(String value, int column, String message,
			int limit, String pageName) {

		 assertTrue("No Results Found ", limit != 0);
		for (int i = 1; i <= limit; i++) {
			String result = driver
					.findElement(
							By.xpath("//*[@id=\"searchResultList\"]/div[2]/table/tbody/tr["
									+ i + "]/td[" + column + "]")).getText();
			 assertTrue("Results do not Match According to " + message,
			 result.contains(value));
		}
	}

	public void verifyToolTipColumn(String value, int column, String message) {
		int limit = getRowCount();
		for (int i = 0; i < limit; i++) {
			String result = driver.findElement(
					By.xpath("//*[@id=\"" + i + "\"]/td[" + column + "]"))
					.getText();
			assertTrue("Results do not Match According to " + message,
					result.equals(value));
		}
	}

	public void openPage(String xpathMenu, String linkText) {
		pageLoadTimeout();

		Actions a1 = new Actions(driver);
	    explicitWait(explicitCondTypeobj.elementisvisible, locatorObj.xpath, xpathMenu, null);

		a1.moveToElement(driver.findElement(By.xpath(xpathMenu))).build()
				.perform();
		clickElement(locatorObj.link, linkText);
	}

	public void openPageXpath(String xpathMenu, String xpathLink) {
		pageLoadTimeout();

		Actions a1 = new Actions(driver);
		explicitWait(explicitCondTypeobj.elementisvisible, locatorObj.xpath, xpathMenu, null);

		a1.moveToElement(driver.findElement(By.xpath(xpathMenu))).build()
				.perform();

		clickElement(locatorObj.xpath, xpathLink);
	}
	
	/*
     * Description: Click Element
     * 
     * */
	public void clickElement(int locatorType, String locator){
		explicitWait(explicitCondTypeobj.elementispresent,locatorType,locator,null);
		driver.findElement(byLocator(locatorType, locator)).click();
	}
	
	
	/*
     * Description: Apply Explicit Wait depending on Condition
     * 
     * */
	public void explicitWait(int condition, int locatorType, String locator, String input){
		switch (condition){
			case 1:
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(byLocator(locatorType, locator)));
				break;
			case 2:
				wait.until(ExpectedConditions
					.presenceOfElementLocated(byLocator(locatorType, locator)));
				break;
			case 3:
				break;
			case 4:
				wait.until(ExpectedConditions
					.invisibilityOfElementLocated(byLocator(locatorType, locator)));
				break;
			case 5:
				wait.until(ExpectedConditions.elementToBeClickable(byLocator(
					locatorType, locator )));
				break;
			case 6:
				wait.until(ExpectedConditions.elementToBeSelected(byLocator(
					locatorType, locator )));
				break;
			case 7:
				stepStatus=wait.until(ExpectedConditions.textToBePresentInElementLocated(
					byLocator(locatorType, locator), input));
				break;
		    case 8:
				wait.until(ExpectedConditions.titleContains(input));
				break;
			case 9:
				wait.until(ExpectedConditions.alertIsPresent());
				break;
		    case 10:
				wait.until(ExpectedConditions
					.presenceOfAllElementsLocatedBy(byLocator(
						locatorType, locator)));
				break;
			case 11:
				wait.until(ExpectedConditions
					.visibilityOfAllElementsLocatedBy(byLocator(
						locatorType, locator)));
				break;
			case 12:
				wait.until(ExpectedConditions.not(ExpectedConditions
					.presenceOfElementLocated(byLocator(locatorType, locator))));
				break;
			case 13:
				wait.until(ExpectedConditions.not(ExpectedConditions
					.visibilityOfElementLocated(byLocator(locatorType, locator))));
				break;
			case 14:
				wait.until(ExpectedConditions.not(ExpectedConditions
					.invisibilityOfElementLocated(byLocator(locatorType, locator))));
				break;
			case 15:
				wait.until(ExpectedConditions.not(ExpectedConditions
					.elementToBeClickable(byLocator(locatorType, locator
						))));
				break;
			case 16:
				wait.until(ExpectedConditions.not(ExpectedConditions
					.presenceOfAllElementsLocatedBy(byLocator(
						locatorType, locator ))));
				break;
			case 17:
				wait.until(ExpectedConditions.not(ExpectedConditions
					.visibilityOfAllElementsLocatedBy(byLocator(
						locatorType, locator ))));
				break;
				
			}
	}
	
	
	/*
     * Description: Return By element
     * 
     * */
	public By byLocator(int locatorType, String locator){
		
		By by = null;
		switch (locatorType) {
		    default:
		    	break;
		    case 1:
		    	by = By.id(locator);
		    	break;
		    case 2:
		    	by = By.name(locator);
		    	break;
		    case 3:
		    	by = By.className(locator);
		    	break;
		    case 4:
		    	by = By.cssSelector(locator);
				break;
		    case 5:
		    	by = By.xpath(locator);
				break;
		    case 6:
				by = By.linkText(locator);
				break;
			}
		return by;
	}
	
	public void clickSearchXpath(String xpath) {
		try {
			clickElement(locatorObj.xpath, xpath);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickSearchClassName(String sclassname) {
		clickElement(locatorObj.classtype, sclassname);
	}

	public void verifyStatus(int limit) {

		String odd = "odd edit", even = "even edit";
		assertTrue("No Results Found ", limit != 0);

		for (int i = 1; i <= limit; i++) {
			WebElement w = driver
					.findElement(By
							.xpath("//*[@id=\"searchResultList\"]/div[2]/table/tbody/tr["
									+ i + "]"));
			String result = w.getAttribute("class");
			assertTrue("Results do not Match According to Status",
					(result.equals(odd) || result.equals(even)));
		}
	}
	
	public int getRowCount(int locatorType, String locator){
		explicitWait(explicitCondTypeobj.elementisinvisible, locatorObj.cssSelector, "img[id='spinner']",null );
		
		List<WebElement> rows = driver.findElements(byLocator(locatorType, locator));

		return rows.size();

	}
	
	public int getRowCount() {
		explicitWait(explicitCondTypeobj.elementisinvisible, locatorObj.cssSelector, "img[id='spinner']",null );
		List<WebElement> rows = driver.findElements(By
				.xpath("//*[@id=\"searchResultList\"]/div[2]/table/tbody/tr"));

		return rows.size();
	}

	public int getRowCountSearchMediaBuy() {
		explicitWait(explicitCondTypeobj.elementisinvisible, locatorObj.cssSelector, "img[id='spinner']",null );

		List<WebElement> rows;
		if (SeleniumUtility.Internal) {
			rows = driver
					.findElements(By
							.xpath("//*[@id=\"searchResultList\"]/div[4]/div[2]/table/tbody/tr"));
		} else {
			rows = driver
					.findElements(By
							.xpath("//*[@id=\"searchResultList\"]/div[3]/div[2]/table/tbody/tr"));
		}

		return rows.size();
	}

	public void verifyPageID(String id, String message, String pageName) {
		pageLoadTimeout();
		explicitWait(explicitCondTypeobj.elementispresent, locatorObj.id, id,null );

		assertTrue(message + " Page is not Displayed", isDisplayed(locatorObj.id,id));
	}

	public void verifyPageXpath(String xpath, String message) {
		explicitWait(explicitCondTypeobj.elementispresent, locatorObj.xpath, xpath,null );

		assertTrue(message + " Page is not Displayed",
				isDisplayed(locatorObj.xpath,xpath));
	}

	public void logOut(){
		driver.findElement(By.linkText("Logout")).click();
		DriverFactory.tearDown();
	}

	public void clearTextBoxData(String xpath) {
		explicitWait(explicitCondTypeobj.elementispresent, locatorObj.xpath, xpath,null );

        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
        sleep(2000);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
    }
    
    public void selectDropDownValue(String xpath, String value) {
        explicitWait(explicitCondTypeobj.elementispresent, locatorObj.xpath, xpath, null);
        WebElement w = driver.findElement(By.xpath(xpath));
        Select drop1 = new Select(w);
        drop1.selectByValue(value);
    }
    
    public int getRowCount(String xpath) {
    	explicitWait(explicitCondTypeobj.elementisinvisible, locatorObj.xpath, "img[id='spinner']", null);
        List<WebElement> rows = driver.findElements(By.xpath(xpath));
        return rows.size();
}
    
    /*
     * Description: Return attribute value for the element
     * 
     * */
    public String getAttribute(int locatorType, String locator, String attribute){
    	explicitWait(explicitCondTypeobj.elementispresent, locatorType, locator, null);
    	return driver.findElement(byLocator(locatorType, locator)).getAttribute(attribute);
    }
    
    
    /*
     * Description: Return text on the page for respective locator
     * 
     * */
    public String  getText(int locatorType, String locator) {
    	explicitWait(explicitCondTypeobj.elementispresent, locatorType, locator, null);
		return driver.findElement(byLocator(locatorType, locator)).getText();
	}
    
    /*
     *Description: Enter Text in Element
     * 
     * */
    public void enterText(int locatorType, String locator, String text){
    	explicitWait(explicitCondTypeobj.elementispresent, locatorType, locator, null);
    	testElement=driver.findElement(byLocator(locatorType, locator));
    	testElement.clear();
    	testElement.sendKeys(text);
    }
    
   
    /*
     * Description: Handling Window dialog Module 
     * 
     * */
    public void handleWindowAlert(){
    	 Alert alert = driver.switchTo().alert();
         alert.accept();
    }
    
    /*
     * Decription: Apply pageLoadTimeout check
     * 
     * */
    public void pageLoadTimeout(){
    	driver.manage().timeouts()
		.pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS);
    }
    
     
    /*
     * Description: Return True when element is Displayed on page
     * else Return False
     * */
    public boolean isDisplayed(int locatorType, String locator){
    	pageLoadTimeout();
    	try{
    		explicitWait(explicitCondTypeobj.elementisvisible, locatorType, locator, null);
    		return true;
    	}catch(Exception e){
    		return false;
    	}
    }
    
    public boolean errorDisplayed(int locatorType, String locator){
    	pageLoadTimeout();
    	try{
    		explicitWait(explicitCondTypeobj.elementisvisible, locatorType, locator, null);
    		return true;
    	}catch(Exception e){
    		return false;
    	}
    }
    
    public void clearText(int locatorType, String locator){
    	pageLoadTimeout();
    	explicitWait(explicitCondTypeobj.elementisvisible, locatorType, locator, null);
    	driver.findElement(byLocator(locatorType, locator)).clear();
    }
    
    public void sendKeys(int locatorType, String locator, String keyType){
    	driver.findElement(byLocator(locatorType, locator)).sendKeys(keyType);
    }

}
