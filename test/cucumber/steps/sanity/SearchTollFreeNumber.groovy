package steps.sanity

import static cucumber.api.groovy.EN.*;
import pages.*;
import cucumber.api.DataTable;

def tollFreeNumberPage = new TollFreeNumberPage()
def utility = new SeleniumUtility()
def locatorTypeObj = new LocatorType();


Given(~/^user is on Search Toll Free Number Page$/) { 
-> utility.openPage("//ul[@class='megamenu']/li[2]","Search Toll Free Number")
}

When(~/^user enters Creative on Search Toll Free Number Page$/) { DataTable enterTollFreeValue
-> tollFreeNumberPage.enterCreative(enterTollFreeValue)
}

When(~/^user clicks on search button on Search Toll Free Number Page$/) { 
-> 
utility.clickElement(locatorTypeObj.id, "tfnSearchButton")
}

Then(~/^user finds the required result by Creative on Search Toll Free Number Page$/) { DataTable tollFreeResultValue
-> tollFreeNumberPage.verifyCreative(tollFreeResultValue)
}
