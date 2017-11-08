package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def searchMediaBuyPIPage=new SearchMediaBuyPIPage()
def utility = new SeleniumUtility()

Given(~/^user is on Search Media Buy-PI-TV Page$/) {
    -> utility.openPageXpath(SeleniumUtility.MenuSearchMediaBuyRegular,SeleniumUtility.MenuSearchMediaBuyPILink)
}

Given(~/^user enters Media Type and Creative on Search Media Buy-PI-TV Page$/) { DataTable enterValues
    -> searchMediaBuyPIPage.enterMediaTypeCreative(enterValues)
}

When(~/^user clicks on search button on Search Media Buy-PI-TV Page$/) {
    -> utility.clickSearchXpath("//*[@id=\"searchForm\"]/div[1]/div/div/div/div/div[9]/input[1]")
}

Then(~/^user finds the required results by Media Type and Creative on Search Media Buy-PI-TV Page$/) { DataTable verifyValues
    -> searchMediaBuyPIPage.verifyMediaTypeCreative(verifyValues)
}