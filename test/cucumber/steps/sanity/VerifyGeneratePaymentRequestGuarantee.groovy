package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def generatePaymentRequestGuaranteePage=new GeneratePaymentRequestGuaranteePage()
def utility = new SeleniumUtility()
def locObj = new LocatorType();


Given(~/^user is on Generate Payment Request Guarantee Page\.$/) { ->
    utility.openPage("//*[@id=\"megamenu\"]/li[5]","Generate Payment Requests - GT")
}

When(~/^user selects Station Direct in drop down for vendor Type\.$/) { ->
 	utility.selectValueFromDD(locObj.id, "dealerType", "Station Direct")
}

When(~/^user clicks on search button on Generate Payment Request Guarantee Page\.$/) { ->
	utility.clickElement(locObj.id, "searchBtn")
}

Then(~/^user finds the required result by Station Direct on Generate Payment Request Guarantee Page\.$/) { ->
    generatePaymentRequestGuaranteePage.verifySearchResultGeneratePaymentRequestGuarantee()
}