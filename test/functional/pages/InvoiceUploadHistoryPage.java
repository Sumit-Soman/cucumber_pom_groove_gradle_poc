package pages;

import static org.junit.Assert.assertTrue;
import driver.DriverFactory;
import java.util.List;
import org.openqa.selenium.By;
import cucumber.api.DataTable;

public class InvoiceUploadHistoryPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorObj =  new LocatorType();
	
	public void enterStatus(DataTable enterValues) {
		// Clear dates

		utility.clearTextBoxData(SeleniumUtility.UploadDateFrom);

		utility.clearTextBoxData(SeleniumUtility.UploadDateTo);
		// Enter File Type
		utility.selectDropDownValue(SeleniumUtility.FileType,"0");
			
	}	

	
	public void verifyStatus(DataTable verifyValues) {
		List<List<String>> val = verifyValues.raw();
				
		int limit = utility.getRowCount("//*[contains(@class,'performanceTable searchResults form')]/tbody/tr");
		int column = utility.invoiceUploadHistoryColumn;
		
		assertTrue("No records found on Invoice upload History page.", limit!=0);
		
		for (int i = 1; i <= limit; i++) {

			String result = driver
					.findElement(
							By.xpath("//*[contains(@class,'performanceTable searchResults form')]/tbody/tr["
									+ i + "]/td[" + column + "]"))
					.getText();
			assertTrue("Results do not Match According to File Type", (result.equals(val.get(1).get(1)) || result.equals(val.get(2).get(1))));
		}
					     													
    }
			 		
}