package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def searchPerformancePiPage=new SearchPerformancePiPage()
def utility = new SeleniumUtility()
def locatorTypeObj = new LocatorType();


Given(~/^user is on Search Performance PI Page$/) { ->
    utility.openPage(SeleniumUtility.MenuPerformancePI,"PI")
}

When(~/^user selects creative$/) { DataTable enterValues ->
    searchPerformancePiPage.selectPayout(enterValues)
}

When(~/^user clicks on search button on Search Performance PI Page$/) { ->
	utility.clickElement(locatorTypeObj.id, "performanceSearchBtn")
}

Then(~/^user finds the required result by creative on Search Performance PI$/) { DataTable verifyPayout ->
    searchPerformancePiPage.verifySearchResultPayouts(verifyPayout)
}