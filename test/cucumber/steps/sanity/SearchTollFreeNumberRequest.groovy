package steps.sanity

import static cucumber.api.groovy.EN.*;
import pages.*;
import cucumber.api.DataTable;

def tollFreeNumberRequestPage = new TollFreeNumberRequestPage()
def utility = new SeleniumUtility()

Given(~/^user is on Search Toll Free Number Request Status Page$/) {
 -> utility.openPage("//ul[@class='megamenu']/li[2]","Toll Free Number Request Status")
}

When(~/^user enters Start Date on Search Toll Free Number Request Status Page$/) { DataTable enterDate
 -> tollFreeNumberRequestPage.enterStartDate(enterDate)
}

When(~/^user clicks on search button on Search Toll Free Number Request Status Page$/) {
 -> utility.clickSearchXpath("//*[@id=\"pageBody\"]/div[2]/form/div[3]/div[7]/div[1]/input")
}

Then(~/^user finds the required result by Start Date on Search Toll Free Number Request Status Page$/) { DataTable verifyStartDate
  -> tollFreeNumberRequestPage.verifySearchResultTollFreeNumberStartDate(verifyStartDate)
}