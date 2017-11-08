package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def searchMediaBuyRegularPage=new SearchMediaBuyRegularPage()
def utility = new SeleniumUtility()

Given(~/^user is on Search Media Buy-Regular-TV Page$/) {
    -> utility.openPageXpath(SeleniumUtility.MenuSearchMediaBuyRegular,SeleniumUtility.MenuSearchMediaBuyRegularLink)
}

Given(~/^user enters Status and Creative on Search Media Buy-Regular-TV Page$/) { DataTable enterValues
    -> searchMediaBuyRegularPage.enterStatusCreative(enterValues)
}

When(~/^user clicks on search button on Search Media Buy-Regular-TV Page$/) {
    -> utility.clickSearchXpath("//*[@id=\"searchForm\"]/div[10]/input[1]")
}

Then(~/^user finds the required results by Status and Creative on Search Media Buy-Regular-TV Page$/) { DataTable verifyValues
    -> searchMediaBuyRegularPage.verifyStatusCreative(verifyValues)
}