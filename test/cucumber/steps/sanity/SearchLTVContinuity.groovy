package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def ltvContinuityPage = new SearchLTVContinuityPage()
def utility = new SeleniumUtility()
LocatorType locatorObj = new LocatorType();


Given(~/^user is on LTV Continuity Page$/) { ->
    utility.openPage("//*[@id='megamenu']/li[2]/h2","LTV/Continuity")
}

Given(~/^user selects Product, Media Type, Call Center and Upsell on LTV Continuity Page$/) { DataTable enterType 
    -> ltvContinuityPage.selectProduct(enterType)
}

When(~/^user clicks on search button on LTV Continuity Page$/) { ->
     utility.clickElement(locatorObj.cssSelector, "div.flt input[value='Search']")
}

Then(~/^user finds the required result by Product as result on LTV Continuity Page$/) { DataTable verifyProductType ->
    ltvContinuityPage.verifySearchResultProduct(verifyProductType)
}