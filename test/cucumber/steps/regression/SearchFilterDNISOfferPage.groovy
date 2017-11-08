package steps

import static org.junit.Assert.assertTrue;

import java.beans.PropertyChangeEvent;

import javax.servlet.jsp.PageContext;

import cucumber.api.DataTable;
import junit.framework.Assert;
import static cucumber.api.groovy.EN.*
import pages.*;

def utility = new SeleniumUtility()
def locatorObj = new LocatorType()
def searchFilterDNISOfferPage = new pages.SearchFilterDNISOfferPage()


Given(~/^user is on DNISOffer Search Page$/) { 
-> utility.openPage("//ul[@class='megamenu']/li[1]","DNIS / Offers")
}

Then(~/^verify Pagination is present on the Search DNISOffer Page$/) {
	-> def boolean status =utility.isDisplayed(locatorObj.classtype, "paginateButtons")
	   assertTrue("Pagination not found on Search Creative Page.", status==true)
}

When(~/^user click on Next button of Pagination on the Search DNISOffer Page$/){
	-> utility.clickElement(locatorObj.classtype, "nextLink")
}

Then(~/^user is navigated to next set of records$/){
	-> 	utility.pageLoadTimeout()
		utility.sleep(2000)
		def String pageCount = utility.getText(locatorObj.classtype, "currentStep")
		assertTrue("Pagination is not working on Search DNIS/Offer Page.", pageCount.equalsIgnoreCase("2"))
}

//Export to Excel

When(~/^user click on Export to excel link on Search DNISOffer Page$/){
	-> searchFilterDNISOfferPage.exportToExcel()
}

Then(~/^DNISOffer excel report is saved on local machine$/){
	-> searchFilterDNISOfferPage.verifyCreativeFile()
}

Then(~/^verify the DNISOffer count in excel$/){
	-> searchFilterDNISOfferPage.verifyExcelCount()
}

// Search Functionality

When(~/^user enters DNIS Group and Offer Type$/){ DataTable values
	-> searchFilterDNISOfferPage.fillSearchForm(values)
}

When(~/^user clicks on Search button$/){
	-> utility.clickElement(locatorObj.classtype, "cta_button ")
}

Then(~/^required DNIS Group records are populated on the page$/){ DataTable values
	-> searchFilterDNISOfferPage.verifyRecords(values)
}

