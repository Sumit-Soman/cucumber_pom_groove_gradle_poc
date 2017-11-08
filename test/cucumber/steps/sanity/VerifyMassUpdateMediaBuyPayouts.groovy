package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def massUpdateMediaBuyPayoutsPage=new MassUpdateMediaBuyPayoutsPage()
def utility = new SeleniumUtility()
def locatorTypeObj = new LocatorType();

Given(~/^user is on Mass Update Media Buy Payouts Page$/) {
    -> utility.openPage("//*[@id=\"megamenu\"]/li[4]","Payouts")
}

Given(~/^user enters Creative on Mass Update Media Buy Payouts Page$/) { DataTable enterValues
    -> massUpdateMediaBuyPayoutsPage.enterCreative(enterValues)
}

When(~/^user clicks on search button on Mass Update Media Buy Payouts Page$/) {
    -> 
	utility.clickElement(locatorTypeObj.id, "searchTvMediaBuy")
}

Then(~/^user finds the required results by Creative on Mass Update Media Buy Payouts Page$/) { DataTable verifyValues
    -> massUpdateMediaBuyPayoutsPage.verifyCreative(verifyValues)
}