package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def searchMediaBuyGuaranteePage=new SearchMediaBuyGuaranteePage()
def utility = new SeleniumUtility()

Given(~/^user is on Search Media Buy-Guarantee-TV Page$/) {
    -> utility.openPageXpath(SeleniumUtility.MenuSearchMediaBuyRegular,SeleniumUtility.MenuSearchMediaBuyGuaranteeLink)
}

Given(~/^user enters Station on Search Media Buy-Guarantee-TV Page$/) { DataTable enterValues
    -> searchMediaBuyGuaranteePage.enterStation(enterValues)
}

When(~/^user clicks on search button on Search Media Buy-Guarantee-TV Page$/) { ->
	if(SeleniumUtility.Internal) {
		utility.clickSearchXpath("//*[@id=\"searchForm\"]/div[1]/div/div/div/div[1]/div[5]/input[1]")
	}
	else { 
		utility.clickSearchXpath("///*[@id=\"searchForm\"]/div[1]/div/div/div/div[1]/div[4]/input[1]")
	}
}

Then(~/^user finds the required results by Station on Search Media Buy-Guarantee-TV Page$/) { DataTable verifyValues
    -> searchMediaBuyGuaranteePage.verifyStation(verifyValues)
}