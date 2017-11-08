package steps.sanity

import static cucumber.api.groovy.EN.*;
import pages.*;
import cucumber.api.DataTable;

def searchVendorPage=new SearchVendorPage()
def utility = new SeleniumUtility()

Given(~/^user is on Search Vendor Page$/) {
	 -> utility.openPage("//ul[@class='megamenu']/li[1]","Vendors")
}

Given(~/^user enters Vendor Type on Search Vendor Page$/) { DataTable enterType
 	 -> searchVendorPage.enterVendorType(enterType)
}

When(~/^the user clicks on search button on Search Vendor Page$/) { 
	 -> utility.clickSearchXpath("//*[@id=\"pageBody\"]/div[2]/form/div[1]/div/div/div[12]/input")

}

Then(~/^user finds the required Vendor by Full Name and Vendor Type on Search Vendor Page$/) { DataTable verifyVendorType 
 	 -> searchVendorPage.verifySearchResultVendorType(verifyVendorType)
}