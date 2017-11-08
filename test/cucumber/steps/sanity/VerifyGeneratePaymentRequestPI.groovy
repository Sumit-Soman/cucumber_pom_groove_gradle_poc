package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def generatePaymentRequestPIPage=new GeneratePaymentRequestPIPage()
def utility = new SeleniumUtility()
def locatorTypeObj = new LocatorType();
def explicitObj = new ExplicitConditionType();


Given(~/^user is on Generate Payment Request PI Page\.$/) { ->
    utility.openPage("//*[@id=\"megamenu\"]/li[5]","Generate Payment Requests - PI")
}

When(~/^user selects Agency and Station for vendor Type\.$/) { ->
	utility.enterText(locatorTypeObj.id, "stationName", "KADN")
	utility.enterDropDownID("dealerType","Agency")
}

When(~/^user clicks on search button on Generate Payment Request PI Page\.$/) { ->
	utility.explicitWait(explicitObj.elementisinvisible, locatorTypeObj.cssSelector, "img[id='spinner']",null );
	utility.clickElement(locatorTypeObj.id, "searchBtn")
}

Then(~/^user finds the required result by Agency on Generate Payment Request PI Page\.$/) { ->
    generatePaymentRequestPIPage.verifySearchResultGeneratePaymentRequestPI()
}