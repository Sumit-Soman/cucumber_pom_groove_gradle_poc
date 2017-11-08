package pages;

import static org.junit.Assert.*;
import driver.DriverFactory;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;


public class SearchPerformancePiPage extends DriverFactory {

	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorTypeObj = new LocatorType();
	ExplicitConditionType explicitObj = new ExplicitConditionType();


	public void selectPayout(DataTable enterValues) {
		List<List<String>> eV = enterValues.raw();
		
		utility.enterTextBoxIDEsc("pscvrlmts", eV.get(1).get(1));
		
	}

	public void verifySearchResultPayouts(DataTable verifyPayout) {
		
		
		List<List<String>> vP = verifyPayout.raw();
	
		int limit = getRowCountPerformancePiResultSearch();
	
		verifyColumnSearchPerformancePiResult(vP.get(1).get(1), SeleniumUtility.verifyColumnNumberPerformancePiResult, "product", limit);
	}
    
    public int getRowCountPerformancePiResultSearch() {
    	
    	utility.explicitWait(explicitObj.elementisinvisible, locatorTypeObj.cssSelector, "img[id='spinner']",null );
        List<WebElement> rows = driver.findElements(By.xpath(SeleniumUtility.searchPerformancePiXPath));
        return rows.size();
    }
    

    
    public void verifyColumnSearchPerformancePiResult(String value, int column, String message, int limit) {
    	
        assertTrue("No Results Found ", limit != 0);

        for (int i = 1; i < limit; i++) {
            String result = driver
                    .findElement(
                            By.xpath(SeleniumUtility.searchPerformancePiXPath +"["
                                    + i + "]/td[" + column + "]")).getText();
            assertTrue("Results do not Match According to " + message,
                    result.equals(value));
          
        }
    } 
}
