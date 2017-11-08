package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def searchDubHouseWorkRequestPage=new SearchDubHouseWorkRequestPage()
def utility = new SeleniumUtility()
def locatorTypeObj = new LocatorType();


Given(~/^user is on Search Dub House Job Request Page$/) {
 	-> utility.openPage("//*[@id=\"megamenu\"]/li[2]","Search Dub House Job Requests")
}

Given(~/^user enters Dub House and Creative on Search Dub House Job Request Page$/) { DataTable enterValues
 	-> searchDubHouseWorkRequestPage.enterDubHouseCreative(enterValues)
}

When(~/^user clicks on search button on Search Dub House Request Page$/) {
	-> utility.clickElement(locatorTypeObj.id, "search")

}

Then(~/^user finds the required requests by Dub House and Creative on Search Dub House Job Request Page$/) { DataTable verifyValues
	 -> searchDubHouseWorkRequestPage.verifyDubHouseCreative(verifyValues)
}