package steps

import static cucumber.api.groovy.EN.*;

import java.beans.PropertyChangeEvent;

import pages.*;
import cucumber.api.DataTable;
import static org.junit.Assert.assertTrue;

def createEditVendorPage = new pages.CreateEditVendorPage()
def utility = new SeleniumUtility()
def locatorTypeObj = new LocatorType();
def explicitObj = new ExplicitConditionType();


Given(~/^user is on Search Vendor Page.$/) {
	-> utility.openPage("//ul[@class='megamenu']/li[1]","Vendors")
}

Given(~/^user navigates to Create Vendor Page$/) {
	-> utility.clickElement(locatorTypeObj.classtype, "customButton")
}

When(~/^user fills the search form and click on search button$/) { DataTable values
	->  while (true){
		createEditVendorPage.searchExistingAgencyVendor(values)
		
		if(utility.getText(locatorTypeObj.classtype, "listCount").equalsIgnoreCase("No Vendor Record(s) found")) break
	}
}

When(~/^user fill the vendor details and clicks on Save button$/) { DataTable values
	->  createEditVendorPage.fillCreateVendorForm(values)
		createEditVendorPage.clickSave()
}

Then(~/^user is moved to Vendor Details tab$/) {
	-> utility.isDisplayed(locatorTypeObj.id, "vendorDetailsTab")
}

Given(~/^user moves to Permission and Translation Tab$/) {
	-> utility.clickElement(locatorTypeObj.id, "permissionTab")
	utility.clickElement(locatorTypeObj.id, "createPermission")
	
}

Then(~/^user add Permission and Translation details$/) { DataTable values
	-> createEditVendorPage.addPermission(values)
	assertTrue("Adding Permission to vendor Failed.", utility.getText(locatorTypeObj.classtype, "success").contains("successfully"))
}


Given(~/^user moves to Contact Tab and clicks on Create Contact button$/) {
	-> utility.clickElement(locatorTypeObj.id, "contactsTab")
	utility.clickElement(locatorTypeObj.id, "createContact")
	
}

Then(~/^user add Contact details$/) { DataTable values
	-> createEditVendorPage.addContact(values)
	utility.explicitWait(explicitObj.elementisinvisible, locatorTypeObj.cssSelector, "img[id='spinner']",null );
	assertTrue("Adding Contact to vendor Failed.", utility.getText(locatorTypeObj.classtype, "success").contains("successfully"))
}


Given(~/^user moves to Vendor Tab$/) {
	-> utility.clickElement(locatorTypeObj.id, "vendorDetailsTab")
}


When(~/^user clicks on Edit button$/) { 
	-> utility.clickElement(locatorTypeObj.name, "_action_edit")
}

When(~/^user select Guarantee Buy Type and click the save button$/) { 
	-> utility.clickElement(locatorTypeObj.cssSelector, "input[value='GURANTEE']")
	utility.clickElement(locatorTypeObj.name, "_action_update")
}


When(~/^Vendor is saved successfully$/) { 
	-> def status = utility.getText(locatorTypeObj.classtype, "success")
	assertTrue("Unable to update the Vendor. ", status.equalsIgnoreCase("Vendor Successfully Updated."))
}
