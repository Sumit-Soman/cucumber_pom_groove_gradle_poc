package steps

import static org.junit.Assert.assertTrue;

import java.beans.PropertyChangeEvent;
import java.io.File;

import javax.servlet.jsp.PageContext;

import cucumber.api.DataTable;
import junit.framework.Assert;
import static cucumber.api.groovy.EN.*
import pages.*;
import util.Property;

def utility = new SeleniumUtility()
def locatorObj = new LocatorType()
def searchFilterDNISCallCenterPageobj = new pages.SearchFilterDNISCallCenterPage()


Given(~/^user is on DNISCallCenter Search Page$/) {
-> utility.openPage("//ul[@class='megamenu']/li[1]","DNIS / Call Centers")
}

Then(~/^verify Pagination is present on the Search DNISCallCenter Page$/) {
	-> def boolean status =utility.isDisplayed(locatorObj.classtype, "paginateButtons")
	   assertTrue("Pagination not found on Search Creative Page.", status==true)
}

When(~/^user click on Next button of Pagination on the Search DNISCallCenter Page$/){
	-> utility.clickElement(locatorObj.classtype, "nextLink")
}

Then(~/^user is navigated to next set of DNISCallCenter records$/){
	-> 	utility.pageLoadTimeout()
		utility.sleep(2000)
		def String pageCount = utility.getText(locatorObj.classtype, "currentStep")
		assertTrue("Pagination is not working on Search DNIS/Offer Page.", pageCount.equalsIgnoreCase("2"))
}

//Export to Excel

When(~/^user click on Export to excel link on Search DNISCallCenter Page$/){
	-> utility.pageLoadTimeout()
	   utility.clickElement(locatorObj.classtype, "exportToExcel_Btn");
}

Then(~/^DNISCallCenter excel report is saved on local machine$/){
	-> File file = new File(Property.exportExcelPath + "DNISCallCenter.xls");
	   assertTrue("Failed to Download Excel", file.exists());
}

Then(~/^verify the DNISCallCenter records count in excel$/){
	-> searchFilterDNISCallCenterPageobj.verifyExcelCount()
}

// Search Functionality

When(~/^user enters Call Center, DNIS Group and Media Type$/){ DataTable values
	-> searchFilterDNISCallCenterPageobj.fillSearchForm(values)
}

When(~/^user clicks on Search button on DNIS Call Center Page$/){
	-> utility.clickElement(locatorObj.classtype, "cta_button ")
}

Then(~/^required DNIS Call Center records are populated on the page$/){ DataTable values
	-> searchFilterDNISCallCenterPageobj.verifyRecords(values)
}

