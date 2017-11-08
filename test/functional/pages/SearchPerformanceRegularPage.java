package pages;

import static org.junit.Assert.*;
import driver.DriverFactory;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import cucumber.api.DataTable;


public class SearchPerformanceRegularPage extends DriverFactory {

	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorTypeObj = new LocatorType();
	ExplicitConditionType explicitObj = new ExplicitConditionType();



	public void selectLocalDates(DataTable enterValues) {
		List<List<String>> eV = enterValues.raw();
		utility.enterTextBoxIDPerformance(SeleniumUtility.selectLocalDatefrom,eV.get(1).get(1));
		utility.enterTextBoxIDPerformance(SeleniumUtility.selectLocalDateTo,eV.get(2).get(1));
	}

	public void verifySearchResultLocalDates(DataTable verifyDate) {
		List<List<String>> vD = verifyDate.raw();
	//	int limit = utility.getRowCountPerformanceSearch();
		int limit = getRowCountPerformanceSearch();
	//	utility.verifyColumnSearchPerformance(vD.get(1).get(1), 6, "product", limit);
		verifyColumnSearchPerformance(vD.get(1).get(1), 6, "product", limit);
	}
	
    public int getRowCountPerformanceSearch() {
    	
    	utility.explicitWait(explicitObj.elementisinvisible, locatorTypeObj.cssSelector, "img[id='spinner']",null );
    	List<WebElement> rows = driver.findElements(By.xpath(SeleniumUtility.searchPerformanceRegularXPath));
        return rows.size();

    }
    
    public void verifyColumnSearchPerformance(String value, int column, String message, int limit) {
    	
        assertTrue("No Results Found ", limit != 0);

        for (int i = 1; i < limit; i++) {
            String result = driver
                    .findElement(
                            By.xpath(SeleniumUtility.searchPerformanceRegularXPath +"["
                                    + i + "]/td[" + column + "]")).getText();

           assertTrue("Results do not Match According to " + message,
                   result.equals(value));
          
        }
    } 
}
