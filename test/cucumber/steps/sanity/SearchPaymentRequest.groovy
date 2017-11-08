package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def searchPaymentRequestPage=new SearchPaymentRequestPage()
def utility = new SeleniumUtility()


Given(~/^user is on Search Payment Request Page\.$/) { ->
    utility.openPage(SeleniumUtility.SearchPaymentRequestXpath,SeleniumUtility.SearchPaymentRequestLink)
}

When(~/^user selects regular in drop down for media buy Type\.$/) { ->
	utility.enterDropDownID("contractType","Regular")
}

When(~/^user clicks on search button on Search Payment Request Page\.$/) { ->
    utility.clickSearchXpath("//*[@id=\"performanceSearchBtn\"]")
}

Then(~/^user finds the required result by Regular on Search Payment Request Page\.$/) { ->
    searchPaymentRequestPage.verifySearchPaymentRequestPage()
}