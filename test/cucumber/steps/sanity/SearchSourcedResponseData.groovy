package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def searchSourcedResponseDatapage=new SearchSourcedResponseDataPage()
def utility = new SeleniumUtility()


Given(~/^user is on Search Sourced Response Data Page$/) { ->
    utility.openPage("//*[@id=\"megamenu\"]/li[3]","Search Sourced Response Data") 
}

When(~/^user selects Product$/) { DataTable enterValues 
 	-> searchSourcedResponseDatapage.selectProduct(enterValues)
}

When(~/^user clicks on search button on Search Sourced Response Data Page$/) { ->
    utility.clickSearchXpath(SeleniumUtility.SourcedResponseSearchButtonXPath)
}

Then(~/^user finds the required result by product on Search Sourced Response Data Page$/) { DataTable verifyProductType ->
    searchSourcedResponseDatapage.verifySearchResultProduct(verifyProductType)
}