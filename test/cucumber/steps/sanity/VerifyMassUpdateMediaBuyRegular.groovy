package steps.sanity

import static cucumber.api.groovy.EN.*
import pages.*
import cucumber.api.DataTable

def massUpdateMediaBuyRegularPage=new MassUpdateMediaBuyRegularPage()
def utility = new SeleniumUtility()

Given(~/^user is on Mass Update Media Buy-Regular-TV-Longform Page$/) {
    -> utility.openPageXpath("//*[@id=\"megamenu\"]/li[4]","//*[@id=\"megamenu\"]/li[4]/div/table/tbody/tr[11]/td[1]/a")
}

Given(~/^user enters Creative on Mass Update Media Buy-Regular-TV-Longform Page$/) { DataTable enterValues
    -> massUpdateMediaBuyRegularPage.enterCreative(enterValues)
}

When(~/^user clicks on search button on Mass Update Media Buy-Regular-TV-Longform Page$/) {
    -> utility.clickSearchXpath("//*[@id=\"searchForm\"]/div/div/div/div/div[15]/input[1]")
}

Then(~/^user finds the required results by Creative on Mass Update Media Buy-Regular-TV-Longform Page$/) { DataTable verifyValues
    -> massUpdateMediaBuyRegularPage.verifyCreative(verifyValues)
}