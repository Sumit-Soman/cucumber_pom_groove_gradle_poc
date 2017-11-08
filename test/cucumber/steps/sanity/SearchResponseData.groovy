package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def searchResponseDataPage=new SearchResponseDataPage()
def utility = new SeleniumUtility()


Given(~/^user is on Search Response Data Page$/) { ->
    utility.openPage("//*[@id=\"megamenu\"]/li[3]","Search Response Data") 
}

When(~/^user selects product$/) { DataTable enterValues 
 	-> searchResponseDataPage.selectProduct(enterValues)
}

When(~/^user blanks Starting Date on Search Response Data Page$/) { ->
    searchResponseDataPage.clearStarDate()
}

When(~/^user clicks on search button on Search Response Data Page$/) { ->
    utility.clickSearchXpath(SeleniumUtility.ResponseSearchButtonXPath)
 }

Then(~/^user finds the required result by product on Search Response Data Page$/) { DataTable verifyProductType ->
    searchResponseDataPage.verifySearchResultProduct(verifyProductType)
}