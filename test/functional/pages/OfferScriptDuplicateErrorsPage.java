package pages;

import static org.junit.Assert.*;
import driver.DriverFactory;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import cucumber.api.DataTable;

public class OfferScriptDuplicateErrorsPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorTypeObj = new LocatorType();
	ExplicitConditionType explicitObj = new ExplicitConditionType();

	public void selectProduct(DataTable enterType) {

		utility.pageLoadTimeout();
		List<List<String>> ev = enterType.raw();
		utility.enterTextBoxID("product", ev.get(1).get(1));
	}

	public void verifySearchResultProduct(DataTable verifyProductType) {
		List<List<String>> vT = verifyProductType.raw();

		int limit = getRowCountOfferScriptDuplicateErrors();

		verifyColumnOfferScriptDuplicateErrors(vT.get(1).get(1), 7,
				"product", limit);
	}
	
    public void verifyColumnOfferScriptDuplicateErrors(String value, int column, String message, int limit) {
    	
        assertTrue("No Results Found ", limit != 0);

        for (int i = 1; i <= limit; i++) {
            String result = driver
                    .findElement(
                            By.xpath("//*[@id=\"searchResultList\"]/div[3]/table/tbody/tr["
                                    + i + "]/td[" + column + "]")).getText();

            assertTrue("Results do not Match According to " + message,
                    result.equals(value));
        }
    }
    
	public int getRowCountOfferScriptDuplicateErrors() {
		utility.explicitWait(explicitObj.elementisinvisible, locatorTypeObj.cssSelector, "img[id='spinner']",null );

		List<WebElement> rows = driver
				.findElements(By
						.xpath("//*[@id=\"searchResultList\"]/div[3]/table/tbody/tr"));

		return rows.size();
	}
	
}
