package pages;

import static org.junit.Assert.assertTrue;
import driver.DriverFactory;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;

public class SearchSourcedResponseDataPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locObj = new LocatorType();
	ExplicitConditionType explicitobj = new ExplicitConditionType();


	public void selectProduct(DataTable enterType) {
		List<List<String>> eT = enterType.raw();
		enterDropDownCheckBoxSearchSourcedResponseData(eT.get(1).get(1));
	}

	public void verifySearchResultProduct(DataTable verifyProductType) {
		List<List<String>> vT = verifyProductType.raw();
		int limit = getRowCountSearchSourcedResponseData();
		verifyColumnSearchSourcedResponseData(vT.get(1).get(1), SeleniumUtility.verifyColumnNumberSearchSourcedResponseResult, "product", limit);
	}
	
	   public void enterDropDownCheckBoxSearchSourcedResponseData(String product) {
	        (new WebDriverWait(driver, 2)).until(ExpectedConditions
	                .visibilityOfElementLocated(By.xpath(SeleniumUtility.SearchSourcedResponseDataSelectProduct)));

	        utility.driver.findElement(By.xpath(SeleniumUtility.SearchSourcedResponseDataSelectProduct)).click();

	        (new WebDriverWait(driver, 2)).until(ExpectedConditions
	                .visibilityOfElementLocated(By.xpath("//span[contains(text(), '"+ product +"')]")));

	        utility.driver.findElement(By.xpath("//span[contains(text(), '"+ product +"')]")).click();
	   
	   
	        utility.driver.findElement(By.xpath(SeleniumUtility.SearchSourcedResponseDataSelectProduct)).sendKeys(Keys.ESCAPE);
	    }
	   
	    public int getRowCountSearchSourcedResponseData() {

	    	utility.explicitWait(explicitobj.elementisinvisible, locObj.cssSelector, "img[id='spinner']",null );

	        List<WebElement> rows = driver.findElements(By.xpath(SeleniumUtility.searchSourcedResponseResultXPath));
	        return rows.size();
	    }
	    
	    public void verifyColumnSearchSourcedResponseData(String value, int column, String message, int limit) {
	    	
	        assertTrue("No Results Found ", limit != 0);
	        for (int i = 1; i <= limit; i++) {
	            String result = driver
	                    .findElement(
	                            By.xpath(SeleniumUtility.searchSourcedResponseResultXPath + "["
	                                    + i + "]/td[" + column + "]")).getText();

	            assertTrue("Results do not Match According to " + message,
	                    result.equals(value));
	            
	        }
	    }
	   
}
