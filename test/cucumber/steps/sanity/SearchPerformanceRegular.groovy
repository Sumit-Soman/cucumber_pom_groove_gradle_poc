package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def searchPerformanceRegularPage=new SearchPerformanceRegularPage()
def utility = new SeleniumUtility()

Given(~/^user is on Search Performance Regular Page$/) { ->
    utility.openPage(SeleniumUtility.MenuPerformanceRegular,"Regular")
}

When(~/^user selects Local Date From and Loca Date To$/) { DataTable enterValues ->
    searchPerformanceRegularPage.selectLocalDates(enterValues)
}

When(~/^user clicks on search button on Search Performance Regular Page$/) { ->
    utility.clickSearchXpath("//*[@id=\"performanceResultList\"]/div/div/div/div[34]/input")
}

Then(~/^user finds the required result by Local Date From and Loca Date To on Search Performance Regular$/) { DataTable verifyDate ->
    searchPerformanceRegularPage.verifySearchResultLocalDates(verifyDate)
}