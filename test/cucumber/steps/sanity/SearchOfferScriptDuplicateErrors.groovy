package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def offerScriptDuplicateErrorsPage=new OfferScriptDuplicateErrorsPage()
def utility = new SeleniumUtility()
def locatorTypeObj = new LocatorType();
def explicitObj = new ExplicitConditionType();


Given(~/^user is on Offer or Script or Duplicate Errors Page$/) { ->
    utility.openPage("//*[@id=\"megamenu\"]/li[3]","Offer / Script / Duplicate Errors") 
}

When(~/^user selects Product on Offer or Script or Duplicate Errors Page$/) { DataTable enterType 
    -> offerScriptDuplicateErrorsPage.selectProduct(enterType)
}

When(~/^user clicks on search button on Offer or Script or Duplicate Errors Page$/) { ->
	utility.explicitWait(explicitObj.elementisinvisible, locatorTypeObj.cssSelector, "img[id='spinner']",null );
    utility.clickElement(locatorTypeObj.xpath, "//*[@id=\"searchResponseData\"]/div/div[23]/div/input")
}

Then(~/^user finds the required result by product on Offer or Script or Duplicate Errors Page$/) { DataTable verifyProductType ->
    offerScriptDuplicateErrorsPage.verifySearchResultProduct(verifyProductType)
}