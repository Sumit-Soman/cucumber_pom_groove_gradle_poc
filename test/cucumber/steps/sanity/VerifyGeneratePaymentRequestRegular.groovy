package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def generatePaymentRequestRegularPage=new GeneratePaymentRequestRegularPage()
def utility = new SeleniumUtility()
def locator = new LocatorType();


Given(~/^user is on Generate Payment Request Regular Page\.$/) { ->
    utility.openPage("//*[@id=\"megamenu\"]/li[5]","Generate Payment Requests - Regular")
}

When(~/^user selects New Status and Agency vendor type\.$/) { ->
	utility.selectValueFromDD(locator.cssSelector, "select.ng-valid", "New")
	utility.clickElement(locator.xpath, "//div[@options-list='vendorTypeDataList']/button")
	utility.clickElement(locator.cssSelector, "input[value='AGENCY']")
}

When(~/^user clicks on search button on Generate Payment Request Regular Page\.$/) { ->
    utility.clickSearchXpath("//*[@id=\"searchDiv\"]/input[1]")
}

Then(~/^user finds the required result by external billed on Generate Payment Request Regular Page\.$/) { ->
    generatePaymentRequestRegularPage.verifySearchResultGeneratePaymentRequestRegular()
}