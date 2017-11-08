package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def searchPayoutPage=new SearchPayoutPage()
def utility = new SeleniumUtility()


Given(~/^user is on Search Payout Page\.$/) { ->
    utility.openPage(SeleniumUtility.SearchPayoutXpath,SeleniumUtility.SearchPayoutLink)
}

When(~/^user selects regular in drop down for media buy Type on Search Payout Page\.$/) { ->
	utility.enterDropDownID("contractType","PI")
}

When(~/^user clicks on search button on Search Payout Page\.$/) { ->
    utility.clickSearchXpath("//*[@id=\"searchForm\"]/div[1]/div/div/div/div/div[8]/input")
}

Then(~/^user finds the required result by Regular on Search Payout Page\.$/) { ->
    searchPayoutPage.verifySearchPayoutPage()
}