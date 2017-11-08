package pages;

import driver.DriverFactory;
import java.util.Properties;

public class LoginPage extends DriverFactory {
	SeleniumUtility utility = new SeleniumUtility();
	LocatorType locatorTypeObj = new LocatorType();
	ExplicitConditionType explicitCondTypeobj = new ExplicitConditionType();
	
    public void login(Properties configs, String user) {

        // enter username
    	utility.enterText(locatorTypeObj.id, "username", configs.getProperty(user+".username"));
        
    	utility.enterText(locatorTypeObj.id, "password", configs.getProperty(user+".password"));
    	utility.clickElement(locatorTypeObj.xpath, "//button[contains(text(),'Login')]");
        // wait for home page
        
    }
}