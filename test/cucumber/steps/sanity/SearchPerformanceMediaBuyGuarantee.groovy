package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def searchPerformanceMediaBuyGuaranteePage=new SearchPerformanceMediaBuyGuaranteePage()
def utility = new SeleniumUtility()
def locatorTypeObj = new LocatorType();

Given(~/^user is on Search Performance Media Buy-Guarantee-TV Page$/) { 
 -> utility.openPageXpath(SeleniumUtility.MenuSearchPerformanceMediaBuyGurantee,SeleniumUtility.MenuSearchPerformanceMediaBuyGuranteeLink)
}

Given(~/^user enters Media Type, Station Type, Creative and Region on Search Performance Media Buy-Guarantee-TV Page$/) { DataTable enterValues
 -> searchPerformanceMediaBuyGuaranteePage.enterMediaTypeStationTypeCreativeRegion(enterValues)
}

When(~/^user clicks on search button on Search Performance Media Buy-Guarantee-TV Page$/) { 
 -> utility.clickElement(locatorTypeObj.id, "performanceSearchBtn")
}

Then(~/^user finds the required results by Media Type, Station Type, Creative and Region on Search Performance Media Buy-Guarantee-TV Page$/) { DataTable verifyValues
 -> searchPerformanceMediaBuyGuaranteePage.verifyMediaTypeStationTypeCreativeRegion(verifyValues)
}